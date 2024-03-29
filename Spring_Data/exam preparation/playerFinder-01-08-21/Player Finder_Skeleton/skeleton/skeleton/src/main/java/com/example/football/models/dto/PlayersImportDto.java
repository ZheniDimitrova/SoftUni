package com.example.football.models.dto;

import com.example.football.models.entity.Position;

import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayersImportDto {
    @XmlElement(name = "first-name")
    @Size(min = 3)
    @NotNull
    private String firstName;
    @XmlElement(name = "last-name")
    @Size(min = 3)
    @NotNull
    private String lastName;
    @XmlElement(name = "email")
    @Email
    @NotNull
    private String email;
    @XmlElement(name = "birth-date")
    @NotNull
    private String birthDate;
    @XmlElement(name = "position")
    @Enumerated
    @NotNull
    private Position position;
    @XmlElement(name = "town")
    @NotNull
    private TownNameDto town;
    @XmlElement(name = "team")
    @NotNull
    private TeamNameDto team;
    @XmlElement(name = "stat")
    @NotNull
    private StatIdDto stat;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public TownNameDto getTown() {
        return town;
    }

    public void setTown(TownNameDto town) {
        this.town = town;
    }

    public TeamNameDto getTeam() {
        return team;
    }

    public void setTeam(TeamNameDto team) {
        this.team = team;
    }

    public StatIdDto getStat() {
        return stat;
    }

    public void setStat(StatIdDto stat) {
        this.stat = stat;
    }
}
