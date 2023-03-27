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
		
		repository.save(entity);//저장
		
		
		TodoEntity saveEntity = repository.findById(entity.getId()).get();
		
		return saveEntity.getTitle();
	}
	
	/**
	 * 데이터 작업 전 정보의 유무 체크 
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
	 * 사용자의 정보 저장
	 * */
	public List<TodoEntity> create(final TodoEntity entity){
		validate(entity);
		
		repository.save(entity);
		
		log.info("Entity id : {} is saved.",entity.getUserId());
		return repository.findByUserId(entity.getUserId());
	}
	
	
	/**
	 * 사용자의 정보조회
	 * */
	public List<TodoEntity> retrive(final String userId){
		return repository.findByUserId(userId);
	}
	
	public List<TodoEntity> update(final TodoEntity entity){
		validate(entity);
		
		repository.findByUserId(entity.getId());
		
		final Optional<TodoEntity> original = repository.findById(entity.getId());
		
		if(original.isPresent()) {// 값이 존재할 경우
			final TodoEntity todo = original.get();
			todo.setTitle(entity.getTitle());
			todo.setDone(entity.isDone());
			
			repository.save(todo);
		}
		return retrive(entity.getUserId()); // 유저의 정보 조회
	}
	
}
