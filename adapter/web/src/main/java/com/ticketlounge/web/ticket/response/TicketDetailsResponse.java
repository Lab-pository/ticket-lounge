package com.ticketlounge.web.ticket.response;

import java.time.LocalDate;

import com.ticketlounge.domain.ticket.Ticket;

public record TicketDetailsResponse(
        Long ticketId, String howToAcquire, LocalDate acquireDate, LocalDate expireDate, boolean isUsed,
        String howToUse, LocalDate useDate
) {

    public static TicketDetailsResponse from(Ticket ticket) {
        return new TicketDetailsResponse(ticket.getId(), ticket.getHowToAcquire(),
                ticket.getAcquireDate(), ticket.getExpireDate(), ticket.isUsed(),
                ticket.getHowToUse(), ticket.getUsedDate()
        );
    }
}
