package com.glAssimentTicket.demo.Controller;

import com.glAssimentTicket.demo.Service.TicketService;
import com.glAssimentTicket.demo.main.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class TicketController {
    @Autowired
    TicketService service;
    @RequestMapping("/home")
    public String Home(){
        return "Home";
    }
    @RequestMapping("/newticket")
    public String newticket(Model m){
        m.addAttribute("newticket",new Ticket());
        return "create";
    }
    @RequestMapping("/ticketcreated")
    public  String newticket(@ModelAttribute Ticket newticket){
        service.addTicket(newticket);
        return "redirect:/home";
    }
    @RequestMapping("/tickets")
    public String listoftickets(Model m){
        List<Ticket>list=service.getAllTicket();
        m.addAttribute("tickets",list);
        return "tickets";
    }
    @RequestMapping("/editpage{id}")
    public String edit(@PathVariable int id,Model m){
        Ticket t=service.getTicketById(id);
        m.addAttribute("tickets",t);
        return "edit";
    }
    @RequestMapping("/saveedit")
    public String savedetails(@ModelAttribute Ticket title) {
        service.UpdateTicketById(title.getId(), title);
        return "redirect:/tickets";
    }
    @RequestMapping("/viewpage{id}")
    public String viewpade(@PathVariable int id,Model m) {
        Ticket t = service.getTicketById(id);
        m.addAttribute("viewticket", t);
        return "view";
    }
    @RequestMapping("/search{id}")
    public String search(@RequestParam int id,Model m){
        Ticket ticket=service.getTicketById(id);
        m.addAttribute("ticket",ticket);
        return "search";
    }
    @RequestMapping("/delete{id}")
    public String delete(@PathVariable int id){
        service.DeleteTicketById(id);
        return "redirect:/home";
    }
}
