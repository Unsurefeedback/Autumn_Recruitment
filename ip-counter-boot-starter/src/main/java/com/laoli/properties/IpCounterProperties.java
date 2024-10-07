package com.laoli.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author WeiHanQiang
 * @date 2024/10/07 13:40
 **/
@Data
@ConfigurationProperties("tool.ip")
@Component
public class IpCounterProperties {
    private String display = DisplayMode.SIMPLE.getValue();

    public enum DisplayMode{
        SIMPLE("simple"),
        DETAIL("detail");
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        DisplayMode(String value) {
            this.value = value;
        }
    }
}
