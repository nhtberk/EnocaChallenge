package com.nhtberk.berkchallenge.service;

import com.nhtberk.berkchallenge.exception.UniversityNotFoundException;
import com.nhtberk.berkchallenge.model.University;
import com.nhtberk.berkchallenge.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServices {

    @Autowired
    private UniversityRepository universityRepository;

    public void save(University university){
        universityRepository.save(university);
    }

    public List<University> findAll(){
        return universityRepository.findAll();
    }

    public University findById(long id){
        return universityRepository.findById(id).orElseThrow(()->new UniversityNotFoundException(id));
    }
    public University updateById(long id ,University newUniversity){

        return universityRepository.findById(id).map( university -> {
                    university.setName(newUniversity.getName());
                    university.setAddress(newUniversity.getAddress());
                    return universityRepository.save(university);
                })
                .orElseGet(() -> {
                    newUniversity.setId(id);
                    return universityRepository.save(newUniversity);
                });
    }

    public void deleteById(long id){

        universityRepository.deleteById(id);
    }
}
