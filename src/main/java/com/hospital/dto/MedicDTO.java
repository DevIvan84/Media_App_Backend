package com.hospital.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MedicDTO {

    @EqualsAndHashCode.Include
    private Integer idMedic;

    @NotNull
    @Size(min = 3)
    private String primaryName;

    @NotNull
    @Size(min = 3)
    private String surname;

    @NotNull
    @Size(min = 3, max = 12)
    private String cmpMedic;

    @NotNull
    private String photo;
}
