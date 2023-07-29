package dev.halasz.bored.shell;

import dev.halasz.bored.shell.Controller.BoredController;
import dev.halasz.bored.shell.Models.BORED_RESPONSE_TYPE;
import dev.halasz.bored.shell.Models.BoredResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BoredShellApplicationTests {


	@DisplayName("Testing BORED_RESPONSE_TYPE.getEnums()")
	@Test
	public void getEnumsTest(){
		String[] types = {"education", "recreational", "social", "diy", "charity", "cooking", "relaxation", "music", "busywork"};
		assertArrayEquals(types,BORED_RESPONSE_TYPE.getEnums());
	}

	@DisplayName("Testing BORED_RESPONSE_TYPE.get(diy) isPresent")
	@Test
	public void getDiyEnumTest(){
		assertThat(BORED_RESPONSE_TYPE.get(" diy ")).isPresent();
		assertThat(BORED_RESPONSE_TYPE.get("DIY ")).isPresent();
		assertThat(BORED_RESPONSE_TYPE.get("diy")).isPresent();
	}

	@DisplayName("Testing BORED_RESPONSE_TYPE.get(x) isEmpty")
	@Test
	public void getXEnumTest() {
		assertThat(BORED_RESPONSE_TYPE.get(" x ")).isEmpty();
		assertThat(BORED_RESPONSE_TYPE.get("X")).isEmpty();
		assertThat(BORED_RESPONSE_TYPE.get("x")).isEmpty();
	}

	@DisplayName("Testing random BoredController.BoredResponseDTO() ")
	@Test
	public void getResponseTest(){
		String url = "http://www.boredapi.com/api/activity/";
		BoredResponseDTO boredResponseDTO = BoredController.getResponse(url);
		assertThat(boredResponseDTO.activity()).isNotEqualTo("Something went wrong, check your internet connection");
	}

	@DisplayName("Testing failing BoredController.BoredResponseDTO() ")
	@Test
	public void getResponseTestNullUrl(){
		BoredResponseDTO boredResponseDTO = BoredController.getResponse(null);
		assertThat(boredResponseDTO.activity()).isEqualTo("Something went wrong, check your internet connection");
	}

	@DisplayName("Testing GetTip.getRequestToBoredAPI() arg null ")
	@Test
	public void GetTipTestNullParam(){
		GetTip getTip = new GetTip();
		String response = getTip.getRequestToBoredAPI(null);
		assertThat(response).isNotEqualTo("Something went wrong, check your internet connection");
	}
	@DisplayName("Testing GetTip.getRequestToBoredAPI() arg diy ")
	@Test
	public void GetTipTestStringParam(){
		GetTip getTip = new GetTip();
		String response = getTip.getRequestToBoredAPI("diy");
		assertThat(response).isNotEqualTo("Something went wrong, check your internet connection");
	}
}
