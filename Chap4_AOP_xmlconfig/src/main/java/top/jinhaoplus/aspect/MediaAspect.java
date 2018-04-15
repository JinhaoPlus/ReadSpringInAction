package top.jinhaoplus.aspect;

public class MediaAspect {
    public void mediaVisit(boolean open) {
        if (open) {
            System.out.println("media can visit ");
        } else {
            System.out.println("media can't visit ");
        }
    }
}
