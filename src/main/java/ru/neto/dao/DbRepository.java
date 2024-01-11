package ru.neto.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DbRepository {

    @Autowired
    private DataSource dataSource;
/*    @Autowired
    private JdbcTemplate jdbcTemplate;*/
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${application.getProductNameByNameScript}")
    private String getProductNameByNameScript;

    public List<String> getProductName(String name) throws SQLException {
        Connection connection = dataSource.getConnection();
        HashMap<String, Object> param = new HashMap<>();
        param.put("name",name);
        String sql = read(getProductNameByNameScript);
        List<String> productsNames = namedParameterJdbcTemplate.query(sql,param,(rs,rowNum)->{
            return rs.getString("product_name");
        });
        return productsNames;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
