package org.project;

import org.project.Models.Club;
import org.project.Models.Player;

import java.sql.SQLException;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {
        // club instances
        Club club1 = new Club(UUID.randomUUID(), "Real Madrid", "Carlo Ancelotti");
        Club club2 = new Club(UUID.randomUUID(), "Liverpool", "Arne Slot");

        DatabaseManager.createClub(club1);
        DatabaseManager.createClub(club2);

        // player instances
        Player player1 = new Player(UUID.randomUUID(), "Thibaut Courtois", club1.getId());
        Player player2 = new Player(UUID.randomUUID(), "Jude Bellingham", club1.getId());
        Player player3 = new Player(UUID.randomUUID(), "Trent Alexander-Arnold", club2.getId());
        Player player4 = new Player(UUID.randomUUID(), "Federico Valverde", club1.getId());

        DatabaseManager.createPlayer(player1);
        DatabaseManager.createPlayer(player2);
        DatabaseManager.createPlayer(player3);
        DatabaseManager.createPlayer(player4);

        System.out.println("Initial data:");
        DatabaseManager.printAllClubs();
        DatabaseManager.printAllPlayers();


        DatabaseManager.updatePlayerClub("Trent Alexander-Arnold", club1.getId());
        DatabaseManager.updateClubManager("Real Madrid", "Xabi Alonso");

        System.out.println("\nAfter update:");
        DatabaseManager.printAllClubs();
        DatabaseManager.printAllPlayers();


        DatabaseManager.deletePlayer("Jude Bellingham");
        DatabaseManager.deleteClub("Liverpool");

        System.out.println("\nAfter delete:");
        DatabaseManager.printAllClubs();
        DatabaseManager.printAllPlayers();
    }
}