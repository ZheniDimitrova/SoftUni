package com.likebookapp.service.impl;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.enums.MoodNameEnum;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.service.MoodService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MoodServiceImpl implements MoodService {

    private final MoodRepository moodRepository;

    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void initMood() {

        if (moodRepository.count() > 0) {
            return;
        }
        Mood mood = new Mood();
        mood.setMoodName(MoodNameEnum.HAPPY);

        Mood mood1 = new Mood();
        mood1.setMoodName(MoodNameEnum.SAD);

        Mood mood2 = new Mood();
        mood2.setMoodName(MoodNameEnum.INSPIRED);

        moodRepository.save(mood);
        moodRepository.save(mood1);
        moodRepository.save(mood2);


//        Arrays.stream(MoodNameEnum.values())
//                .forEach(moodNameEnum -> {
//                    Mood mood = new Mood();
//                    mood.setMoodName(moodNameEnum);
//
//                    switch (moodNameEnum) {
//                        case SAD -> mood.setDescription("...");
//                        case HAPPY -> mood.setDescription("..");
//                        case INSPIRED -> mood.setDescription(".");
//                    }

//                    moodRepository.save(mood);
//
//                });


    }
}
