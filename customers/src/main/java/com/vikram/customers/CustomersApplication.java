package com.vikram.customers;

import com.vikram.customers.Models.Customer;
import com.vikram.customers.Repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CustomersApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CustomersApplication.class, args);
    }

    @Autowired
    CustomerRepo customerRepo;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }

    @Override
    public void run(String... args) throws Exception {
        customerRepo.save(new Customer("John", "Smith", 1l));
        customerRepo.save(new Customer("Jane", "Doe", 2l));
        customerRepo.save(new Customer("Bob", "Smith", 3l));
        customerRepo.save(new Customer("Freds", "Tred", 4l));
    }
}
