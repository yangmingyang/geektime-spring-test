package com.mego.w03_case.service.impl;

import com.mego.w03_case.dao.HobbyWordDao;
import com.mego.w03_case.domain.Hobby_word;
import com.mego.w03_case.service.HobbyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Service
@Repository("hobbyWordService")
public class HobbyWordServiceImpl implements HobbyWordService {
    @Autowired
    private HobbyWordDao hobbyWordDao;

    public List<Hobby_word> findAllWord() {
        return hobbyWordDao.findAllWord();
    }

    public Hobby_word getHobbyWord() {
        Hobby_word hobbyWord = hobbyWordDao.getHobbyWord();
        return hobbyWord;
    }

}
