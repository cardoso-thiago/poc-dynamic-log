package br.com.cardoso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class PocDynamicLogApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(PocDynamicLogApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PocDynamicLogApplication.class, args);
    }

    @Scheduled(fixedRate = 3000)
    public void log() {
		LOGGER.trace("Log de trace");
		LOGGER.debug("Log de debug");
		LOGGER.info("Log de info");
		LOGGER.warn("Log de warn");
		LOGGER.error("Log de error");
    }
}
