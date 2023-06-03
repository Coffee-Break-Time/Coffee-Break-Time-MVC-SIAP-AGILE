package com.project.siapagile.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "PRJMAST")
public class Prjmast {
    @Id
    @Column(name = "PRJID", nullable = false)
    private Integer id;

    @Column(name = "PRJNAME")
    private String prjname;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRJPOWN", nullable = false)
    private Usrmst prjpown;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRJKTR", nullable = false)
    private Ktrmast prjktr;

    @Column(name = "PRJPRTY")
    private Integer prjprty;

    @Column(name = "PRJBBT")
    private Integer prjbbt;

    @Column(name = "PRJSTDT")
    private LocalDate prjstdt;

    @Column(name = "PRJMTDT")
    private LocalDate prjmtdt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRJUNK", nullable = false)
    private Unkjmst prjunk;

    @Column(name = "PRJDESC")
    private String prjdesc;

    @Column(name = "PRJSTAT")
    private Integer prjstat;

    @OneToMany(mappedBy = "prjid")
    private Set<Extmast> extmasts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "prjid")
    private Set<Tprjtem> tprjtems = new LinkedHashSet<>();

}