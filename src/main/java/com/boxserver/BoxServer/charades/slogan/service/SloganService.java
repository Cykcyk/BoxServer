package com.boxserver.BoxServer.charades.slogan.service;

import com.boxserver.BoxServer.charades.slogan.controller.SloganDto;
import com.boxserver.BoxServer.charades.slogan.dao.Slogan;
import com.boxserver.BoxServer.charades.slogan.dao.SloganFactory;
import com.boxserver.BoxServer.charades.slogan.dao.SloganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class SloganService {

    @Autowired
    private final SloganRepository sloganRepository;
    private final SloganFactory sloganFactory;

    private Random randomGenerator;

    public SloganService(SloganRepository sloganRepository,
                         SloganFactory sloganFactory) {

        this.sloganRepository = sloganRepository;
        this.sloganFactory = sloganFactory;

        this.randomGenerator = new Random();
    }

    public SloganDto getRandomSloganDto() {

        List<Long> sloganIds = sloganRepository.getAllIds();

        return getSloganDto((long) randomGenerator.nextInt(sloganIds.size()));
    }

    public SloganDto getSloganDto(Long sloganId) {

        Optional<Slogan> sloganOptional = sloganRepository.findById(sloganId);

        return sloganOptional.map(sloganFactory::transformToSloganDto)
                .orElse(null);
    }

    public Long saveOrUpdate(SloganDto sloganDto) {

        Slogan slogan = sloganFactory.transformFromSloganDto(sloganDto);

        sloganRepository.save(slogan);

        return slogan.getSloganId();
    }
}
