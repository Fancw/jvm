package xyz.fanchw.factory.abs;

public class IntelComputerFactory implements ComputerFactory {
    @Override
    public CPU createCPU() {
        return new IntelCPU();
    }

    @Override
    public GPU creatGPU() {
        return new IntelGPU();
    }

    @Override
    public Board creatBoard() {
        return new IntelBoard();
    }
}
