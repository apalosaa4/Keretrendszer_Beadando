package uni.eszterhazy.keretrendszer.dao.mongo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import uni.eszterhazy.keretrendszer.model.Termek;

import java.io.IOException;

public class TermekAdapter {
    private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public static Termek dbObjectToTermek(DBObject termek){
        try {
            Termek obj = mapper.readValue(termek.toString(),Termek.class);
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DBObject termekToDBObject(Termek termek){
        String termekString= "";
        try {
            termekString = mapper.writeValueAsString(termek);
            BasicDBObject obj = mapper.readValue(termekString, BasicDBObject.class);
            return obj;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BasicDBObject();
    }
}