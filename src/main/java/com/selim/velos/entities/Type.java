package com.selim.velos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import com.selim.velos.entities.Velo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;
    private String nomType;
    private String DescriptionType;
    @OneToMany (mappedBy = "type")
    @JsonIgnore
    private List<Velo> velos;


    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public Long getIdType() {
        return idType;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }

    public String getDescriptionType() {
        return DescriptionType;
    }

    public void setDescriptionType(String description) {
        DescriptionType = description;
    }

    public List<Velo> getVelos() {
        return velos;
    }

    public void setVelos(List<Velo> velos) {
        this.velos = velos;
    }
}
