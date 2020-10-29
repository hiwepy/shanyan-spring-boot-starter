package com.shanyan.spring.boot;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shanyan.spring.boot.dto.FlashLoginResponse;
import com.shanyan.spring.boot.dto.FlashValidateResponse;

import okhttp3.OkHttpClient;

public class FlashMobileTemplateTest {

	ObjectMapper objectMapper = new ObjectMapper();
	OkHttpClient okhttp3Client = new OkHttpClient.Builder().build();
	FlashMobileProperties properties = new FlashMobileProperties();
	
	@Before
	public void setup() {
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}

	@Test
	public void testLogin() {

		try {
			FlashMobileTemplate template = new FlashMobileTemplate(properties, objectMapper, okhttp3Client);
			FlashLoginResponse response = template.login("test", "127.0.0.1", "00001");
			System.out.println(objectMapper.writeValueAsString(response));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testValidate() {

		try {
			
			FlashMobileTemplate template = new FlashMobileTemplate(properties, objectMapper, okhttp3Client);
			FlashValidateResponse response2 = template.validate("test", "", "");
			System.out.println(objectMapper.writeValueAsString(response2));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}