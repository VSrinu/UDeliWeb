package com.uDeli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.uDeli.model.FileStorageProperties;

@SpringBootApplication

/*@EnableConfigurationProperties({
	FileStorageProperties.class
})*/
public class UDeliWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UDeliWebAppApplication.class, args);
	}
}
