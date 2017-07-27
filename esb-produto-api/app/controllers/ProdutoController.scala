package controllers

import javax.inject._
import service.ProdutoService
import play.api.mvc._


@Singleton
class ProdutoController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

    def index(id: Long) = Action { implicit request: Request[AnyContent] =>
        try {
            val json = (new ProdutoService()).get(id)
            Ok(json).as("text/json; charset=utf-8")
        } catch {
            case e: Exception => BadRequest("Produto não encontrado")
        }
    }

}
