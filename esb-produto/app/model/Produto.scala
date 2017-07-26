package model

import play.api.libs.json._

case class Produto(id: Int, nome: String, descricao: String, foto: String, valor: Float)

object Produto {

  implicit val implicitProdutoWrites = new Writes[Produto] {
    def writes(produto: Produto): JsValue = {
      Json.obj(
        "id" -> produto.id,
        "nome" -> produto.nome,
        "descricao" -> produto.descricao,
        "foto" -> produto.foto,
        "valor" -> produto.valor
      )
    }
  }
}

