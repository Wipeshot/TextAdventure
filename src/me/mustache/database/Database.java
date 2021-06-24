package me.mustache.database;

import me.mustache.gui.MetadataInventar;
import me.mustache.items.*;

import java.sql.*;
import java.util.ArrayList;


public class Database {

    private static final String[] answers = new String[4];
    private static final int[] answerIds = new int[4];
    private static String answerIdsString;
    private static final int[] storyId = new int[4];
    private static String url;
    private static String firstStory;
    private static String storyByAnswer;
    private static int nextStoryId;
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

    public static int getEnum(int answerId){
        int answer = 0;
        String getEnum = "SELECT enumLevel\n"
                + " FROM answer\n"
                + " WHERE answerId = ?"
                + " ;";
        try (Connection conn = DriverManager.getConnection(url)) {
            PreparedStatement pstmt = conn.prepareStatement(getEnum);
            pstmt.setInt(1, answerId);
            ResultSet rs = pstmt.executeQuery();
            answer = rs.getInt("enumLevel");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return answer;
    }

    public static void addItem(int id){
        String getItemInfo = "SELECT itemId, type, name, desc\n"
                + " FROM items i\n"
                + " WHERE itemId = ?"
                + " ;";
        int itemId = 0;
        int type = 0;
        String desc = null;
        String name = null;

        String getItemDamage = "SELECT damage\n"
                + " FROM i_weapons\n"
                + " WHERE itemId = ?"
                + " ;";
        int dmg = 1;

        String getStaffMagic = "SELECT magicPower\n"
                + " FROM i_staff\n"
                + " WHERE itemId = ?"
                + " ;";
        int magic = 1;

        String getConsumableType = "SELECT consumableType\n"
                + " FROM  i_consumables\n"
                + " WHERE itemId = ?"
                + " ;";
        int consumableType= 0;

        String getFoodVal = "SELECT hungerVal\n"
                + " FROM i_c_food\n"
                + " WHERE itemId = ?"
                + " ;";
        int foodVal = 0;

        String getPotValue = "SELECT value, potionType\n"
                + " FROM i_c_potion\n"
                + " WHERE itemId = ?"
                + " ;";
        int potValue = 0;
        int potType = 0;

        try (Connection conn = DriverManager.getConnection(url)) {
            PreparedStatement pstmt = conn.prepareStatement(getItemInfo);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            itemId = rs.getInt("itemId");
            type = rs.getInt("type");
            name = rs.getString("name");
            desc = rs.getString("desc");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if(type == 0){
            //MetadataInventar.getInstance().addItem(new Item(name, desc, itemId));
        }else if(type == 1){
            try (Connection conn = DriverManager.getConnection(url)) {
                PreparedStatement pstmt = conn.prepareStatement(getItemDamage);
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                dmg = rs.getInt("damage");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            MetadataInventar.getInstance().addItem(new Weapon(name, desc, itemId, dmg));
        }else if(type == 2){
            try (Connection conn = DriverManager.getConnection(url)) {
                PreparedStatement pstmt = conn.prepareStatement(getStaffMagic);
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                magic = rs.getInt("magicPower");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            MetadataInventar.getInstance().addItem(new Staff(name, desc, itemId, magic));
        }else if(type == 3){
            try (Connection conn = DriverManager.getConnection(url)) {
                PreparedStatement pstmt = conn.prepareStatement(getConsumableType);
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                consumableType = rs.getInt("consumableType");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            if(consumableType == 1){
                try (Connection conn = DriverManager.getConnection(url)) {
                    PreparedStatement pstmt = conn.prepareStatement(getFoodVal);
                    pstmt.setInt(1, id);
                    ResultSet rs = pstmt.executeQuery();
                    foodVal = rs.getInt("hungerVal");
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                MetadataInventar.getInstance().addConsumable(new Food(name, desc, itemId, foodVal));
            }else if(consumableType == 2){
                try (Connection conn = DriverManager.getConnection(url)) {
                    PreparedStatement pstmt = conn.prepareStatement(getPotValue);
                    pstmt.setInt(1, id);
                    ResultSet rs = pstmt.executeQuery();
                    potValue = rs.getInt("value");
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                MetadataInventar.getInstance().addConsumable(new Potion(name, desc, itemId, potValue, potType));
            }
        }

    }


}
