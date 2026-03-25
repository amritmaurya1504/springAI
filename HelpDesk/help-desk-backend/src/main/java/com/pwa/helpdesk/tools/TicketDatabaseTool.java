package com.pwa.helpdesk.tools;

import com.pwa.helpdesk.entity.Ticket;
import com.pwa.helpdesk.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {

    private final TicketService ticketService;

    @Tool(description = "This tools helps to create new ticket in database")
    public Ticket createTicketTool(@ToolParam(description = "Ticket details") Ticket ticket){
        return ticketService.createTicket(ticket);
    }

    @Tool(description = "This tools helps to get ticket details by user name from database")
    public Ticket getTicketByUserName(@ToolParam(description = "UserName whose ticket is required") String userName){
        return ticketService.getTicketByUserName(userName);
    }

    @Tool(description = "This tools helps to update ticket details in database")
    public Ticket updateTicket(@ToolParam(description = "new ticket details with ticket id.") Ticket ticket){
        return ticketService.updateTicket(ticket.getId(), ticket);
    }

}
