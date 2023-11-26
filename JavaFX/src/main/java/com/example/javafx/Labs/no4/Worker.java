package com.example.javafx.Labs.no4;

import java.time.LocalDate;
import java.util.Date;

public class Worker {
    private String name, secondName, occupation;
    private int experience;
    private LocalDate birthDate;

    public Worker(String name, String secondName, String occupation, int experience, LocalDate birthDate) {
        this.name = name;
        this.secondName = secondName;
        this.occupation = occupation;
        this.experience = experience;
        this.birthDate = birthDate;
    }
}
