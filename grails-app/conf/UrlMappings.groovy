class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        // "/"(controller:"setup")
				"/"(controller:"listprojects")
        "500"(view:'/error')
	}
}
