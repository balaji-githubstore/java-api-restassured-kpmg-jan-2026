package com.kpmg.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)

/**
 * @Data - auto generate getters and setters method
 * @Builder - Builder method (add value to id, name, other fields)
 * @NoArgsConstructor - creates constructor without argument
 * @AllArgsConstructor - constructor with argument (based on the fields)
 * JsonIgnoreProperties - default to false - validates the given field presence
 */
public class Pet1 {
	private Long id;
	private String name;
    private Category category;
	
}
