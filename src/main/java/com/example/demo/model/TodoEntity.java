package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Todo")
public class TodoEntity {

	@Id
	@GeneratedValue(generator = "system-uuid")//id를 자동생성
	@GenericGenerator(name = "system-uuid", strategy = "uuid")// 나만의 GenericGenerator를 사용하려 할때 사용
	//기본적으로는 INCREMENTAL, SEQUEBCE, IDENTITY 등이 있음
	private String id;
	private String userId;
	private String title;
	private boolean done;
	
	
	
}
