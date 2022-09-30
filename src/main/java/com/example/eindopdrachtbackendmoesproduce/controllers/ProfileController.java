package com.example.eindopdrachtbackendmoesproduce.controllers;

import com.example.eindopdrachtbackendmoesproduce.dtos.ProfileDto;
import com.example.eindopdrachtbackendmoesproduce.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/auth/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/all")
    public ResponseEntity<List<ProfileDto>> getAllProfiles() {

        List<ProfileDto> profileDtos = profileService.getAllProfiles();

        return ResponseEntity.ok().body(profileDtos);

    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<ProfileDto> getProfile(@PathVariable("username") String username) {

        ProfileDto optionalProfile = profileService.getProfile(username);

        return ResponseEntity.ok().body(optionalProfile);

    }

//    public ResponseEntity<Object> deleteProfile(@PathVariable("username") String username) {
//        profileService.deleteProfile(username);
//
//        return ResponseEntity.noContent().build();
//    }

}
