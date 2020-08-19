package com.example.accessingdatamongodb;

/*
Reference: https://spring.io/guides/gs/accessing-data-mongodb/
 */

import com.example.accessingdatamongodb.domain.Customer;
import com.example.accessingdatamongodb.repository.CustomerRepository;
import com.example.accessingdatamongodb.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
public class AccessingDataMongodbApplication implements CommandLineRunner{

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private GroupRepository groupRepository;

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// truncate the database
		customerRepository.deleteAll();
		groupRepository.deleteAll();

		// save a couple of customers
		customerRepository.save(new Customer("Alice", "Smith", "AS@abc.com"));
		customerRepository.save(new Customer("Bob", "Smith", "BS@bbc.com"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(customerRepository.findCustomerByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : customerRepository.findCustomerByLastName("Smith")) {
			System.out.println(customer);
		}
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer()
//	{
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("");
//			}
//		};
//	}

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
