package controllers

import javax.inject.Inject
import play.api.Logger
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{AbstractController, ControllerComponents, Request}


class Application @Inject()(components: ControllerComponents) extends AbstractController(components) {

  private val LOG = Logger(getClass)

  /**
    * call method get name and parse the given body as json.
    *
    * Example call:
    * curl -XGET  -H "Content-Type: application/json" http://localhost:9000/name -d '{ "name": "world" }'
    * Result:
    *
    * @return json formatted string with the given name in the body
    */
  def getName = Action(parse.json) {
    LOG.info("Request name")
    request: Request[JsValue] =>
      Ok(
        // parse and check if the string is JSON like
        Json.toJson(
          "Hello:"  + (request.body \ "name")
            )
      )
  }

}

