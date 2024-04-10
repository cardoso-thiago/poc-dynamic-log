package br.com.cardoso.controller;

import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private final LoggingSystem loggingSystem;

    public LogController(LoggingSystem loggingSystem) {
        this.loggingSystem = loggingSystem;
    }

    @GetMapping("/log/{level}")
    public ResponseEntity<String> changeLogLevel(@PathVariable("level") String level) {
        loggingSystem.setLogLevel("ROOT", LogLevel.valueOf(level));
        return ResponseEntity.ok("OK");
    }
}
