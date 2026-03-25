package com.pwa.helpdesk.services.impl;

import com.pwa.helpdesk.entity.Ticket;
import com.pwa.helpdesk.respositories.TicketRepository;
import com.pwa.helpdesk.services.TicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(Long ticketId, Ticket ticket) {
        Ticket ticketNotFound = ticketRepository.findById(ticketId).orElseThrow(() ->
                new RuntimeException("Ticket not found"));
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    @Override
    public Ticket getTicketByUserName(String userName) {
        return ticketRepository.findByUserName(userName).orElseThrow(() -> new RuntimeException("Ticket not found"));
    }
}
