package id.domain;

import id.domain.sha.ShaPasswordEncoder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Created by robertsikora on 25.03.2016.
 */

@Document(collection = Account.NAME)
@ToString
public class Account implements Serializable {
    final static String NAME = "accounts";
    private static final long serialVersionUID = 1391314099197545306L;

    @Id
    @Getter
    private String id;
    @NotEmpty
    @Getter
    @Setter
    private String username;
    @NotEmpty
    @Setter
    private String password;
    @Getter
    @Setter
    private List<String> authorities = Collections.singletonList("ROLE_USER");
    @NotNull
    @Getter
    @Setter
    private AccountPolicy policy = new AccountPolicy();

    /**
     * New_feature
     */

    @Autowired
    private ShaPasswordEncoder shaPasswordEncoder;

    public boolean matchPassword(final String rawPassword) {
        final String encodedPassword = shaPasswordEncoder.encode(rawPassword);
        return encodedPassword.equals(password);
    }

    public void encodePassword() {
        setPassword(shaPasswordEncoder.encode(password));
    }
}
