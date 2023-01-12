package org.maslov.cleanarchitecture.usercreation;

interface UserFactory {
    User create(String name, String password);
}
