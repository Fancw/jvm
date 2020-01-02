package xyz.fanchw.observe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Observable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Food extends Observable {
    private Integer number = 10;

    public void buy() {
        super.setChanged();
        super.notifyObservers(number);
        this.number-=3;
    }
}
