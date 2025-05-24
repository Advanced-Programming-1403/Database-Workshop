package org.project.Models;

import java.util.List;
import java.util.UUID;

public class Club {
    private UUID id;
    private String Title;
    private String Manager;

    public List<Player> Players;

    public Club(UUID id, String title, String manager) {
        this.id = id;
        Title = title;
        Manager = manager;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getManager() {
        return Manager;
    }

    public void setManager(String manager) {
        Manager = manager;
    }
}