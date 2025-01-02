package org.advancedjava.lld.parkinglot2.manager;

import lombok.Getter;
import org.advancedjava.lld.parkinglot2.model.Slot;
import org.advancedjava.lld.parkinglot2.model.Ticket;

import java.util.HashMap;
import java.util.Map;

@Getter
public class TicketManager {
    private final String parkingLotId;
    private final Map<String, Ticket> ticketMap;

    public TicketManager(String parkingLotId) {
        this.parkingLotId = parkingLotId;
        ticketMap = new HashMap<>();
    }

    public String createTicket(Slot slot, int floorNumber) {
        Ticket ticket = new Ticket(parkingLotId, slot, floorNumber);
        ticketMap.put(ticket.getTicketId(), ticket);
        return ticket.getTicketId();
    }

    public void removeTicket(String ticketId) {
        this.ticketMap.remove(ticketId);
    }
}
