package com.spring.SpringCrud.service;

import java.util.List;

import com.spring.SpringCrud.Model.Person;

public interface PersonService {

	public void addPerson(Person person);

	public void updatePerson(Person person);

	public void removePerson(int id);

	public List<Person> getPersonList();

	public Person getPersonById(int id);
}
