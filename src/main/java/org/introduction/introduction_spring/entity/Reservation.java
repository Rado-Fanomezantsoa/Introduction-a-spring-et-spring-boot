package org.introduction.introduction_spring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    private String nomClient;

    @NotBlank(message = "Le téléphone est obligatoire")
    private String telephone;

    @Email(message = "Email invalide")
    private String email;

    @Positive(message = "Le numéro de chambre doit être positif")
    private int numeroChambre;

    private String descriptionChambre;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @FutureOrPresent(message = "La date ne peut pas être dans le passé")
    private LocalDate dateReservation;
}
