package com.udemy.kafka.applicationdemokafka.util;

import com.udemy.kafka.applicationdemokafka.dto.CarDTO;

import java.util.UUID;

public class BuilderUtil {

    public static CarDTO getBuildCarDto(CarDTO carDTO){
        CarDTO car = CarDTO.builder()
                .id(UUID.randomUUID().toString())
                .model(carDTO.getModel())
                .color(carDTO.getColor())
                .build();

        return car;
    }
}
