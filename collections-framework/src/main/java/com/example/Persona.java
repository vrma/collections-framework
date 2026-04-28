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
		// Para que el orden sea Lexicograficamente de la Z a la A, hay que 
		// ubicar primero el objeto que se recibe como parametro
		int cmpPrimerApellido = persona.primerApellido()
				.compareTo(this.primerApellido);
		// Resultado de la comparacion por el segundo apellido
		int cmpSegundoApellido = persona.segundoApellido()
				.compareTo(this.segundoApellido);
		// Resultado de la comparacion por el nombre
		int cmpNombre = persona.nombre().compareTo(this.nombre);
		
		return cmpPrimerApellido != 0 ? cmpPrimerApellido :
					cmpSegundoApellido != 0 ? cmpSegundoApellido :
						cmpNombre;
	}
	


}
