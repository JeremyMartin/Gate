package com.jmc.commons.web.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class consists of define a container for CORS configuration along with methods to check against the actual origin, HTTP methods, and
 * headers of a given request for whole application
 *
 * @author Jeremy MARTIN CATANI
 * created on 28/10/2021
 */
@Configuration
public class WebMvcCorsConfiguration {

	private static final long MAX_AGE = 3600;
	private static final List<String> ALLOWED_HEADERS = new ArrayList<>() {{
		add(HttpHeaders.AUTHORIZATION);
		add(HttpHeaders.ACCEPT_LANGUAGE);
		add(HttpHeaders.CONTENT_TYPE);
	}};
	private static final List<String> DEFAULT_EXPOSED_HEADERS = new ArrayList<>() {{
		add(HttpHeaders.AUTHORIZATION);
		add(HttpHeaders.ACCEPT_LANGUAGE);
		add(HttpHeaders.CONTENT_TYPE);
	}};
	private static final List<String> EXPOSED_HEADERS = new ArrayList<>() {{
		add(HttpHeaders.AUTHORIZATION);
		add(HttpHeaders.ACCEPT_LANGUAGE);
		add(HttpHeaders.CONTENT_DISPOSITION);
		add(HttpHeaders.CONTENT_TYPE);
		add(HttpHeaders.TRANSFER_ENCODING);
	}};

	private final boolean exposeHeaders;

	public WebMvcCorsConfiguration(@Value("${expose.headers:false}") final boolean exposeHeaders) {
		this.exposeHeaders = exposeHeaders;
	}

	private List<String> getAllowedHeaders() {
		if (this.exposeHeaders) {
			return EXPOSED_HEADERS;
		}
		return DEFAULT_EXPOSED_HEADERS;
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(Boolean.FALSE);
		corsConfiguration.setAllowedHeaders(ALLOWED_HEADERS);
		corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));
		corsConfiguration.setExposedHeaders(this.getAllowedHeaders());
		corsConfiguration.setMaxAge(MAX_AGE);
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
