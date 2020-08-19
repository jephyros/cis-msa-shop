package kr.chis.cismsashop.shop.domain;

import kr.chis.cismsashop.common.Money;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author InSeok
 * Date : 2020/08/18
 * Remark :
 */
@Entity
@Getter
@Table(name="sp_shop_menu")
public class ShopMenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sm_id")
    private Long id;

    @Column(name="sm_menu_name")
    private String menuName;

    @Embedded
    @AttributeOverride(name="amount", column=@Column(name="sm_menu_price"))
    private Money menuPrice;

    public ShopMenuItem() {
    }

    @Builder
    public ShopMenuItem(Long id,String menuName, Money menuPrice) {
        this.id = id;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    public BigDecimal getMenuPrice() {
        return menuPrice.BigDecimalValue();
    }
}
