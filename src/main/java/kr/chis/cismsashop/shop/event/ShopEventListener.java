package kr.chis.cismsashop.shop.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kr.chis.cismsashop.shop.mapper.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;

/**
 * @author InSeok
 * Date : 2020/07/19
 * Remark : Shop
 */
@Component
@Slf4j
public class ShopEventListener {

    private final ObjectMapper mapper;

    public ShopEventListener(ObjectMapper mapper) {
        this.mapper = mapper;
    }


    @KafkaListener(topics = "ordersave")
    public void receiveOrderedEvent(ConsumerRecord consumerRecord) throws JsonProcessingException {
        System.out.println("=================" + consumerRecord.value());
        //new JsonDeserializer<Order>(consumerRecord.value());
        //mapper.registerModule(new JavaTimeModule());
        Order order = mapper.readValue(consumerRecord.value().toString(), Order.class);

        log.info("========= Order Mapped : {}",order.toString());

    }
}
