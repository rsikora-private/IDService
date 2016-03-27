package id.api;

import id.domain.Account;
import id.domain.Credentials;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by robertsikora on 26.03.2016.
 */

@RequestMapping("/api/v1/account")
public interface IdResource {

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    Account signIn(Credentials credentials);

    @RequestMapping(method = RequestMethod.POST)
    void register(Account account);
}
