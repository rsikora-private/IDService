package id.service;

import id.domain.Account;
import id.domain.Credentials;

/**
 * Created by robertsikora on 25.03.2016. fit
 */
public interface AccountService {

    Account signIn(Credentials credentials);

    void register(Account account);
}
