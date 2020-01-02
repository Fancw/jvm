package xyz.fanchw.reference;

public class Fa implements Cloneable {

    public final void over() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Fa fa = null;
        try {
            fa = (Fa) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return fa;
    }

    public void fa() {
    }
}
