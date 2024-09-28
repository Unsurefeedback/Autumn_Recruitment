package SpringIOC;

import lombok.Data;

/**
 * @author WeiHanQiang
 * @date 2024/09/25 16:36
 **/
@Data
public class BeanDefinition {
    private String beanName;
    private Class beanClass;
}
