package me.mustache.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Database {

    private static String url;
    private List<String> answers = new List<String>();

    public Database(){

    }

    public static void createNewDatabase(String fileName) {

        setUrl("jdbc:sqlite:database/" + fileName);

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createStory(){
        String tableStory = "CREATE TABLE IF NOT EXISTS story (\n"
                + " storyId INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " storyText TEXT,"
                + " answerIds TEXT"
                + ");";

        String tableAnswer = "CREATE TABLE IF NOT EXISTS answer (\n"
                + " answerId INTEGER PRIMARY KEY AUTOINCREMENT\n"
                + " answerText TEXT NOT NULL,\n"
                + ");";
    }

    public String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Database.url = url;
    }

    public String getFirstStory(){
        String firstStory = "SELECT storyText \n"
                    + " FROM story"
                    + " WHERE storyId = 0"
                    + ";";
        return firstStory;
    }

    public List<String> getFirstAnswers(){
        for(int i = 0; i < 4; i++) {
            answers.add("SELECT answerText"
                    + "FROM answer"
                    + "WHERE answerId = " + i
                    + ";");
        }
        return answers;
    }

    public String getStoryByAnswer(int answerID){
        String nextStory = " SELECT storyText"
                        + " FROM story s, answer a"
                        + " WHERE s.answerId = " + answerID;
        return nextStory;
    }


}
