package com.abhishek.task_management_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetController {

    @GetMapping()
    public ResponseEntity<String> greeting(){
        return new ResponseEntity<>("Welcome Hackers", HttpStatus.OK);
    }

}
