package com.jmc.commons.web.configuration;

import com.jmc.commons.utils.test.AbstractMockTest;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.web.filter.CorsFilter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Jeremy MARTIN CATANI
 * created on 29/10/2021
 */
@PrepareForTest(value = {WebMvcCorsConfiguration.class})
public class WebMvcCorsConfigurationTest extends AbstractMockTest {

	@Test
	public void withoutExposeHeaders() {
		WebMvcCorsConfiguration webMvcCorsConfiguration = new WebMvcCorsConfiguration(Boolean.FALSE);
		CorsFilter corsFilter = webMvcCorsConfiguration.corsFilter();
		assertNotNull(corsFilter, "Cors filter must noy be null");
	}

	@Test
	public void withExposeHeaders() {
		WebMvcCorsConfiguration webMvcCorsConfiguration = new WebMvcCorsConfiguration(Boolean.TRUE);
		CorsFilter corsFilter = webMvcCorsConfiguration.corsFilter();
		assertNotNull(corsFilter, "Cors filter must noy be null");
	}

}