package com.glAssimentTicket.demo.Service;

import com.glAssimentTicket.demo.main.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    Ticket getTicketById(int id);
    void UpdateTicketById(int id,Ticket ticket);
    void DeleteTicketById(int id);
    List<Ticket> getAllTicket();
    void addTicket(Ticket ticket);
}
