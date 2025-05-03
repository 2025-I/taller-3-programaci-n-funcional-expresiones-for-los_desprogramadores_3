package taller

import scala.annotation.tailrec

class Maniobra {
  type Vagon = Any
  type Tren = List[Vagon]
  type Estado = (Tren, Tren, Tren)
  type Maniobra = List[Movimiento]


  def aplicarMovimiento(e: Estado, m: Movimiento): Estado = m match {
    case Uno(n) if n > 0 =>
      val (resto, mover) = e._1.splitAt(e._1.length - (n min e._1.length))
      (resto, mover ++ e._2, e._3)
    case Uno(n) if n < 0 =>
      val (mover, resto) = e._2.splitAt((-n) min e._2.length)
      (e._1 ++ mover, resto, e._3)
    case Dos(n) if n > 0 =>
      val (resto, mover) = e._1.splitAt(e._1.length - (n min e._1.length))
      (resto, e._2, mover ++ e._3)
    case Dos(n) if n < 0 =>
      val (mover, resto) = e._3.splitAt((-n) min e._3.length)
      (e._1 ++ mover, e._2, resto)
    case _ => e
  }
  def aplicarMovimientos(e: Estado, movs: Maniobra): List[Estado] = {
    @tailrec
    def aux(movs: Maniobra, acc: List[Estado]): List[Estado] = movs match {
      case Nil => acc
      case m :: ms => aux(ms, acc :+ aplicarMovimiento(acc.last, m))
    }

    aux(movs, List(e))
  }
}

