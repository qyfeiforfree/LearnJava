package com.qyfei;

import java.sql.*;

public class testJDBC {
    String JDBC_URL = "jdbc:mysql://192.168.195.82:3306/learnjdbc?serverTimezone=UTC";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "root";

    public void selectAll(Long id) {
        try(Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)){
            try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, grade, name, gender,score  FROM students WHERE id=? order by score desc")) {
                preparedStatement.setObject(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Long tableid = resultSet.getLong(1);
                        Long grade = resultSet.getLong(2);
                        String name = resultSet.getString(3);
                        int gender = resultSet.getInt(4);
                        int score = resultSet.getInt(5);

                        System.out.println("ID:" + tableid + " Grade:" + grade + " Name:" + name + " Gender:" + gender + " Score:" + score);
                    }

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {

        }
    }

    public Long insertOne() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            {
                try (PreparedStatement preparedStatement = connection.prepareStatement("insert into students (grade,name,gender,score) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setObject(1, 1);
                    preparedStatement.setObject(2, "Bob");
                    preparedStatement.setObject(3, 1);
                    preparedStatement.setObject(4, 98);
                    int n = preparedStatement.executeUpdate();
                   // System.out.println(n);
                    try(ResultSet resultSet=preparedStatement.getGeneratedKeys()){
                        if(resultSet.next()){
                            Long id =resultSet.getLong(1);
                            System.out.println(id);
                            return id;
                        }
                    }

                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {

        }
        return 0l;
    }

    public void updateOne(Long id){
        try(Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement preparedStatement = connection.prepareStatement("update students set name = ? where id = ?")){
                preparedStatement.setObject(1,"小金");
                preparedStatement.setObject(2,id);
                int n=preparedStatement.executeUpdate();
                System.out.println(n);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteOne(Long id){
        try(Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
            try(PreparedStatement preparedStatement = connection.prepareStatement("delete from students where id = ?")){
                preparedStatement.setObject(1,id);
                int n=preparedStatement.executeUpdate();
                System.out.println(n);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void main(String[] args) {
        testJDBC testJDBC = new testJDBC();
        long id = testJDBC.insertOne();
        testJDBC.selectAll(id);

        System.out.println(id);
        testJDBC.updateOne(id);
        testJDBC.deleteOne(id);

    }
}
