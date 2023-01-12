package org.maslov.cleanarchitecture.auth.entity;

public interface User {
    boolean passwordIsValid();

    String getName();

    String getPassword();
}
