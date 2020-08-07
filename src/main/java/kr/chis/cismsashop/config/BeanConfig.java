package kr.chis.cismsashop.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author InSeok
 * Date : 2020/08/08
 * Remark :
 */
@Configuration
public class BeanConfig {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    //@Bean
    //    public ModelMapper modelMapper() {
    //        return new ModelMapper();
    //    }
}
