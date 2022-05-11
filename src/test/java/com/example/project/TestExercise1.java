package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestExercise1 {

  Exercise1 obj = new Exercise1();

  @Test
  public void case_1() {

    boolean result = obj.esCuadradoPerfecto(25);

    assertEquals(result, true, "La salida esperada es true pero se retorno un false.");
  }

  @Test
  public void case_2() {

    boolean result = obj.esCuadradoPerfecto(47);

    assertEquals(result, false, "La salida esperada es false pero se retorno un true.");
  }

  @Test
  public void case_3() {

    boolean result = obj.esCuadradoPerfecto(0);

    assertEquals(result, false, "La salida esperada es false pero se retorno un true.");
  }

  @Test
  public void case_4() {

    boolean result = obj.esCuadradoPerfecto(625);

    assertEquals(result, true, "La salida esperada es true pero se retorno un false.");
  }

}
