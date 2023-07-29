package dev.halasz.bored.shell;

import dev.halasz.bored.shell.Controller.BoredController;
import dev.halasz.bored.shell.Models.BORED_RESPONSE_TYPE;
import dev.halasz.bored.shell.Models.BoredResponseDTO;

public class GetTip {


    public String getRequestToBoredAPI(String inputArg){

        String url = "http://www.boredapi.com/api/activity/";

        if(inputArg == null)  return BoredController.getResponse(url).activity();

        if(BORED_RESPONSE_TYPE.get(inputArg).isPresent())  {
            url = "http://www.boredapi.com/api/activity?type=" + inputArg;

            // ich könnte api mocken und and
            // DTO
            // feign
            // tests
            //https://github.com/google/google-java-format
        }

        BoredResponseDTO boredResponseDTO = BoredController.getResponse(url);

        return boredResponseDTO.activity();
    }


}
