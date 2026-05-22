package utils;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {
	
    public static Employee getEmployee(String usuario) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            Map<String, Employee> datos = mapper.readValue(
                new File("src/test/resources/data/employeeData.json"),
                new TypeReference<Map<String, Employee>>() {}
            );

            return datos.get(usuario);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

}
