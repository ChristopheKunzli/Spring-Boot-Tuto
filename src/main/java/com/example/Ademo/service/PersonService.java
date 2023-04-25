package com.example.Ademo.service;

import com.example.Ademo.dao.PersonDao;
import com.example.Ademo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("testDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        personDao.insertPerson(person);
        return 1;
    }

    public List<Person> getAllpeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getpersonById (UUID id)
    {
        return personDao.selectPersonById(id);
    }

    public int deletePerson (UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson (UUID id, Person newPerson){
        return personDao.updatePersonById(id, newPerson);
    }
}
