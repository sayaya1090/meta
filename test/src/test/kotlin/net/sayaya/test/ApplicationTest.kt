package net.sayaya.test

import net.sayaya.metaform.service.TestRouter
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

@SpringBootTest(classes = [TestRouter::class])
@EnableConfigurationProperties
internal class ApplicationTest{
    @Autowired
    lateinit var router: RouterFunction<ServerResponse>
    lateinit var webTestClient: WebTestClient

    @BeforeEach
    fun initialize() { webTestClient = WebTestClient.bindToRouterFunction(router).build() }

    @Test
    @DisplayName("Test1")
    internal fun test1() {
        webTestClient.post()
            .uri("/test")
            //.body(Mono.just("Test Data"), String::class.java)
            .exchange()
            .expectStatus()
            .is2xxSuccessful
    }
}