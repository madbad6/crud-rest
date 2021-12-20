package com.madbad.springcourse.dao;

import com.madbad.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person>list;

    {
        list = new ArrayList<>();
        list.add(new Person(++PEOPLE_COUNT, "Nick", 20,"madbad6@yandex.ru"));
        list.add(new Person(++PEOPLE_COUNT, "Andrey", 18,"dnishe@ebanoe.com"));
        list.add(new Person(++PEOPLE_COUNT, "Sergey",25, "down@gmail.com"));
        list.add(new Person(++PEOPLE_COUNT, "Boris", 45, "superstar@gmail.com"));
    }

    public List<Person> index(){
        return list;
    }

    public Person show (int id){
        return list.stream().filter(p -> p.getId()==id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        list.add(person);
    }

    public void update(Person person, int id){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id){
        list.removeIf(p ->p.getId()==id);
    }
}
