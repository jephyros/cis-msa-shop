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
    public Flux<Shop> getShops(){
        log.info("GetShops Called");
        return shopService.findAll();
    }
    @GetMapping("/{id}")
    public Mono<Shop> getShop(@PathVariable Long id){
        log.info("GetShop Called");
        return shopService.findById(id);
    }

}
