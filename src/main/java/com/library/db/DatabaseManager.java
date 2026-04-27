package com.library.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    // SQLite connection URL (file-based database)
    private static final String URL = "jdbc:sqlite:library.db";

    // Get a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Creates all tables
    public static void initializeDatabase() {
        String createBooks = """
                CREATE TABLE IF NOT EXISTS books (
                    id        INTEGER PRIMARY KEY AUTOINCREMENT,
                    title     TEXT NOT NULL,
                    author    TEXT NOT NULL,
                    year      INTEGER,
                    available INTEGER DEFAULT 1
                );
                """;

        String createMembers = """
                CREATE TABLE IF NOT EXISTS members (
                    id    INTEGER PRIMARY KEY AUTOINCREMENT,
                    name  TEXT NOT NULL,
                    email TEXT UNIQUE NOT NULL
                );
                """;

        String createLoans = """
                CREATE TABLE IF NOT EXISTS loans (
                    id          INTEGER PRIMARY KEY AUTOINCREMENT,
                    book_id     INTEGER NOT NULL,
                    member_id   INTEGER NOT NULL,
                    borrowed_on TEXT NOT NULL,
                    due_date   TEXT ,
                    returned_on TEXT,
                    FOREIGN KEY (book_id)   REFERENCES books(id),
                    FOREIGN KEY (member_id) REFERENCES members(id)
                );
                """;

        // Execute the SQL statements to create tables
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(createBooks);
            stmt.execute(createMembers);
            stmt.execute(createLoans);
            System.out.println("Database initialized successfully.");

        } catch (SQLException e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }
    }
}