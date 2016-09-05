package id.server;

import id.api.IdResource;
import id.domain.Account;
import id.domain.Credentials;
import id.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by robertsikora on 26.03.2016.
 */

@RestController
class IdResourceImpl implements IdResource {

    private final AccountService accountService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    public IdResourceImpl(final AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Account signIn(@RequestBody final Credentials credentials) {
        return accountService.signIn(credentials);
    }

    @Override
    public void register(@RequestBody final Account account) {
        accountService.register(account);
    }

    @Override
    public ResponseEntity test() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "http://www.onet.pl?param=xxx");
        headers.add("token", "bla bla bla 123");
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}
