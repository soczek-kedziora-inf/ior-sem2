package pl.polsl.projekt;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.polsl.projekt.utils.DataLoader;

@SpringBootApplication
@AllArgsConstructor
public class ProjektSoczekKedzioraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektSoczekKedzioraApplication.class, args);
	}


}
