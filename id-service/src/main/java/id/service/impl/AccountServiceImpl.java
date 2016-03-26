package id.service.impl;

import id.domain.Account;
import id.domain.Credentials;
import id.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by robertsikora on 26.03.2016.
 */

@Service
class AccountServiceImpl implements AccountService {

    @Override
    public Account signIn(final Credentials credentials) {
        Assert.notNull(credentials);
        return credentials.signIn();
    }

    @Override
    public void register(final Account account) {
        Assert.notNull(account);
        account.register();
    }
}
