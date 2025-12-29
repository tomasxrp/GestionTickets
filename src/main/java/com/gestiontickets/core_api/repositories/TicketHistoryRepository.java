package com.gestiontickets.core_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestiontickets.core_api.entities.Ticket;
import com.gestiontickets.core_api.entities.TicketHistory;

public interface TicketHistoryRepository extends JpaRepository<TicketHistory, Long>{

   List<TicketHistory> findByTicket_IdOrderByCreatedAtDesc(Long ticketId);
    
}
