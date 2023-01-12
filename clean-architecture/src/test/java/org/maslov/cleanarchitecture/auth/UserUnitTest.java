package org.maslov.cleanarchitecture.auth;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.maslov.cleanarchitecture.auth.entity.CommonUser;
import org.maslov.cleanarchitecture.auth.entity.User;

class UserUnitTest {

    @Test
    void given123Password_whenPasswordIsNotValid_thenIsFalse() {
        User user = new CommonUser("Baeldung", "123");

        assertThat(user.passwordIsValid()).isFalse();
    }
}
