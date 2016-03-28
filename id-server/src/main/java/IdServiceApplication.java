import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"id"})
@EnableMongoRepositories(value = {"id.domain.persistance"})
public class IdServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdServiceApplication.class, args);
    }
}
