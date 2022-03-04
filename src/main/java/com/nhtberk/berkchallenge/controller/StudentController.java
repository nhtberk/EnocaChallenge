package com.nhtberk.berkchallenge.controller;

import com.nhtberk.berkchallenge.model.Student;
import com.nhtberk.berkchallenge.model.University;
import com.nhtberk.berkchallenge.service.StudentServices;
import com.nhtberk.berkchallenge.service.UniversityServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class StudentController {

    public final UniversityServices universityServices;
    public final StudentServices studentServices;

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        return new ResponseEntity<>(studentServices.findById(id), HttpStatus.OK);
    }
    @GetMapping("/university/{university_id}/student")
    public ResponseEntity<List<Student>> getStudents(@PathVariable long university_id){
        return new ResponseEntity<>(universityServices.findById(university_id).getStudents(), HttpStatus.OK );
    }

    @PostMapping("/university/{university_id}/student/save")
    public ResponseEntity<String> save(@RequestBody Student newStudent,@PathVariable long university_id){
        try {
            University university = universityServices.findById(university_id);
            university.getStudents().add(newStudent);
            studentServices.save(newStudent);
            universityServices.save(university);
            String nameofStudent = newStudent.getName();
            return new ResponseEntity<>(nameofStudent + " has added to "+university.getName(), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/student/{id}")
    public Student update( @PathVariable long id ,@RequestBody Student newStudent ) {

        return studentServices.updateById(id, newStudent);
    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> delete(@PathVariable long id ) {
        try {
            Student student = studentServices.findById(id);
            String nameOfStudent = student.getName();
            studentServices.delete(student);
            return new ResponseEntity<>(nameOfStudent + " has deleted.", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
        }
    }

}
