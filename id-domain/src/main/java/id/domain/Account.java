package id.domain;

import id.domain.persistance.AccountRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by robertsikora on 25.03.2016.
 */

@Document(collection = Account.NAME)
@ToString
public class Account implements Serializable {
    final static String NAME = "accounts";
    private static final long serialVersionUID = 1391314099197545306L;

    @Id
    @Getter @Setter
    private ObjectId id;
    @NotEmpty
    @Getter @Setter
    private String username;
    @NotEmpty
    @Setter
    private String password;
    @Getter @Setter
    private Collection<Authority> authorities;
    @NotNull
    @Getter @Setter
    private AccountPolicy accountPolicy;

    @Autowired
    private AccountRepository accountRepository;

    public boolean matchPassword(final String rawPassword){
        final String encodedPassword = rawPassword;
        return encodedPassword.equals(password);
    }

    public Account register(){
        setPassword(password);
        return accountRepository.save(this);
    }
}
