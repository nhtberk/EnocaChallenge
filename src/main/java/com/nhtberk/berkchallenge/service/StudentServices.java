package com.nhtberk.berkchallenge.service;

import com.nhtberk.berkchallenge.exception.StudentNotFoundException;
import com.nhtberk.berkchallenge.model.Student;
import com.nhtberk.berkchallenge.model.University;
import com.nhtberk.berkchallenge.repository.StudentRepository;
import com.nhtberk.berkchallenge.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {

    @Autowired
    private StudentRepository studentRepository;

    public Student findById(long id){
        return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
    }
    public void save(Student student){
        studentRepository.save(student);
    }

    public void delete( Student student ){
        studentRepository.delete(student);
    }

    public Student updateById(long id, Student newStudent ){

        return studentRepository.findById(id).map( student -> {
                    student.setName(newStudent.getName());
                    student.setSurname(newStudent.getSurname());
                    student.setEmail(newStudent.getEmail());
                    student.setDepartment(newStudent.getDepartment());
                    return studentRepository.save(student);
                })
                .orElseGet( () -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }
}
