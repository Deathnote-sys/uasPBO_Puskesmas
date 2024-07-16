/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puskesmas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yogi
 */
public class koneksi {
    public static Connection con;
    public static Statement stm;
    
    public void config() {
        try {
            String url = "jdbc:mysql://localhost:3306/db_puskesmas";
            String user = "root";
            String pass = "";
            
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();
            System.out.println("Koneksi Berhasil");
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Koneksi Gagal: " + ex.getMessage());
        }
    }
    
    private static Connection koneksi;
    
    public static Connection getConnection() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_puskesmas"; // Ganti dengan URL database Anda
                String user = "root"; // Ganti dengan username database Anda
                String pass = ""; // Ganti dengan password database Anda

                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish the connection
                koneksi = DriverManager.getConnection(url, user, pass);
                System.out.println("Koneksi Berhasil");
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException("Koneksi Gagal: " + e.getMessage(), e);
            }
        }
        return koneksi;
    }
}
