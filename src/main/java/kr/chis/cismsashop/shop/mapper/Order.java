package kr.chis.cismsashop.shop.mapper;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author InSeok
 * Date : 2020/08/08
 * Remark :
 */
@Data
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
    private String orderStatus;
    private Long orderAmoumt;


}
