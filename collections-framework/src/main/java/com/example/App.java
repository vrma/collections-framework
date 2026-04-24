package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * El Framework de Collecciones:
 * 
 *  https://docs.oracle.com/javase/tutorial/collections/index.html
 */
public class App {
	
	
    public static void main(String[] args) {
    	
    	/* Colleccion de numeros enteros, a partir de un array */
    	
    	Integer[] arrayNumerosEnteros = {1, 2, 3, 4, 5};
    	
    	List<Integer> numerosEnteros = Arrays.asList(arrayNumerosEnteros);
    	
    	/* Una coleccion obtenida directamente a partir de un array es una coleccion
    	 * de tamaño fijo, es decir, que no se le puedan agregar ni eliminar elementos,
    	 * pero si se pueden modificar los elementos, porque de lo contrario seria 
    	 * inmutable*/
    	
    	// numerosEnteros.add(6);
    	
    	/* Ejemplo de creacion de lista (coleccion) utilizando el metodo add(),
    	 * que es polimorfico, para agregar elementos a la lista */
    	
    	// var realmente es List<Persona>
    	var personas = new ArrayList<Persona>();
    	
    	personas.add(
    		Persona.builder()
    			.nombre("Duglas")
    			.primerApellido("Taydron")
    			.segundoApellido("Gonzalez")
    			.fechaNacimiento(LocalDate.of(1995,
    					Month.JANUARY, 20))
    			.genero(Genero.HOMBRE)
    			.build()
    	);
    	
    	personas.add(
    			Persona.builder()
    			.nombre("Carolina")
    			.primerApellido("Garzon")
    			.segundoApellido("Becerra")
    			.fechaNacimiento(LocalDate.of(2000,
    					Month.OCTOBER, 10))
    			.genero(Genero.MUJER)
    			.build()
    	);
    	
    	
    	personas.add(
    			Persona.builder()
    			.nombre("Maria")
    			.primerApellido("Garzon")
    			.segundoApellido("Glez")
    			.fechaNacimiento(LocalDate.of(2005,
    					Month.DECEMBER, 14))
    			.genero(Genero.MUJER)
    			.build()
    	);
    	
    	
    	personas.add(
    		Persona.builder()
    			.nombre("Jeronimo")
    			.primerApellido("Arenal")
    			.segundoApellido("Gomez")
    			.fechaNacimiento(LocalDate.of(1989,
    					Month.MAY, 22))
    			.genero(Genero.HOMBRE)
    			.build()
    	);
    	
    	/* La lista resultante, personas, no es de tamaño fijo, porque no se ha obtenido
    	 * a parti de un array, por lo cual le puedo agregar o eliminar elementos Persona
    	 * cuando quiera */
    	
    	System.out.println(personas);
        
    }
}








