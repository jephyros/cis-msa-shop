package kr.chis.cismsashop.shop.mapper;

import lombok.Data;

/**
 * @author InSeok
 * Date : 2020/08/08
 * Remark :
 */
@Data
public class OrderLineItem {
    private Long id;
    private String itemName;
    private Long orderId;
    private Long orderQty;
    private Long orderPrice;
    private Long orderAmount;
}
