package org.project;

import org.project.Models.Club;
import org.project.Models.Player;

import java.sql.*;
import java.util.UUID;

public class DatabaseManager {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/workshop";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "D29011385m";

    // a method to connect to database with credentials given
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public static void createPlayer(Player player) throws SQLException {
        Connection conn = connect();
        String query = "INSERT INTO player (id, name, club) VALUES (?, ?, ?)" ;

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setObject(1,player.getId());
        ps.setString(2,player.getFullName());
        ps.setObject(3,player.getClubId());


        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static void createClub(Club club) throws SQLException {
        Connection conn = connect();
        String query = "INSERT INTO club (id, title, manager) VALUES (?, ?, ?)" ;

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setObject(1,club.getId());
        ps.setString(2,club.getTitle());
        ps.setString(3, club.getManager());

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static void updatePlayer(Player player, String name, UUID club) throws SQLException {
        Connection conn = connect();
        String query = "UPDATE player SET name = ?, club = ? WHERE id = ?";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1,name);
        ps.setObject(2,club);
        ps.setObject(3,player.getId());
        ps.executeUpdate();
        ps.close();
        conn.close();

    }

    public static void updateClub(Club club,String title,String manager) throws SQLException {
        Connection conn = connect();
        String query = "UPDATE club SET title = ?, manager = ? WHERE id = ?";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1,title);
        ps.setString(2,manager);
        ps.setObject(3,club.getId());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static void selectPlayer(Player player) throws SQLException {
        Connection conn = connect();
        String query = "SELECT * FROM player WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setObject(1,player.getId());
        ResultSet rs = ps.executeQuery();
        rs.next();
        UUID playerId = UUID.fromString(rs.getString(1));
        String name = rs.getString(2);
        UUID clubId = UUID.fromString(rs.getString(3));
        String query2 = "SELECT * FROM club WHERE id = ?";
        PreparedStatement ps2 = conn.prepareStatement(query2);
        ps2.setObject(1,clubId);
        ResultSet rs2 = ps2.executeQuery();
        rs2.next();
        String clubTitle = rs2.getString(2);

        System.out.println(playerId + "-" + name + "-" + clubTitle);
    }

    public static void selectClub(Club club) throws SQLException {
        Connection conn = connect();
        String query = "SELECT * FROM club WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setObject(1,club.getId());
        ResultSet rs = ps.executeQuery();
        rs.next();
        UUID clubId = UUID.fromString(rs.getString(1));
        String name = rs.getString(2);
        String manager = rs.getString(3);
        System.out.println(clubId + "-" + name + "-" + manager);
    }

    public static void deletePlayer(Player player) throws SQLException {
        Connection conn = connect();
        String query = "DELETE FROM player WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setObject(1,player.getId());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static void deleteClub(Club club) throws SQLException {
        Connection conn = connect();
        String query = "DELETE FROM club WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setObject(1,club.getId());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

}
