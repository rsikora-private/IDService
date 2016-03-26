package id.server;

import id.api.IdService;
import id.domain.Account;
import id.domain.Credentials;
import id.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by robertsikora on 26.03.2016.
 */

@RestController
class IdResourceImpl implements IdService {

    @Autowired
    private AccountService authentication;

    @Override
    public Account signIn(@RequestBody final Credentials credentials) {
        return authentication.signIn(credentials);
    }
}
