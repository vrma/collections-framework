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
        
    }
}
