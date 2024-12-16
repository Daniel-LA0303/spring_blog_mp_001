package com.mx.dev.blog.spring_001_blog.integration.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.mx.dev.blog.spring_001_blog.builders.category.CategoryRequestDTOBuilder;
import com.mx.dev.blog.spring_001_blog.builders.category.CategoryResponseDTOBuilder;
import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryResponseDTO;
import com.mx.dev.blog.spring_001_blog.utils.response.ApiResponse;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/import.sql")
@ActiveProfiles("test")
public class CategoryServiceExceptionTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int port;

	HttpHeaders headers;

	CategoryResponseDTO categoryBuilder;

	CategoryRequestDTO categoryRequestDTOBuilder;

	@Test
	@Order(1)
	void createCategoryExistingExceptionTest() {

		// change data builder
		CategoryResponseDTO categoryBuilder = CategoryResponseDTOBuilder.withAllDummy().setCategoryId(6L)
				.setName("Travel").setDescription("This is a sample description.").setColor("#FF5733").build();

		CategoryRequestDTO categoryRequestDTOBuilder = CategoryRequestDTOBuilder.withAllDummy().setColor("#000")
				.setName("Education").setDescription("A easy description.").build();

		HttpEntity<CategoryRequestDTO> requestEntity = new HttpEntity<>(categoryRequestDTOBuilder, headers);

		ResponseEntity<ApiResponse<CategoryResponseDTO>> response = testRestTemplate.exchange("/api/category",
				HttpMethod.POST, requestEntity, new ParameterizedTypeReference<ApiResponse<CategoryResponseDTO>>() {
				});

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		ApiResponse<CategoryResponseDTO> apiResponse = response.getBody();
		assertNotNull(apiResponse);
		assertEquals(400, apiResponse.getStatus());

	}

	@Test
	@Order(3)
	void createCategoryInvalidDataExceptionTest() {

		// change data builder
		CategoryResponseDTO categoryBuilder = CategoryResponseDTOBuilder.withAllDummy().setCategoryId(6L)
				.setName("Sample Category").setDescription("This is a sample description.").setColor("#FF5733").build();

		CategoryRequestDTO categoryRequestDTOBuilder = CategoryRequestDTOBuilder.withAllDummy().setColor("#jklsa920")
				.setName(
						"The rapid development of technology has enabled significant advancements across multiple fields, from artificial intelligence to personalized medicine, opening new possibilities to improve the quality of life and tackle global challenges with a more efficient and sustainable approach.")
				.setDescription(
						"In today's fast-paced world, technology is advancing at an unprecedented rate, revolutionizing industries and reshaping the way we live. From artificial intelligence and machine learning to robotics and biotechnology, these innovations are transforming everything from healthcare and education to transportation and entertainment, creating a future where possibilities are endless and new challenges arise at every corner.")
				.build();

		HttpEntity<CategoryRequestDTO> requestEntity = new HttpEntity<>(categoryRequestDTOBuilder, headers);

		ResponseEntity<ApiResponse<CategoryResponseDTO>> response = testRestTemplate.exchange("/api/category",
				HttpMethod.POST, requestEntity, new ParameterizedTypeReference<ApiResponse<CategoryResponseDTO>>() {
				});

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		ApiResponse<CategoryResponseDTO> apiResponse = response.getBody();
		assertNotNull(apiResponse);
		assertEquals(400, apiResponse.getStatus());

	}

	@BeforeEach
	void setUp() {

		categoryBuilder = CategoryResponseDTOBuilder.withAllDummy().build();

		categoryRequestDTOBuilder = CategoryRequestDTOBuilder.withAllDummy().setColor("#98sjka2a").build();

		headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);

	}

	/*
	 * @Test
	 * 
	 * @Order(2) void updateCategoryExistingExceptionTest() {
	 * 
	 * CategoryRequestDTO categoryRequestDTOBuilder =
	 * CategoryRequestDTOBuilder.withAllDummy().setColor("#000")
	 * .setName("Health").setDescription("A easy description.").build();
	 * 
	 * HttpEntity<CategoryRequestDTO> requestEntity = new
	 * HttpEntity<>(categoryRequestDTOBuilder, headers);
	 * 
	 * ResponseEntity<ApiResponse<CategoryResponseDTO>> response =
	 * testRestTemplate.exchange("/api/category/1", HttpMethod.PUT, requestEntity,
	 * new ParameterizedTypeReference<ApiResponse<CategoryResponseDTO>>() { });
	 * 
	 * assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	 * 
	 * ApiResponse<CategoryResponseDTO> apiResponse = response.getBody();
	 * assertNotNull(apiResponse); assertEquals(404, apiResponse.getStatus());
	 * 
	 * // CommentDTO commentDTO = apiResponse.getData();
	 * 
	 * // assertNotNull(apiResponse.getData());
	 * 
	 * // assertEquals(categoryResponseDTOBuilder.getCategoryId(), //
	 * apiResponse.getData().getCategoryId()); //
	 * assertEquals(categoryResponseDTOBuilder.getDescription(), //
	 * apiResponse.getData().getDescription()); //
	 * assertEquals(categoryResponseDTOBuilder.getColor(), //
	 * apiResponse.getData().getColor()); //
	 * assertEquals(categoryResponseDTOBuilder.getName(), //
	 * apiResponse.getData().getName());
	 * 
	 * assertNotNull(apiResponse.getTimestamp());
	 * 
	 * }
	 */

	@Test
	@Order(4)
	void updateCategoryInvalidDataExceptionTest() {

		CategoryResponseDTO categoryResponseDTOBuilder = CategoryResponseDTOBuilder.withAllDummy().setCategoryId(1L)
				.setName("New Category EDIT").setDescription("This is a sample description.").setColor("#FF5733")
				.build();

		CategoryRequestDTO categoryRequestDTOBuilder = CategoryRequestDTOBuilder.withAllDummy().setColor("#jklsa920")
				.setName(
						"The rapid development of technology has enabled significant advancements across multiple fields, from artificial intelligence to personalized medicine, opening new possibilities to improve the quality of life and tackle global challenges with a more efficient and sustainable approach.")
				.setDescription(
						"In today's fast-paced world, technology is advancing at an unprecedented rate, revolutionizing industries and reshaping the way we live. From artificial intelligence and machine learning to robotics and biotechnology, these innovations are transforming everything from healthcare and education to transportation and entertainment, creating a future where possibilities are endless and new challenges arise at every corner.")
				.build();

		HttpEntity<CategoryRequestDTO> requestEntity = new HttpEntity<>(categoryRequestDTOBuilder, headers);

		ResponseEntity<ApiResponse<CategoryResponseDTO>> response = testRestTemplate.exchange("/api/category/1",
				HttpMethod.PUT, requestEntity, new ParameterizedTypeReference<ApiResponse<CategoryResponseDTO>>() {
				});

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		ApiResponse<CategoryResponseDTO> apiResponse = response.getBody();
		assertNotNull(apiResponse);
		assertEquals(400, apiResponse.getStatus());

		// CommentDTO commentDTO = apiResponse.getData();

		// assertNotNull(apiResponse.getData());

		// assertEquals(categoryResponseDTOBuilder.getCategoryId(),
		// apiResponse.getData().getCategoryId());
		// assertEquals(categoryResponseDTOBuilder.getDescription(),
		// apiResponse.getData().getDescription());
		// assertEquals(categoryResponseDTOBuilder.getColor(),
		// apiResponse.getData().getColor());
		// assertEquals(categoryResponseDTOBuilder.getName(),
		// apiResponse.getData().getName());

		assertNotNull(apiResponse.getTimestamp());

	}

	@Test
	@Order(5)
	void updateCategoryNotFoundExceptionTest() {

		CategoryResponseDTO categoryResponseDTOBuilder = CategoryResponseDTOBuilder.withAllDummy().setCategoryId(1L)
				.setName("New Category EDIT").setDescription("This is a sample description.").setColor("#FF5733")
				.build();

		CategoryRequestDTO categoryRequestDTOBuilder = CategoryRequestDTOBuilder.withAllDummy().setColor("#000")
				.setName("Travel").setDescription("A easy description.").build();

		HttpEntity<CategoryRequestDTO> requestEntity = new HttpEntity<>(categoryRequestDTOBuilder, headers);

		ResponseEntity<ApiResponse<CategoryResponseDTO>> response = testRestTemplate.exchange("/api/category/99999",
				HttpMethod.PUT, requestEntity, new ParameterizedTypeReference<ApiResponse<CategoryResponseDTO>>() {
				});

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

		ApiResponse<CategoryResponseDTO> apiResponse = response.getBody();
		assertNotNull(apiResponse);
		assertEquals(404, apiResponse.getStatus());

		// CommentDTO commentDTO = apiResponse.getData();

		// assertNotNull(apiResponse.getData());

		// assertEquals(categoryResponseDTOBuilder.getCategoryId(),
		// apiResponse.getData().getCategoryId());
		// assertEquals(categoryResponseDTOBuilder.getDescription(),
		// apiResponse.getData().getDescription());
		// assertEquals(categoryResponseDTOBuilder.getColor(),
		// apiResponse.getData().getColor());
		// assertEquals(categoryResponseDTOBuilder.getName(),
		// apiResponse.getData().getName());

		assertNotNull(apiResponse.getTimestamp());

	}

}
