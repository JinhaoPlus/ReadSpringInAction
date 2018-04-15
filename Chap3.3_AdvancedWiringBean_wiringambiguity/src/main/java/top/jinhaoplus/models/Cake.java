package top.jinhaoplus.models;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// 使用@Primary设置多个相同类型bean需要选择注入时的首选装配的bean，可能会有多个bean被设为首选，所以仍然存在风险
//@Primary
// 使用@Qualifier以设置bean注入的限定符，此限定符和beanName是不一样的，虽然限定名默认是beanName，不过为了避免类名变更带来可能的注入问题，建议使用自定义限定符
@Qualifier("softDessert")
public class Cake implements Dessert {
}
