package me.mustache.database;

import java.sql.*;


public class Database {

    private static String[] answers = new String[4];
    private static String url;
    private static String firstStory;
    static Statement stmt;

    public Database(){

    }

    public static void createNewDatabase(String fileName) {

        url = "jdbc:sqlite:database/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                stmt = conn.createStatement();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void createStory(){
        String tableStory = "CREATE TABLE IF NOT EXISTS story (\n"
                + " storyId INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " storyText VARCHAR(10) NOT NULL,\n"
                + " answerIds VARCHAR(10) NOT NULL"
                + ");";

        String tableAnswer = "CREATE TABLE IF NOT EXISTS answer (\n"
                + " answerId INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " answerText VARCHAR(10) NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(url)){
            if(conn != null){
                stmt = conn.createStatement();
                stmt.executeUpdate(tableStory);
                stmt.executeUpdate(tableAnswer);
                stmt.close();
                conn.close();
            }
        } catch(SQLException e){
            System.out.println(e);
        }

    }

    public static void insertIntoStory(String story, String answerIds){
        String insertStory = "INSERT INTO story(storyText, answerIds)\n"
                     + " VALUES(?,?)"
                       + " ;";
        try (Connection conn = DriverManager.getConnection(url)){
            if(conn != null){
                PreparedStatement pstmt = conn.prepareStatement(insertStory);
                pstmt.setString(1, story);
                pstmt.setString(2, answerIds);
                pstmt.executeUpdate();
                conn.close();
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        }

    public static void insertIntoAnswer(String answer){
        String insertAnswer = "INSERT INTO answer(answerText)"
                        + " VALUES(?)"
                        + " ;";
        try (Connection conn = DriverManager.getConnection(url)){
            if(conn != null){
                PreparedStatement pstmt = conn.prepareStatement(insertAnswer);
                pstmt.setString(1, answer);
                pstmt.executeUpdate();
                conn.close();
            }
        } catch(SQLException e){
            System.out.println(e);
        }
    }


    public static String getFirstStory(){
        String sql = "SELECT storyText\n"
                    + " FROM story\n"
                    + " WHERE storyId = ?"
                    + " ;";
        try (Connection conn = DriverManager.getConnection(url)){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1);
            ResultSet rs = pstmt.executeQuery();
             firstStory = rs.getString("storyText");
            }
         catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return firstStory;
    }

    public static String[] getFirstAnswers(){
        String sql = "SELECT answerText\n"
                + " FROM answer\n"
                + " WHERE answerId = ?";
        String[] answers = new String[4];
        for(int i = 0; i <4; i++){
            try (Connection conn = DriverManager.getConnection(url)){
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, i+1);
                ResultSet rs = pstmt.executeQuery();
                answers[i] = rs.getString("answerText");
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }


        }

        return answers;
    }


}
