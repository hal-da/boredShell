package dev.halasz.bored.shell;


import dev.halasz.bored.shell.Models.BORED_RESPONSE_TYPE;
import dev.halasz.bored.shell.Models.BoredResponse;
import org.springframework.web.reactive.function.client.WebClient;
public class GetFromBoredAPI {

    public String getRequestToBoredAPI(String inputArg){

        String url = "http://www.boredapi.com/api/activity/";

        if(inputArg == null)  return getResponse(url);

        String type = inputArg.substring(2);

        if(BORED_RESPONSE_TYPE.get(type).isPresent())  {
            url = "http://www.boredapi.com/api/activity?type=" + type;

            // ich könnte api mocken und and
            // DTO
            // feign
            // tests
            //https://github.com/google/google-java-format
        }
        return getResponse(url);
    }

    private static String getResponse(String url) {
        BoredResponse res;
        WebClient client = WebClient.create(url);
        try {
            res = client.get().retrieve().bodyToMono(BoredResponse.class).block();
            assert res != null;
            return res.activity();
        } catch (Exception e) {
            return "Something went wrong, check your internet connection";
        }
    }
}
