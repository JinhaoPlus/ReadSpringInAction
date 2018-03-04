package top.jinhaplus.di.usexml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.jinhaplus.model.knight.Knight;

public class KnightMain {

    /**
     * DI: Dependency Injection
     * 将依赖的bean通过Spring上下文注入而非bean自己管理，这样做的好处是可以充分解耦
     * 依赖的bean的定义是接口形式，注入的实际实现是由Spring来管理的，这一整套依赖管理声明式地将bean之间的关系网构建出来
     * 在实际使用之前被注入依赖的bean是不感知注入其中的依赖bean的具体实现的
     */
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("knight.xml");
        Knight knight = applicationContext.getBean(Knight.class);
        knight.embarkOnQuest();
        applicationContext.close();
    }

}
