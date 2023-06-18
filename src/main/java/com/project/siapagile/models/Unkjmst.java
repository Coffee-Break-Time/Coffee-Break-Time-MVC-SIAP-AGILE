package com.project.siapagile.models;

import javax.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "UNKJMST")
public class Unkjmst {
    @Id
    @Column(name = "UNKJID", nullable = false)
//    private Integer id;
    private Integer departemenId;


    @Column(name = "UNKJNAME", length = 100)
//    private String unkjname;
    private String namaDepartemen;

    @Column(name = "UNKJDESC")
//    private String unkjdesc;
    private String keterangan;


    @Column(name = "UNKJPM", length = 10)
    private String projectManager;

//    @OneToMany(mappedBy = "unkjid")
//    private Set<Lunknusr> lunknusrs = new LinkedHashSet<>();
//
//    @OneToMany(mappedBy = "prjunk")
//    private Set<Prjmast> prjmasts = new LinkedHashSet<>();
//
//    @OneToMany(mappedBy = "unkjid")
//    private Set<Tskmast> tskmasts = new LinkedHashSet<>();

}