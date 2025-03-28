package com.example.Ecole_gestion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BulletinRespDTO {
    private Integer bulletinId;
    private Date dateRemise;
    private Float moyenne;
    private String appreciaton;

    public Integer getBulletinId() {
        return bulletinId;
    }

    public void setBulletinId(Integer bulletinId) {
        this.bulletinId = bulletinId;
    }

    public Date getDateRemise() {
        return dateRemise;
    }

    public void setDateRemise(Date dateRemise) {
        this.dateRemise = dateRemise;
    }

    public Float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(Float moyenne) {
        this.moyenne = moyenne;
    }

    public String getAppreciaton() {
        return appreciaton;
    }

    public void setAppreciaton(String appreciaton) {
        this.appreciaton = appreciaton;
    }
}
