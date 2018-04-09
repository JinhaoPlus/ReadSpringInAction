package top.jinhaoplus.aspect;

public class YardAspect {

    public void prepare(String showname) {
    }

    public void cleanTheYard(String showname) {
        System.out.println("Clean the yard for " + showname);
    }

    public void arrangeFacility(String showname) {
        System.out.println("Arrange the facility for " + showname);
    }
}
