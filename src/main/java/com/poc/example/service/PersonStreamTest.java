package com.poc.example.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonStreamTest {
	
	public static void main(String[] args) {
		Person p1 = new Person(1, 22, "Puja", "Female");
		Person p5 = new Person(1, 18, "Payal", "Female");
		Person p2 = new Person(2, 66, "Hamza", "Male");
		Person p3 = new Person(3, 10, "Sona", "Female");
		Person p4 = new Person(4, 13, "Ajay", "Male");
		
		List<Person> listPerson = new ArrayList<>();
		listPerson.add(p4);
		listPerson.add(p3);
		listPerson.add(p2);
		listPerson.add(p1);
		
		List<Person> female = listPerson.stream().filter(person-> person.getGender().equalsIgnoreCase("female")).collect(Collectors.toList());
		List<Person> sorted = listPerson.stream().sorted(Comparator.comparingInt(Person::getAge)).collect(Collectors.toList());
		//System.out.println(female);
		//System.out.println(sorted);

		List<Person> hikePerson = listPerson.stream().filter(person -> person.getAge() > 60).map(person -> {
			person.setId(person.getId()+10);
			return person;
		}).collect(Collectors.toList());

		System.out.println(hikePerson);

		List<Person> filteredPerson = listPerson.stream().filter(per1 -> per1.getAge() > 20).filter(per2 -> per2.getName().charAt(0) == 'P').collect(Collectors.toList());
		//System.out.println(filteredPerson);

		//sortedByAge=list.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
		
	}

}
