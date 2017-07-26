package controllers

import javax.inject._

import model.Produto
import org.jsoup.Jsoup
import org.jsoup.Connection.Method
import play.api._
import play.api.mvc._
import play.api.libs.json.{JsUndefined, JsValue, Json}


@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index() = Action { implicit request: Request[AnyContent] =>
    val codigo = request.getQueryString("codigo").get

    val conn = Jsoup.connect(s"http://product-v3.soubarato.com.br/v3/product/$codigo")
        .ignoreContentType(true)
        .method(Method.GET);

    try {
      val response = conn.execute()
      val body = response.body()
      val json = Json.parse(body)

      val prod = Produto(
        json.\("id").as[String].toInt,
        json.\("name").as[String],
        json.\("description").as[String],
        detectImage(json),
        json.\("offers").\(0).\("salesPrice").as[Float]
      )

      Ok(Json.toJson(prod)).as("text/json; charset=utf-8")
    } catch {
      case e: Exception => BadRequest("Produto não encontrado")
    }
  }

  private def detectImage(json: JsValue): String = {
    val jsonImg = json \ "images" \ 0

    //tenta encontrar extraLarge
    var obj = jsonImg \ "extraLarge"
    if (!obj.isInstanceOf[JsUndefined]) {
      return obj.as[String]
    }

    //tenta encontrar large
    obj = jsonImg \ "large"
    if (!obj.isInstanceOf[JsUndefined]) {
      return obj.as[String]
    }

    //tenta encontrar big
    obj = jsonImg \ "big"
    if (!obj.isInstanceOf[JsUndefined]) {
      return obj.as[String]
    }

    //tenta encontrar medium
    obj = jsonImg \ "medium"
    if (!obj.isInstanceOf[JsUndefined]) {
      return obj.as[String]
    }

    //não detectou imagem
    return ""
  }
}
