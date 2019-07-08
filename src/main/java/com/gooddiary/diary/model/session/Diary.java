package com.gooddiary.diary.model.session;

import com.gooddiary.diary.model.authority.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "diary_id")
    private Long id;

    @Column(length = 100)
    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String contentHtml;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createDate;

    @UpdateTimestamp
    private Date updateDate;

    private boolean isPublic;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "TINYINT")
    private DiaryStatus status;

    @ManyToOne
    private User author;

    public boolean isPublic() {
        return false;
    }

}
