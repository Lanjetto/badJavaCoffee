package designPatterns.structuralPatterns.adapter;

public class SocketAdapter implements EuropeanSocket {
    private AmericanSocket americanSocket;

    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    @Override
    public void providePowerEU() {
        System.out.println("Adapter for european socket");
        americanSocket.providePower();
    }
}
