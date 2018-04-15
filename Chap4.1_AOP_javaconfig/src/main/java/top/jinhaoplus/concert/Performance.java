package top.jinhaoplus.concert;

public interface Performance {
    public void prepare(String showname);

    public boolean isOpen();
    public void perform();
}
