package com.kb.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ToDoDTO {

	private String title;
	private Date dueDate;
}
