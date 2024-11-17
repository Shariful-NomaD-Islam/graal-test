package com.example.graal_test;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Paths;
import java.util.Arrays;


@SpringBootApplication
public class GraalTestApplication {

	private static Logger log = LoggerFactory.getLogger(GraalTestApplication.class);

	@Autowired
	PropsComponent propsComponent;

	public static void main(String[] args) {
		log.info("args size {}", args.length);
		Arrays.stream(args).forEach(log::info);
		PropsComponent.args = args;
		PropsComponent.CONFIG_FILE = (args.length > 0)?args[0]: "my.props";
		SpringApplication.run(GraalTestApplication.class, args);
	}

	@PostConstruct
	public void setProperty() {
		System.setProperty("app.home", Paths.get(".").toAbsolutePath().toString());
	}

}
