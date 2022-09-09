package io.javabrains.springsecurityjwt.Books;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository){
        return args -> {
            Book HarryPotter = new Book(
                    "Harry Potter",
                    "JK Rowling ",
                    "Fantasy",
                    LocalDate.of(2000, Month.JANUARY, 5)

            );
            Book SnowWhite = new Book(
                    "Snow White",
                    "Walt Disney",
                    "Kids",
                    LocalDate.of(2004, Month.MARCH, 8)

            );
            Book ItEndsWithUs = new Book(
                    "It Ends With Us",
                    "Collen Hoover",
                    "Horror",
                    LocalDate.of(2010, Month.MARCH, 30)

            );
            Book MalibuRising = new Book(
                    "Malibu Rising",
                    "Adenike Adesanya",
                    "Fiction",
                    LocalDate.of(2004, Month.MARCH, 8)

            );

            repository.saveAll(
                    List.of(HarryPotter ,SnowWhite, ItEndsWithUs, MalibuRising)
            );


        };
    }
}
