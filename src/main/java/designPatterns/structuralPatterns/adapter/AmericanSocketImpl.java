package designPatterns.structuralPatterns.adapter;

public class AmericanSocketImpl implements AmericanSocket {
    @Override
    public void providePower() {
        System.out.println("American socket");
    }
}
