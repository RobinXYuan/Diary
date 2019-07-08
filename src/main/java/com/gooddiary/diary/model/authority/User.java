package com.gooddiary.diary.model.authority;

import com.gooddiary.diary.model.business.Diary;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Builder
@Table(indexes = {@Index(columnList = "email")})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String username;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "TINYINT")
    private UserGender gender;

    @Column(columnDefinition = "DATE")
    private Date birthDate;

    @Column(updatable = false)
    private Date joinTime;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "TINYINT")
    private UserStatus status;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Diary> diaries = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User() {}

    public User(String email) {
        this.email = email;
    }


    public boolean isAdministrator() {
        return this.role.hasPermission(Permission.ADMINISTRATOR);
    }

    public boolean isModifier() {
        return this.role.hasPermission(Permission.MODIFY) &&
                !this.role.hasPermission(Permission.ADMINISTRATOR);
    }

    public boolean isAnonymousUser() {
        return this.role.getPermission() == 0;
    }

}
