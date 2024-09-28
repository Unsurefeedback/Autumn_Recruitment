package SpringAnnotation;

/**
 * @author WeiHanQiang
 * @date 2024/09/28 15:00
 **/

@MyAnnotation(description = "This is a test class", value = 100,enumValue = MyEnum.VALUE1)
public class MyClass {

    @MyAnnotation(description = "This is a test method", value = 200)
    public void testMethod() {
        // 方法实现
    }
}
