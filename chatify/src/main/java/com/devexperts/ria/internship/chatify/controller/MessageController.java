package com.devexperts.ria.internship.chatify.controller;

import com.devexperts.ria.internship.chatify.model.dto.MessageRequest;
import com.devexperts.ria.internship.chatify.model.dto.MessageResponse;
import com.devexperts.ria.internship.chatify.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@CrossOrigin("*")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping()
    public void postMessage(@RequestBody MessageRequest messageRequest){}
    @GetMapping()
    public List<MessageResponse> getAllMessages(){
        return messageService.getAllMessages();
    }
}
