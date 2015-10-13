package com.capgemini.starterkit.jee.todo.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.capgemini.starterkit.jee.todo.entities.TODO;

/**
 * Session Bean implementation class TODOsManagmentService
 */
@Stateless
@LocalBean
public class TODOsManagmentService {

    /**
     * Default constructor. 
     */
    public TODOsManagmentService() {
        // TODO Auto-generated constructor stub
    }
    
	@PersistenceContext(unitName = "TodoPU")
	EntityManager em;

	public List<TODO> findTODOs() {
		return em.createQuery("Select td From TODO td", TODO.class)
				.getResultList();
	}

	public void addTODO(TODO todo) {
		em.persist(todo);
	}

	public void markTODOAsDone(TODO todo) {
		TODO todoDb = em.find(TODO.class, todo.getId());
		todoDb.setDone(true);
	}


}
