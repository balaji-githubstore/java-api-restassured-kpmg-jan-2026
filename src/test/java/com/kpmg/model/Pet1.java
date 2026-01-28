package com.kpmg.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(Include.NON_NULL)

/**
 * @Data - auto generate getters and setters method
 * @Builder - Builder method (add value to id, name, other fields)
 */
public class Pet1 {
	private Long id;
	private String name;
	
}
