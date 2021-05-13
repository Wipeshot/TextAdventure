package me.mustache.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {

    //private static List<String> answers;
    private static String[] answers = new String[4];

    public Database(){

    }

    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:database/" + fileName;

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

    public static void insertIntoStory(String story, String answerIds){
        String insertStory = "INSERT INTO story(storyText, answerIds)\n"
                    + " VALUES(" + story + ", " + answerIds + ")"
                    + " ;";
    }

    public static void insertIntoAnswer(String answer){
        String insertAnswer = "INSERT INTO answer(answerText)"
                        + " VALUES(" + answer + ")"
                        + " ;";
    }

    public static String getFirstStory(){
        String firstStory = "SELECT storyText \n"
                    + " FROM story"
                    + " WHERE storyId = 1"
                    + ";";
        return firstStory;
    }

    public static String[] getFirstAnswers(){
        for(int i = 1; i <= 4; i++) {
            answers[i-1] = ("SELECT answerText"
                    + " FROM answer"
                    + " WHERE answerId = " + i
                    + " ;");
        }
        return answers;
    }

    public static String getStoryByAnswer(int answerID){
        return " SELECT storyText"
                        + " FROM story s, answer a"
                        + " WHERE s.answerId = " + answerID;
    }


}
