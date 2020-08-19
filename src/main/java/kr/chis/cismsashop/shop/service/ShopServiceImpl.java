package kr.chis.cismsashop.shop.service;

import kr.chis.cismsashop.shop.domain.Shop;
import kr.chis.cismsashop.shop.domain.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

/**
 * @author InSeok
 * Date : 2020/07/22
 * Remark :
 */
@Service
@Slf4j
public class ShopServiceImpl implements ShopService{
    private final ShopRepository shopRepository;
    private final ShopTestService shopTestService;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, ShopTestService shopTestService) {
        this.shopRepository = shopRepository;
        this.shopTestService = shopTestService;
    }

    public Mono<List<Shop>> findAll()  {
        return Mono.fromCallable(()-> {
            //Thread.sleep(2000);
            return shopRepository.findAll();
        })
                .subscribeOn(Schedulers.elastic());


    }

    @Override
    public Mono<Shop> findById(Long id) {

        return Mono.fromCallable(()-> {
            //Thread.sleep(2000);
            return shopRepository.findById(id).orElse(null);
            }).subscribeOn(Schedulers.elastic());


    }


}
