package umc.study.Ateam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AteamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AteamApplication.class, args);
	}

}
