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

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Flux<Shop> findAll(){
        List<Shop> shops = shopRepository.findAll();
        return Flux.fromIterable(shops);
    }

    @Override
    public Mono<Shop> findById(Long id) {
        log.info("Shop findById====서비스 시작");
//        Optional<Shop> shop = shopRepository.findById(id);
//        return Mono.just(shop.get()).log();
        return Mono.fromCallable(()-> shopRepository.findById(id).get())
                .subscribeOn(Schedulers.elastic()).log();
    }
}
