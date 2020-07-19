package kr.chis.cismsashop.shop.domain;

import kr.chis.cismsashop.common.ShopStatus;
import lombok.*;

import javax.persistence.*;

/**
 * @author InSeok
 * Date : 2020/07/19
 * Remark :
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sp_shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sp_id")
    private Long id;

    @Column(name="sp_name")
    private String shopName;

    @Enumerated(EnumType.STRING)
    @Column(name="sp_status")
    private ShopStatus shopStatus;

    @Column(name="sp_min_order_amt")
    private Long minOrderAmt;

    public boolean isOpen() {
        if ( this.shopStatus == ShopStatus.OPEN){
            return true;
        }
        return false;
    }

    public boolean isValidOrderAmount(Long totalAmount) {
        if (totalAmount >= this.minOrderAmt){
            return true;
        }
        return false;
    }
}
