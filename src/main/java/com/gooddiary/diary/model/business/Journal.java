package com.gooddiary.diary.model.business;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Journal extends BaseEntity implements Serializable {

    @Column(length = 100)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journal")
    Set<Diary> diaries = new HashSet<>();

    private boolean isPublic;

    public boolean isPublic() {
        return false;
    }
}
