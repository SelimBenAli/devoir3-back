package com.selim.velos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage ;
    private String name ;
    private String type ;
    @Column( name = "IMAGE" , length = 40485760 )
    @Lob
    private byte[] image;
    /*@OneToOne
    private Velo velo;*/

    @ManyToOne()
    @JoinColumn (name="VELO_ID")
    @JsonIgnore
    private Velo velo;


}
