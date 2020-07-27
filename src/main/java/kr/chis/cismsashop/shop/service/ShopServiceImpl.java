package kr.chis.cismsashop.shop.service;

import kr.chis.cismsashop.shop.domain.Shop;
import kr.chis.cismsashop.shop.domain.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
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

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
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
            Thread.sleep(2000);
            //log.info("repository========");
            //this.asyncWork("call async");
            return shopRepository.findById(id).orElse(null);
        })
                .subscribeOn(Schedulers.elastic())
                .map(v-> {
                    try {
                        v.setShopName(this.asyncWork(v.getShopName()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    return v;
                });
    }

    //@Async("threadPoolTaskExecutor")
    public String asyncWork(String str) throws InterruptedException {
        Thread.sleep(2000);
        log.info("Asyncwork=========:" + str);
        return str+"<AsyncWork>";
    }
}
