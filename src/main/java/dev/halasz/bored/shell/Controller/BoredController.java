package dev.halasz.bored.shell.Controller;

import dev.halasz.bored.shell.Models.BoredResponse;
import dev.halasz.bored.shell.Models.BoredResponseDTO;
import org.springframework.web.reactive.function.client.WebClient;

public class BoredController {
    public static BoredResponseDTO getResponse(String url) {
        BoredResponse res;
        WebClient client = WebClient.create(url);
        try {
            res = client.get().retrieve().bodyToMono(BoredResponse.class).block();
            assert res != null;
            return new BoredResponseDTO(res.activity());
        } catch (Exception e) {
            return new BoredResponseDTO("Something went wrong, check your internet connection");
        }
    }
}
