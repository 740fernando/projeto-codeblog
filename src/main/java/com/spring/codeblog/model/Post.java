package com.spring.codeblog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table (name="TB_POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // gera o id autom.
    private Long id;

    @NotBlank
    private  String titulo;

    @NotBlank
    private String autor;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern =  "dd-MM-yyyy") //formato de data
    private LocalDate data;

    @NotBlank
    @Lob //para o banco aceitar valores grandes e dessa forma a perfomance melhora.
    private String texto;

}
