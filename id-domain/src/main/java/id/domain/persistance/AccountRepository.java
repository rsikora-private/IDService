package id.domain.persistance;

import id.domain.Account;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by robertsikora on 26.03.2016.
 */
public interface AccountRepository extends MongoRepository<Account, ObjectId> {

    Account findByUsername(String username);
}
