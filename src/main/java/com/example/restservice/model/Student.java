package com.example.restservice.model;

import lombok.*;

//Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Student {
    private long studentNo;
    private String fName;
    private String lName;
    private String address;
    private boolean activeflag;
}
