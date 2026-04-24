package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
        
        
		var personas = new ArrayList<Persona>();


		
		Persona persona1 = new Persona(
			"Douglas",
			"Perez",
			"Gomez",
			LocalDate.of(1990, 1, 1),
			Genero.HOMBRE
		);

		Persona persona2 = new Persona(
			"Maria",
			"Lopez",
			"Garcia",
			LocalDate.of(1995, 2, 2),
			Genero.MUJER
		);

		Persona persona3 = new Persona(
			"Pedro",
			"Gonzalez",
			"Martinez",
			LocalDate.of(2000, 3, 3),
			Genero.HOMBRE
		);

		personas.add(persona1);
		personas.add(persona2);
		personas.add(persona3);

		/* Si la lista de personas apunta a null, se debe inicializar, no podemos agregar elementos persona a dicha lista, porque no hemos reservado memoria para ella 
		*
		*Y, como se reserva memoria para una lista? Utilizando una clase que implemente la interfaz List, como por ejemplo ArrayList, LinkedList, etc. Por ejemplo:
		* List<Persona> personas = new ArrayList<>(); o List<Persona> personas = new LinkedList<>(); dependiendo de las necesidades de la aplicacion, se puede elegir una u otra implementacion de la interfaz List
		* Si se desea una lista de tamaño fijo, se puede utilizar la clase Arrays.asList(), que devuelve una lista de tamaño fijo,
		* pero no se le pueden agregar ni eliminar elementos, pero si se pueden modificar los elementos, porque de lo contrario seria inmutable
		* List<Persona> personas = Arrays.asList(persona1, persona2, persona3); o List<Persona> personas = Arrays.asList(new Persona[]{persona1, persona2, persona3}); 
		* dependiendo de las necesidades de la aplicacion, se puede elegir una u otra forma de crear la lista de personas2
		
		*/

		System.out.println(personas);

		/**
		 * Traversing Collections:
		 * En primer lugar 
		 * https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html#traversing
		 * 
		 * En segundo lugar:	
		 * 
		 * Ver el documento Arrays, Generics and Collections, que se encuentra en el repositorio de la asignatura, para entender como se pueden utilizar las colecciones con genericos, y como se pueden utilizar los metodos de las colecciones con genericos, como por ejemplo el metodo add(), remove(), etc.
		 * 
		 * Existen 3 formas de recorrer una coleccion:
		 * 1. Utilizando un iterador, que es una interfaz que permite recorrer una coleccion de forma secuencial, utilizando los metodos hasNext() y next() para recorrer la coleccion, y el metodo remove() para eliminar elementos de la coleccion mientras se recorre, pero no se pueden modificar los elementos de la coleccion mientras se recorre, porque se lanzaria una ConcurrentModificationException
		 * 2. Utilizando un bucle for-each, que es una forma mas sencilla de recorrer una coleccion, pero no se pueden eliminar elementos de la coleccion mientras se recorre, porque se lanzaria una ConcurrentModificationException
		 * 3. Utilizando un bucle for tradicional, que es una forma mas sencilla de recorrer una coleccion, pero no se pueden eliminar elementos de la coleccion mientras se recorre, porque se lanzaria una ConcurrentModificationException	
		 * 
		 */
		
		/* Variante 1 de recorrer/iterar utilizando un iterador. A modo de ejemplo: vamos a recorrer la coleccion de personas y eliminar las personas de genero HOMBRE */

		System.out.println("----lista de personas antes de eliminar las personas de genero HOMBRE----");
		System.out.println(personas);

		//Iterator<Persona> iteradorPersonas = personas.iterator();
		//while(iteradorPersonas.hasNext()) {
		//	Persona persona = iteradorPersonas.next();
		//	if(persona.genero() == Genero.HOMBRE) {
		//		iteradorPersonas.remove();
		//	}
		// }
		// System.out.println("----lista de personas despues de eliminar las personas de genero HOMBRE----");
		// System.out.println(personas);

		/* Ejercicio 1.
		*
		* Utilizando un iterador eliminar del listado de personas, aquellas que sean de genero HOMBRE y el nombre tenga 6 caracteres
		*
		*
		* Hacer un commit del estado actual y posteriormente eliminar o comentar el codigo del uso del iterador anterior para tener la lista de personas original.
		*/

		Iterator<Persona> iteradorPersonas2 = personas.iterator();
		while(iteradorPersonas2.hasNext()) {
			Persona persona = iteradorPersonas2.next();
			if(persona.genero() == Genero.HOMBRE && persona.nombre().length() == 7) {
				iteradorPersonas2.remove();
			}
		}

		System.out.println("----lista de personas despues de eliminar las personas de genero HOMBRE con 7 caracteres----");
		System.out.println(personas);
    }
}
