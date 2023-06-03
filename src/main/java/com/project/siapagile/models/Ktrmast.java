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
@Table(name = "KTRMAST")
public class Ktrmast {
    @Id
    @Column(name = "KTRID", nullable = false)
    private Integer id;

    @Column(name = "KTRNAME")
    private String ktrname;

    @Column(name = "KTRNOHP")
    private Integer ktrnohp;

    @Column(name = "KTRJNS")
    private Integer ktrjns;

    @Column(name = "KTRADDS")
    private String ktradds;

    @OneToMany(mappedBy = "prjktr")
    private Set<Prjmast> prjmasts = new LinkedHashSet<>();

}