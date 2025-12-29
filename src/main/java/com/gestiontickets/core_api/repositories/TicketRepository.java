package com.gestiontickets.core_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestiontickets.core_api.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
    List<Ticket> findByCreator_Id(Long creatorId);

    List<Ticket> findByAgent_Id(Long agentId);

    List<Ticket> findByStatus(String status);

}
