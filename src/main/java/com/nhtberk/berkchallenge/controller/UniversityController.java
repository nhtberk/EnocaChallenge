package com.nhtberk.berkchallenge.controller;

import com.nhtberk.berkchallenge.model.Student;
import com.nhtberk.berkchallenge.model.University;
import com.nhtberk.berkchallenge.service.UniversityServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UniversityController {

    private final UniversityServices universityServices;

    @GetMapping("/university/all")
    public List<University> getAll() {
        return universityServices.findAll();
    }

    @GetMapping("/university/{id}")
    public ResponseEntity<University> getUniversityById(@PathVariable long id) {
        return new ResponseEntity<>(universityServices.findById(id), HttpStatus.OK);
    }

    @PostMapping("/university/save")
    public ResponseEntity<String> save(@RequestBody University university) {
        try {
            universityServices.save(university);
            String universityName = university.getName();
            return new ResponseEntity<>(universityName + "has been saved", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unsuccessful", HttpStatus.OK);
        }
    }

    @PutMapping("/university/update/{id}")
    public University update(@RequestBody University newUniversity, @PathVariable int id) {
        return universityServices.updateById(id, newUniversity);
    }

    @DeleteMapping("/university/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        try {
            University university = universityServices.findById(id);
            String nameOfUniversity = university.getName();
            universityServices.deleteById(id);
            return new ResponseEntity<>(nameOfUniversity + " has deleted.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
        }
    }
}
