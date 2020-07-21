package com.boxserver.BoxServer.charades.slogan.dao;

import com.boxserver.BoxServer.charades.slogan.controller.SloganDto;
import org.springframework.stereotype.Service;

@Service
public class SloganFactory {

    public SloganDto transformToSloganDto(Slogan slogan) {

        return new SloganDto(slogan.getSloganId(), slogan.getSlogan());
    }

    public Slogan transformFromSloganDto(SloganDto sloganDto) {

        return new Slogan(sloganDto.getId(), sloganDto.getSlogan());
    }
}
