package h61gradle.prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Prefs {
    public static final String DB_URL="dbUrl";
    public static final String INIT_DB_SQL_FILE_PATH= "initDbSql";
    public static final String POPULATE_DB_SQL_FILE_PATH= "populateServiceSql";
    public static final String QUERY1_DB_SQL_FILE_PATH="queryMaxSalaryWorkerSql";
    public static final String QUERY2_DB_SQL_FILE_PATH= "queryMaxProjectsClientSql";
    public static final String QUERY3_DB_SQL_FILE_PATH= "queryLongestProjectSql";
    public static final String QUERY4_DB_SQL_FILE_PATH= "queryYoungestEldestWorkersSql";
    public static final String QUERY5_DB_SQL_FILE_PATH= "queryProjectPricesSql";
    public static final String DEFAULT_PREFS_FILENAME= "prefs1.json";
    private Map<String, Object> prefs = new HashMap<>();
    public Prefs(){
        this (DEFAULT_PREFS_FILENAME);

    }
    public Prefs(String filename){
        try{
            String json;
            json = String.join( "\n", Files.readAllLines(Paths.get(filename)) );

            TypeToken<?> typeToken = TypeToken.getParameterized(
                    Map.class,
                    String.class,
                    Object.class);
            prefs= new Gson().fromJson(json,typeToken.getType());

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public String getString(String key){

        return getPref(key).toString();
    }
    public Object getPref(String key){
        return  prefs.get(key);
    }


}

