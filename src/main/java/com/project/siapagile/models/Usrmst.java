package com.project.siapagile.models;

import javax.persistence.*;

import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "USRMST")
public class Usrmst {
    @Id
    @Column(name = "USRNPP", nullable = false)
    private Integer id;

    @Column(name = "USRNAME", nullable = false, length = 40)
    private String usrname;

    @Column(name = "USRPWD")
    private String usrpwd;

    @Column(name = "USRNOHP", length = 13)
    private String usrnohp;

    @Column(name = "USRIMG", nullable = false)
    private Integer usrimg;

    @Column(name = "USRMAIL", nullable = false)
    private String usrmail;

    @Column(name = "USRADDS", nullable = false)
    private String usradds;

    @Column(name = "USRROLE")
    private Integer usrrole;

    @Column(name = "USSRGETROLE")
    private String usrGetRole;



}