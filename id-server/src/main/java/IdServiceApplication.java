import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"id"})
public class IdServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdServiceApplication.class, args);
	}
}
