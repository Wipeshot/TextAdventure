package me.mustache.database;

import java.sql.*;
import java.util.ArrayList;


public class Database {

    private static String[] answers = new String[4];
    private static int[] answerIds = new int[4];
    private static String answerIdsString;
    private static int[] storyId = new int[4];
    private static String url;
    private static String firstStory;
    private static String storyByAnswer;
    private static int nextStoryId;
    private static int[] currentAnswerId = new int[4];
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
                + " answerText VARCHAR(10) NOT NULL,\n"
                + " storyId INTEGER,\n"
                + " FOREIGN KEY(storyId) REFERENCES story(storyId)"
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

    public static void setStoryForAnswer(int answerId, int storyId){
        String insertStoryIdToAnswer = "UPDATE answer\n"
                                    + " SET storyId = ?\n"
                                    + " WHERE answerId = ?"
                                    + " ;";
        try (Connection conn = DriverManager.getConnection(url)){
            if(conn != null){
                PreparedStatement pstmt = conn.prepareStatement(insertStoryIdToAnswer);
                pstmt.setInt(1, storyId);
                pstmt.setInt(2, answerId);
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
        String sql = "SELECT answerText, storyId\n"
                + " FROM answer\n"
                + " WHERE answerId = ?";
        String[] answers = new String[4];
        for(int i = 0; i <4; i++){
            try (Connection conn = DriverManager.getConnection(url)){
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, i+1);
                ResultSet rs = pstmt.executeQuery();
                answers[i] = rs.getString("answerText");
                storyId[i] = rs.getInt("storyId");
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }


        }

        return answers;
    }

    public static int getNextStoryId(int answerId){
        String nextStory = "SELECT a.storyId\n"
                + " FROM answer a\n"
                + " WHERE a.answerId = ?"
                + " ;";
        try (Connection conn = DriverManager.getConnection(url)){
            PreparedStatement pstmt = conn.prepareStatement(nextStory);
            pstmt.setInt(1, answerId);
            ResultSet rs = pstmt.executeQuery();
            nextStoryId = rs.getInt("storyId");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("NEXT STORY IS " + nextStoryId);
        return nextStoryId;
    }

    public static String getStoryByAnswer(int answerId){
        String sql = "SELECT storyText\n"
                + " FROM story s, answer a\n"
                + " WHERE a.storyId = s.storyId\n"
                + " AND a.answerId = ?"
                + " ;";

            try (Connection conn = DriverManager.getConnection(url)){
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, answerId);
                ResultSet rs = pstmt.executeQuery();
                storyByAnswer = rs.getString("storyText");
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return storyByAnswer;
    }

    public static String[] getAnswersByStory(int storyId){
        String sql = "SELECT answerText\n"
                    + " FROM answer a, story s\n"
                    + " WHERE a.answerId = ?\n"
                    + " AND s.storyId = ?\n"
                    + " ;";
        for(int i = 0; i < 4; i++) {
            try (Connection conn = DriverManager.getConnection(url)) {
                int[] aId;
                aId = getAnswerIdsByStory(storyId);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, aId[i]);
                pstmt.setInt(2, storyId);
                ResultSet rs = pstmt.executeQuery();
                answers[i] = rs.getString("answerText");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return answers;
    }

    public static int[] getAnswerIdsByStory(int storyId){
        String sql = "SELECT answerIds\n"
                + " FROM story\n"
                + " WHERE storyId = ?"
                + " ;";
            try (Connection conn = DriverManager.getConnection(url)) {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, storyId);
                ResultSet rs = pstmt.executeQuery();
                answerIdsString = rs.getString("answerIds");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        int i = 0;
        for (String s : answerIdsString.split(",")) {
            answerIds[i] = Integer.parseInt(s);
            if(i<4) {
                i++;
            }
        }
        return answerIds;
    }

    public static void createHaendler(){
        String createHaendler = "CREATE TABLE IF NOT EXISTS haendler (\n"
                + " haendlerId INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " haendlerName TEXT NOT NULL\n"
                + ");";
        try (Connection conn = DriverManager.getConnection(url)){
            if(conn != null){
                stmt = conn.createStatement();
                stmt.executeUpdate(createHaendler);
                stmt.close();
                conn.close();
            }
        } catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void createNewHaendler(String name){
        String createNewHaendler = "INSERT INTO haendler(haendlerName)\n"
                + " VALUES(?)"
                + " ;";

        try (Connection conn = DriverManager.getConnection(url)){
            PreparedStatement pstmt = conn.prepareStatement(createNewHaendler);
            pstmt.setString(1, name);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createHaendlerInventar(){
        String createHaendlerInventar = "CREATE TABLE IF NOT EXISTS haendlerInventar"
                + " haendlerInventarId INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " itemId INTEGER NOT NULL,\n"
                + " anzahl INTEGER NOT NULL,\n"
                + " haendlerId INTEGER NOT NULL,\n"
                + " FOREIGN KEY(itemId) REFERENCES item(itemId),\n"
                + " FOREIGN KEY(haendlerId) REFERENCES haendler(haendlerId)"
                + " );";

        try (Connection conn = DriverManager.getConnection(url)){
            if(conn != null){
                stmt = conn.createStatement();
                stmt.executeUpdate(createHaendlerInventar);
                stmt.close();
                conn.close();
            }
        } catch(SQLException e){
            System.out.println(e);
        }
    }

   /* public static int[][] getHaendlerInventar(int haendlerId){
        int[][] inventar;
        String getInventar = "SELECT itemId, anzahl\n"
                + " FROM haendlerInventar\n"
                + " WHERE haendlerId = ?";
        try (Connection conn = DriverManager.getConnection(url)){
            PreparedStatement pstmt = conn.prepareStatement(getInventar);
            pstmt.setInt(1, haendlerId);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Integer> item = new ArrayList<>();
            ArrayList<Integer> anz = new ArrayList<>();
            item = rs.getInt("itemId");
            anz = rs.getInt("anzahl");
            int i = item.size();
            int[][] inv = new int[i][i];
            for(int z = 0; z <= i; z++){
                inv[z] = item.toArray();
                inv[z][z] = anz.toArray();
            }
            inventar = inv;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return inventar;
    }*/

    public static void insertIntoHaendlerInventar(int haendlerId, int itemId, int anzahl ){
        String insertIntoHaendlerInventar = "INSERT INTO haendlerInventar(haendlerId, itemId, anzahl)\n"
                + " VALUES(?,?,?)"
                + " ;";
        try (Connection conn = DriverManager.getConnection(url)){
            PreparedStatement pstmt = conn.prepareStatement(insertIntoHaendlerInventar);
            pstmt.setInt(1, haendlerId);
            pstmt.setInt(2, itemId);
            pstmt.setInt(3, anzahl);
            pstmt.executeQuery();
            pstmt.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createItemTable(){
        String itemTable = "CREATE TABLE IF NOT EXISTS item (\n"
                + " itemId INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " name TEXT,\n"
                + " description TEXT ,\n"
                + " price INTEGER"
                + ");";

        try (Connection conn = DriverManager.getConnection(url)){
            if(conn != null){
                stmt = conn.createStatement();
                stmt.executeUpdate(itemTable);
                stmt.close();
                conn.close();
            }
        } catch(SQLException e){
            System.out.println(e);
        }
    }


}
