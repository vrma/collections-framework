package com.example;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record Persona(
		String nombre,
		String primerApellido,
		String segundoApellido,
		LocalDate fechaNacimiento,
		Genero genero,
		double salario		
) implements Comparable<Persona> {
	
	@Override
	public int compareTo(Persona persona) {
		
		// Resultado de la comparacion por el primer apellido, de dos personas
		// de la lista de personas
		int cmpPrimerApellido = this.primerApellido
					.compareTo(persona.primerApellido());
		// Resultado de la comparacion por el segundo apellido
		int cmpSegundoApellido = this.segundoApellido
					.compareTo(persona.segundoApellido());
		// Resultado de la comparacion por el nombre
		int cmpNombre = this.nombre.compareTo(persona.nombre());
		
		return cmpPrimerApellido != 0 ? cmpPrimerApellido :
					cmpSegundoApellido != 0 ? cmpSegundoApellido :
						cmpNombre;
	}
	


}
