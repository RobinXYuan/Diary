package com.gooddiary.diary.service;

import com.gooddiary.diary.model.session.Diary;
import com.gooddiary.diary.repository.session.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class DiaryService implements IDiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    @Override
    public List<Diary> getAllDiaries(String uid) {
        return diaryRepository.findDiariesByAuthor(Long.valueOf(uid));
    }

}
