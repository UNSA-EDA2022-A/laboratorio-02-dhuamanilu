package com.example.project;

import java.util.Scanner;

public class Exercise1 {

	public static void main(final String[] args) {

		Exercise1 obj = new Exercise1();
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			System.out.println(obj.esCuadradoPerfecto(n));			
		}
	}

	public boolean esCuadradoPerfecto(long numero) {
		return verificaCuadradoPerfecto(numero,1,numero);
	}
	public boolean verificaCuadradoPerfecto(long numero,long inicio,long fin) {
		/*Calculamos el entero que esta en el medio de inicio y fin ,osea ,en cada invocacion de la funcion reducimos el 
		espacio de busqueda a la mitad*/
		//Para calcular medio podriamos utilizar (inicio+fin)/2 , pero esto puede causar overflow si los 2 estan cerca del limite de long 
		long medio=inicio+(fin-inicio)/2;
		
		//Criterio de parada
		if(inicio>fin){
			return false;
		}
		/*(Este system out print me sirvio para darme cuenta de que si ponia 1000000 me daba false,porque medio*medio sobrepasaba 
		lo que puede guardar int,entonces lo cambie a long los datos*/
		//System.out.println(medio*medio+" <-- este fue el medio*medio");
		//Si medio*medio==numero ,significa que numero si es un cuadrado perfecto ,por lo tanto retornamos true
		if(medio*medio==numero){
			return true;
		}
		//Si no se cumple la igualdad,solo hay 2 opciones,que medio*medio sea mas grande o mas pequeño que el numero
		else if(medio*medio>numero){
			/*Si es mas grande,entonces reducimos nuestro espacio de busqueda de inicio a medio-1 ,dado que ya hemos probado
			con medio y nos resulto mas grande*/
			return verificaCuadradoPerfecto(numero,inicio,medio-1);
		}
		else{
			/*Si es mas pequeño,entonces reducimos nuestro espacio de busqueda de medio+1 a fin, dado que ya hemos probado 
			con medio y nos resulto mas pequeño*/
			return verificaCuadradoPerfecto(numero,medio+1,fin);
		}
	}
}
