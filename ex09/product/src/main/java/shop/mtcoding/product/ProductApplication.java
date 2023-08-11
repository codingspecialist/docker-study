package shop.mtcoding.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import shop.mtcoding.product.model.Product;
import shop.mtcoding.product.model.ProductRepository;

@SpringBootApplication
public class ProductApplication {

	@Profile("dev") // dev 동작
	@Bean
	CommandLineRunner init(ProductRepository productRepository) { // main이 실행될 때 반드시 한번 실행됨
		return args -> {
			Product product1 = new Product(null, "바나나", 1000);
			Product product2 = new Product(null, "딸기", 2000);
			Product product3 = new Product(null, "참외", 3000);
			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product3);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
