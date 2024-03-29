package com.ticketlounge.ticket.api;

import static com.ticketlounge.ticket.fixture.TicketFixture.티켓_발급_요청;
import static io.restassured.RestAssured.given;

import com.ticketlounge.web.ticket.request.TicketRequest;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public final class TicketApiSupporter {

    private TicketApiSupporter() {
    }

    public static ExtractableResponse<Response> 티켓_발급(final String 토큰) {
        return given()
                .header(new Header("X-AUTH-TOKEN", 토큰))
                .body(티켓_발급_요청())
                .contentType(ContentType.JSON)
                .when()
                .post("/api/v1/tickets")
                .then()
                .extract();
    }

    public static ExtractableResponse<Response> 티켓_발급(final String 토큰, final TicketRequest 티켓_발급_요청) {
        return given()
                .header(new Header("X-AUTH-TOKEN", 토큰))
                .body(티켓_발급_요청)
                .contentType(ContentType.JSON)
                .when()
                .post("/api/v1/tickets")
                .then()
                .extract();
    }
}
