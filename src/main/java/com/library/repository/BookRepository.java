package com.library.repository;
import com.library.db.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BookRepository {
    public void addBook(String title, String author, int year) {
        // Code to insert a new book into the database
        String sql = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";
        try(Connection connection = DatabaseManager.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {


            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setInt(3, year);
            stmt.executeUpdate();
            System.out.println("Book added successfully: " + title);

        }
        catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }

    }
}
