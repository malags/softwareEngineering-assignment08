package usi.inf.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DesignPatternPersistencyApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DesignPatternPersistencyApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(DesignPatternPersistencyApplication.class, args);
	}

}
