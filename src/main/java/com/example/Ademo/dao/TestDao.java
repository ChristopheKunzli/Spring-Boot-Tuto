package com.example.Ademo.dao;

import com.example.Ademo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("testDao")
public class TestDao implements PersonDao{
    private static final List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        for (Person p : DB)
        {
            if(p.getId().equals(id))
            {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        for (Person p : DB)
        {
            if(p.getId().equals(id))
            {
                DB.remove(p);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        for (Person p : DB)
        {
            if(p.getId().equals(id))
            {
                DB.remove(p);
                DB.add(new Person(id, person.getName()));
                return 1;
            }
        }
        return 0;
    }
}
