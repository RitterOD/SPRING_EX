package org.maslov.repository;

import org.maslov.model.OTP;
import org.maslov.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OTPrepository extends JpaRepository<OTP, Long> {

    Optional<OTP> findByUser(User user);
}
