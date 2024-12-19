package com.mx.dev.blog.spring_001_blog.utils.validators;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.mx.dev.blog.spring_001_blog.utils.constants.regex.ReplyRegex;
import com.mx.dev.blog.spring_001_blog.utils.dtos.reply.ReplyCreateRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.enums.MethodEnum;
import com.mx.dev.blog.spring_001_blog.utils.enums.ResponseStatus;
import com.mx.dev.blog.spring_001_blog.utils.enums.ValidationReplyEnum;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;

public class ReplyValidator implements Validator<ReplyCreateRequestDTO> {

	public Map<String, String> mapValidation = new HashMap<>();

	public boolean isValidateContent(String content) {
		return Pattern.matches(ReplyRegex.ALFANUMERIC_300, content);
	}

	@Override
	public void validate(ReplyCreateRequestDTO t) throws ServiceException {
		mapValidation.clear();
		validateContent(t.getContent());

		if (!mapValidation.isEmpty()) {
			throw new ServiceException("Validation errors", ResponseStatus.BAD_REQUEST.getHttpStatusCode(),
					"/api/reply", MethodEnum.POST, mapValidation);
		}

	}

	public void validateContent(String content) {

		boolean isValid = isValidateContent(content);

		if (!isValid || content.isBlank() || content.isEmpty()) {
			mapValidation.put("content", ValidationReplyEnum.ALFANUMERIC_300.getMessage());
		}
	}

}
