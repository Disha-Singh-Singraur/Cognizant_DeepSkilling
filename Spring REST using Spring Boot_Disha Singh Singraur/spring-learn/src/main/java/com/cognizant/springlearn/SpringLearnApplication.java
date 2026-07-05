package com.cognizant.springlearn;

import com.cognizant.springlearn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Handout 1: SpringLearnApplication main driver
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("     STARTING SPRING-LEARN REST API (Lab)        ");
        System.out.println("=================================================");
        SpringApplication.run(SpringLearnApplication.class, args);
    }

    @Bean
    public CommandLineRunner restLabRunner() {
        return (args) -> {
            System.out.println("\n--- Loading Handout 1 Verification Checks ---");
            displayDate();
            displayCountry();
            displayCountries();
            System.out.println("--- Handout 1 Checks Complete ---\n");
        };
    }

    // Handout 1, Exercise 2: Load date format bean
    public void displayDate() {
        LOGGER.info("START displayDate");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Parsed Date: {}", date);
        } catch (Exception e) {
            LOGGER.error("Date parsing failed", e);
        }
        LOGGER.info("END displayDate");
    }

    // Handout 1, Exercise 4 & 5: Load country bean and demonstrate prototype scope
    public void displayCountry() {
        LOGGER.info("START displayCountry");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());

        // Scope check (Exercise 5)
        Country anotherCountry = context.getBean("country", Country.class);
        LOGGER.debug("Another Country instance: {}", anotherCountry.toString());
        LOGGER.info("END displayCountry");
    }

    // Handout 1, Exercise 6: Load list of countries
    public void displayCountries() {
        LOGGER.info("START displayCountries");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<Country> list = (ArrayList<Country>) context.getBean("countryList", ArrayList.class);
        LOGGER.debug("Country List: {}", list);
        LOGGER.info("END displayCountries");
    }
}
