package hh.swd20.bookstore;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository crepository, UserRepository urepository) { 
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Education"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Fantasy"));
			
			bookRepository.save(new Book("Kekkuli", "Huhuu", 2035, 2312, 20.50, crepository.findByName("Education").get(0)));
			bookRepository.save(new Book("Vekkuli", "Hihii", 1345, 23243, 10.50, crepository.findByName("Horror").get(0)));	
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
			//users admin and user
						User user1 = new User("user", "$2a$10$xPZiJLuRylSGezZaK5PvneiEwnTHVnCeDbW83i9PfkEDdtb8jsbuy", "USER");
						User user2 = new User("admin", "$2a$10$xghe.Q2afaeocnPSlsqz9OUFDF4gUxGQUGAQNcmn0YeJAHBtV422u", "ADMIN");
						urepository.save(user1);
						urepository.save(user2);
						
						log.info("fetch all students");
						for (Book book : bookRepository.findAll()) {
							log.info(book.toString());
						}

		};
	}
}
