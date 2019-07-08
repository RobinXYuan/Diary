package com.gooddiary.diary.bootstrap;

import com.gooddiary.diary.model.authority.Permission;
import com.gooddiary.diary.model.authority.Role;
import com.gooddiary.diary.repository.authority.RoleRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class RoleBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private RoleRepository roleRepository;

    public RoleBootstrap(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        roleRepository.saveAll(getRoles());
    }

    private List<Role> getRoles() {

        List<Role> roles = new ArrayList<>(4);

        Set<Permission> userRolePermissions = new HashSet<Permission>(){{
            add(Permission.WRITE);
            add(Permission.READ);
            add(Permission.FOLLOW);
        }};

        Set<Permission> modifierPermission = new HashSet<Permission>() {{
            add(Permission.READ);
            add(Permission.WRITE);
            add(Permission.FOLLOW);
            add(Permission.MODIFY);
        }};

        Set<Permission> adminPermission = new HashSet<Permission>() {{
            add(Permission.READ);
            add(Permission.WRITE);
            add(Permission.FOLLOW);
            add(Permission.MODIFY);
            add(Permission.ADMINISTRATOR);
        }};

        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        userRole.setPermissions(userRolePermissions);
        roles.add(userRole);

        Role modifier = new Role();
        modifier.setName("ROLE_MODIFIER");
        modifier.setPermissions(modifierPermission);
        roles.add(modifier);

        Role admin = new Role();
        admin.setName("ROLE_ADMINISTRATOR");
        admin.setPermissions(adminPermission);
        roles.add(admin);

        Role anonymous = new Role();
        anonymous.setName("ROLE_ANONYMOUS");
        roles.add(anonymous);

        return roles;

    }
}
