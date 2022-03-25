package org.maslov.repository;

import org.maslov.model.Otp;
import org.maslov.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OTPrepository /*extends JpaRepository<Otp, Long>*/ {

   /* Optional<Otp> findByUser(User user);*/
}
