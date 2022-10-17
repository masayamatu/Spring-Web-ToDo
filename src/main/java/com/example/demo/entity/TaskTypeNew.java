package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tasktypenew")
public class TaskTypeNew implements Serializable{
	@Id
	@Column(name = "id")
    private int id;
	@Column(name = "type")
    private String type;
	@Column(name = "comment")
    private String comment;
	@OneToMany(mappedBy = "taskTypeNew", cascade = CascadeType.ALL)
	private List<TaskNew> taskNews;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
