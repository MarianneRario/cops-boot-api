package com.zrariom.copsboot.orm.jpa;

public interface UniqueIdGenerator<T> {
    T getNextUniqueId();
}
