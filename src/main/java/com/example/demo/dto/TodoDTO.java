package com.example.demo.dto;

import com.example.demo.model.TodoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

	private String id;
	private String userId;
	private String title;
	private boolean done;
	
	
	public TodoDTO(final TodoEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.done = entity.isDone();
	}
	
	public static TodoEntity todoEntity(final TodoDTO dto) {
		return TodoEntity.builder().id(dto.id)
				.title(dto.title)
				.done(dto.done).build();
		
	}
}
