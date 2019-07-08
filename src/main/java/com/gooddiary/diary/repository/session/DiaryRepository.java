package com.gooddiary.diary.repository.session;

import com.gooddiary.diary.model.session.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DiaryRepository extends JpaRepository<Diary, Long> {

    List<Diary> findDiariesByAuthor(Long uid);

}
