package com.devexperts.ria.internship.chatify.repository;

import com.devexperts.ria.internship.chatify.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
