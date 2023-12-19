package h61gradle.storage;

import h61gradle.prefs.Prefs;
import h61gradle.storage.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        try {
            String populateFilename = new Prefs().getString(Prefs.POPULATE_DB_SQL_FILE_PATH);

            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(populateFilename)));
            database.executeUpdate(sql);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
