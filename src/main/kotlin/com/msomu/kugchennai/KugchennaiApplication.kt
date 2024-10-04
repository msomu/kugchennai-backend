package com.msomu.kugchennai

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Query
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans

@SpringBootApplication
class KugchennaiApplication

class RootQuery : Query {
	@GraphQLDescription("Get all sessions from ramanhall")
	fun sessions() = jsonData.agendas
}

fun main() {
	runApplication<KugchennaiApplication>{
		addInitializers(beans {
			bean<RootQuery>()
		})
	}
}
