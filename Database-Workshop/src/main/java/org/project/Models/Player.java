package org.project.Models;

import java.util.UUID;

public class Player {
    private UUID id;
    private String fullName;
    private UUID clubId;

    public Player(UUID id, String fullName, UUID clubId) {
        this.id = id;
        this.fullName = fullName;
        this.clubId = clubId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UUID getClubId() {
        return clubId;
    }

    public void setClubId(UUID clubId) {
        this.clubId = clubId;
    }
}