package invoiceCreator.backend.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {

    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure()
                     .directory("backend/src/main/java/invoiceCreator/backend")
                     .ignoreIfMissing()
                     .load();
    }


}
