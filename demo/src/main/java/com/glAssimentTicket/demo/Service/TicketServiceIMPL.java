package com.glAssimentTicket.demo.Service;

import com.glAssimentTicket.demo.DAO.TicketRepository;
import com.glAssimentTicket.demo.main.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceIMPL implements TicketService{
    @Autowired
    TicketRepository repository;

    @Override
    public Ticket getTicketById(int id) {
        Optional<Ticket> result = repository.findById(id);
        return result.orElse(null);
    }

    @Override
    public void UpdateTicketById(int id, Ticket ticket) {
        Ticket t = repository.findById(id).get();
        t.setId(ticket.getId());
        t.setTicketTitle(ticket.getTicketTitle());
        t.setTicketDescription(ticket.getTicketDescription());
        t.setCreatedOn(ticket.getCreatedOn());
        repository.save(ticket);
    }
    @Override
    public void DeleteTicketById(int id) {
        Optional<Ticket>ticket=repository.findById(id);
        if (ticket.isPresent()) {
            repository.delete(ticket.get());
        }
    }
    @Override
    public List<Ticket> getAllTicket() {
        return repository.findAll();
    }
    @Override
    public void addTicket(Ticket ticket){
        repository.save(ticket);
    }


}
