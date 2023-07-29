package dev.halasz.bored.shell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.command.CommandRegistration;

@SpringBootApplication
public class BoredShellApplication {

	String[] PossibleTypes = {"education", "recreational", "social", "diy", "charity", "cooking", "relaxation", "music", "busywork"};

	public static void main(String[] args) {
		SpringApplication.run(BoredShellApplication.class, args);
	}

	@Bean
	CommandRegistration commandRegistration() {
		return 	CommandRegistration.builder()
				.command("get")
				.description("Get random tipps against boredom.")
				.withTarget()
				.function(ctx -> {
					String arg = ctx.getRawArgs().length > 1 ? ctx.getRawArgs()[1] : null;
					return new GetFromBoredAPI().getRequestToBoredAPI(arg);
				})
				.and()
					.withOption()
					.longNames("education", "recreational", "social", "diy", "charity", "cooking", "relaxation", "music", "busywork")
					.required(false)
				.and()
				.build();
	}
}
