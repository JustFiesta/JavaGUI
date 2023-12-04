package com.example.javafx.Labs.no5;

import java.time.LocalDate;

public class Worker {
    private String name, secondName, occupation;
    private char sex;
    private boolean active;
    private LocalDate birthDate;


    public Worker(String name, String secondName, String occupation, char sex, boolean active, LocalDate birthDate) {
        this.name = name;
        this.secondName = secondName;
        this.occupation = occupation;
        this.sex = sex;
        this.active = active;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
