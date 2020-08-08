package kr.chis.cismsashop.shop.mapper;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author InSeok
 * Date : 2020/08/08
 * Remark :
 */
@Getter
@ToString
public class Order {
    private Long id;
    private String orderName;
    private Long version;
    private List<OrderLineItem> orderLineItems = new ArrayList<>();
    private Long shopId;
    private LocalDateTime orderStatusTime;
    private LocalDateTime createDate;
    private String createId;
    private LocalDateTime modifyData;
    private String modifyId;


}
