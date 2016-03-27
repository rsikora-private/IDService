package id.domain;

import id.domain.exception.BadCredentialsException;
import id.domain.persistance.AccountRepository;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by robertsikora on 25.03.2016.
 */

@ToString
public class Credentials implements Serializable {
    private static final long serialVersionUID = -2666918932596907098L;

    @Setter
    @NotEmpty
    private String username;
    @Setter
    @NotEmpty
    private String password;

    @Autowired
    private AccountRepository accountRepository;

    public Account signIn() {
        final Account account = accountRepository.findByUsername(this.username);
        if (account == null) {
            throw new BadCredentialsException("Wrong credentials!");
        }
        if (account.matchPassword(password)) {
            return account;
        }
        throw new BadCredentialsException("Wrong credentials!");
    }
}
