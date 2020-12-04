package uni.eszeterhazy.keretrendszer.dao.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import uni.eszterhazy.keretrendszer.dao.TermekDAO;
import uni.eszterhazy.keretrendszer.model.Kategoria;
import uni.eszterhazy.keretrendszer.model.Termek;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class TermekDAOJSON implements TermekDAO {

    File jsonFile;

    ObjectMapper mapper;

    public TermekDAOJSON(String jsonfilePath) throws IOException {
        jsonFile = new File(jsonfilePath);
        if (!jsonFile.exists()){
            jsonFile.createNewFile();
            FileWriter writer = new FileWriter(jsonFile);
            writer.write("[]");
            writer.flush();
            writer.close();
        }
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    public void createTermek(Termek termek) {

    }

    public Collection<Termek> readAllTermek() {
        return null;
    }

    public Termek readTermek(String id) {
        return null;
    }

    public void updateTermek(Termek termek) {

    }

    public void deleteTermek(Termek termek) {

    }

    public Collection<Termek> readAllTermekOfKategoria(Kategoria kategoria) {
        return null;
    }
}
