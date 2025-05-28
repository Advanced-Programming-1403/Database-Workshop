package org.project;

import org.project.Models.Club;
import org.project.Models.Player;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.UUID;

public class Main {
    public static void main(String[] args)  {
        // club instances
        Club club1 = new Club(UUID.randomUUID(), "Real Madrid", "Carlo Ancelotti");
        Club club2 = new Club(UUID.randomUUID(), "Liverpool", "Arne Slot");
        // player instances
        Player player1 = new Player(UUID.randomUUID(), "Thibaut Courtois", club1.getId());
        Player player2 = new Player(UUID.randomUUID(), "Jude Bellingham", club1.getId());
        Player player3 = new Player(UUID.randomUUID(), "Trent Alexander-Arnold", club2.getId());
        Player player4 = new Player(UUID.randomUUID(), "Federico Valverde", club1.getId());
        try {
            DatabaseManager.createClub(club1);
            DatabaseManager.createClub(club2);
            DatabaseManager.createPlayer(player1);
            DatabaseManager.createPlayer(player2);
            DatabaseManager.createPlayer(player3);
            DatabaseManager.createPlayer(player4);

            DatabaseManager.selectClub(club1);
            DatabaseManager.selectClub(club2);
            DatabaseManager.selectPlayer(player1);
            DatabaseManager.selectPlayer(player2);
            DatabaseManager.selectPlayer(player3);
            DatabaseManager.selectPlayer(player4);

            System.out.println("---------------------------");

            DatabaseManager.updateClub(club1, "Real Madrid", "Alonso");
            DatabaseManager.updatePlayer(player3, player3.getFullName(), club1.getId());


            DatabaseManager.selectClub(club1);
            DatabaseManager.selectClub(club2);
            DatabaseManager.selectPlayer(player1);
            DatabaseManager.selectPlayer(player2);
            DatabaseManager.selectPlayer(player3);
            DatabaseManager.selectPlayer(player4);

            System.out.println("---------------------------");


            DatabaseManager.deletePlayer(player2);
            DatabaseManager.deleteClub(club2);

            DatabaseManager.selectClub(club1);
            DatabaseManager.selectPlayer(player1);
            DatabaseManager.selectPlayer(player3);
            DatabaseManager.selectPlayer(player4);

            System.out.println("---------------------------");
        }catch (Exception e) {
            System.out.println(e);
        }

    }
}