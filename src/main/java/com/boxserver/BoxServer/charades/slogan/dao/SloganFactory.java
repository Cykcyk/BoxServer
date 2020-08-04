package com.boxserver.BoxServer.charades.slogan.dao;

import com.boxserver.BoxServer.charades.slogan.controller.SloganDto;
import org.springframework.stereotype.Service;

@Service
public class SloganFactory {

    public SloganDto generateSloganDto(Slogan slogan) {

        return new SloganDto(slogan.getId(), slogan.getMainSlogan(), slogan.getSecondSlogan(),
                slogan.getCategory(), slogan.getDifficulty());
    }

    public Slogan generateSlogan(SloganDto sloganDto) {

        return new Slogan(sloganDto.getId(), sloganDto.getMainSlogan(), sloganDto.getSecondSlogan(),
                sloganDto.getCategory(), sloganDto.getDifficulty());
    }
}
