package br.com.jamesson.mscartoes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableRabbit
@Slf4j
public class MsCartoesApplication {
	public static void main(String[] args) {
		log.info("Informação: {}", "teste info");
		log.error("Erro: {}", "teste erro");
		log.warn("Aviso: {}", "teste aviso");
		SpringApplication.run(MsCartoesApplication.class, args);
	}

}
