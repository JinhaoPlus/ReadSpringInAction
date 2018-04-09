package top.jinhaoplus.concert;

public class Concert implements Performance {

    @Override
    public void prepare(String showname) {
        System.out.println(showname + " is on preparation");
    }

    @Override
    public void perform() {
        System.out.println("The Concert is performing!");
    }
}
