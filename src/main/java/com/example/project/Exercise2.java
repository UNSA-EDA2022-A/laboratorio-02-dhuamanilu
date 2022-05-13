package com.example.project;


import java.util.Scanner;

public class Exercise2 {

	public static void main(final String[] args) {

		Exercise2 obj = new Exercise2();
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt(), suma;
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				//En el caso 4 2 7 1  4 6 , se escaneaba normal 2 7 1 pero por alguna razon 4 se escaneba como 0
				a[i]= sc.nextInt();
			}
			suma = sc.nextInt();
			System.out.println(obj.esSubconjuntoSumaExt(a, suma));
		}
	}
	public boolean esSubconjuntoSumaExt(int a[], int suma) {
		
		//Primero se hara que cumpla con las condiciones dadas para despues aplicar el algoritmo normal
		int []arrYSuma=cumpleCondiciones(a,suma);
		
		//Extraemos los primeros a.length elementos para pasarlo como parametro al algoritmo normal
		int []pasa=new int[a.length];
		for(int i=0;i<a.length;i++) {
			pasa[i]=a[i];
		}
		//Tambien extraemos la suma que era el ultimo elemento 
		int pasaSuma=arrYSuma[a.length];
		//Usamos el algoritmo dado en clase
		return VerificaSubconjuntoSumaExt(pasa,0,pasaSuma);
	}
	public int [] cumpleCondiciones(int a[],int suma) {
		int []rptaYsuma=new int[a.length+1];
		for(int i=0;i<a.length-1;i++) {
			//Si el elemento actual es multiplo de 7
			if(a[i]%7==0) {
				//Si el sgte elemento es diferente de 1 se considera 
				if(a[i+1]!=1) {
					//Osea,para usar el algoritmo normal ya no querremos la suma total ,sino suma-a[i]
					suma-=a[i];
					//Y tendremos que quitar el 7,para representar esto simplemente le podemos poner 0
					a[i]=0;
				}
				//Si el sgte elemento es 1 , NO SE considera,segun las condiciones dadas
				else {
					//Osea ,lo pondremos en 0
					a[i]=0;
				}
			}
		}
		//Faltaria verificar el ultimo elemento si es multiplo de 7
		if(a[a.length-1]%7==0) {
			suma-=a[a.length-1];
			a[a.length-1]=0;
		}
		//Ahora copiaremos todo a un arreglo en el que el ultimo elemento sea la suma y los demas son la copia de "a"
		for(int i=0;i<a.length;i++) {
			rptaYsuma[i]=a[i];
		}
		//Ultimo elemento=suma
		rptaYsuma[a.length]=suma;
		return rptaYsuma;
	}
	// Retorna true si hay un subgrupo
	// de a[] con suma igual al valor de ‘suma’ 
	public boolean VerificaSubconjuntoSumaExt(int a[],int n,int suma) {
		// Casos base
		//Si la suma es 0,significa que si hay un subgrupo que sume lo pedido
		if (suma==0)
			return true;
		//Si n llega a ser a.length,significa que se exploraron todas las posibilidades y no se pudo hacer que la
		//suma sea 0 ,por lo tanto no hay subgrupo
		if (n==a.length)
			return false;
		/* verificamos si conseguimos la suma por alguna de las siguientes formas:
		(a) incluyendo el primer elemento
		(b) excluyendo el primer elemento */
		return VerificaSubconjuntoSumaExt(a,n+1,suma-a[n])
		|| VerificaSubconjuntoSumaExt(a,n+1,suma);
		
	}
}
