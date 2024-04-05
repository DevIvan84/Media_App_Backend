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
public class ExamDTO {

    @EqualsAndHashCode.Include
    private Integer idExam;

    @NotNull
    private String nameExam;

    @NotNull
    private String descriptionExam;
}
