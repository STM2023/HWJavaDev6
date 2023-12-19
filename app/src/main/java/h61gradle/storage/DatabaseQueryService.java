package h61gradle.storage;

import h61gradle.infoClass.LongestProject;
import h61gradle.infoClass.YoungestEldestWorkers;
import h61gradle.infoClass.MaxProjectCountClient;
import h61gradle.infoClass.MaxSalaryWorker;
import h61gradle.prefs.Prefs;
import h61gradle.infoClass.ProjectPrices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

  public   List<MaxSalaryWorker> findMaxSalaryWorker() throws SQLException {
       List<MaxSalaryWorker>  result = new ArrayList<>() ;

        Database database = Database.getInstance();
        try {
            String queryFilename = new Prefs().getString(Prefs.QUERY1_DB_SQL_FILE_PATH);

            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(queryFilename)));

            try (Statement st = database.getConnection().createStatement()){
                try(ResultSet rs = st.executeQuery(sql)){
                    while(rs.next()) {
                        String name = rs.getString("name");
                        int salary = rs.getInt("salary");

                    //    System.out.println("name: " + name);
                    //    System.out.println("salary: " + salary);

                        result.add(new MaxSalaryWorker(name,salary));
                     }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
     return result;
    }
    public   List<MaxProjectCountClient> findMaxProjectCountClient() throws SQLException {
        List<MaxProjectCountClient>  result = new ArrayList<>() ;

        Database database = Database.getInstance();
        try {
            String queryFilename = new Prefs().getString(Prefs.QUERY2_DB_SQL_FILE_PATH);

            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(queryFilename)));

            try (Statement st = database.getConnection().createStatement()){
                try(ResultSet rs = st.executeQuery(sql)){
                    while(rs.next()) {
                        String name = rs.getString("name");
                        int projectCount = rs.getInt("project_count");

                  //      System.out.println("name: " + name);
                  //      System.out.println("projectCount: " + projectCount);

                        result.add(new MaxProjectCountClient(name,projectCount));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public   List<LongestProject> findLongestProject() throws SQLException {
        List<LongestProject>  result = new ArrayList<>() ;

        Database database = Database.getInstance();
        try {
            String queryFilename = new Prefs().getString(Prefs.QUERY3_DB_SQL_FILE_PATH);

            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(queryFilename)));

            try (Statement st = database.getConnection().createStatement()){
                try(ResultSet rs = st.executeQuery(sql)){
                    while(rs.next()) {
                        String name = rs.getString("name");
                        int monthCount = rs.getInt("month_count");

                   //     System.out.println("name: " + name);
                   //     System.out.println("projectCount: " + monthCount);

                        result.add(new LongestProject(name,monthCount));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public   List<YoungestEldestWorkers> findYoungestEldestWorkers() throws SQLException {
        List<YoungestEldestWorkers>  result = new ArrayList<>() ;

        Database database = Database.getInstance();
        try {
            String queryFilename = new Prefs().getString(Prefs.QUERY4_DB_SQL_FILE_PATH);

            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(queryFilename)));

            try (Statement st = database.getConnection().createStatement()){
                try(ResultSet rs = st.executeQuery(sql)){
                    while(rs.next()) {
                        String type= rs.getString("type");
                        String name = rs.getString("name");
                        LocalDate birthday=LocalDate.parse(rs.getString("birthday"));

                     //   System.out.println("type: " + type);
                     //   System.out.println("name: " + name);
                     //   System.out.println("birthday: " + birthday);
                        result.add(new YoungestEldestWorkers(type,name,birthday));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public   List<ProjectPrices> findProjectPrices() throws SQLException {
        List<ProjectPrices>  result = new ArrayList<>() ;

        Database database = Database.getInstance();
        try {
            String queryFilename = new Prefs().getString(Prefs.QUERY5_DB_SQL_FILE_PATH);

            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(queryFilename)));

            try (Statement st = database.getConnection().createStatement()){
                try(ResultSet rs = st.executeQuery(sql)){
                    while(rs.next()) {

                        String name = rs.getString("name");
                        int price = rs.getInt("price");

                   //     System.out.println("name: " + name);
                   //     System.out.println("price: " + price);

                        result.add(new ProjectPrices(name,price));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
