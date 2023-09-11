package com.example.springbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository //bean that performs database operations
public class JDBCRepository {
    @Autowired
    private JdbcTemplate springJDBCTemplate;
    private static String INSERT_QUERY = """
        INSERT INTO course(id, name, author)
        VALUES (?, ?, ?);
    """;

    private static String DELETE_QUERY = """
        DELETE FROM COURSE    
        WHERE id = ?
    """;

    private static String SELECT_QUERY = """
        SELECT * FROM COURSE    
        WHERE id = ?
    """;

    public Course select(long id){
        return springJDBCTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }

    public void insert(Course course){
        springJDBCTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(Long id){
        springJDBCTemplate.update(DELETE_QUERY, id);
    }
}
