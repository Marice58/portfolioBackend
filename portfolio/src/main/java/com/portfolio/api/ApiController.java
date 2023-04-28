package com.portfolio.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    private JdbcTemplate jdbcTemplate; // or EntityManager entityManager;


    @GetMapping("/portfolio")
    @ResponseBody
    public List<portfolio> getPortfolio() {
        String sql = "SELECT * FROM portfolios";
        List<portfolio> examples = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(portfolio.class));
        return examples;
    }
}
