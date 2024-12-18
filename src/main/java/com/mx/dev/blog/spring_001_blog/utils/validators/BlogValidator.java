package com.mx.dev.blog.spring_001_blog.utils.validators;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.mx.dev.blog.spring_001_blog.utils.constants.regex.BlogRegex;
import com.mx.dev.blog.spring_001_blog.utils.dtos.blog.BlogCreateRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.enums.MethodEnum;
import com.mx.dev.blog.spring_001_blog.utils.enums.ResponseStatus;
import com.mx.dev.blog.spring_001_blog.utils.enums.ValidationCategoryEnum;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;

public class BlogValidator implements Validator<BlogCreateRequestDTO> {

	public Map<String, String> mapValidation = new HashMap<>();

	public boolean isValidateDescription(String description) {
		return Pattern.matches(BlogRegex.ALFANUMERIC_300, description);
	}

	public boolean isValidateTitle(String title) {
		return Pattern.matches(BlogRegex.ALFANUMERIC_200, title);
	}

	@Override
	public void validate(BlogCreateRequestDTO t) throws ServiceException {
		mapValidation.clear();
		validateDescription(t.getDescription());
		validateContent(t.getContent());
		validateTitle(t.getTitle());

		if (!mapValidation.isEmpty()) {
			throw new ServiceException("Validation errors", ResponseStatus.BAD_REQUEST.getHttpStatusCode(), "/api/blog",
					MethodEnum.POST, mapValidation);
		}

	}

	public void validateContent(String content) {

		if (content.isBlank() || content.isEmpty()) {
			mapValidation.put("content", ValidationCategoryEnum.ALFANUMERIC_150.getMessage());
		}
	}

	public void validateDescription(String description) {

		boolean isValid = isValidateDescription(description);

		if (!isValid || description.isBlank() || description.isEmpty()) {
			mapValidation.put("description", ValidationCategoryEnum.ALFANUMERIC_300.getMessage());
		}
	}

	public void validateTitle(String title) {

		boolean isValid = isValidateTitle(title);

		if (!isValid || title.isBlank() || title.isEmpty()) {
			mapValidation.put("title", ValidationCategoryEnum.COLOR_HEXA.getMessage());
		}
	}

}
