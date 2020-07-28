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
            Thread.sleep(2000);
            return shopRepository.findAll();
        })
                .subscribeOn(Schedulers.elastic()).log();


    }

    @Override
    public Mono<Shop> findById(Long id) {
        log.info("Shop findById====서비스 시작");
//        Optional<Shop> shop = shopRepository.findById(id);
//        return Mono.just(shop.get()).log();
        return Mono.fromCallable(()-> {
            log.info("repository find");
            Thread.sleep(2000);
            return shopRepository.findById(id).orElse(null);
        })

                .map(v-> {
                    try {
                        log.info(shopTestService.asyncWork("test"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return v;
                }).subscribeOn(Schedulers.elastic());


    }


}
