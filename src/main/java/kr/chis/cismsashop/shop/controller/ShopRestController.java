package kr.chis.cismsashop.shop.controller;

import kr.chis.cismsashop.common.ShopStatus;
import kr.chis.cismsashop.shop.domain.Shop;
import kr.chis.cismsashop.shop.domain.ShopDto;
import kr.chis.cismsashop.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

/**
 * @author InSeok
 * Date : 2020/07/19
 * Remark :
 */
@RestController
@RequestMapping("/api/v1/shops")
public class ShopRestController {
    private final ShopService shopService;

    @Autowired
    public ShopRestController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("")
    public Flux<Shop> getShops(){

        return shopService.findAll();
    }

}
