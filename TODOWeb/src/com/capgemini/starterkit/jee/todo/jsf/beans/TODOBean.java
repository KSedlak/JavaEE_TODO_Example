package com.capgemini.starterkit.jee.todo.jsf.beans;



import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.capgemini.starterkit.jee.todo.entities.TODO;
import com.capgemini.starterkit.jee.todo.service.TODOsManagementService;

@SessionScoped
@ManagedBean(name = "todoBean")
public class TODOBean {

	@EJB
	private TODOsManagementService todosService;
	
	
	public List<TODO> getTodos() {
		return todosService.findTODOs();
	}
	
	public void setTodoAsDone(TODO todo) {
		todosService.markTODOAsDone(todo);
	}
	
	private TODO todo;
	
	public TODO getTodo() {
		if (todo == null) {
			todo = new TODO();
		}
		return todo;
	}
	
	public String addNewTodo() {
		todosService.addTODO(todo);
		todo = null;
		
		return "list";
	}
}
