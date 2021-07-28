package santos.karolina.consultaDeCidades.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import santos.karolina.consultaDeCidades.services.DBService;

@Configuration
@Profile("prod")
public class ProdConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public boolean criarBanco(){
        dbService.criarBanco();
        return true;
    }
}
