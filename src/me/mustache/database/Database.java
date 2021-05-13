package me.mustache.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Database {

    private static String url;
    private final List<String> answers = new List<String>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<String> iterator() {
            return null;
        }

        @Override
        public void forEach(Consumer<? super String> action) {
            List.super.forEach(action);
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public <T> T[] toArray(IntFunction<T[]> generator) {
            return List.super.toArray(generator);
        }

        @Override
        public boolean add(String s) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends String> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends String> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean removeIf(Predicate<? super String> filter) {
            return List.super.removeIf(filter);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void replaceAll(UnaryOperator<String> operator) {
            List.super.replaceAll(operator);
        }

        @Override
        public void sort(Comparator<? super String> c) {
            List.super.sort(c);
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public String get(int index) {
            return null;
        }

        @Override
        public String set(int index, String element) {
            return null;
        }

        @Override
        public void add(int index, String element) {

        }

        @Override
        public String remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<String> listIterator() {
            return null;
        }

        @Override
        public ListIterator<String> listIterator(int index) {
            return null;
        }

        @Override
        public List<String> subList(int fromIndex, int toIndex) {
            return null;
        }

        @Override
        public Spliterator<String> spliterator() {
            return List.super.spliterator();
        }

        @Override
        public Stream<String> stream() {
            return List.super.stream();
        }

        @Override
        public Stream<String> parallelStream() {
            return List.super.parallelStream();
        }
    };

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
