package com.shh.service;

import com.shh.repository.MessageRepository;
import java.util.Collection;


public class MessageServiceImpl implements MessageService {

    private final MessageRepository<Integer,String> messageRepository;

    public MessageServiceImpl(MessageRepository<Integer, String> messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Integer create(String data) {
       return messageRepository.create(data);
    }

    @Override
    public String get(Integer id) {
        return messageRepository.get(id).orElseThrow(
                ()-> new IllegalArgumentException("Message not found"));
    }

    @Override
    public Collection<String> getAll() {
        return messageRepository.getAll();
    }

    @Override
    public String update(Integer id, String data) {
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
