package com.project.siapagile.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ROLEMAST")
public class Rolemast {
    @Id
    @Column(name = "ROLEID", nullable = false)
    private Integer id;

    @Column(name = "ROLENAME", nullable = false, length = 25)
    private String rolename;

    public Rolemast(Integer id) {
        this.id = id;
    }
}