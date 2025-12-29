package com.gestiontickets.core_api.services;

import java.util.List;

import com.gestiontickets.core_api.entities.Ticket;

public interface TicketService {

    Ticket createTicket(Ticket ticket, Long categoryId, Long creatorId );
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
    
}
