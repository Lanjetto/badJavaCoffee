package designPatterns.creationalPatterns.factory.abstractFactory;

import designPatterns.creationalPatterns.factory.MovieTicket;
import designPatterns.creationalPatterns.factory.Ticket;

public class MovieFactory implements TicketFactory{
    @Override
    public Ticket createTicket() {
        return new MovieTicket();
    }
}
