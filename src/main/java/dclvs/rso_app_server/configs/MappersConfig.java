package dclvs.rso_app_server.configs;

import dclvs.rso_app_server.mappers.EventMapper;
import dclvs.rso_app_server.mappers.UserMapper;
import dclvs.rso_app_server.mappers.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public EventMapper eventMapper() {
        return new EventMapperImpl();
    }

}
