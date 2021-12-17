package com.madbad.springcourse.dao;

import com.madbad.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDao {
    private static int PEOPLE_COUNT;
    private List<Person>list;

    {
        list = new ArrayList<>();
        list.add(new Person(++PEOPLE_COUNT, "Nick"));
        list.add(new Person(++PEOPLE_COUNT, "Andrey"));
        list.add(new Person(++PEOPLE_COUNT, "Sergey"));
        list.add(new Person(++PEOPLE_COUNT, "Boris"));
    }

    public List<Person> index(){
        return list;
    }

    public Person show (int id){
        return list.stream().filter(p -> p.getId()==id).findAny().orElse(null);
    }
}
