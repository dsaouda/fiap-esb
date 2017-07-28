package esb.checkout.api

class UrlMappings {

    static mappings = {

        "/v1/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
