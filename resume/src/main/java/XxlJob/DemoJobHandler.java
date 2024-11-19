package XxlJob;

/**
 * @author WeiHanQiang
 * @date 2024/10/10 20:25
 **/
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.handler.IJobHandler;
import org.springframework.stereotype.Component;

@JobHandler(value = "demoJobHandler")
@Component
public class DemoJobHandler extends IJobHandler {
    @Override
    public void execute() throws Exception {
        System.out.println("Hello, XXL-Job!");
        // 执行你的任务逻辑
    }
}

