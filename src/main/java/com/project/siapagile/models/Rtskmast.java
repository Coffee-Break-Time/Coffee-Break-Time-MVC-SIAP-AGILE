package com.project.siapagile.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "RTSKMAST")
public class Rtskmast {
    @Id
    @Column(name = "RWTID", nullable = false)
    private Integer id;

    @Column(name = "RWTCTDT")
    private LocalDate rwtctdt;

    @Column(name = "RWTPDDT")
    private LocalDate rwtpddt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RWTCTBY", nullable = false)
    private Usrmst rwtctby;

    @Column(name = "RWTSTAT")
    private Integer rwtstat;

    @Column(name = "RWTDESC")
    private String rwtdesc;

    @Column(name = "RWTPRBM")
    private String rwtprbm;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TSLMID", nullable = false)
    private Tskmast tslmid;

}