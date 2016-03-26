package id.service;

import id.domain.Credentials;
import id.domain.Account;

/**
 * Created by robertsikora on 25.03.2016.
 */
public interface AccountService {

    Account signIn(Credentials credentials);

    void register(Account account);
}
