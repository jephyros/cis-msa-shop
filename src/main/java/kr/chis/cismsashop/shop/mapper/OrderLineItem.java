package kr.chis.cismsashop.shop.mapper;

import lombok.Getter;
import lombok.ToString;

/**
 * @author InSeok
 * Date : 2020/08/08
 * Remark :
 */
@Getter
@ToString
public class OrderLineItem {
    private Long id;
    private String itemName;
    private Long orderQty;
    private Long orderPrice;
    private Long orderAmount;
}
