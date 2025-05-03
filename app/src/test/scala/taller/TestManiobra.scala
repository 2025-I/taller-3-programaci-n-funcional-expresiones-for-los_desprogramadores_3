
package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestManiobra extends AnyFunSuite {

  val maniobra = new Maniobra
  test("Transformar tren inicial en tren objetivo - caso con más elementos manual") {
    val trenInicial2 = List('i', 'j', 'k','l','m','o')
    val trenObjetivo = List('o','m','l','k', 'j', 'i')

    val movimientos = maniobra.definirManiobra(trenInicial2, trenObjetivo)
    val estados = maniobra.aplicarMovimientos((trenInicial2, Nil, Nil), movimientos)

    val resultadoFinal = estados.last._1
    assert(resultadoFinal == trenObjetivo, s"Resultado: $resultadoFinal, Esperado: $trenObjetivo")
    println(s"Estado final: ${estados.last}")
  }
  test("Caso complejo ") {
    val trenInicial2 = List('a','b','c','d')
    val trenObjetivo = List('d','c','b','a')

    val movimientos = maniobra.definirManiobra(trenInicial2, trenObjetivo)
    val estados = maniobra.aplicarMovimientos((trenInicial2, Nil, Nil), movimientos)

    val resultadoFinal = estados.last._1
    assert(resultadoFinal == trenObjetivo, s"Resultado: $resultadoFinal, Esperado: $trenObjetivo")
    println(s"Estado final: ${estados.last}")
  }

  test("Transformar tren largo con orden arbitrario") {
    val trenInicial = List('a', 'c', 'd', 'f', 'h', 'i', 'j')
    val trenObjetivo = List('j', 'a', 'i', 'h', 'c', 'd', 'f')

    val movimientos = maniobra.definirManiobra(trenInicial, trenObjetivo)
    val estados = maniobra.aplicarMovimientos((trenInicial, Nil, Nil), movimientos)

    val resultadoFinal = estados.last._1
    assert(resultadoFinal == trenObjetivo, s"Resultado: $resultadoFinal, Esperado: $trenObjetivo")
    /*println(s"Movimientos requeridos (${movimientos.length}):")
    movimientos.foreach(println)*/
    println(s"Estado final: ${estados.last}")
  }
  test("Transformar tren inicial en tren objetivo - caso simple") {
    val trenInicial = List('a', 'b', 'c', 'd')
    val trenObjetivo = List('d', 'c', 'b', 'a')

    val movimientos = maniobra.definirManiobra(trenInicial, trenObjetivo)
    val estados = maniobra.aplicarMovimientos((trenInicial, Nil, Nil), movimientos)

    val resultadoFinal = estados.last._1
    assert(resultadoFinal == trenObjetivo, s"Resultado: $resultadoFinal, Esperado: $trenObjetivo")
    println(s"Estado final: ${estados.last}")
  }

}




