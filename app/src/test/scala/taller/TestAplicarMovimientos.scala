
package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class TestAplicarMovimientos extends AnyFunSuite {
    test("Prueba1") {
      val obj = new Maniobra()
      val e = (List('a', 'b'), List('c'), List('d'))  //(b,c)()(a,d)
      val movs = List(Uno(1), Dos(1), Uno(-2))
      val resultado = obj.aplicarMovimientos(e, movs)
      val esperado = (List('b','c'), Nil, List('a','d'))
      assert(resultado.last == esperado)

    }

  test("Secuencia compleja que intercambia vagones entre los tres rieles y reconstruye el orden deseado") {
    val obj = new Maniobra ()
    val estado = (List('a', 'b', 'c', 'd'), Nil, Nil)  //(a,c,b,d)
    val movs = List(Uno(2), Dos(1), Uno(-1), Dos(-1), Uno(1), Uno(-2))
    val resultado = obj.aplicarMovimientos(estado, movs)
    val esperado  = (List('a', 'c', 'b', 'd'), Nil, Nil)
    assert(resultado.last == esperado)
  }

  test("Movimiento desde dos de regreso al principal") {
    val obj = new Maniobra()
    val estado = (List('a', 'b'), Nil, List('x', 'y'))
    val movs = List(Dos(-2))
    val resultado = obj.aplicarMovimientos(estado, movs)
    val esperado = (List('a', 'b','x','y'), Nil, Nil)
    assert(resultado.last == esperado)
  }

  test("Prueba2") {
    val obj = new Maniobra()
    val estado = (List('a','b','c'),List('e','f'),List('g','h','j'))
    val movs = List(Uno(1),Dos(3),Uno(-3),Dos(-1),Uno(1),Dos(1),Uno(-1),Dos(2),Uno(2))
    val resultado = obj.aplicarMovimientos(estado,movs)
    val esperado = (Nil,List('c'),List('e','a','f','b','g','h','j'))
    assert(resultado.last == esperado)
  }

  test("Prueba3") {
    val obj = new Maniobra()
    val estado = (List('a','b','c','d'),List(),List())
    val movs = List(Uno(1),Dos(3),Uno(-1),Dos(-3),Uno(1),Dos(2),Uno(-1),Dos(-1),Uno(1),Dos(-1),Uno(-1))
    val resultado = obj.aplicarMovimientos(estado,movs)
    val esperado = (List('d','c','b','a'),Nil,Nil)
    assert(resultado.last == esperado)
  }
  test("Prueba100MovimientosLogicos") {
    val obj = new Maniobra()
    val estadoInicial = (List('a','b','c','d'), List(), List())
    val ciclo = List(
      Uno(1), Dos(1), // a -> b -> c
      Uno(1), Dos(1), // b -> b -> c
      Uno(1), Dos(1), // c -> b -> c
      Uno(1), Dos(1), // d -> b -> c
      // Regresar a pila A
      Dos(-1), Uno(-1),
      Dos(-1), Uno(-1),
      Dos(-1), Uno(-1),
      Dos(-1), Uno(-1)
    ) // Total: 16 movimientos por ciclo
    val movs = List.fill(6)(ciclo).flatten.take(100) // 100 movimientos exactos
    val resultado = obj.aplicarMovimientos(estadoInicial, movs)
    val esperado = (List('a','b','c','d'), Nil, Nil) // Volvieron a su estado inicial
    assert(resultado.last == esperado)
  }
  test("Prueba500MovimientosFinalDistinto") {
    val obj = new Maniobra()
    val estadoInicial = (List('e','f','g','h'), Nil, Nil)
    // Movimiento: A → B → C, 4 veces (para cada letra)
    val ciclo = List(
      Uno(1), Dos(1) // mover uno de A a B, luego B a C
    )
    val movs = List.fill(4)(ciclo).flatten ++ List.fill(468)(Uno(1)) ++ List.fill(28)(Dos(1)) // total 500
    val resultado = obj.aplicarMovimientos(estadoInicial, movs)
    val esperado = (Nil, List('f','h'), List('e','g')) // los elementos en C en orden inverso de A
    assert(resultado.last == esperado)
  }
  test("Prueba1000MovimientosFinalDistinto") {
    val obj = new Maniobra()
    val estadoInicial = (List('i','j','k','l'), Nil, Nil)
    val ciclo = List(
      Uno(1), Dos(1)
    )
    val movs = List.fill(4)(ciclo).flatten ++ List.fill(980)(Uno(1)) ++ List.fill(12)(Dos(1)) // total 1000
    val resultado = obj.aplicarMovimientos(estadoInicial, movs)
    val esperado = (Nil, List('j','l'), List('i','k')) // todos en C, orden inverso
    assert(resultado.last == esperado)
  }






}
