package id.domain.persistance;

import id.domain.Account;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by robertsikora on 26.03.2016.
 */

public interface AccountRepository extends CrudRepository<Account, ObjectId> {

    Optional<Account> findByUsername(String username);
}
