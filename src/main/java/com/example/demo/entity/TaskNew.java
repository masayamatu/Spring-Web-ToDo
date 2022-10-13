package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tasknew")
public class TaskNew implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "username", nullable = false, length = 50)
    private String userName;
	
	@Column(name = "typeid", nullable = false)
    private int typeId;
	
	@OneToOne
	@JoinColumn(name = "id")
    private TaskTypeNew taskTypeNew;
	
	@Column(name = "title")
    private String title;
	
	@Column(name = "detail")
    private String detail;
	
	@Column(name = "deadline")
    private LocalDateTime deadline;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public TaskTypeNew getTaskType() {
		return taskTypeNew;
	}

	public void setTaskTypeNew(TaskTypeNew taskTypeNew) {
		this.taskTypeNew = taskTypeNew;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public LocalDateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}
}
