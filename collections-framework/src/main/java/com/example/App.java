package com.example;

import java.time.LocalDate;
import java.time.Month;
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
    	
    	/* Traversing Collections 
    	 * 
    	 * En primer lugar:
    	 * 
    	 * https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
    	 * 
    	 * En segundo lugar: 
    	 * 
    	 * Ver el documento Arrays, Generics and Collection Framework */
    	
    	/* Existen 3 formas de recorrer una coleccion, de las cuales solamente una
    	 * permite eliminar elementos de una coleccion a la vez que se recorre:
    	 * 
    	 * 1- Utilizando un Iterador, es decir, interfaz Iterator<E>, que es la unica
    	 * forma de eliminar un elemento de la coleccion a la misma vez que se 
    	 * recorre
    	 * 
    	 * 2- Utilizando una sentencia for mejorada 
    	 * 
    	 * 3- (La variante sugerida, la mejor) Utilizando Operaciones de Agregado, es decir:
    	 *    Programacion Funcional, metodos de la clase Stream, metodos por referencia
    	 *    y operaciones lambda */
    	
    	/* Variante # 1 de Recorrer/Iterar sobre una coleccion, es decir, utilizando un 
    	 * Iterator. A modo de ejemplo, vamos a recorrer la coleccion de personas y 
    	 * eliminar las pesonas del genero HOMBRE */
    	
    	System.out.println("------------ Listado original de personas ----------");
    	System.out.println(personas);
        
    	Iterator<Persona> it = personas.iterator();
    	
    	while (it.hasNext()) {
    		
    		if (it.next().genero().equals(Genero.HOMBRE)) {
    			it.remove();
    		}
    	}
    	
    	
    	System.out.println("--- Listado resultante luego de eliminar las "
    			+ "personas del genero HOMBRE ---");
    	System.out.println(personas);
    	
    	/* Ejercicio # 1.
    	 * 
    	 * Utilizando un Iterator eliminar del listado de personas, aquellas que sean 
    	 * del genero HOMBRE y el nombre tenga 6 caracteres 
    	 * 
    	 * Para la solucion: Hacer un commit del estado actual, y posteriormente eliminar o 
    	 * comentar el codigo del uso del iterador anterior, para tener la lista de personas
    	 * original
    	 * 
    	 * */
    }
}











