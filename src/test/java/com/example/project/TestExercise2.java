package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestExercise2 {

  Exercise2 obj = new Exercise2();

  @Test
  public void case_1() {

    int a[] = {2, 7, 10, 4};
    int suma = 17;

    boolean result = obj.esSubconjuntoSumaExt(a, suma);

    assertEquals(result, true, "La salida esperada es true pero se retorno un false.");
  }

  @Test
  public void case_2() {

    int a[] = {2, 7, 10, 4};
    int suma = 16;

    boolean result = obj.esSubconjuntoSumaExt(a, suma);

    assertEquals(result, false, "La salida esperada es false pero se retorno un true.");    
  }

  @Test
  public void case_3() {

    int a[] = {2, 7, 1, 4};
    int suma = 6;

    boolean result = obj.esSubconjuntoSumaExt(a, suma);

    assertEquals(result, true, "La salida esperada es true pero se retorno un false.");  
  }

  @Test
  public void case_4() {

    int a[] = {2, 7, 1, 4};
    int suma = 7;

    boolean result = obj.esSubconjuntoSumaExt(a, suma);

    assertEquals(result, true, "La salida esperada es true pero se retorno un false.");
  }

  @Test
  public void case_5() {

    int a[] = {2, 7, 1, 4};
    int suma = 8;

    boolean result = obj.esSubconjuntoSumaExt(a, suma);

    assertEquals(result, false, "La salida esperada es false pero se retorno un true.");
  }

}