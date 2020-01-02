package xyz.fanchw.enumm;

import lombok.Getter;

@Getter
public enum MyStatus {
    SLOW("轻轻", "1"),
    WIND("海风", "2"),
    SLOW_WIND("轻轻和海风", "3");

    private String statusName;
    private String statusNumber;

    MyStatus() {
    }

    MyStatus(String statusName, String statusNumber) {
        this.statusName = statusName;
        this.statusNumber = statusNumber;
    }

}
