package kr.chis.cismsashop.shop.domain;

import kr.chis.cismsashop.common.ShopStatus;
import lombok.*;

/**
 * @author InSeok
 * Date : 2020/07/22
 * Remark :
 */
@Getter
public class ShopDto {
    private Long id;
    private String shopName;
    private ShopStatus shopStatus;
    private Long minOrderAmt;

    @Builder
    public ShopDto(Long id, String shopName, ShopStatus shopStatus, Long minOrderAmt) {
        this.id = id;
        this.shopName = shopName;
        this.shopStatus = shopStatus;
        this.minOrderAmt = minOrderAmt;
    }
}
