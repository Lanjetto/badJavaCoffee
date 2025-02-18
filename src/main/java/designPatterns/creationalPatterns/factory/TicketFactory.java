package designPatterns.creationalPatterns.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class TicketFactory {
    // Map для хранения соответствий между типом билета и его конструктором
    private static final Map<String, Supplier<Ticket>> ticketTypes = new HashMap<>();

    // Статический блок для инициализации Map
    static {
        ticketTypes.put("movie", MovieTicket::new);
        ticketTypes.put("theater", TheaterTicket::new);
    }

    // Метод для создания билета
    public static Ticket createTicket(String type) {
        Supplier<Ticket> ticketSupplier = ticketTypes.get(type.toLowerCase());
        if (ticketSupplier == null) {
            throw new IllegalArgumentException("Неизвестный тип билета: " + type);
        }
        return ticketSupplier.get();
    }

    // Метод для добавления нового типа билета (опционально)
    public static void registerTicketType(String type, Supplier<Ticket> supplier) {
        ticketTypes.put(type.toLowerCase(), supplier);
    }
}