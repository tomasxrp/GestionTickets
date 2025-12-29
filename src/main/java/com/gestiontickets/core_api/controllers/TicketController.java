package com.gestiontickets.core_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestiontickets.core_api.dto.CreateTicketDTO;
import com.gestiontickets.core_api.entities.Ticket;
import com.gestiontickets.core_api.services.TicketService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    

    @PostMapping
    public ResponseEntity<Ticket> create(@RequestBody CreateTicketDTO request){
        Ticket ticket = new Ticket();
        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setPriority(request.getPriority());

        Ticket newTicket = ticketService.createTicket(ticket, request.getCategoryId(), request.getCreatorId());

        return ResponseEntity.ok(newTicket);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAll(){
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getOne(@PathVariable Long id){
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }
    
    
}
