package kr.chis.cismsashop.shop.service;

import kr.chis.cismsashop.shop.domain.Shop;
import kr.chis.cismsashop.shop.domain.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author InSeok
 * Date : 2020/07/22
 * Remark :
 */
@Service
public class ShopServiceImpl implements ShopService{
    private final ShopRepository shopRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Flux<Shop> findAll(){
        List<Shop> shops = shopRepository.findAll();
        return Flux.fromIterable(shops);
    }
}
