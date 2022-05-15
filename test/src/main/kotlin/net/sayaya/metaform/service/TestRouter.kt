package net.sayaya.metaform.service

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@Configuration
@ConfigurationProperties(prefix = "spring.cloud.metaform")
class TestRouter {
    lateinit var testUrl: String
    @Bean("TestRouter")
    fun route() = router {
        POST(testUrl,
            // contentType(MediaType("application", "vnd.worklist.v1+json", Charsets.UTF_8)),
            ::test
        )
    }
    private fun test(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.status(HttpStatus.NO_CONTENT).build()
    }
}