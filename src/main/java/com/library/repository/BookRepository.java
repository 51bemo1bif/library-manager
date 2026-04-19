package com.library.repository;
import com.library.db.DatabaseManager;
import com.library.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
    public List<Book> getAllBooks() {
        // Code to retrieve all books from the database
        List<Book> books = new ArrayList<>();
        String sql = "SELECT id, title, author, year, available FROM books";

        try(Connection connection = DatabaseManager.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);){

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int year = rs.getInt("year");
                boolean available = rs.getInt("available") == 1;
                books.add(new Book(id, title, author, year, available));


        }

        }
        catch (SQLException e) {
            System.out.println("Error retrieving books: " + e.getMessage());

        }
        return books;




    }




}
