package com.uDeli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.uDeli.model.FileStorageProperties;

@SpringBootApplication

/*@EnableConfigurationProperties({
	FileStorageProperties.class
})*/
@EnableAutoConfiguration
@EnableScheduling
public class UDeliWebAppApplication {

	/*@SuppressWarnings("resource")*/
	public static void main(String[] args) {
		SpringApplication.run(UDeliWebAppApplication.class, args);
		/*new ClassPathXmlApplicationContext("Spring-Module-TaskSchedular.xml");*/
	}
}
