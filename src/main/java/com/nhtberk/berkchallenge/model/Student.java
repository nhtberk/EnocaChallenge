package com.nhtberk.berkchallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private @Id @GeneratedValue long id;
    private String name;
    private String surname;
    private String email;
    private String department;

    public Student(String name, String surname, String email, String department) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.department = department;
    }

    @ManyToOne
    @JsonIgnore //model tekrarlanmasını engeller.
    @JoinColumn(name = "university_id",referencedColumnName = "id")
    private University university;
}
