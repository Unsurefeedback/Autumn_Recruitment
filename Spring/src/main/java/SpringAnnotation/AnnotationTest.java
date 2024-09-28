package SpringAnnotation;

/**
 * @author WeiHanQiang
 * @date 2024/09/28 14:59
 **/
import java.lang.reflect.Method;

public class AnnotationTest {

    public static void main(String[] args) throws NoSuchMethodException {
        // 获取TestClass类的Class对象  
        Class<?> clazz = MyClass.class;

        // 检查类上的注解  
        if (clazz.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation classAnnotation = clazz.getAnnotation(MyAnnotation.class);
            System.out.println("Class Description: " + classAnnotation.description());
            System.out.println("Class Value: " + classAnnotation.value());
            System.out.println("Class enumValue: " + classAnnotation.enumValue());
            System.out.println("Class ids: " + classAnnotation.ids().toString());
        }

        // 检查方法上的注解  
        Method method = clazz.getMethod("testMethod");
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation methodAnnotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("Method Description: " + methodAnnotation.description());
            System.out.println("Method Value: " + methodAnnotation.value());
        }
    }
}
