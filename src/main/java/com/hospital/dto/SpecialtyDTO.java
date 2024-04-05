package com.hospital.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SpecialtyDTO {

    @EqualsAndHashCode.Include
    private Integer idSpecialty;

    @NotNull
    private String nameSpecialty;

    @NotNull
    private String descriptionSpecialty;
}
