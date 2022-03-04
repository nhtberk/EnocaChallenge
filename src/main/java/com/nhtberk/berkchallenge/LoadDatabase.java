package com.nhtberk.berkchallenge;


import com.nhtberk.berkchallenge.model.Student;
import com.nhtberk.berkchallenge.model.University;
import com.nhtberk.berkchallenge.repository.UniversityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
class LoadDatabase {

    private static final Logger logger= LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UniversityRepository universityRepository){

        return args -> {
            if(universityRepository.findAll().size()==0){
                University university= new University("Karabuk University","Karabuk");
                universityRepository.save(university);
                Student berk= new Student("Nihat Berk", "Öz", "berkoz5555@gmail.com", "Computer Engineering");
                Student nilay= new Student("Nilay", "Aktaş", "nilayaktas0019@gmail.com", "Industrial Engineering");
                university.setStudents(Arrays.asList(berk, nilay));
                logger.info("Preloading " + universityRepository.save(university));
            }
        };
    }
}
