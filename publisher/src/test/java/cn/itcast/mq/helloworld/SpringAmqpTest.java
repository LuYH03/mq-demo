package cn.itcast.mq.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 生产者发送消息到队列 队列发送到一个消费者
    // 一个消息只能被一个消费者接收
    @Test
    public void testSimpleQueue() {
        String queueName = "simple.queue";
        String message = "hello, spring amqp!";
        rabbitTemplate.convertAndSend(queueName,message);
    }

    // 生产者发送消息到队列 队列发送到多个消费者
    // 一个消息只能被一个消费者接收
    @Test
    public void testWorkQueue() throws InterruptedException {
        String queueName = "simple.queue";
        String message = "hello, spring amqp!";
        for (int i = 0; i < 50; i++) {
            rabbitTemplate.convertAndSend(queueName,message);
            Thread.sleep(20);
        }
    }

    // 生产者发送消息到交换机(fanoutExchange)  交换机发送到多个队列  队列发送到消费者
    //  fanoutExchange：广播   - 一个消息所有消费者都能收到
    @Test
    public void testfanoutQueue(){
        String exchangeName = "baomido.fanout";
        String message = "hello eray one!";

        rabbitTemplate.convertAndSend(exchangeName,"",message);
    }

    // 生产者发送消息到交换机(DirectExchange)  交换机发送到多个队列  队列发送到消费者
    // DirectExchange：路由   - 通过绑定key可以实现交换机根据key发送到指定的队列
    @Test
    public void testDirectQueue(){
        String exchangeName = "baomido.direct";
        //String message = "hello yellow！";
        //String message = "hello blue！";
        String message = "hello red！";

        rabbitTemplate.convertAndSend(exchangeName,"red",message);
    }

    // TopicExchange跟DirectExchange区别在于: TopicExchange可以实现通配符对key做条件匹配
    // #：0个或多个单词   *：一个单词
    @Test
    public void testTopicQueue(){
        String exchangeName = "baomido.topic";
        String message = "中美会谈-11.15";

        rabbitTemplate.convertAndSend(exchangeName,"Amarican.news",message);
    }

    @Test
    public void testObjectQueue(){
        Map<String,String> message = new HashMap<>();
        message.put("name","啊刚");
        message.put("age","20");
        rabbitTemplate.convertAndSend("object.queue",message);
    }



}
