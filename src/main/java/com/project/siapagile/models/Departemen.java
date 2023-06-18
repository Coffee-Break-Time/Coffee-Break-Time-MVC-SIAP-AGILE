package com.project.siapagile.models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "departemen")
public class Departemen {

    @Id
    @Column(name = "dprtmn_id")
    private Integer departemenId;

    @Column(name = "nama_dprtmn", length = 100)
    private String namaDepartemen;

    @Column(name = "keterangan", length = 100)
    private String keterangan;
}
