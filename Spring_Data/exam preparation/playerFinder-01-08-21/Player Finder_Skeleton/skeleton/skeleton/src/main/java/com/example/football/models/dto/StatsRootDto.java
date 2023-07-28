package com.example.football.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "stats")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatsRootDto {
    @XmlElement(name = "stat")
    List<StatsImportDto> stats;

    public List<StatsImportDto> getStats() {
        return stats;
    }

    public void setStats(List<StatsImportDto> stats) {
        this.stats = stats;
    }
}
