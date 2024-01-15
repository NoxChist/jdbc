package ru.neto.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DbRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final HashMap<String, String> scriptMap;

    public DbRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, @Value("#{'${sqlScript.filenames.stringList}'.split(',')}") List<String> scriptsFileNamesList) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        scriptMap = new HashMap<>();
        for (String fileName : scriptsFileNamesList) {
            scriptMap.put(fileName, read(fileName));
        }
    }

    public List<String> getProductName(String name) throws SQLException {

        HashMap<String, Object> param = new HashMap<>();
        param.put("name", name);
        return namedParameterJdbcTemplate.queryForList(scriptMap.get("getProductNameByNameScript.sql"), param, String.class);
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
