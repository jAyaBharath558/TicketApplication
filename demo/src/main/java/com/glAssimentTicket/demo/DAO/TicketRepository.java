package com.glAssimentTicket.demo.DAO;

import com.glAssimentTicket.demo.main.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
