package com.hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idConsult;

    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false,foreignKey = @ForeignKey(name = "FK_CONSULT_PATIENT"))
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "id_medic", nullable = false,foreignKey = @ForeignKey(name = "FK_CONSULT_MEDIC"))
    private Medic medic;


    @ManyToOne
    @JoinColumn(name = "id_specialty", nullable = false,foreignKey = @ForeignKey(name = "FK_CONSULT_SPECIALTY"))
    private Specialty specialty;

    @Column(nullable = false, length = 3)
    private String numConsult;

    @Column(nullable = false)
    private LocalDateTime consultDate;

    @OneToMany(mappedBy = "consult",
            cascade = {CascadeType.ALL},
            orphanRemoval = true
            //fetch = FetchType.LAZY
    )
    private List<ConsultDetail> details;
}
