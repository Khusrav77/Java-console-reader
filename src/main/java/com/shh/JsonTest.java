package com.shh;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shh.model.Person;

public class JsonTest {

    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person();
        person.setName("Ваня");
        person.setAge(18);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);

        String json2 = "{\"name\":\"Ваня\",\"age\":18}";
        Person person1 = objectMapper.readValue(json2, Person.class);
        System.out.println(person1);

    }

    static boolean isValidJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readValue(json, Person.class);
            return true;
        } catch (JsonProcessingException e) {
            return false;
        }
    }
}
