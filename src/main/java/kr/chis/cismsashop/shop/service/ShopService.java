package kr.chis.cismsashop.shop.service;

import kr.chis.cismsashop.shop.domain.Shop;
import kr.chis.cismsashop.shop.domain.ShopDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author InSeok
 * Date : 2020/07/22
 * Remark :
 */
public interface ShopService {
    public Flux<Shop> findAll();
    public Mono<Shop> findById(Long id);

}
