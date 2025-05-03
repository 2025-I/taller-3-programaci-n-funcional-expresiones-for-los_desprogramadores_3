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

  test("Prueba3 - pasar algunos a auxiliar Dos y devolverlos") {
    val e1 = (List('m','n','o','p'), List(), List())
    val e2 = obj.aplicarMovimiento(e1, Dos(2))
    assert(e2 == (List('m','n'), List(), List('o','p')))

    val e3 = obj.aplicarMovimiento(e2, Dos(-1))
    assert(e3 == (List('m','n','o'), List(), List('p')))

    val e4 = obj.aplicarMovimiento(e3, Dos(-1))
    assert(e4 == (List('m','n','o','p'), List(), List()))
  }

  test("Prueba5 - uso combinado de Uno y Dos") {
    val e1 = (List('1','2','3','4','5'), List(), List())
    val e2 = obj.aplicarMovimiento(e1, Uno(2))
    assert(e2 == (List('1','2','3'), List('4','5'), List()))

    val e3 = obj.aplicarMovimiento(e2, Dos(1))
    assert(e3 == (List('1','2'), List('4','5'), List('3')))

    val e4 = obj.aplicarMovimiento(e3, Uno(-1))
    assert(e4 == (List('1','2','4'), List('5'), List('3')))

    val e5 = obj.aplicarMovimiento(e4, Dos(-1))
    assert(e5 == (List('1','2','4','3'), List('5'), List()))
  }


  test("Prueba7 - inversión completa de un tren de 4 vagones") {
    val obj = new Maniobra()
    val e1 = (List('a', 'b', 'c', 'd'), List(), List())
    val e2 = obj.aplicarMovimiento(e1, Uno(1) )
    assert(e2 == (List('a','b','c'), List('d'), List()))
    val e3 = obj.aplicarMovimiento(e2, Dos(3) )
    assert(e3 == (List(), List('d'), List('a','b','c')))
    val e4 = obj.aplicarMovimiento(e3, Uno(-1) )
    assert(e4 == (List('d'), List(), List('a','b','c')))
    val e5 = obj.aplicarMovimiento(e4, Dos(-3) )
    assert(e5 == (List('d','a','b','c'), List(), List()))
    val e6 = obj.aplicarMovimiento(e5, Uno(1))
    assert(e6 == (List('d','a','b'), List('c'), List()))
    val e7 = obj.aplicarMovimiento(e6, Dos(2))
    assert(e7 == (List('d'), List('c'), List('a','b')))
    val e8 = obj.aplicarMovimiento(e7, Uno(-1))
    assert(e8 == (List('d','c'), List(), List('a','b')))
    val e9 = obj.aplicarMovimiento(e8, Dos(-1))
    assert(e9 == (List('d','c','a'), List(), List('b')))
    val e10 = obj.aplicarMovimiento(e9, Uno(1))
    assert(e10 == (List('d','c'), List('a'), List('b')))
    val e11 = obj.aplicarMovimiento(e10, Dos(-1))
    assert(e11 == (List('d','c','b'), List('a'), List()))
    val e12 = obj.aplicarMovimiento(e11, Uno(-1))
    assert(e12 == (List('d','c','b','a'), List(), List()))
  }

  test("Prueba6 - combinación avanzada Uno y Dos con varios intercambios") {
    val e1 = (List('a', 'b', 'c', 'd', 'e', 'f'), List(), List())
    val e2 = obj.aplicarMovimiento(e1, Uno(3))
    assert(e2 == (List('a', 'b', 'c'), List('d', 'e', 'f'), List()))
    val e3 = obj.aplicarMovimiento(e2, Dos(2))
    assert(e3 == (List('a'), List('d', 'e', 'f'), List('b', 'c')))
    val e4 = obj.aplicarMovimiento(e3, Dos(-1))
    assert(e4 == (List('a', 'b'), List('d', 'e', 'f'), List('c')))
    val e5 = obj.aplicarMovimiento(e4, Uno(-2))
    assert(e5 == (List('a', 'b', 'd', 'e'), List('f'), List('c')))
    val e6 = obj.aplicarMovimiento(e5, Dos(1))
    assert(e6 == (List('a', 'b', 'd'), List('f'), List('e', 'c')))
    val e7 = obj.aplicarMovimiento(e6, Dos(-2))
    assert(e7 == (List('a', 'b', 'd', 'e', 'c'), List('f'), List()))
    val e8 = obj.aplicarMovimiento(e7, Uno(-1))
    assert(e8 == (List('a', 'b', 'd', 'e', 'c', 'f'), List(), List()))
  }

  test("Prueba con 100 movimientos") {
    val e1: (List[Any], List[Any], List[Any]) = (List.fill(100)('c'), List(), List())

    val estadoFinal = (1 to 100).foldLeft(e1) { (estado, i) =>
      if (i % 2 == 1) {
        // Movimiento Uno
        obj.aplicarMovimiento(estado, Uno(i % 2 match {
          case 0 => 2
          case _ => -2
        }))
      } else {

        obj.aplicarMovimiento(estado, Dos(i % 2 match {
          case 0 => 4
          case _ => -4
        }))
      }
    }
    assert(estadoFinal._1.size + estadoFinal._2.size + estadoFinal._3.size == 100)
  }

  test("Prueba con 500 movimientos") {
    val e1: (List[Any], List[Any], List[Any]) = (List.fill(500)('c'), List(), List())


    val estadoFinal = (1 to 500).foldLeft(e1) { (estado, i) =>
      if (i % 2 == 1) {

        obj.aplicarMovimiento(estado, Uno(i % 2 match {
          case 0 => 2
          case _ => -2
        }))
      } else {

        obj.aplicarMovimiento(estado, Dos(i % 2 match {
          case 0 => 4
          case _ => -4
        }))
      }
    }
    assert(estadoFinal._1.size + estadoFinal._2.size + estadoFinal._3.size == 500)
  }


  test("Prueba con 1000 movimientos") {
    val e1: (List[Any], List[Any], List[Any]) = (List.fill(1000)('c'), List(), List())

    val estadoFinal = (1 to 1000).foldLeft(e1) { (estado, i) =>
      if (i % 2 == 1) {

        obj.aplicarMovimiento(estado, Uno(i % 2 match {
          case 0 => 2
          case _ => -2
        }))
      } else {

        obj.aplicarMovimiento(estado, Dos(i % 2 match {
          case 0 => 4
          case _ => -4
        }))
      }
    }
    assert(estadoFinal._1.size + estadoFinal._2.size + estadoFinal._3.size == 1000)
  }

}


