package onextent.navixml.data

import scala.collection.mutable.ArrayBuffer

case class Topping (name: String)

case class Cheese(name: String)

case class Pizza(crustSize: Int, crustType: String, cheeses: Array[Cheese]) {
  val toppings: ArrayBuffer[Topping] = ArrayBuffer[Topping]()
  def addTopping(t: Topping) { toppings += t }
}
