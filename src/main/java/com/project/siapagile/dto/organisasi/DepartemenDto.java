package com.project.siapagile.dto.organisasi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartemenDto {

    private Integer departemenId;
    private String namaDepartemen;
    private String keterangan;

}
