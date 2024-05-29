package cn.itcast.mq.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConverter {

    /**
     * RabbitMq支持生产者发送Obejct类型
     * Spring默认消息转换器SimpleMessageConverter 基于JDK的ObjectOutPutStream序列化
     * 配置Json方式序列化
     */
    @Bean
    public MessageConverter JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
