package service

import model.Produto
import org.jsoup.Connection.Method
import org.jsoup.Jsoup
import play.api.libs.json.{JsUndefined, JsValue, Json}

class ProdutoService {

  def get(id: Long): JsValue = {
      val body = request(id)
      val json = Json.parse(body)

      val produto = Produto(
        json.\("id").as[String].toInt,
        json.\("name").as[String],
        json.\("description").as[String],
        detectImage(json),
        json.\("offers").\(0).\("salesPrice").as[Float]
      )

      Json.toJson(produto)
  }

  private def request(id: Long): String = {
      val conn = Jsoup.connect(s"http://product-v3.soubarato.com.br/v3/product/$id")
          .ignoreContentType(true)
          .method(Method.GET);

      val response = conn.execute()
      return response.body()
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
