package com.ticketlounge.product.api;

import static com.ticketlounge.product.fixture.ProductFixture.상품_생성_요청;
import static io.restassured.RestAssured.given;

import com.ticketlounge.web.product.request.ProductRequest;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public final class ProductApiSupporter {

    private ProductApiSupporter() {
    }

    public static ExtractableResponse<Response> 상품_생성() {
        return 상품_생성(상품_생성_요청());
    }

    public static ExtractableResponse<Response> 상품_생성(final ProductRequest 상품_생성_요청) {
        return given()
                .body(상품_생성_요청)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post("/api/v1/products")
                .then().extract();
    }

    public static ExtractableResponse<Response> 상품_응모(final String 토큰, final Long 상품_ID) {
        return given()
                .header(new Header("X-AUTH-TOKEN", 토큰))
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post("/api/v1/products/{productId}", 상품_ID)
                .then().extract();
    }
}
