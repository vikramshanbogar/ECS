package com.vikram.customers.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/db/")
public class DbHealthCheckController {
@Autowired
JdbcTemplate template;

private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

@GetMapping("/health")
public ResponseEntity<?> dbHealthCheck() {
    LOGGER.info("checking db health");
    try {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 1)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("DOWN");
        return ResponseEntity.ok("UP");
    } catch (Exception ex) {
        ex.printStackTrace();
        LOGGER.error("Error Occured" + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("DOWN");
    }
}

   private int check() {
     List<Object> results = template.query("select 1 from dual", new
             SingleColumnRowMapper<>());
          return results.size();
     }
}