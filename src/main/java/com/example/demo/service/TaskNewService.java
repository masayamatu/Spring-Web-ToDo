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
	
	public Optional<TaskNew> getTaskNew(Integer id) {
		Optional<TaskNew> taskOpt = taskNewRepository.findById(id);
		return taskOpt;
	}
	public TaskNew getTaskNewById(Integer id) {
		Optional<TaskNew> taskOpt = taskNewRepository.findById(id);
		return taskOpt.get();
	}
	
	public TaskNew insert(TaskNew task) {
		return taskNewRepository.save(task);
	}
	
	public TaskNew update(Integer id, TaskNew updTask) {
		Optional<TaskNew> taskOpt = getTaskNew(id);
		TaskNew task = new TaskNew();
		if(taskOpt.isPresent()) {
			insert(updTask);
		} else {
			throw new TaskNotFoundException("指定されたタスクは存在しません。");
		}
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
