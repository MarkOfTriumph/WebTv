package org.generation.italy.webtv;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DataSourceProperties.class)
public class PrwWebTvApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrwWebTvApplication.class, args);
	}

}
