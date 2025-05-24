package org.project;

import org.project.Models.Club;
import org.project.Models.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    // todo: modify these constants to connect to database
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/Workshop";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Partow@1384";

    // a method to connect to database with credentials given
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public static void createPlayer(Player player) throws SQLException {
        Connection conn = connect();

        // todo: fill the query to create a player
        String query = "INSERT INTO players (id, full_name, club_id) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setObject(1, player.getId());
        ps.setString(2, player.getFullName());
        ps.setObject(3, player.getClubId());
        // todo: set values of the prepared statement
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static void createClub(Club club) throws SQLException {
        Connection conn = connect();
        String query = "INSERT INTO clubs (id, title, manager) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setObject(1, club.getId());
        ps.setString(2, club.getTitle());
        ps.setString(3, club.getManager());

        ps.executeUpdate();
        ps.close();
        conn.close();

    }



    // todo: create methods to complete the task of workshop
    public static void printAllClubs() throws SQLException {
        String query = "SELECT * FROM clubs";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query);
             var rs = ps.executeQuery()) {
            System.out.println("Clubs:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getObject("id")
                        + ", Title: " + rs.getString("title")
                        + ", Manager: " + rs.getString("manager"));
            }
        }
    }


    public static void printAllPlayers() throws SQLException {
        String query = "SELECT * FROM players";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query);
             var rs = ps.executeQuery()) {
            System.out.println("Players:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getObject("id")
                        + ", Full Name: " + rs.getString("full_name")
                        + ", Club ID: " + rs.getObject("club_id"));
            }
        }
    }

    public static void updatePlayerClub(String playerFullName, Object newClubId) throws SQLException {
        String query = "UPDATE players SET club_id = ? WHERE full_name = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, newClubId);
            ps.setString(2, playerFullName);
            ps.executeUpdate();
        }
    }


    public static void updateClubManager(String clubTitle, String newManager) throws SQLException {
        String query = "UPDATE clubs SET manager = ? WHERE title = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, newManager);
            ps.setString(2, clubTitle);
            ps.executeUpdate();
        }
    }

    public static void deletePlayer(String playerFullName) throws SQLException {
        String query = "DELETE FROM players WHERE full_name = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, playerFullName);
            ps.executeUpdate();
        }
    }


    public static void deleteClub(String clubTitle) throws SQLException {
        String query = "DELETE FROM clubs WHERE title = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, clubTitle);
            ps.executeUpdate();
        }
    }

}