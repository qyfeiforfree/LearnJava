package com.qyfei;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testHikariCP {

    static List<Student> queryStudents(DataSource ds) throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = ds.getConnection()) { // 在此获取连接
            try (PreparedStatement ps = conn
                    .prepareStatement("SELECT * FROM students WHERE grade = ? AND score >= ?")) {
                ps.setInt(1, 3); // 第一个参数grade=?
                ps.setInt(2, 90); // 第二个参数score=?
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        students.add(extractRow(rs));
                    }
                }
            }
        } // 在此“释放”连接
        return students;
    }
    static Student extractRow(ResultSet rs) throws SQLException {
        Student std = new Student();
        std.setId(rs.getLong("id"));
        std.setName(rs.getString("name"));
        std.setGender(rs.getBoolean("gender"));
        std.setGrade(rs.getInt("grade"));
        std.setScore(rs.getInt("score"));
        return std;
    }
    public static void main(String[] args) throws SQLException {
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setJdbcUrl("jdbc:mysql://192.168.195.82:3306/learnjdbc?serverTimezone=UTC");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("root");
        hikariConfig.addDataSourceProperty("connectionTimeout", "1000");
        hikariConfig.addDataSourceProperty("idleTimeout", "60000");
        hikariConfig.addDataSourceProperty("maximumPoolSize", "10");

DataSource dataSource = new HikariDataSource(hikariConfig);
List<Student> students=queryStudents(dataSource);
students.forEach(System.out::println);

    }
}