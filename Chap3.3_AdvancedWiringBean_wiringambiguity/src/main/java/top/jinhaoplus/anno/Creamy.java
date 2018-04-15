package top.jinhaoplus.anno;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用自定义注解对@Qualifier注解进行了包装，包装过后其实可以认为@Creamy和@Qualifier的功能是相同的，不过表意会更加明确，而且可以加上多个包装后的注解以表示多种特性
 */
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Creamy {
}
