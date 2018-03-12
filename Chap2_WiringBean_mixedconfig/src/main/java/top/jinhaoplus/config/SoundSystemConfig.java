package top.jinhaoplus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 在javaconfig配置中通过@Import别的javaconfig可以拼装上下文
 * 在javaconfig配置中通过@ImportResource别的xmlconfig可以拼装上下文
 */

@Configuration
@Import(CDPlayerConfig.class)
@ImportResource("classpath:cd-config.xml")
public class SoundSystemConfig {

}
