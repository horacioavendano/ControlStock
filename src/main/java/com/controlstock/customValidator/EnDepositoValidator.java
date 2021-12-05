package com.controlstock.customValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EnDepositoValidator implements ConstraintValidator<EnDeposito, String> {

	Logger logger = LoggerFactory.getLogger(EnDepositoValidator.class);

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean rta = false;
		try {
			RestTemplate restTemplate = new RestTemplate();
			String fooResourceUrl = "https://api.mercadolibre.com/items/";
			ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + value, String.class);
			if (response.getStatusCode() == HttpStatus.OK) {

				JSONObject productJson = new JSONObject(response.getBody());
				JSONObject shipping = (JSONObject) productJson.get("shipping");
				String logistic_type = (String) shipping.get("logistic_type");
				if (logistic_type.equals("fulfillment")) {
					rta = true;
				}
			} else {
				rta = false;
			}

		} catch (Exception e) {

			return false;
		}
		return rta;
	}
}
