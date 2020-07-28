package kr.chis.cismsashop.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author InSeok
 * Date : 2020-07-28
 * Remark :
 */
@Service
@Slf4j
public class ShopTestService {
    @Async("threadPoolTaskExecutor")
    public String asyncWork(String str) throws InterruptedException {
        Thread.sleep(2000);
        log.info("Asyncwork=========:" + str);
        return str+"<AsyncWork>";
    }
}
