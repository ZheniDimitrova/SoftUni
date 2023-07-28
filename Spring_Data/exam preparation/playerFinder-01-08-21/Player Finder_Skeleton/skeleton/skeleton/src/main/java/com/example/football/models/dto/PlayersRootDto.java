package com.example.football.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayersRootDto {
    @XmlElement(name = "player")
    List<PlayersImportDto> players;

    public List<PlayersImportDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayersImportDto> players) {
        this.players = players;
    }
}
