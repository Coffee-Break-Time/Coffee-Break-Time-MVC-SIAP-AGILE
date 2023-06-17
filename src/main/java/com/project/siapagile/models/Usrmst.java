package com.project.siapagile.models;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USRROLE")
    private Rolemast usrrole;

    @Column(name = "USSRGETROLE", length = 50)
    private String ussrgetrole;

    public Usrmst(Integer id, String usrname, String usrpwd, String usrnohp, Integer usrimg, String usrmail, String usradds, Integer usrrole) {
        this.id = id;
        this.usrname = usrname;
        this.usrpwd = usrpwd;
        this.usrnohp = usrnohp;
        this.usrimg = usrimg;
        this.usrmail = usrmail;
        this.usradds = usradds;
        this.usrrole = new Rolemast(usrrole);
    }
}