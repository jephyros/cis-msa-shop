package kr.chis.cismsashop.shop.event;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author InSeok
 * Date : 2020/07/19
 * Remark : Shop
 */
@Component
public class ShopEventListener {

    @KafkaListener(topics = "ordersave")
    public void receiveOrderedEvent(ConsumerRecord consumerRecord){
        System.out.println("=================" + consumerRecord.value());

    }
}
