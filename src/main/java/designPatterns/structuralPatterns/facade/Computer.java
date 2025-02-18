package designPatterns.structuralPatterns.facade;

public class Computer {
    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();

    public void startComputer() {
        memory.load();
        hardDrive.read();
        cpu.execute();
    }
}
