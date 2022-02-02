package dz.acs.books;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.logging.LoggersEndpoint.LoggerLevels;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.logging.LogLevel;
import org.springframework.context.annotation.Bean;

import dz.acs.books.dao.BookRepository;
import dz.acs.books.model.Book;

@SpringBootApplication
//@EnableDbCounting
public class DbBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbBookApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner clr(@Autowired BookRepository bookRepository/*,DbCountRunner dbCountRunner*/) {
		return ( args) -> {
			bookRepository.save(new Book("01234567891235", "Spring Boot In Action !", "Jooma"));
			bookRepository.save(new Book("01234567891234", "Java In Action !", "Bruce"));
			//dbCountRunner.run(args);
		};
	}
	
	
}
