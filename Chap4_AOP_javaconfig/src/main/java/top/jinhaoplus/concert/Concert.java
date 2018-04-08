package top.jinhaoplus.concert;

public class Concert implements Performance {

    @Override
    public void perform() {
        System.out.println("The Concert is performing!");
    }
}
