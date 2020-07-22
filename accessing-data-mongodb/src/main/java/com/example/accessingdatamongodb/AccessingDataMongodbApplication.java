package com.example.accessingdatamongodb;

/*
Reference: https://spring.io/guides/gs/accessing-data-mongodb/
 */

import com.example.accessingdatamongodb.model.Customer;
import com.example.accessingdatamongodb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}
}

/*
@SpringBootApplication
is a convenience annotation that adds all of the following:
	@Configuration: Tags the class as a source of bean definitions for the application context.
	@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings,
	 other beans, and various property settings. For example, if spring-webmvc is on the classpath,
	 this annotation flags the application as a web application and activates key behaviors,
	 such as setting up a DispatcherServlet.
	@ComponentScan: Tells Spring to look for other components, configurations, and services in
	the com/example package, letting it find the controllers.
 */
