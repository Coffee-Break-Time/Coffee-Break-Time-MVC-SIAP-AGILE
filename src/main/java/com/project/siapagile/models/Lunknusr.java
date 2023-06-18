package com.project.siapagile.models;

import javax.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "LUNKNUSR")
public class Lunknusr {
    @Id
    @Column(name = "UNKJUSRID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UNKJNPP", nullable = false)
    private Usrmst unkjnpp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UNKJID", nullable = false)
    private Unkjmst unkjid;

}