package onextent.navixml.data

import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.io.xml.DomDriver
import io.circe.generic.semiauto._
import io.circe.{Decoder, Encoder}

/**
  * to use these xml and json helpers:
  *
  * import io.circe.parser._
  * import io.circe.syntax._
  * import onextent.xml.DataSupport._
  *
  */
trait DataSupport {

  implicit val stream: XStream = XStreamConversions(
    new XStream(new DomDriver()))
  stream.alias("cheese", classOf[Cheese])
  stream.alias("topping", classOf[Topping])
  stream.alias("pizza", classOf[Pizza])

  //
  // XML support
  //
  implicit val pizzaDecoder: Decoder[Pizza] = deriveDecoder
  implicit val pizzaEncoder: Encoder[Pizza] = deriveEncoder
  implicit val chDecoder: Decoder[Cheese] = deriveDecoder
  implicit val chEncoder: Encoder[Cheese] = deriveEncoder

}
