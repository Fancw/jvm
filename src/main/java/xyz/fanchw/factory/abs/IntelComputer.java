package xyz.fanchw.factory.abs;

import lombok.Data;

@Data
public class IntelComputer implements Computer {
    private IntelCPU intelCPU;
    private IntelGPU intelGPU;
    private IntelBoard intelBoard;

    public IntelComputer(CPU intelCPU, GPU intelGPU, Board intelBoard) {
        this.intelCPU = (IntelCPU) intelCPU;
        this.intelGPU = (IntelGPU) intelGPU;
        this.intelBoard = (IntelBoard) intelBoard;
    }
}
