package com.gooddiary.diary.model.authority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(length = 50)
    private String name;

    private int permission;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();

    public void setPermissions(Set<Permission> permissions) {
        int perm = 0;

        if (permissions.size() != 0) {
            for (Permission p : permissions) {
                perm += p.getValue();
            }
        }

        this.permission = perm;
    }

    public int getPermission() {
        return this.permission;
    }

    public boolean hasPermission(Permission permission) {
        int perm = permission.getValue();
        return (perm & this.permission) == perm;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
