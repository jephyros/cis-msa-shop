package kr.chis.cismsashop.shop.domain;

import kr.chis.cismsashop.common.Money;
import kr.chis.cismsashop.common.ShopStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author InSeok
 * Date : 2020/07/19
 * Remark :
 */
@Entity
@Table(name="sp_shop")
@Getter
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

    @AttributeOverride(name="amount", column=@Column(name="sp_min_order_amt"))
    private Money minOrderAmt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name ="sm_sp_id")
    private List<ShopMenuItem> shopMenuItems = new ArrayList<>();

    public boolean isOpen() {
        if ( this.shopStatus == ShopStatus.OPEN){
            return true;
        }
        return false;
    }

    public boolean isValidOrderAmount(Money totalAmount) {
        if (totalAmount.isLessThan(this.minOrderAmt)){
            return true;
        }
        return false;
    }

    public Shop() {
    }

    @Builder
    public Shop(String shopName, ShopStatus shopStatus, Money minOrderAmt, List<ShopMenuItem> shopMenuItems,Date createDate) {
        this.shopName = shopName;
        this.shopStatus = shopStatus;
        this.minOrderAmt = minOrderAmt;
        this.shopMenuItems.addAll(shopMenuItems);
        this.createDate = createDate;
    }

    public BigDecimal getMinOrderAmt() {
        return minOrderAmt.BigDecimalValue();
    }
}
