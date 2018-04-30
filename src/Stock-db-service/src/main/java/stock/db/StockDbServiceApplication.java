package stock.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//EnableJpaRepositories(basePackages = "stock.repository")
//EntityScan("stock.model")
@SpringBootApplication
public class StockDbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockDbServiceApplication.class, args);
	}
}
