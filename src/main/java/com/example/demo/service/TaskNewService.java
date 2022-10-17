package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TaskNew;
import com.example.demo.entity.TaskNewRepository;

@Service
public class TaskNewService {
	@Autowired
	TaskNewRepository taskNewRepository;
	
	public TaskNew getTaskNew(Integer id) {
		Optional<TaskNew> task = taskNewRepository.findById(id);
		return task.get();
	}
	
	public TaskNew insert(TaskNew task) {
		return taskNewRepository.save(task);
	}
	
	public TaskNew update(Integer id, TaskNew updTask) {
		TaskNew task = getTaskNew(id);
		task.setTitle(updTask.getTitle());
		task.setTypeId(updTask.getTaskType().getId());
		task.setDetail(updTask.getDetail());
		task.setDeadline(updTask.getDeadline());
		return task;
	}
	
	public List<TaskNew> findByName(String userName)
	{
		List<TaskNew> list = taskNewRepository.findByUserName(userName);
		return list;
	}
	public List<TaskNew> findAll() {
		List<TaskNew> list = taskNewRepository.findAll();
		return list;
	}
}
