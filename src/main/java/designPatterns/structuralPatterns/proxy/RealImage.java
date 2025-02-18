package designPatterns.structuralPatterns.proxy;

public class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    @Override
    public void display() {
        System.out.println("Display " + fileName);
    }

    private void loadFromDisk() {
        System.out.println("Load from Disk");
    }
}
