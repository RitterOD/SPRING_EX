package org.maslov.services;

import org.maslov.model.OTP;
import org.maslov.model.User;
import org.maslov.repository.OTPrepository;
import org.maslov.repository.UserRepository;
import org.maslov.util.OTPgenerator;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final OTPrepository otPrepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, OTPrepository otPrepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.otPrepository = otPrepository;
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void auth(User user) {
        Optional<User> o =
                userRepository.findByUsername(user.getUsername());

        if(o.isPresent()) {

            User u = o.get();
            if (passwordEncoder.matches(
                    user.getPassword(),
                    u.getPassword())) {
                renewOtp(u);
            } else {
                throw new BadCredentialsException("Bad credentials.");
            }
        } else {
            throw new BadCredentialsException("Bad credentials.");
        }
    }


    private void renewOtp(User user) {
        String code = OTPgenerator.generateCode();
        Optional<OTP> userOtp = otPrepository.findByUser(user);
        if (userOtp.isPresent()) {
            OTP otp = userOtp.get();
            otp.setCode(code);
            otPrepository.save(otp);
        } else {
            OTP otp = new OTP();
            otp.setCode(code);
            otp.setUser(user);
            otPrepository.save(otp);
        }
    }

    public boolean check(OTP otpToValidate) {
        Optional<OTP> userOtp =
                otPrepository.findByUser(otpToValidate.getUser());

        if (userOtp.isPresent()) {
            OTP otp = userOtp.get();
            if (otpToValidate.getCode().equals(otp.getCode())) {
                return true;
            }
        }
        return false;
    }
}
