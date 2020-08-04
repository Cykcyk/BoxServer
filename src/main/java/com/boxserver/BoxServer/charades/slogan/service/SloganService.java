package com.boxserver.BoxServer.charades.slogan.service;

import com.boxserver.BoxServer.charades.slogan.controller.SloganDto;
import com.boxserver.BoxServer.charades.slogan.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class SloganService {

    private final SloganRepository sloganRepository;
    private final SloganFactory sloganFactory;

    private final Random randomGenerator;

    @Autowired
    public SloganService(SloganRepository sloganRepository,
                         SloganFactory sloganFactory) {

        this.sloganRepository = sloganRepository;
        this.sloganFactory = sloganFactory;

        this.randomGenerator = new Random();
    }

    public SloganDto getRandomSingleSloganDto(List<SloganCategory> categories, List<SloganDifficulty> difficulties) {

        List<Long> sloganIds = sloganRepository.findIdsByCategoriesAndDifficulties(categories, difficulties);

        return getRandomSlogan(sloganIds);
    }

    public SloganDto getRandomDoubleSloganDto(List<SloganCategory> categories, List<SloganDifficulty> difficulties) {

        List<Long> sloganIds = sloganRepository.findDoubleSloganIdsByCategoriesAndDifficulties(categories, difficulties);

        return getRandomSlogan(sloganIds);
    }

    public Long saveOrUpdate(SloganDto sloganDto) {

        Slogan slogan = sloganFactory.generateSlogan(sloganDto);

        sloganRepository.saveOrUpdate(slogan);

        return slogan.getId();
    }

    public SloganDto getSloganDto(Long sloganId) {

        Optional<Slogan> sloganOptional = sloganRepository.findById(sloganId);

        return sloganOptional.map(sloganFactory::generateSloganDto)
                .orElse(new SloganDto());
    }

    private SloganDto getRandomSlogan(List<Long> sloganIds) {

        if (sloganIds.size() > 0) {

            return getSloganDto((long) randomGenerator.nextInt(sloganIds.size()));
        }

        return new SloganDto();
    }
}