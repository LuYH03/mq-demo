package cn.itcast.mq.Listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Map;

@Component
public class SpringRabbitListener {
    /*@RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage(String msg){
        System.out.println("spring 消费者接收到消息：【" + msg + "】");
    }*/


   /* @RabbitListener(queues = "simple.queue")
    public void listenWorkQueue1(String msg) throws InterruptedException {
        System.out.println("spring 消费者1接收到消息：【" + msg + "】" + LocalTime.now());
        Thread.sleep(20);
    }
    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueue2(String msg) throws InterruptedException {
        System.out.println("spring 消费者2.......接收到消息：【" + msg + "】" + LocalTime.now());
        Thread.sleep(200);
    }*/


   /* @RabbitListener(queues = "fanout.queue1")
    public void listenfanoutQueue1(String msg){
        System.out.println("spring 消费者1接收到fanout.queue1消息：【" + msg + "】" + LocalTime.now());
    }
    @RabbitListener(queues = "fanout.queue2")
    public void listenfanoutQueue2(String msg){
        System.out.println("spring 消费者2接收到fanout.queue2消息：【" + msg + "】" + LocalTime.now());
    }*/


  /* @RabbitListener(bindings = @QueueBinding(
           value = @Queue("direct.queue1"),
           exchange = @Exchange(value = "baomido.direct",type = ExchangeTypes.DIRECT),
           key = {"red","blue"}
   ))
   public void listendirectQueue1(String msg){
       System.out.println("spring 消费者接收到direct.queue1消息：【" + msg + "】" + LocalTime.now());
   }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("direct.queue2"),
            exchange = @Exchange(value = "baomido.direct",type = ExchangeTypes.DIRECT),
            key = {"red","yellow"}
    ))
    public void listendirectQueue2(String msg){
        System.out.println("spring 消费者接收到direct.queue2消息：【" + msg + "】" + LocalTime.now());
    }*/


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("topic.queue1"),
            exchange = @Exchange(value = "baomido.topic",type = ExchangeTypes.TOPIC),
            key = {"china.#"}
    ))
    public void listenTopicQueue1(String msg){
        System.out.println("spring 消费者接收到Topic.queue1消息：【" + msg + "】" + LocalTime.now());
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("topic.queue2"),
            exchange = @Exchange(value = "baomido.topic", type = ExchangeTypes.TOPIC),
            key = {"#.news"}
    ))
    public void listenTopicQueue2(String msg){
        System.out.println("spring 消费者接收到Topic.queue2消息：【" + msg + "】" + LocalTime.now());
    }

    @RabbitListener(queues = "object.queue")
    public void listenObjectQueue(Map<String,String> msg){
        System.out.println("spring 消费者接收到Obejct.queue2消息：【" + msg + "】" + LocalTime.now());
    }

}
