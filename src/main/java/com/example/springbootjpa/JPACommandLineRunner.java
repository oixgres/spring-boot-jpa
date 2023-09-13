package com.example.springbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JPACommandLineRunner implements CommandLineRunner {
    @Autowired
    private SpringJPARepository jpaRepository;

    @Override
    public void run(String... args) throws Exception {
        jpaRepository.save(new Course(1, "LearnSomeStuff", "sergio"));
        jpaRepository.save(new Course(2, "LearnSomeStuff2", "sergio"));
        jpaRepository.deleteById(1L);

        System.out.println(jpaRepository.findById(2L));
    }
}
