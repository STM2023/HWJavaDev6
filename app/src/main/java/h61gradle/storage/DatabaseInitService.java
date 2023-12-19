package h61gradle.storage;

import h61gradle.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        try {
            String initDbFilename = new Prefs().getString(Prefs.INIT_DB_SQL_FILE_PATH);

            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(initDbFilename)));
            database.executeUpdate(sql);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
