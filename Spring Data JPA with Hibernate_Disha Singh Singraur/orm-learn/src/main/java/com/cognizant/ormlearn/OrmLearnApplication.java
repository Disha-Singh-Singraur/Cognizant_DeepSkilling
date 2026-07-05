package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.repository.*;
import com.cognizant.ormlearn.service.*;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Main application class running verification for orm-learn exercises (Files 1, 2, 3).
 */
@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("     STARTING ORM-LEARN APPLICATION (Lab)        ");
        System.out.println("=================================================");
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(
            CountryService countryService,
            CountryRepository countryRepository,
            StockRepository stockRepository,
            EmployeeService employeeService,
            DepartmentService departmentService,
            SkillService skillService,
            AttemptService attemptService,
            UserRepository userRepository,
            QuestionRepository questionRepository,
            OptionRepository optionRepository,
            AttemptRepository attemptRepository,
            AttemptQuestionRepository attemptQuestionRepository,
            AttemptOptionRepository attemptOptionRepository,
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository,
            SkillRepository skillRepository) {

        return (args) -> {
            System.out.println("\n[Database Initialization] Starting data seeding...");

            // 1. Seed Countries (File 1, Hands on 1 & 5)
            countryRepository.deleteAll();
            List<Country> countries = Arrays.asList(
                new Country("IN", "India"),
                new Country("US", "United States of America"),
                new Country("BV", "Bouvet Island"),
                new Country("DJ", "Djibouti"),
                new Country("GP", "Guadeloupe"),
                new Country("GS", "South Georgia and the South Sandwich Islands"),
                new Country("LU", "Luxembourg"),
                new Country("SS", "South Sudan"),
                new Country("TF", "French Southern Territories"),
                new Country("UM", "United States Minor Outlying Islands"),
                new Country("ZA", "South Africa"),
                new Country("ZM", "Zambia"),
                new Country("ZW", "Zimbabwe")
            );
            countryRepository.saveAll(countries);

            // 2. Seed Stock Data (File 2, Hands on 2)
            stockRepository.deleteAll();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            List<Stock> stocks = Arrays.asList(
                new Stock(0, "FB", df.parse("2019-09-03"), new BigDecimal("184.00"), new BigDecimal("182.39"), 9779400L),
                new Stock(0, "FB", df.parse("2019-09-04"), new BigDecimal("184.65"), new BigDecimal("187.14"), 11308000L),
                new Stock(0, "FB", df.parse("2019-09-05"), new BigDecimal("188.53"), new BigDecimal("190.90"), 13876700L),
                new Stock(0, "FB", df.parse("2019-01-31"), new BigDecimal("165.60"), new BigDecimal("166.69"), 77233600L),
                new Stock(0, "FB", df.parse("2018-10-31"), new BigDecimal("155.00"), new BigDecimal("151.79"), 60101300L),
                new Stock(0, "FB", df.parse("2018-12-19"), new BigDecimal("141.21"), new BigDecimal("133.24"), 57404900L),
                new Stock(0, "GOOGL", df.parse("2019-04-22"), new BigDecimal("1236.67"), new BigDecimal("1253.76"), 954200L),
                new Stock(0, "GOOGL", df.parse("2019-04-23"), new BigDecimal("1256.64"), new BigDecimal("1270.59"), 1593400L),
                new Stock(0, "GOOGL", df.parse("2019-04-24"), new BigDecimal("1270.59"), new BigDecimal("1260.05"), 1169800L),
                new Stock(0, "GOOGL", df.parse("2019-10-17"), new BigDecimal("1251.40"), new BigDecimal("1252.80"), 1047900L),
                new Stock(0, "NFLX", df.parse("2018-12-24"), new BigDecimal("242.00"), new BigDecimal("233.88"), 9547600L),
                new Stock(0, "NFLX", df.parse("2018-12-21"), new BigDecimal("263.83"), new BigDecimal("246.39"), 21397600L),
                new Stock(0, "NFLX", df.parse("2018-12-26"), new BigDecimal("233.92"), new BigDecimal("253.67"), 14402700L)
            );
            stockRepository.saveAll(stocks);

            // 3. Seed Payroll Data (File 2, Hands on 3)
            // Clear existing skills, employees, departments
            attemptOptionRepository.deleteAll();
            attemptQuestionRepository.deleteAll();
            attemptRepository.deleteAll();
            optionRepository.deleteAll();
            questionRepository.deleteAll();
            userRepository.deleteAll();
            
            employeeRepository.deleteAll();
            departmentRepository.deleteAll();
            skillRepository.deleteAll();

            Department it = new Department(0, "IT", null);
            Department hr = new Department(0, "HR", null);
            departmentRepository.saveAll(Arrays.asList(it, hr));

            Skill java = new Skill(0, "Java", null);
            Skill spring = new Skill(0, "Spring Boot", null);
            Skill sql = new Skill(0, "SQL", null);
            skillRepository.saveAll(Arrays.asList(java, spring, sql));

            Employee emp1 = new Employee(0, "John Doe", 50000.0, true, df.parse("1990-01-01"), it, new HashSet<>(Arrays.asList(java, sql)));
            Employee emp2 = new Employee(0, "Jane Smith", 60000.0, true, df.parse("1992-05-15"), hr, new HashSet<>(Arrays.asList(sql)));
            Employee emp3 = new Employee(0, "Alice Jones", 45000.0, false, df.parse("1995-10-20"), it, new HashSet<>(Arrays.asList(spring)));
            employeeRepository.saveAll(Arrays.asList(emp1, emp2, emp3));

            // 4. Seed Quiz Data (File 3, Hands on 3)
            User userDisha = new User("disha");
            userRepository.save(userDisha);

            Question q1 = new Question("What is the extension of the hyper text markup language file?", 1.0);
            Question q2 = new Question("What is the maximum level of heading tag can be used in a HTML page?", 1.0);
            Question q3 = new Question("The HTML document itself begins with <html> and ends </html>. State True of False", 1.0);
            Question q4 = new Question("Choose the right option to store text value value in a variable", 1.0);
            questionRepository.saveAll(Arrays.asList(q1, q2, q3, q4));

            Option o1_1 = new Option(".xhtm", false, q1);
            Option o1_2 = new Option(".ht", false, q1);
            Option o1_3 = new Option(".html", true, q1);
            Option o1_4 = new Option(".htmx", false, q1);

            Option o2_1 = new Option("5", false, q2);
            Option o2_2 = new Option("3", false, q2); // user selects this (incorrect)
            Option o2_3 = new Option("4", false, q2);
            Option o2_4 = new Option("6", true, q2);

            Option o3_1 = new Option("false", false, q3);
            Option o3_2 = new Option("true", true, q3);

            Option o4_1 = new Option("'John'", true, q4);
            Option o4_2 = new Option("John", false, q4);
            Option o4_3 = new Option("\"John\"", true, q4);
            Option o4_4 = new Option("/John/", false, q4);
            optionRepository.saveAll(Arrays.asList(
                o1_1, o1_2, o1_3, o1_4,
                o2_1, o2_2, o2_3, o2_4,
                o3_1, o3_2,
                o4_1, o4_2, o4_3, o4_4
            ));

            Attempt attempt = new Attempt(userDisha, new Date());
            attemptRepository.save(attempt);

            AttemptQuestion aq1 = new AttemptQuestion(attempt, q1);
            AttemptQuestion aq2 = new AttemptQuestion(attempt, q2);
            AttemptQuestion aq3 = new AttemptQuestion(attempt, q3);
            AttemptQuestion aq4 = new AttemptQuestion(attempt, q4);
            attemptQuestionRepository.saveAll(Arrays.asList(aq1, aq2, aq3, aq4));

            AttemptOption ao1_1 = new AttemptOption(aq1, o1_1, false);
            AttemptOption ao1_2 = new AttemptOption(aq1, o1_2, false);
            AttemptOption ao1_3 = new AttemptOption(aq1, o1_3, true);
            AttemptOption ao1_4 = new AttemptOption(aq1, o1_4, false);

            AttemptOption ao2_1 = new AttemptOption(aq2, o2_1, false);
            AttemptOption ao2_2 = new AttemptOption(aq2, o2_2, true); // selected
            AttemptOption ao2_3 = new AttemptOption(aq2, o2_3, false);
            AttemptOption ao2_4 = new AttemptOption(aq2, o2_4, false);

            AttemptOption ao3_1 = new AttemptOption(aq3, o3_1, false);
            AttemptOption ao3_2 = new AttemptOption(aq3, o3_2, true); // selected

            AttemptOption ao4_1 = new AttemptOption(aq4, o4_1, true); // selected
            AttemptOption ao4_2 = new AttemptOption(aq4, o4_2, false);
            AttemptOption ao4_3 = new AttemptOption(aq4, o4_3, false);
            AttemptOption ao4_4 = new AttemptOption(aq4, o4_4, false);
            attemptOptionRepository.saveAll(Arrays.asList(
                ao1_1, ao1_2, ao1_3, ao1_4,
                ao2_1, ao2_2, ao2_3, ao2_4,
                ao3_1, ao3_2,
                ao4_1, ao4_2, ao4_3, ao4_4
            ));

            System.out.println("[Database Initialization] Seeding completed successfully!\n");

            // =========================================================================
            // RUNNING VERIFICATION CHECKS
            // =========================================================================
            runFile1Tests(countryService);
            runFile2Tests(countryRepository, stockRepository, employeeService, departmentService, skillService);
            runFile3Tests(employeeService, attemptService, userDisha.getId(), attempt.getId());
        };
    }

    private void runFile1Tests(CountryService countryService) {
        System.out.println("=================================================");
        System.out.println("   RUNNING FILE 1 TESTS: Country CRUD            ");
        System.out.println("=================================================");
        
        // Hands on 1: testGetAllCountries
        LOGGER.info("Start testGetAllCountries");
        List<Country> list = countryService.getAllCountries();
        LOGGER.debug("Countries loaded (Count: {}): {}", list.size(), list);
        LOGGER.info("End testGetAllCountries");

        // Hands on 6: testFindCountryByCode
        try {
            LOGGER.info("Start testFindCountryByCode");
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country found: {}", country);
            LOGGER.info("End testFindCountryByCode");
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country lookup failed", e);
        }

        // Hands on 7: testAddCountry
        LOGGER.info("Start testAddCountry");
        Country newCountry = new Country("KH", "Cambodia");
        countryService.addCountry(newCountry);
        try {
            Country found = countryService.findCountryByCode("KH");
            LOGGER.debug("Added Country: {}", found);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Added country not found!", e);
        }
        LOGGER.info("End testAddCountry");

        // Hands on 8: testUpdateCountry
        LOGGER.info("Start testUpdateCountry");
        try {
            countryService.updateCountry("KH", "Kingdom of Cambodia");
            Country found = countryService.findCountryByCode("KH");
            LOGGER.debug("Updated Country: {}", found);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Update failed", e);
        }
        LOGGER.info("End testUpdateCountry");

        // Hands on 9: testDeleteCountry
        LOGGER.info("Start testDeleteCountry");
        countryService.deleteCountry("KH");
        try {
            countryService.findCountryByCode("KH");
            LOGGER.error("Delete failed! Country 'KH' still exists.");
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Deleted country successfully checked. Exception: {}", e.getMessage());
        }
        LOGGER.info("End testDeleteCountry");
        System.out.println("-------------------------------------------------");
    }

    private void runFile2Tests(
            CountryRepository countryRepository,
            StockRepository stockRepository,
            EmployeeService employeeService,
            DepartmentService departmentService,
            SkillService skillService) {
        
        System.out.println("=================================================");
        System.out.println("   RUNNING FILE 2 TESTS: Query Methods & ORM     ");
        System.out.println("=================================================");

        // Hands on 1: Write queries on Country table
        System.out.println("\n--- Hands on 1: Country Query Methods ---");
        List<Country> c1 = countryRepository.findByNameContainingOrderByCodeAsc("ou");
        System.out.println("Countries containing 'ou' (Sorted by Code):");
        c1.forEach(c -> System.out.println("  " + c.getCode() + "   " + c.getName()));

        List<Country> c2 = countryRepository.findByNameContainingOrderByNameAsc("ou");
        System.out.println("\nCountries containing 'ou' (Sorted by Name):");
        c2.forEach(c -> System.out.println("  " + c.getCode() + "   " + c.getName()));

        List<Country> c3 = countryRepository.findByNameStartingWith("Z");
        System.out.println("\nCountries starting with 'Z':");
        c3.forEach(c -> System.out.println("  " + c.getCode() + "   " + c.getName()));

        // Hands on 2: Stock Query Methods
        System.out.println("\n--- Hands on 2: Stock Query Methods ---");
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            
            System.out.println("Facebook stock details in Sept 2019:");
            List<Stock> fbStock = stockRepository.findByCodeAndDateBetween("FB", df.parse("2019-09-01"), df.parse("2019-09-30"));
            fbStock.forEach(s -> System.out.println("  " + s.getCode() + "  " + df.format(s.getDate()) + "  " + s.getOpen() + "  " + s.getClose() + "  " + s.getVolume()));

            System.out.println("\nGoogle stock details where price > 1250:");
            List<Stock> googlStock = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
            googlStock.forEach(s -> System.out.println("  " + s.getCode() + "  " + df.format(s.getDate()) + "  " + s.getOpen() + "  " + s.getClose() + "  " + s.getVolume()));

            System.out.println("\nTop 3 dates with highest transaction volumes:");
            List<Stock> topVol = stockRepository.findTop3ByOrderByVolumeDesc();
            topVol.forEach(s -> System.out.println("  " + s.getCode() + "  " + df.format(s.getDate()) + "  " + s.getOpen() + "  " + s.getClose() + "  " + s.getVolume()));

            System.out.println("\nTop 3 dates with lowest Netflix stocks:");
            List<Stock> lowestNflx = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
            lowestNflx.forEach(s -> System.out.println("  " + s.getCode() + "  " + df.format(s.getDate()) + "  " + s.getOpen() + "  " + s.getClose() + "  " + s.getVolume()));
        } catch (Exception e) {
            LOGGER.error("Stock queries failed", e);
        }

        // Hands on 4: Employee & Department ManyToOne
        System.out.println("\n--- Hands on 4: Many-to-One Relationships ---");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());

        // testAddEmployee
        LOGGER.info("Start testAddEmployee");
        Employee newEmp = new Employee();
        newEmp.setName("Robert Martin");
        newEmp.setSalary(75000.0);
        newEmp.setPermanent(true);
        newEmp.setDateOfBirth(new Date());
        newEmp.setDepartment(departmentService.get(1)); // IT
        employeeService.save(newEmp);
        LOGGER.debug("Saved Employee details: {}", newEmp);
        LOGGER.info("End testAddEmployee");

        // testUpdateEmployee
        LOGGER.info("Start testUpdateEmployee");
        Employee toUpdate = employeeService.get(3);
        if (toUpdate != null) {
            LOGGER.debug("Old department: {}", toUpdate.getDepartment().getName());
            toUpdate.setDepartment(departmentService.get(2)); // HR
            employeeService.save(toUpdate);
            LOGGER.debug("Updated department details: {}", employeeService.get(3).getDepartment().getName());
        }
        LOGGER.info("End testUpdateEmployee");

        // Hands on 5: OneToMany relationship
        System.out.println("\n--- Hands on 5: One-to-Many Relationships (EAGER Fetch) ---");
        Department dept = departmentService.get(1);
        LOGGER.debug("Department fetched: {}", dept.getName());
        LOGGER.debug("Employees: {}", dept.getEmployeeList());

        // Hands on 6: ManyToMany relationship
        System.out.println("\n--- Hands on 6: Many-to-Many Relationships (Employee & Skills) ---");
        Employee emp = employeeService.get(1);
        LOGGER.debug("Skills for employee 1: {}", emp.getSkillList());

        // testAddSkillToEmployee
        LOGGER.info("Start testAddSkillToEmployee");
        Employee testEmp = employeeService.get(2); // Jane Smith
        Skill skillToAdd = skillService.get(1); // Java
        if (testEmp != null && skillToAdd != null) {
            testEmp.getSkillList().add(skillToAdd);
            employeeService.save(testEmp);
            LOGGER.debug("Updated skills list: {}", employeeService.get(2).getSkillList());
        }
        LOGGER.info("End testAddSkillToEmployee");
        System.out.println("-------------------------------------------------");
    }

    private void runFile3Tests(EmployeeService employeeService, AttemptService attemptService, int userId, int attemptId) {
        System.out.println("=================================================");
        System.out.println("   RUNNING FILE 3 TESTS: HQL & Native Queries    ");
        System.out.println("=================================================");

        // Hands on 2: Get all permanent employees using optimized HQL Join Fetch
        System.out.println("\n--- Hands on 2: Permanent Employees (HQL Join Fetch) ---");
        LOGGER.info("Start permanent employees lookup");
        List<Employee> permanent = employeeService.getAllPermanentEmployees();
        permanent.forEach(e -> {
            LOGGER.debug("Permanent Employee: {}", e);
            LOGGER.debug("Department: {}, Skills: {}", e.getDepartment(), e.getSkillList());
        });
        LOGGER.info("End permanent employees lookup");

        // Hands on 3: Fetch Quiz Attempt details using HQL
        System.out.println("\n--- Hands on 3: Quiz Attempt Retrieval ---");
        Attempt attemptObj = attemptService.getAttempt(userId, attemptId);
        if (attemptObj != null) {
            System.out.println("User: " + attemptObj.getUser().getName());
            System.out.println("Attempt Date: " + attemptObj.getDate());
            
            // Loop and format questions and answers
            List<AttemptQuestion> aqList = new ArrayList<>(attemptObj.getAttemptQuestions());
            aqList.sort(Comparator.comparingInt(aq -> aq.getQuestion().getId()));
            
            for (AttemptQuestion aq : aqList) {
                Question q = aq.getQuestion();
                System.out.println(q.getText());
                
                List<AttemptOption> aoList = new ArrayList<>(aq.getAttemptOptions());
                aoList.sort(Comparator.comparingInt(ao -> ao.getOption().getId()));
                
                int index = 1;
                for (AttemptOption ao : aoList) {
                    Option o = ao.getOption();
                    // Score is displayed as 1.0 (if correct) or 0.0 (if incorrect). Or options could have relative scores.
                    double relativeScore = o.isCorrect() ? q.getScore() : 0.0;
                    // For Question 4, there are multiple correct answers (e.g. 'John' score 0.5, "John" score 0.5).
                    if (q.getId() == 4) {
                        relativeScore = o.isCorrect() ? 0.5 : 0.0;
                    }
                    System.out.printf("  %d) %-10s   %.1f    %b\n", index++, o.getText(), relativeScore, ao.isSelected());
                }
            }
        } else {
            System.out.println("Attempt not found!");
        }

        // Hands on 4: Average Salary by Department HQL
        System.out.println("\n--- Hands on 4: Average Salary using HQL ---");
        double avgSalary = employeeService.getAverageSalary(1); // IT
        System.out.printf("Average Salary in IT Department (ID 1): %.2f\n", avgSalary);

        // Hands on 5: Get all employees using Native SQL Query
        System.out.println("\n--- Hands on 5: Get All Employees using Native Query ---");
        List<Employee> nativeEmps = employeeService.getAllEmployeesNative();
        nativeEmps.forEach(e -> System.out.println("  " + e.getName() + " - " + e.getSalary()));
        System.out.println("-------------------------------------------------");
    }
}
