package xyz.fanchw.factory.abs;

public interface ComputerFactory {
    CPU createCPU();

    GPU creatGPU();

    Board creatBoard();

}
