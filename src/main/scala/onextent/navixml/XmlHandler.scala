package onextent.navixml

import com.amazonaws.services.lambda.runtime.Context
import io.circe.generic.auto._
import io.github.mkotsur.aws.handler.Lambda._
import io.github.mkotsur.aws.proxy
import io.github.mkotsur.aws.proxy.ProxyResponse
import onextent.navixml.XmlHandler._
import onextent.navixml.data.{DataSupport, Pizza}

object XmlHandler {
  case class PizzaResp(message: String, request: Pizza)
}

class ApiGatewayPizzaXmlHandler extends Proxy[String, PizzaResp] with DataSupport {
  override def handle(
      input: proxy.ProxyRequest[String],
      c: Context): Either[Throwable, ProxyResponse[PizzaResp]] = {
    val headers = Map(
      "x-custom-response-header" -> "my custom response header value!!")
    val responseBodyOption = input.body.map(xml => {
      val pizza = stream.fromXML(xml).asInstanceOf[Pizza]
      PizzaResp("And this is how you do pizza with mkotsur/aws-lambda-scala",
                pizza)
    })
    Right(ProxyResponse(200, Some(headers), responseBodyOption))
  }
}
