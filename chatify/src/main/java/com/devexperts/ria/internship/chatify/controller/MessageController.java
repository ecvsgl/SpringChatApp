package com.devexperts.ria.internship.chatify.controller;

import com.devexperts.ria.internship.chatify.model.dto.MessageRequest;
import com.devexperts.ria.internship.chatify.model.dto.MessageResponse;
import com.devexperts.ria.internship.chatify.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/message")
    public void postMessage(@RequestBody MessageRequest messageRequest){}
    @GetMapping("/message")
    public List<MessageResponse> getAllMessages(){
        return messageService.getAllMessages();
    }
}
