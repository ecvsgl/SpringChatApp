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
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message postMessage(MessageRequest messageRequest) {
        if(isNullOrEmpty(messageRequest.getUsername()) || isNullOrEmpty(messageRequest.getMessage())){
            throw new IllegalArgumentException("Username or Message cannot be empty.");
        }
        return messageRepository.save(
                new Message(messageRequest.getUsername(), messageRequest.getMessage(), LocalDateTime.now())
        );
    }

    public List<MessageResponse> getAllMessages () {
        List<Message> allMessages = messageRepository.findAll(Sort.by(Sort.Order.asc("date")));
        return allMessages.stream()
                .map(x -> new MessageResponse(x.getUsername(),x.getMessage(),x.getDate()))
                .collect(Collectors.toList());
    }
    private boolean isNullOrEmpty(String str){
        return (str == null || str.isEmpty());
    }
}

