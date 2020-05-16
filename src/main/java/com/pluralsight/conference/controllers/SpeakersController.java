package com.pluralsight.conference.controllers;

import com.pluralsight.conference.models.Speaker;
import com.pluralsight.conference.repositories.SpeakerRepositories;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakerRepositories speakerRepositories;

    @GetMapping
    public List<Speaker> list() {
        return speakerRepositories.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return speakerRepositories.getOne(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker) {
        return speakerRepositories.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //Todo:Check the children records, it does not check
        speakerRepositories.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        //Todo:Add Validation for all attributes not present
        Speaker existingSpeaker = speakerRepositories.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepositories.saveAndFlush(speaker);
    }
}
