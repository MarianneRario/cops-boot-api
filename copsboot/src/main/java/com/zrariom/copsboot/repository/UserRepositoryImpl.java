package com.zrariom.copsboot.repository;

import com.zrariom.copsboot.orm.jpa.UniqueIdGenerator;
import com.zrariom.copsboot.user.UserId;

import java.util.UUID;

public class UserRepositoryImpl implements UserRepositoryCustom {
    private final UniqueIdGenerator<UUID> generator;

    public UserRepositoryImpl(UniqueIdGenerator<UUID> generator) {
        this.generator = generator;
    }

    @Override
    public UserId nextId() {
        return new UserId(generator.getNextUniqueId());
    }
}
