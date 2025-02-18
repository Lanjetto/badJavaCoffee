package designPatterns.creationalPatterns.factory.abstractFactory;

import designPatterns.creationalPatterns.factory.TheaterTicket;
import designPatterns.creationalPatterns.factory.Ticket;

public class TheatreFactory implements TicketFactory{
    @Override
    public Ticket createTicket() {
        return new TheaterTicket();
    }
}
