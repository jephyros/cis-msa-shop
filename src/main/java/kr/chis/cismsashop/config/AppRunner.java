package kr.chis.cismsashop.config;

import kr.chis.cismsashop.common.ShopStatus;
import kr.chis.cismsashop.shop.domain.Shop;
import kr.chis.cismsashop.shop.domain.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

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
        Shop s1 = Shop.builder()
                .minOrderAmt(12000L)
                .shopStatus(ShopStatus.OPEN)
                .shopName("양꼬치대장").build();
        shopRepository.save(s1);

        Shop s2 = Shop.builder()
                .minOrderAmt(25000L)
                .shopStatus(ShopStatus.OPEN)
                .shopName("수원왕갈비").build();
        shopRepository.save(s2);

    }
}
