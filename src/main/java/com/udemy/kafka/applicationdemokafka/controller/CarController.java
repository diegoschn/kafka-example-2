package com.udemy.kafka.applicationdemokafka.controller;

import com.udemy.kafka.applicationdemokafka.dto.CarDTO;
import com.udemy.kafka.applicationdemokafka.producer.CarProducer;
import com.udemy.kafka.applicationdemokafka.util.BuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarProducer carProducer;

    @PostMapping
    public ResponseEntity<CarDTO> create(@RequestBody CarDTO carDTO){
        CarDTO car = BuilderUtil.getBuildCarDto(carDTO);
        carProducer.sendMessage(car);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }


}
