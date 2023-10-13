package com.devexperts.ria.internship.chatify.service;

import com.devexperts.ria.internship.chatify.model.Message;
import com.devexperts.ria.internship.chatify.model.dto.MessageRequest;
import com.devexperts.ria.internship.chatify.model.dto.MessageResponse;
import com.devexperts.ria.internship.chatify.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message postMessage(MessageRequest messageRequest) {
        if(messageRequest.getUsername() == null || messageRequest.getUsername().isEmpty()){
            throw new IllegalArgumentException("Username cannot be empty.");
        } else if (messageRequest.getMessage() == null || messageRequest.getMessage().isEmpty()){
            throw new IllegalArgumentException("Message cannot be empty.");
        }
        Message newMessage = new Message(messageRequest.getUsername(), messageRequest.getMessage(), LocalDateTime.now());
        return messageRepository.save(newMessage);
    }

    public List<MessageResponse> getAllMessages () {
        List<Message> allMessages = messageRepository.findAll(Sort.by(Sort.Order.asc("date")));
        List<MessageResponse> responseList = new ArrayList<>();
        for(Message msg: allMessages){
            responseList.add(new MessageResponse(msg.getUsername(),msg.getMessage(),msg.getDate()));
        }
        return responseList;
    }
}

