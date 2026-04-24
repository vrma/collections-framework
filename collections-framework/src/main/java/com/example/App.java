package com.example;

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


        /**
         * Ejemplo de creacion de lista (coleccion) utilizando el metodo add(), que es polimorfico,
         * para agregar elementos a la lista
         */
        
        
        List<Persona> personas = null;


		
		persona persona1 = Persona.builder()
				.nombre("Juan")
				.primerApellido("Perez")
				.segundoApellido("Gomez")
				.fechaNacimiento(LocalDate.of(1990, 1, 1))
				.genero(Genero.MASCULINO)
				.build();
		persona persona2 = Persona.builder()
				.nombre("Maria")
				.primerApellido("Lopez")
				.segundoApellido("Garcia")
				.fechaNacimiento(LocalDate.of(1995, 2, 2))
				.genero(Genero.FEMENINO)
				.build();
		persona persona3 = Persona.builder()
				.nombre("Pedro")
				.primerApellido("Gonzalez")
				.segundoApellido("Martinez")
				.fechaNacimiento(LocalDate.of(2000, 3, 3))
				.genero(Genero.MASCULINO)
				.build()

		personas.add(arg0: persona1);

		/* Si la lista de personas apunta a null, se debe inicializar, no podemos agregar elementos persona a dicha lista, porque no hemos reservado memoria para ella 
		*
		*Y, como se reserva memoria para una lista? Utilizando una clase que implemente la interfaz List, como por ejemplo ArrayList, LinkedList, etc. Por ejemplo:
		* List<Persona> personas = new ArrayList<>(); o List<Persona> personas = new LinkedList<>(); dependiendo de las necesidades de la aplicacion, se puede elegir una u otra implementacion de la interfaz List
		* Si se desea una lista de tamaño fijo, se puede utilizar la clase Arrays.asList(), que devuelve una lista de tamaño fijo,
		* pero no se le pueden agregar ni eliminar elementos, pero si se pueden modificar los elementos, porque de lo contrario seria inmutable
		* List<Persona> personas = Arrays.asList(persona1, persona2, persona3); o List<Persona> personas = Arrays.asList(new Persona[]{persona1, persona2, persona3}); 
		* dependiendo de las necesidades de la aplicacion, se puede elegir una u otra forma de crear la lista de personas2
		
		*/


		}



    }
}
