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
	@GeneratedValue(generator = "system-uuid")//id�� �ڵ�����
	@GenericGenerator(name = "system-uuid", strategy = "uuid")// ������ GenericGenerator�� ����Ϸ� �Ҷ� ���
	//�⺻�����δ� INCREMENTAL, SEQUEBCE, IDENTITY ���� ����
	private String id;
	private String userId;
	private String title;
	private boolean done;
	
	
	
}