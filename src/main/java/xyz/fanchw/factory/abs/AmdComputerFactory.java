package xyz.fanchw.factory.abs;

public class AmdComputerFactory implements ComputerFactory {
    @Override
    public CPU createCPU() {
        return new AmdCPU();
    }

    @Override
    public GPU creatGPU() {
        return new AmdGPU();
    }

    @Override
    public Board creatBoard() {
        return new AmdBoard();
    }
}
