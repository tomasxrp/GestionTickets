package com.gestiontickets.core_api.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestiontickets.core_api.entities.Category;
import com.gestiontickets.core_api.entities.Ticket;
import com.gestiontickets.core_api.entities.User;
import com.gestiontickets.core_api.repositories.CategoryRepository;
import com.gestiontickets.core_api.repositories.TicketRepository;
import com.gestiontickets.core_api.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements com.gestiontickets.core_api.services.TicketService{

    private final TicketRepository ticketRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public Ticket createTicket(Ticket ticket, Long categoryId, Long creatorId){
        Category category = categoryRepository.findById(categoryId)
                        .orElseThrow(() -> new RuntimeException("CATEGORIA NO ENCONTRADA"));

        
        User usuario = userRepository.findById(creatorId)
                    .orElseThrow(() -> new RuntimeException("USUARIO NO ENCONTRADO"));

        ticket.setCategory(category);
        ticket.setCreator(usuario);

        ticket.setStatus("OPEN");
        ticket.setPriority("MEDIA");

        return ticketRepository.save(ticket);
    }


    @Override
    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long ticketId){
        return ticketRepository.findById(ticketId).orElseThrow( ()-> new RuntimeException("TICKET NO ENCONTRADO"));
        
    }

    
}
