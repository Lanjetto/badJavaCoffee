package designPatterns.structuralPatterns.decorator;

public class Mouse implements Component{
    @Override
    public void operation() {
        System.out.println("Basic mouse");
    }
}
