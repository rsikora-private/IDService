package id.domain.persistance;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

/**
 * Created by robertsikora on 26.03.2016.
 */

@Configuration
@EnableMongoRepositories
@PropertySource("classpath:mongo.properties")
public class MongoDbConfig {

    @Value("${host:localhost}")
    private String host;
    @Value("${port}")
    private int port;
    @Value("${databaseName}")
    private String databaseName;
    @Value("${timeout:100}")
    private int timeoutInMs;

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        final MongoClient mongoClient = new MongoClient(new ServerAddress(host, port),
                MongoClientOptions.builder().connectTimeout(timeoutInMs).build());
        return new MongoTemplate(mongoClient, databaseName);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
