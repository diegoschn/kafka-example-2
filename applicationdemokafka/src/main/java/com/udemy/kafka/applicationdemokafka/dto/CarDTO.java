package com.udemy.kafka.applicationdemokafka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class CarDTO {

    private String id;
    private String model;
    private String color;
}
