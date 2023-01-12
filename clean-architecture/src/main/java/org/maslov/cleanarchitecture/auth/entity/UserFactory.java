package org.maslov.cleanarchitecture.auth.entity;

public interface UserFactory {
    User create(String name, String password);
}
