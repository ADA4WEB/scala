package models


case class Pars()

object Pars {
def calc(a: Int, b: Int): Int ={
if (a > b) 0 else a + b
}
}
