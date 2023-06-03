package com.project.siapagile.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "UNKJMST")
public class Unkjmst {
    @Id
    @Column(name = "UNKJID", nullable = false)
    private Integer id;

    @Column(name = "UNKJNAME", length = 100)
    private String unkjname;

    @Column(name = "UNKJDESC")
    private String unkjdesc;

    @Column(name = "UNKJPM", length = 10)
    private String unkjpm;

    @OneToMany(mappedBy = "unkjid")
    private Set<Lunknusr> lunknusrs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "prjunk")
    private Set<Prjmast> prjmasts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "unkjid")
    private Set<Tskmast> tskmasts = new LinkedHashSet<>();

}