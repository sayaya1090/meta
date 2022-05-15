package net.sayaya.test

import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono

@SpringBootTest
@AutoConfigureWebTestClient
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class ApplicationTest{
    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    @Order(0)
    @DisplayName("Test1")
    internal fun test1() {
        webTestClient.put()
            .uri("/test")
            .body(Mono.just("Test Data"), String::class.java)
            .exchange()
            .expectStatus()
            .is2xxSuccessful
    }
}