package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class TestAplicarMovimiento extends AnyFunSuite {
  val obj = new Maniobra()


  test("Prueba1 - combinación compleja de movimientos Uno y Dos") {
    val e1 = (List('x','y','z','w','v'), List(), List())
    val e2 = obj.aplicarMovimiento(e1, Uno(3))
    assert(e2 == (List('x','y'), List('z','w','v'), List()))
    val e3 = obj.aplicarMovimiento(e2, Uno(-2))
    assert(e3 == (List('x','y','z','w'), List('v'), List()))

    val e4 = obj.aplicarMovimiento(e3, Dos(1))
    assert(e4 == (List('x','y','z'), List('v'), List('w')))

    val e5 = obj.aplicarMovimiento(e4, Dos(-2))
    assert(e5 == (List('x','y','z','w'), List('v'), List()))
  }

  test("Prueba2 - mover todos a auxiliar Uno y devolver uno por uno") {
    val e1 = (List('a', 'b', 'c', 'd'), List(), List())
    val e2 = obj.aplicarMovimiento(e1, Uno(4))
    assert(e2 == (List(), List('a','b','c','d'), List()))

    val e3 = obj.aplicarMovimiento(e2, Uno(-1))
    assert(e3 == (List('a'), List('b','c','d'), List()))

    val e4 = obj.aplicarMovimiento(e3, Uno(-1))
    assert(e4 == (List('a','b'), List('c','d'), List()))

    val e5 = obj.aplicarMovimiento(e4, Uno(-2))
    assert(e5 == (List('a','b','c','d'), List(), List()))
  }
}


