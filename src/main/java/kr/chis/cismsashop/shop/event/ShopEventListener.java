package kr.chis.cismsashop.shop.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.chis.cismsashop.shop.domain.ShopRepository;
import kr.chis.cismsashop.shop.mapper.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
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
    private final KafkaTemplate<String,Object> kafkaTemplate;
    private final ShopRepository shopRepository;

    public ShopEventListener(ObjectMapper mapper, KafkaTemplate<String, Object> kafkaTemplate, ShopRepository shopRepository) {
        this.mapper = mapper;
        this.kafkaTemplate = kafkaTemplate;
        this.shopRepository = shopRepository;
    }


    // Ordered 이벤트를 받아서 오더를 검증 결과를 송신 하는 리스너
    @KafkaListener(topics = "Order-ordered")
    public void receiveOrderedEvent(ConsumerRecord consumerRecord) throws JsonProcessingException {
        OrderAcceptMessage orderAcceptMessage = new OrderAcceptMessage();


        //System.out.println("=================" + consumerRecord.value());
        //new JsonDeserializer<Order>(consumerRecord.value());
        //mapper.registerModule(new JavaTimeModule());
        Order order = mapper.readValue(consumerRecord.value().toString(), Order.class);

        log.info("========= Order Mapped : {}",order.toString());
        //이벤트 버전 (version) 기록및 체크는 오더검증에서는 필요없음
        //오더아이템 확인
        if (!order.isValidOrderItemCount()){
            orderAcceptMessage.fail(order.getId(),"E01","OrderLineItem is not exists.");
        }else{
            orderAcceptMessage.success(order.getId());
        }
        //최소 오더금액 확인


        kafkaTemplate.send("Shop-isValid",orderAcceptMessage);




    }
}
