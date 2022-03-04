package com.nhtberk.berkchallenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class University {

    private @Id @GeneratedValue long id;
    private String name;
    private String address;

    public University(String name, String address) {
        this.address=address;
        this.name=name;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "university_id")
    private List<Student> students;
}
