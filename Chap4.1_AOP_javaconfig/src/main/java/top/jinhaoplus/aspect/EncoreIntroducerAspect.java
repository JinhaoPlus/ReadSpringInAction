package top.jinhaoplus.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import top.jinhaoplus.concert.DefaultEncoreable;
import top.jinhaoplus.concert.Encoreable;

@Aspect
public class EncoreIntroducerAspect {

    // 引入指的是向现有的类添加新的方法，在静态语言Java中已经加载的类可以通过AOP来动态添加其实现的接口，这就是AOP实现的引入

    // @DeclareParents的作用是引入接口到bean中去
    // 一个只实现了Performance接口的Concert的实例，被动态地引入了Encoreable接口
    // 实际上发生的事情是这个切面会把已经实现了Performance接口的Concert的代理proxy实例，再添加一个实现的接口Encoreable（动态代理可以为最终的代理对象指定多个实现的接口）
    // 那么Concert的代理proxy实例同时是Performance类型和Encoreable类型了

    // value表示被代理的目标对象，defaultImpl表示引入接口的默认实现
    @DeclareParents(value = "top.jinhaoplus.concert.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
