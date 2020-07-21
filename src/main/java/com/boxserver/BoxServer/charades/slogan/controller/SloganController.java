package com.boxserver.BoxServer.charades.slogan.controller;

import com.boxserver.BoxServer.charades.slogan.service.SloganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping()
    @ResponseBody
    public SloganDto getRandomSloganDto() {

        return sloganService.getRandomSloganDto();
    }

    @PostMapping()
    @ResponseBody
    public Long saveOrUpdate(@RequestBody SloganDto sloganDto) {

        return sloganService.saveOrUpdate(sloganDto);
    }
}