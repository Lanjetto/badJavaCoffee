package designPatterns.creationalPatterns.factory.abstractFactory;

import designPatterns.creationalPatterns.factory.Ticket;

public class Main {
    public static void main(String[] args) {
        TicketFactory factory = new MovieFactory();
        Ticket ticket = factory.createTicket();

        ticket.print();

        factory = new TheatreFactory();
        ticket = factory.createTicket();
        ticket.print();

    }
}
