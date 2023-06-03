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
@Table(name = "TSKMAST")
public class Tskmast {
    @Id
    @Column(name = "TSKMID", nullable = false)
    private Integer id;

    @Column(name = "TSKMDESC")
    private String tskmdesc;

    @Column(name = "TSKMSTAT")
    private Integer tskmstat;

    @Column(name = "TSKMSTDT")
    private LocalDate tskmstdt;

    @Column(name = "TSKMMTDT")
    private LocalDate tskmmtdt;

    @Column(name = "STKMBBT")
    private Integer stkmbbt;

    @Column(name = "TSKMPRTY")
    private Integer tskmprty;

    @Column(name = "TSKMPIC")
    private Integer tskmpic;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UNKJID", nullable = false)
    private Unkjmst unkjid;

    @OneToMany(mappedBy = "tslmid")
    private Set<Rtskmast> rtskmasts = new LinkedHashSet<>();

}