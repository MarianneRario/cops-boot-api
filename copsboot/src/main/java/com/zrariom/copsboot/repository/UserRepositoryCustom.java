package com.zrariom.copsboot.repository;

import com.zrariom.copsboot.user.UserId;

public interface UserRepositoryCustom {
    // nextId method will return a new UserId instance each time it is called
    UserId nextId();
}
