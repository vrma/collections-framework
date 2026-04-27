package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Stream;

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
    			.salario(3500.50)
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
    			.salario(3600.45)
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
    			.salario(3650.30)
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
    			.salario(4200.25)
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
    	 *    y expresiones lambda */
    	
    	/* Variante # 1 de Recorrer/Iterar sobre una coleccion, es decir, utilizando un 
    	 * Iterator. A modo de ejemplo, vamos a recorrer la coleccion de personas y 
    	 * eliminar las pesonas del genero HOMBRE */
    	
    	System.out.println("------------ Listado original de personas ----------");
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
    	
    	
    	Iterator<Persona> it = personas.iterator();
    	
    	while(it.hasNext()) {
    		
    		var persona = it.next();
    		
    		if (persona.genero().equals(Genero.HOMBRE) && 
    				persona.nombre().length() == 6) 
    			it.remove();
    	}
    	
    	
    	System.out.println("--- Listado resultante -----");
    	System.out.println(personas);
    	
    	/* VARIANTE # 2 de Iterar o recorrer una coleccion. Utilizando una 
    	 * sentencia for mejorada
    	 * 
    	 * A modo de ejemplo, intentemos recorrer la lista de personas y eliminar las personas
    	 * del genero mujer, pera comprobar que no es posible eliminar un elemento de la 
    	 * coleccion mientras se recorrere utilizando un for mejorado */
    	
    	
		/*
		 * for (var p: personas) {
		 * 
		 * if (p.genero().equals(Genero.MUJER)) personas.remove(p); }
		 */
    	 	
    	/**
    	 * OPERACIONES DE AGREGADO PARA RECORRER LAS COLECCIONES.
    	 * 
    	 * https://docs.oracle.com/javase/tutorial/collections/streams/index.html
    	 * 
    	 * Ejemplo: Calcular el salario promedio de las personas del genero MUJER
    	 * 
    	 * Las operaciones de agregado implican convertir la coleccion en un flujo (stream)
    	 * de elementos que a circular por una tuberia imaginaria o pipeline. Por tuberia o 
    	 * pipeline se entiende una secuencia de metodos de la clase Stream, es decir, 
    	 * una secuencia de operaciones de agregado, es decir, metodos que para obtener un 
    	 * resultado agrupan elementos del flujo.
    	 * 
    	 * Una tuberia o pipeline, tiene un origen que puede un array, una coleccion, un socket
    	 * , un fichero, una consulta de base de datos, etc, tambien la tuberia tiene cero, una
    	 * o muchas operaciones intermedias y UNA SOLA operacion terminal.
    	 * 
    	 * Lo primero es utilizar el metodo stream(), que tambien podria ser parallelStream(),
    	 * para convertir la coleccion en un flujo de elementos del mismo tipo de la coleccion
    	 * 
    	 * A partir de tener un flujo de elementos entran a funcionar los metodos de la clase
    	 * Stream, operaciones intermedias, como podria ser el metodo filter, para permitir que 
    	 * solamente circule al proximo nivel de la tuberia las personas del Genero MUJER
    	 * 
    	 * Predicate es una interfaz funcional, es decir, un tipo de interfaz que puede tener
    	 * metodos por defecto, que tienen, cuerpo, metodos estaticos, etc., pero SOLAMENTE UN 
    	 * METODO ABSTRACTO. Un predicate es una condicion que tiene que cumplir un elemento 
    	 * que circula por la tuberia o pipeline
    	 * 
    	 */
    	
    	// Stream<Persona> flujoDePersona = personas.stream();
    	
    	// Filtro filtro = new Filtro();
    	
    	// personas.stream().filter(filtro)
    	
    	// personas.stream().filter(new Filtro());
    	
    	/**
    	 * El codigo hasta este momento se consideraria una total
    	 * exageracion, tener que crear una clase externa solamente
    	 * para implementar la interfaz funcional Predicate.
    	 * 
    	 * Por lo cual un enfoque mas eficiente seria crear una clase
    	 * en el mismo sitio donde se va a instanciar el objeto, 
    	 * es decir, Juan Palomo yo lo guiso yo me lo como, y aqui 
    	 * entran las clases anonimas
    	 * 
    	 * ¿Que es una clase anonima?
    	 * 
    	 * Es, en primer lugar, una clase que no tiene nombre, por
    	 * lo cual una vez que se declara no podria ser utilizada
    	 * para instanciar un objeto, es decir, una clase anonima es
    	 * una expresion de clase, una expresion que vista con buenos
    	 * ojos parece una clase, pero no tiene nombre.
    	 * 
    	 * Se puede utilizar una clase anonima para instanciar un 
    	 * objeto a partir de una una interfaz, pero tambien a 
    	 * partir de una clase abstracta
    	 * 
    	 */
    	
