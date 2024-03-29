package com.ticketlounge.application.ticket.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketlounge.application.ticket.port.in.CreateTicketUseCase;
import com.ticketlounge.application.ticket.port.out.SaveTicketPort;
import com.ticketlounge.domain.auth.MemberToken;
import com.ticketlounge.domain.ticket.Ticket;

@Service
@Transactional
public class CreateTicketService implements CreateTicketUseCase {

    private final SaveTicketPort saveTicketPort;

    public CreateTicketService(final SaveTicketPort saveTicketPort) {
        this.saveTicketPort = saveTicketPort;
    }

    @Override
    public Ticket createTicket(final MemberToken token, final CreateTicketCommand createTicketCommand) {
        final Ticket ticket = createTicketCommand.toDomain(token.getId(), LocalDate.now());
        final List<Ticket> tickets = IntStream.range(0, createTicketCommand.count()).mapToObj(i -> ticket).toList();
        saveTicketPort.saveAll(tickets);

        return ticket;
    }
}
