
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

}
