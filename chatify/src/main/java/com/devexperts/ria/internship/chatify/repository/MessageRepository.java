package com.devexperts.ria.internship.chatify.repository;

import com.devexperts.ria.internship.chatify.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
