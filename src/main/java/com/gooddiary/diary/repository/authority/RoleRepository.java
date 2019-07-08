package com.gooddiary.diary.repository.authority;

import com.gooddiary.diary.model.authority.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);

}
