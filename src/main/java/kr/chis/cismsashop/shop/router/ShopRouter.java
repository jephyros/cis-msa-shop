package kr.chis.cismsashop.shop.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author InSeok
 * Date : 2020-08-19
 * Remark :
 */

@Configuration
@EnableWebFlux
public class ShopRouter {
    @Bean
    public RouterFunction<ServerResponse> routes(ShopHandler handler){
        return nest(path("/api/v1/shops"),
                route(GET("/"),handler::shopList)
                .andRoute(GET("/{id}"),handler::FindById)
        );

    }

}
