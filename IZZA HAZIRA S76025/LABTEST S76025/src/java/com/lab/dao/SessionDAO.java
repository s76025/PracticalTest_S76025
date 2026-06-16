/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lab.dao;

/**
 *
 * @author MP2-4
 */
import com.lab.bean.SessionBean;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class SessionDAO {

    private Object ps;

    public Connection getConncection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/drivesmart_db", "admin", "");
    }

    
    public boolean bookSession(SessionBean session, boolean rowInserted) {
   
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(Training_Sessions)) {

            preparedStatement.setString(1, session.getStudentName());
            preparedStatement.setString(2, session.getBranchLocation());
            preparedStatement.setString(3, session.getLessonType());
            preparedStatement.setString(4, session.getStatus());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
    }

//Retrieve Method
public List<SessionBean> getAllSessions(){
List<SessionBean> listSessions = new ArrayList<>();
String sql = "SELECT * FROM Training_Sessions ORDER BY branch_location ASC";

try (Connection conn = getConnection();
PreparedStatement statement = conn.prepareStatement(sql);
ResultSet resultSet = statement.executeQuery()){

while (resultSet.next()){
int id = resultSet.getInt("session_id");
        String name = resultSet.getString("student_name");
  String branch = resultSet.getString("branch_location");
   String type = resultSet.getString("lesson_type");
    String status = resultSet.getString("status");
  
SessionBean session = new SessionBean(id, name, branch, type, status);
listSessions.add(session);
}
} catch (SQLException e){
    e.printStackTrace();
} return listSessions;
}

    private Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void bookSession(SessionBean newSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
