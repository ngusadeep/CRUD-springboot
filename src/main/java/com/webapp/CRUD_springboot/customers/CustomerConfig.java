package com.webapp.CRUD_springboot.customers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner runner(CustomerRepository repository) {
        return args -> {
            List<Customer> customers = List.of(
                    new Customer("John", "Doe", "john.doe@example.com", "555-1234", "123 Elm Street", "Male", "active", null),
                    new Customer("Jane", "Smith", "jane.smith@example.com", "555-5678", "456 Maple Avenue", "Female", "active", null),
                    new Customer("Michael", "Brown", "michael.brown@example.com", "555-8765", "789 Oak Road", "Male", "inactive", null),
                    new Customer("Lisa", "Jones", "lisa.jones@example.com", "555-4321", "321 Pine Blvd", "Female", "active", null),
                    new Customer("David", "Wilson", "david.wilson@example.com", "555-3456", "654 Cedar Lane", "Male", "inactive", null),
                    new Customer("Emily", "Clark", "emily.clark@example.com", "555-1111", "98 Birch Street", "Female", "active", null),
                    new Customer("Ryan", "King", "ryan.king@example.com", "555-2222", "45 Willow Way", "Male", "active", null),
                    new Customer("Olivia", "Green", "olivia.green@example.com", "555-3333", "76 Aspen Circle", "Female", "inactive", null),
                    new Customer("Noah", "Hall", "noah.hall@example.com", "555-4444", "210 Chestnut Street", "Male", "active", null),
                    new Customer("Sophia", "Lee", "sophia.lee@example.com", "555-5555", "134 Redwood Lane", "Female", "active", null),
                    new Customer("William", "Walker", "william.walker@example.com", "555-6666", "201 Spruce St", "Male", "inactive", null),
                    new Customer("Ava", "Young", "ava.young@example.com", "555-7777", "78 Cypress Dr", "Female", "active", null),
                    new Customer("James", "Harris", "james.harris@example.com", "555-8888", "64 Fir Avenue", "Male", "inactive", null),
                    new Customer("Mia", "Adams", "mia.adams@example.com", "555-9999", "87 Alder Rd", "Female", "active", null),
                    new Customer("Lucas", "Baker", "lucas.baker@example.com", "555-0000", "29 Beech Blvd", "Male", "active", null)
            );

            repository.saveAll(customers);
        };
    }

}
