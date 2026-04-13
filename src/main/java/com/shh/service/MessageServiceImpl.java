package com.shh.service;

import com.shh.model.Person;
import com.shh.repository.MessageRepository;
import java.util.Collection;


public class MessageServiceImpl implements MessageService {

    private final MessageRepository<Integer,Person> messageRepository;

    public MessageServiceImpl(MessageRepository<Integer, Person> messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Integer create(Person data) {
       return messageRepository.create(data);
    }

    @Override
    public Person get(Integer id) {
        return messageRepository.get(id).orElseThrow(
                ()-> new IllegalArgumentException("Message not found"));
    }

    @Override
    public Collection<Person> getAll() {
        return messageRepository.getAll();
    }

    @Override
    public String update(Integer id, Person data) {
        messageRepository.get(id).orElseThrow(
                ()-> new IllegalArgumentException("Message not found"));
        messageRepository.update(id, data);
        return "Message with id " + id + " was updated";
    }

    @Override
    public String delete(Integer id) {
        boolean deleted = messageRepository.delete(id);
        if (!deleted) {
                new IllegalArgumentException("Message not found");
        }
       return "Message with id " + id + " was deleted";
    }
}
