package com.org.unicomer.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidato")
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_candidato;
    private String country;
    @NotEmpty
    @NotNull
    private String customer_identification;
    @NotEmpty
    @NotNull
    private String first_name;
    @NotEmpty
    @NotNull
    private String last_name;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @NotEmpty
    @NotNull
    @Size(min = 1, max = 1)
    private String gender;
    @NotNull
    private String cellphone;
    @NotNull
    private String homephone;
    @NotEmpty
    @NotNull
    private String address_home;
    @NotEmpty
    @NotNull
    private String profession;
    @NotNull
    private double incomes;

}
