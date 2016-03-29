package id.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by robertsikora on 25.03.2016.
 */

@ToString
public class Credentials implements Serializable {
    private static final long serialVersionUID = -2666918932596907098L;

    @Setter
    @Getter
    @NotEmpty
    private String username;
    @Setter
    @Getter
    @NotEmpty
    private String password;
}
