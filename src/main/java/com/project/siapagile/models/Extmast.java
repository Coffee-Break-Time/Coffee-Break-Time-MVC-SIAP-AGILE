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
@Table(name = "EXTMAST")
public class Extmast {
    @Id
    @Column(name = "EXTID", nullable = false)
    private Integer id;

    @Column(name = "EXTBFSTDT")
    private LocalDate extbfstdt;

    @Column(name = "EXTVFMTDT")
    private LocalDate extvfmtdt;

    @Column(name = "EXTATSTDT")
    private LocalDate extatstdt;

    @Column(name = "EXTATMTDT")
    private LocalDate extatmtdt;

    @Column(name = "EXTDESC", length = 1)
    private String extdesc;

    @Column(name = "EXTSTAT")
    private Integer extstat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRJID", nullable = false)
    private Prjmast prjid;

}