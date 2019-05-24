package com.spring.SpringCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.SpringCrud.Model.Person;
import com.spring.SpringCrud.dao.PersonDao;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;

	@Override
	@Transactional
	public void addPerson(Person person) {
		personDao.addPerson(person);
	}

	@Override
	@Transactional
	public void updatePerson(Person person) {
		personDao.updatePerson(person);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		personDao.removePerson(id);
	}

	@Override
	@Transactional
	public List<Person> getPersonList() {

		return personDao.getPersonList();
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		return personDao.getPersonById(id);
	}

}
