package SpringAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author weihanqiang
 * @date 2024/9/28
 */

// 指定注解可以应用的Java元素类型
@Target({ElementType.METHOD, ElementType.TYPE})
// 指定注解的保留策略
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    // 定义注解的成员变量，默认为String类型
    String description() default "这是一个自定义注解";

    // 也可以定义其他类型的成员变量，比如枚举
    MyEnum enumValue() default MyEnum.DEFAULT;

    int value() default 0;

    // 数组类型的成员变量
    int[] ids() default {};
}

