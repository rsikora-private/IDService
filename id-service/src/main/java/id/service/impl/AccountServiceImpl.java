package id.service.impl;

import id.domain.Account;
import id.domain.Credentials;
import id.domain.persistance.AccountRepository;
import id.service.AccountService;
import id.service.exception.BadCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * Created by robertsikora on 26.03.2016.
 */

@Service
class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account signIn(final Credentials credentials) {
        final Optional<Account> accountOptional = accountRepository.findByUsername(credentials.getUsername());
        final Account account = accountOptional.orElseThrow(BadCredentialsException::new);
        if(!account.matchPassword(credentials.getPassword())){
            throw new BadCredentialsException();
        }
        return account;
    }

    @Override
    public void register(final Account account) {
        Assert.notNull(account);
        account.encodePassword();
        accountRepository.save(account);
    }
}
