package kr.chis.cismsashop.shop.router;

import kr.chis.cismsashop.shop.domain.Shop;
import kr.chis.cismsashop.shop.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author InSeok
 * Date : 2020-08-19
 * Remark :
 */
@Component
@Slf4j
public class ShopHandler {
    private final ShopService shopService;

    @Autowired
    public ShopHandler(ShopService shopService) {
        this.shopService = shopService;
    }

    public Mono<ServerResponse> shopList(ServerRequest request) {
        return shopService.findAll()
                .flatMap(v-> ok().body(Mono.just(v),Shop.class));
    }
    public Mono<ServerResponse> FindById(ServerRequest request){
        Long id = Long.valueOf(request.pathVariable("id"));

        return shopService.findById(id)
                .flatMap(v-> ok().body(Mono.just(v),Shop.class));
    }

}
