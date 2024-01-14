package ru.neto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neto.dao.DbRepository;

import java.sql.SQLException;
import java.util.List;

@RestController
public class JdbcController {
    private final DbRepository repository;
    public JdbcController(DbRepository repository){
        this.repository=repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@RequestParam("name")String name) throws SQLException {
        var t = repository.getProductName(name);
        return t;
    }
}
