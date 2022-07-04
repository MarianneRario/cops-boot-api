package com.zrariom.copsboot.repository;

import com.zrariom.copsboot.user.User;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;


public interface UserRepository extends CrudRepository<User, UUID>, UserRepositoryCustom { // also extends UserRepositoryCustom
}
