package com.spring.SpringCrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.SpringCrud.Model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	private static final Logger _log = LoggerFactory.getLogger(PersonDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addPerson(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(person);
		_log.info("Person saved successfully");
	}

	@Override
	public void updatePerson(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.update(person);
		_log.info("Person updated successfully, Person Details " + person);
	}

	@Override
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person person = (Person) session.load(Person.class, new Integer(id));
		if (person != null) {
			session.delete(person);
		}
		_log.info("Person deleted successfully, Person details " + person);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getPersonList() {
		Session session = sessionFactory.getCurrentSession();
		List<Person> personLists = session.createQuery("From Person").list();
		return personLists;
	}

	@Override
	public Person getPersonById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Person person = (Person) session.get(Person.class, new Integer(id));
		_log.info("Person loaded successfully , Person Details" + person);
		return person;
	}
}
