package com.example;

import java.time.LocalDate;

public record Persona(
    String nombre,
    String primerApellido,
    String segundoApellido,
    LocalDate fechaNacimiento,
    Genero genero
) {

}
