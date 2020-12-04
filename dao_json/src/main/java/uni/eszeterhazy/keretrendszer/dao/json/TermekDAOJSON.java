package uni.eszeterhazy.keretrendszer.dao.json;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import uni.eszterhazy.keretrendszer.dao.TermekDAO;
import uni.eszterhazy.keretrendszer.model.Kategoria;
import uni.eszterhazy.keretrendszer.model.Termek;
import uni.eszterhazy.keretrendszer.exception.TermekAlreadyAdded;
import uni.eszterhazy.keretrendszer.exception.TermekNotFound;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    public void createTermek(Termek termek) throws TermekAlreadyAdded {
        Collection<Termek> termekek = readAllTermek();

        Termek result = null;
        try {
            result = readTermek(termek.getId());
        } catch (TermekNotFound termekNotFound) {
            termekek.add(termek);
            try {
                mapper.writeValue(jsonFile, termekek);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new TermekAlreadyAdded(termek.getId());
    }

    public Collection<Termek> readAllTermek() {
        Collection<Termek> termekek = new ArrayList<Termek>();
        TypeReference type = new TypeReference<ArrayList<Termek>>() {};
        try {
            termekek = mapper.readValue(jsonFile,type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return termekek;
    }

    public Termek readTermek(String id) throws TermekNotFound {
        Collection<Termek> termekek = readAllTermek();
        for (Termek t: termekek){
            if(t.getId().equalsIgnoreCase(id)){
                return t;
            }
        }
        throw new TermekNotFound(id);
    }

    public void updateTermek(Termek termek) {

    }

    public void deleteTermek(Termek termek) {

    }

    public Collection<Termek> readAllTermekOfKategoria(Kategoria kategoria) {
        return null;
    }
}
