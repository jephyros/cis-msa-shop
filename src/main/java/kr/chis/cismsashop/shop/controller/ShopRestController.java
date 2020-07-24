package kr.chis.cismsashop.shop.controller;

import kr.chis.cismsashop.shop.domain.Shop;
import kr.chis.cismsashop.shop.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

/**
 * @author InSeok
 * Date : 2020/07/19
 * Remark :
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/shops")
public class ShopRestController {
    private final ShopService shopService;

    @Autowired
    public ShopRestController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("")
    public Mono<List<Shop>> getShops() throws InterruptedException {

        return shopService.findAll();

    }
    @GetMapping("/{id}")
    public Mono<Shop> getShop(@PathVariable Long id){
        log.info("GetShop Called");
        return shopService.findById(id);
    }
    //test=======================================================
    @GetMapping("/service1")
    public Mono<String> service1(String req) throws InterruptedException {
        //netty 는 비동기로 mono 로 해야 속도가 날듯
        //Thread.sleep(2000);
        //return req + "/service1";
        return Mono.fromCallable(()-> {
                    Thread.sleep(2000);
                    return req + "/service1";
                }).subscribeOn(Schedulers.elastic()).log();
    }
    @GetMapping("/service2")
    public Mono<String> service2(String req) throws InterruptedException {
        //netty 는 비동기로 mono 로 해야 속도가 날듯
//        Thread.sleep(2000);
//        return req + "/service2";
        return Mono.fromCallable(()-> {
                Thread.sleep(2000);
                return req + "/service2";
            }).subscribeOn(Schedulers.elastic()).log();

    }


}
