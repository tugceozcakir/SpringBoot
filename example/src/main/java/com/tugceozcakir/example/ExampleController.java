package com.tugceozcakir.example;

import com.tugceozcakir.example.database.entity.PersonEntity;
import com.tugceozcakir.example.database.repository.PersonEntityRepository;
import com.tugceozcakir.example.model.Person;
import com.tugceozcakir.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/example")
public class ExampleController {

    //Oluşturduğu nesneyi bulur.
    @Autowired
    PersonService personService;

    @GetMapping("/hello-world")
    public ResponseEntity<String> helloWorldApi(){
        return new ResponseEntity("Hello World", HttpStatus.OK);
    }

    @GetMapping("/person")
    public ResponseEntity<Person> personApi(){

        Person person = new Person();
        person.setName("Tugce");
        person.setSurname("Ozcakir");
        person.setBirthYear(1999);
        person.setTc("5838539493");

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<Person> personGetByPersonIdApi(@PathVariable int personId){
        Person person = new Person();

        if(personId == 1){
            person.setName("Tugce");
            person.setSurname("Ozcakir");
            person.setBirthYear(1999);
            person.setTc("5838539493");
        } else {
            person.setName("Anil");
            person.setSurname("Caliskan");
            person.setBirthYear(1999);
            person.setTc("5838539493");
        }


        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("person-list")
    public ResponseEntity<List<Person>> getPersonList() {
        List<Person> list = new ArrayList<>();
        Person person = new Person();
        Person person1 = new Person();

        person.setName("Tugce");
        person.setSurname("Ozcakir");
        person.setBirthYear(1999);
        person.setTc("675576567886");

        person1.setName("Gizem");
        person1.setSurname("Kisa");
        person1.setBirthYear(1992);
        person1.setTc("23531467730");

        list.add(person);
        list.add(person1);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("person-by-request-param")
    public ResponseEntity<Person> personGetByPersonIdRequestParamApi(@RequestParam int personId, @RequestParam String tc) {

        System.out.println(tc);
        Person person = new Person();
        if (personId == 1) {
            person.setName("Ali");
            person.setSurname("Kaya");
            person.setBirthYear(1999);
            person.setTc("23531434930");
        } else {
            person.setName("Gizem");
            person.setSurname("Kisa");
            person.setBirthYear(1992);
            person.setTc("23531467730");
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<PersonEntity> postApi(@RequestBody Person person){
        PersonEntity person1 = personService.createPerson(person.getName(), person.getSurname(),
                person.getTc(), person.getBirthYear());
        //throw new Exception("eslşfkgşljkgg");
        return new ResponseEntity<>(person1, HttpStatus.OK);
    }

    @PostMapping("/all-person")
    public ResponseEntity<List<Person>> postApi(@RequestBody List<Person> personList){
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @PutMapping("/person/{tc}")
    public ResponseEntity<Person> createPerson(@RequestBody Person person, @PathVariable String tc){

        List<Person> personList = new ArrayList<>();

        Person personExist = new Person();

        UUID uuid = UUID.randomUUID();
        personExist.setTc("9999999");
        personExist.setName("Furkan");
        personExist.setSurname("Yalçındağ");
        personExist.setBirthYear(1992);
        personExist.setUuid(uuid);
        personList.add(personExist);

        for(Person p:personList){
            if(p.getTc().equals(tc)){
                p.setTc(person.getTc());
                p.setBirthYear(person.getBirthYear());
                p.setSurname(person.getSurname());

                return new ResponseEntity<>(p, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/person/{tc}")
    public ResponseEntity<Person> deletePerson(@PathVariable String tc){

        List<Person> personList = new ArrayList<>();

        Person personExist = new Person();

        UUID uuid = UUID.randomUUID();
        personExist.setTc("9999999");
        personExist.setName("Furkan");
        personExist.setSurname("Yalçındağ");
        personExist.setBirthYear(1992);
        personExist.setUuid(uuid);
        personList.add(personExist);

        for(Person p:personList){
            if(p.getTc().equals(tc)){
               personList.remove(p);
                return new ResponseEntity<>(p, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Autowired
    PersonEntityRepository personRepository;
    @GetMapping("/all-persons")
    public ResponseEntity<List<PersonEntity>> getAllPersons() {


        List<PersonEntity> allPersons = personRepository.findAll();
        return new ResponseEntity<>(allPersons, HttpStatus.OK);
    }

    @GetMapping("person-list-by-name-start-with/{key}")
    public ResponseEntity<List<PersonEntity>> getPersonListByNameStartWith(@PathVariable String key) {
        return new ResponseEntity<>(personService.getPersonNameStartWith(key), HttpStatus.OK);
    }

    @GetMapping("person-list-by-name-i-contains/{key}")
    public ResponseEntity<List<PersonEntity>> getPersonListByNameContains(@PathVariable String key) {
        return new ResponseEntity<>(personService.getPersonNameIContains(key), HttpStatus.OK);
    }

    @GetMapping("person-list-by-name-surname-start-with/name/{name}/surname/{surname}")
    public ResponseEntity<List<PersonEntity>> getPersonListByNameContains(@PathVariable String name, @PathVariable String surname) {
        return new ResponseEntity<>(personService.getPersonNameStartWithAndSurnameStartWith(name, surname), HttpStatus.OK);
    }
























}
