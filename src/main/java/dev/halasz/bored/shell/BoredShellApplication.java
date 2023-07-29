package dev.halasz.bored.shell;

import dev.halasz.bored.shell.Models.BORED_RESPONSE_TYPE;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.command.CommandRegistration;

import org.springframework.shell.CompletionProposal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class BoredShellApplication {
	public final String[] PossibleTypes = BORED_RESPONSE_TYPE.getEnums();

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
						String arg = ctx.getRawArgs()[ctx.getRawArgs().length-1];
						return new GetTip().getRequestToBoredAPI(arg);
					})
					.and()
				.withOption()
					.completion(ctx -> Stream.of(PossibleTypes)
							.map(CompletionProposal::new)
							.collect(Collectors.toList()))
					.longNames("type")
					.shortNames('t')
					.required(false)
					.and()
				.build();
	}
}
