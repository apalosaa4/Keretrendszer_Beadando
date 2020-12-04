package uni.eszterhazy.keretrendszer.dao.mongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;
import com.mongodb.util.JSON;
import uni.eszterhazy.keretrendszer.dao.TermekDAO;
import uni.eszterhazy.keretrendszer.exception.TermekAlreadyAdded;
import uni.eszterhazy.keretrendszer.exception.TermekNotFound;
import uni.eszterhazy.keretrendszer.model.Termek;
import uni.eszterhazy.keretrendszer.model.Kategoria;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;

public class TermekDAOMongo implements TermekDAO {
    private MongoClient client;
    private DB db;
    private DBCollection collection;


    public TermekDAOMongo(String uri, String database, String collection) throws UnknownHostException {
        this.client = new MongoClient(new MongoClientURI(uri));
        this.db = client.getDB(database);
        this.collection = db.getCollection(collection);
    }

    public void createTermek(Termek termek) throws TermekAlreadyAdded {
        try {
            readTermek(termek.getId());
        } catch (TermekNotFound termekNotFound) {
            collection.insert(TermekAdapter.termekToDBObject(termek));
            return;
        }
        throw new TermekAlreadyAdded(termek.getId());
    }

    public Collection<Termek> readAllTermek(){
        DBCursor cursor = collection.find(new BasicDBObject(), new BasicDBObject().append("_id",0));
        Collection<Termek> result = new ArrayList<>();
        cursor.forEach(o->{
            result.add(TermekAdapter.dbObjectToTermek(o));
        });
        return result;
    }

    public Termek readTermek(String id) throws TermekNotFound {
        DBCursor cursor = collection.find(new BasicDBObject().append("id",id), new BasicDBObject().append("_id",0));
        if(cursor.length()==0){
            throw new TermekNotFound(id);
        }
        return TermekAdapter.dbObjectToTermek(cursor.one());
    }

    public void updateTermek(Termek termek) {

    }

    public void deleteTermek(Termek termek) {

    }

    public Collection<Termek> readAllTermekOfKategoria(Kategoria kategoria) {
        return null;
    }
}