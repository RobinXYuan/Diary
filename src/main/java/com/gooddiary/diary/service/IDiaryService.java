package com.gooddiary.diary.service;

import com.gooddiary.diary.model.session.Diary;

import java.util.List;

public interface IDiaryService {

    List<Diary> getAllDiaries(String uid);

}
