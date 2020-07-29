package br.com.hoffmann.brasilprev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BrasilprevApplication {

	public static void main(String[] args) {

		SpringApplication.run(BrasilprevApplication.class, args);
	}
}
