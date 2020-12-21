package com.customerservice.customerservices;

import com.customerservice.customerservices.entities.Customer;
import com.customerservice.customerservices.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServicesApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            customerRepository.save(new Customer(null,"abdellah1","ab1@gmail.com"));
            customerRepository.save(new Customer(null,"abdellah2","ab2@gmail.com"));
            customerRepository.save(new Customer(null,"abdellah3","ab3@gmail.com"));
            customerRepository.findAll().forEach(
                    customer -> {System.out.println(customer.toString());
                    });
        };
    }
}
