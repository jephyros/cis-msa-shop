package kr.chis.cismsashop.config;

import kr.chis.cismsashop.common.Money;
import kr.chis.cismsashop.common.ShopStatus;
import kr.chis.cismsashop.shop.domain.Shop;
import kr.chis.cismsashop.shop.domain.ShopMenuItem;
import kr.chis.cismsashop.shop.domain.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author InSeok
 * Date : 2020-07-21
 * Remark :
 */
@Configuration
public class AppRunner implements ApplicationRunner {
    @Autowired
    ShopRepository shopRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Shop 저장
        ShopMenuItem m1_1 = ShopMenuItem.builder()
                .menuName("양꼬치(소)")
                .menuPrice(Money.wons(11000))
                .build();
        ShopMenuItem m1_2 = ShopMenuItem.builder()
                .menuName("양꼬치(대)")
                .menuPrice(Money.wons(15000))
                .build();


        Shop s1 = Shop.builder()
                .minOrderAmt(Money.wons(12000L))
                .shopStatus(ShopStatus.OPEN)
                .shopMenuItems(Arrays.asList(m1_1,m1_2))
                .shopName("양꼬치대장").build();
        shopRepository.save(s1);

        ShopMenuItem m2_1 = ShopMenuItem.builder()
                .menuName("수원돼지갈비")
                .menuPrice(Money.wons(15000))
                .build();
        ShopMenuItem m2_2 = ShopMenuItem.builder()
                .menuName("수원왕갈비")
                .menuPrice(Money.wons(25000))
                .build();

        Shop s2 = Shop.builder()
                .minOrderAmt(Money.wons(25000L))
                .shopMenuItems(Arrays.asList(m2_1,m2_2))
                .shopStatus(ShopStatus.OPEN)
                .shopName("수원왕갈비").build();
        shopRepository.save(s2);

    }
}
