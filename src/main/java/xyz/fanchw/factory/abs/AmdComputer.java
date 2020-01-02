package xyz.fanchw.factory.abs;

import lombok.Data;

@Data
public class AmdComputer implements Computer {
    private AmdCPU amdCPU;
    private AmdGPU amdGPU;
    private AmdBoard amdBoard;

    public AmdComputer(CPU amdCPU, GPU amdGPU, Board amdBoard) {
        this.amdCPU = (AmdCPU) amdCPU;
        this.amdGPU = (AmdGPU) amdGPU;
        this.amdBoard = (AmdBoard) amdBoard;
    }
}
