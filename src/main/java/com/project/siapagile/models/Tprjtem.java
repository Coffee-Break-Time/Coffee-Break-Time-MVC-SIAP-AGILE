package com.project.siapagile.models;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "TPRJTEM")
public class Tprjtem {
    @Id
    @Column(name = "TPRJID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRJID")
    private Prjmast prjid;

    @Column(name = "TPRJDESC")
    private String tprjdesc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TPRJUSR1", nullable = false)
    private Usrmst tprjusr1;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TPRJUSR2", nullable = false)
    private Usrmst tprjusr2;

    @Column(name = "TPRJSNDT")
    private LocalDate tprjsndt;

    @Column(name = "TPRJACDT")
    private LocalDate tprjacdt;

    @Column(name = "TPRJSTAT")
    private Integer tprjstat;

}