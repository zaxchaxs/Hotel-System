/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author USER
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Database {
    private Connection connect;

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "");
        } catch (
            ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return connect;
    }
    
    public String users(String username, String password) {
        String role = null;
        String query = "SELECT role FROM users WHERE username=? AND password=?";
        
        try (PreparedStatement pst = connect.prepareStatement(query)) {
            pst.setString(1, username);
            pst.setString(2, password);
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    role = rs.getString("role");
                } else {
                    JOptionPane.showMessageDialog(null, "Username or Password Salahhhhhh!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }
    
    public class ambilKamar {
        private Connection connect;

        public ambilKamar(Connection connect) {
            this.connect = connect;
        }

        public ResultSet getKamars() {
            String query = "SELECT * FROM kamar";
            ResultSet rs = null;

            try {
                PreparedStatement pst = connect.prepareStatement(query);
                rs = pst.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error retrieving data: " + e.getMessage());
            }
            return rs;
        }
    }
    
    
    public boolean postKamar(String room_number, String room_type, String price, String status) {
    String query = "INSERT INTO kamar (room_number, room_type, price, status) VALUES (?, ?, ?, ?)";
    try (PreparedStatement pst = connect.prepareStatement(query)) {
        pst.setString(1, room_number);
        pst.setString(2, room_type);
        pst.setString(3, price);
        pst.setString(4, status);

        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}



    public void closeConnection() {
        try {
            if (connect != null && !connect.isClosed()) {
                connect.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
