package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repository;

	public String testService() {
		TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
		
		repository.save(entity);//����
		
		
		TodoEntity saveEntity = repository.findById(entity.getId()).get();
		
		return saveEntity.getTitle();
	}
	
	/**
	 * ������ �۾� �� ������ ���� üũ 
	 * */
	private void validate(TodoEntity entity) {
		if(entity == null) {
			log.warn("Entity = null");
			throw new RuntimeException("Entity ---> null");
		}
		
		if(entity.getUserId() == null) {
			log.warn("user Unknown");
			throw new RuntimeException("user Unknown");
		}
	}
	
	/**
	 * ������� ���� ����
	 * */
	public List<TodoEntity> create(final TodoEntity entity){
		validate(entity);
		
		repository.save(entity);
		
		log.info("Entity id : {} is saved.",entity.getUserId());
		return repository.findByUserId(entity.getUserId());
	}
	
	
	/**
	 * ������� ������ȸ
	 * */
	public List<TodoEntity> retrive(final String userId){
		return repository.findByUserId(userId);
	}
	
	public List<TodoEntity> update(final TodoEntity entity){
		validate(entity);
		
		repository.findByUserId(entity.getId());
		
		final Optional<TodoEntity> original = repository.findById(entity.getId());
		
		if(original.isPresent()) {// ���� ������ ���
			final TodoEntity todo = original.get();
			todo.setTitle(entity.getTitle());
			todo.setDone(entity.isDone());
			
			repository.save(todo);
		}
		return retrive(entity.getUserId()); // ������ ���� ��ȸ
	}
	
}
