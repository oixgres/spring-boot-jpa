package com.example.springbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JDBCCommandLineRunner implements CommandLineRunner {
    @Autowired
    private  JDBCRepository jdbcRepository;
    @Override
    public void run(String... args) throws Exception {
        jdbcRepository.insert(new Course(1, "LearnSomeStuff", "sergio"));
        jdbcRepository.insert(new Course(2, "LearnSomeStuff2", "sergio"));
        jdbcRepository.delete(1L);

        System.out.println(jdbcRepository.select(2));
    }
}