//    	personas.stream().filter(new Predicate<Persona>() {
//
//			@Override
//			public boolean test(Persona p) {
//				// TODO Auto-generated method stub
//				return p.genero().equals(Genero.MUJER) ;
//			}
//		});
    	
    	/**
    	 * El uso de la clase anonima, o mejor dicho, de la expresion de clase anonima
    	 * es mucho mejor que la implementacion de la clase Filtro, pero todavia continua 
    	 * siendo una exageracion, si no se van a declarar variables adicionales, ni
    	 * se va a implementar otra cosa que no sea el metodo abstracto de la interfaz
    	 * funcional Predicate.
    	 * 
    	 * Y se hace la luz, y aperecen las EXPRESIONES LAMBDA
    	 * 
    	 * ¿Que es una expresion lambda?
    	 * 
    	 * Una expresion lambda hay que verla como un "metodo anonimo", por lo general se 
    	 * utilizan para implementar el metodo abstracto de las Interfaces Funcionales
    	 * 
    	 * Concretamente para el ejemplo que estamos desarrollando ahora, vamos a centrarnos 
    	 * en el metodo test 
    	 * 
    	 * Syntax of Lambda Expressions
    	 * 
    	 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#approach6
    	 * 
    	 * NOTA IMPORTANTE SOBRE LAS LAMBDAS Y LAS CLASES ANONIMAS
    	 * 
    	 * Tanto las clases anonimas como las expresiones lambda solamente se pueden relacionar
    	 * con variables locales (declaradas dentro de metodos) que sean explicitamente final
    	 * o effectively final (en efecto, final)
    	 */
    	
    	 // final int x = 4;
    	
    	// effectively final implica que se le ha asignado un valor y posteriormente no
    	// no se la ha asignado otro
    	
    	// int x = 7;
    	 
    	
    	// En el codigo siguiente, el metodo average() de la clase Stream devuelve un 
    	// Optional. ¿Que es el tipo Optional?
    	// es un tipo de datos que surgio posteriomente a Java 8, y es para proteger el codigo
    	// del peligroso NullPointerException, porque el optional hay que verlo como una caja
    	// donde puede venir el valor esperado o un null, y no habria problema porque podemos
    	// comprobar que hay en la cajita antes de extraer el valor
    	
    	OptionalDouble optionalDeSalarioPromedio =  personas.stream()
    		.filter(p -> p.genero().equals(Genero.MUJER))
    		.mapToDouble(p -> p.salario())
    		.average();
    	
    	double salarioMedio = 0.0;
    	
    	// Del optional de salario podemos extraer
    	if (optionalDeSalarioPromedio.isPresent()) {
    		salarioMedio = optionalDeSalarioPromedio.getAsDouble();
    	}
    	
    	// Otra variante de extraer el promedio del optional de Salario medio
    	
    	double salarioPromedio =  personas.stream()
        		.filter(p -> p.genero().equals(Genero.MUJER))
        		.mapToDouble(p -> p.salario())
        		.average().orElse(0);
    	
    	/* Metodo por Referencia: 
    	 * 
    	 * Si la expresion lambda lo unico que va a hacer es invocar al metodo
    	 * que realiza el trabajo, es mas eficiente pasar por referencia, la direccion
    	 * de dicho metodo para que realice el trabajo 
    	 * 
    	 * Por ejemplo, en el metodo mapToDouble, la expresion lambda lo unico que hace
    	 * es invocar al metodo que recupera el salario, en este caso, en lugar de utilizar 
    	 * una lambda es mas eficiente pasar por referencia el propio metodo que
    	 * recupera el salario. */
    	
    	double salarioPromedio2 =  personas.stream()
        		.filter(p -> p.genero().equals(Genero.MUJER))
        		.mapToDouble(Persona::salario)
        		.average().orElse(0);
    	
    	/*
    	 * ¿La siguiente seria una expresion lambda valida? 
    	 * 
    	 * () -> 
    	 * 
    	 * Rta. SI
    	 * 
    	 * void imprimir() {
    	 * 
    	 * 		System.out.println("Hola");
    	 * }
    	 * 
    	 * */
    	
    	
    }
}











