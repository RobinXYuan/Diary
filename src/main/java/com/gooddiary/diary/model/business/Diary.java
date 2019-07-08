package com.gooddiary.diary.model.business;

import com.gooddiary.diary.model.authority.User;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Diary extends BaseEntity implements Serializable {

    @Column(length = 100)
    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String contentHtml;

    private boolean isPublic;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "TINYINT")
    private DiaryStatus status;

    @ManyToOne
    private User author;

    @ManyToOne
    private Journal journal;

    public boolean isPublic() {
        return false;
    }

}
