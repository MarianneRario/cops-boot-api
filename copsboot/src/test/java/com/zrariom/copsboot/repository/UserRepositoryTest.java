package com.zrariom.copsboot.repository;

import com.zrariom.copsboot.orm.jpa.InMemoryUniqueIdGenerator;
import com.zrariom.copsboot.orm.jpa.UniqueIdGenerator;
import com.zrariom.copsboot.user.User;
import com.zrariom.copsboot.user.UserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashSet;
import java.util.UUID;


@RunWith(SpringRunner.class) // enable the testing support of Spring Boot
@DataJpaTest // instructs the testing support to start only the part of the application responsible for everything related to JPA
public class UserRepositoryTest {

    @TestConfiguration
    static class TestConfig {
        @Bean
        public UniqueIdGenerator<UUID> generator() {
            return new InMemoryUniqueIdGenerator();
        }
    }

    @Autowired
    private UserRepository repository;

    @Test
    public void testStoreUser(){
        // add user role
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);

        // create new user
        User user = repository.save(new User( // save the User entity in the database
                repository.nextId(),
                "marianne.rario@gmail.com",
                "my-secret-pwd",
                roles ));

        assertThat(user).isNotNull(); // object returned from the save method of the repository should return a non-null object
        assertThat(repository.count()).isEqualTo(1L); // If you count the number of User entities in the database, you should have one
    }










}
