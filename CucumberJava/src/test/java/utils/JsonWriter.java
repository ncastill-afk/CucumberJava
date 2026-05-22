package utils;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonWriter {
	public static void actualizarEmployeeId(
            String usuario,
            String nuevoId) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            File archivo = new File(
                "src/test/resources/data/employeeData.json"
            );

            Map<String, Employee> datos = mapper.readValue(
                archivo,
                new TypeReference<Map<String, Employee>>() {}
            );
            
            datos.get(usuario).id = nuevoId;

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(archivo, datos);

            System.out.println("JSON actualizado");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
