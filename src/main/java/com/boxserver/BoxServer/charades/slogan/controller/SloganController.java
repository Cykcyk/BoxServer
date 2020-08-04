package com.boxserver.BoxServer.charades.slogan.controller;

import com.boxserver.BoxServer.charades.slogan.dao.SloganCategory;
import com.boxserver.BoxServer.charades.slogan.dao.SloganDifficulty;
import com.boxserver.BoxServer.charades.slogan.service.SloganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slogan")
public class SloganController {

    @Autowired
    private final SloganService sloganService;

    public SloganController(SloganService sloganService) {
        this.sloganService = sloganService;
    }

    @GetMapping(params = "id")
    @ResponseBody
    public SloganDto getSloganDto(@RequestParam Long id) {

        return sloganService.getSloganDto(id);
    }

    @GetMapping("/random-single")
    @ResponseBody
    public SloganDto getRandomSloganDto(@RequestParam(required = false) List<SloganCategory> categories,
                                        @RequestParam(required = false) List<SloganDifficulty> difficulties) {

        return sloganService.getRandomSingleSloganDto(categories, difficulties);
    }

    @GetMapping("/random-double")
    @ResponseBody
    public SloganDto getRandomDoubleSloganDto(@RequestParam(required = false) List<SloganCategory> categories,
                                              @RequestParam(required = false) List<SloganDifficulty> difficulties) {

        return sloganService.getRandomDoubleSloganDto(categories, difficulties);
    }

    @PostMapping()
    @ResponseBody
    public Long saveOrUpdate(@RequestBody SloganDto singleSloganDto) {

        return sloganService.saveOrUpdate(singleSloganDto);
    }
}