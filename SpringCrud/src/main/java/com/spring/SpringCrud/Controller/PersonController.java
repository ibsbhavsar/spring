package com.spring.SpringCrud.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.SpringCrud.Model.Person;
import com.spring.SpringCrud.service.PersonService;

@Controller
public class PersonController {

	private static final Logger _log = LoggerFactory.getLogger(PersonController.class);
	@Autowired
	PersonService personService;

	@RequestMapping(value = "/getPersonList", method = RequestMethod.GET)
	public String listPersons(Model model) {
		List<Person> listPersons = personService.getPersonList();
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", listPersons);
		_log.info("List person method called");
		return "person";

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person person) {
		if (person.getId() == 0) {
			personService.addPerson(person);
		} else {
			personService.updatePerson(person);
		}
		return "redirect:/getPersonList";
	}

	@RequestMapping(value = "/getPerson/{id}", method = RequestMethod.GET)
	public Person getCountryById(@PathVariable int id) {
		return personService.getPersonById(id);
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String removePerson(@PathVariable("id") int id) {
		personService.removePerson(id);
		return "redirect:/getPersonList";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("person", this.personService.getPersonById(id));
		model.addAttribute("listPersons", this.personService.getPersonList());
		return "person";
	}

}
