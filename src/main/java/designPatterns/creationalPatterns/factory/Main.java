package designPatterns.creationalPatterns.factory;

public class Main {
    public static void main(String[] args) {
        // Создаем билеты с помощью фабрики
        Ticket movieTicket = TicketFactory.createTicket("movie");
        Ticket theaterTicket = TicketFactory.createTicket("theater");

        // Печатаем информацию о билетах
        movieTicket.print();
        theaterTicket.print();

        // Пример добавления нового типа билета
        TicketFactory.registerTicketType("sports", () -> new Ticket() {
            @Override
            public void print() {
                System.out.println("football");
            }
        });

        // Создаем и печатаем новый тип билета
        Ticket sportsTicket = TicketFactory.createTicket("sports");
        sportsTicket.print();
    }
}
