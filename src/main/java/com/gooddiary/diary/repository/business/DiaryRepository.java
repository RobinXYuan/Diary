package com.gooddiary.diary.repository.business;

import com.gooddiary.diary.model.business.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DiaryRepository extends JpaRepository<Diary, Long> {

    List<Diary> findDiariesByAuthor(Long uid);

}
