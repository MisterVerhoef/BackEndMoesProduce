package com.example.eindopdrachtbackendmoesproduce.service;

import com.example.eindopdrachtbackendmoesproduce.dtos.ProfileDto;
import com.example.eindopdrachtbackendmoesproduce.models.Profile;
import com.example.eindopdrachtbackendmoesproduce.repository.ProfileRepository;
import com.example.eindopdrachtbackendmoesproduce.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    private final UserRepository userRepository;

    private final ProfileRepository profileRepository;


    public ProfileService(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    public List<ProfileDto> getAllProfiles(){
        List<ProfileDto> ProfileDtoList = new ArrayList<>();
        List<Profile> Profilelist = profileRepository.findAll();
        for (Profile profile : Profilelist) {
            ProfileDtoList.add(fromProfile(profile));
        }

        return ProfileDtoList;
    }

    public ProfileDto getProfile(String username) {
        ProfileDto dto = new ProfileDto();
        Optional<Profile> profile = profileRepository.findById(username);
        if (profile.isPresent()){
            dto = fromProfile(profile.get());
        }else {
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }

    public boolean ProfileExists(String username) {
        return profileRepository.existsById(username);
    }

    public void deleteProfile(Long id, String username) {
        userRepository.deleteById(id);
        profileRepository.deleteById(username);
    }

    public static ProfileDto fromProfile(Profile profile){

        var dto = new ProfileDto();

        dto.setUsername(profile.getUsername());
        dto.setFirstName(profile.getFirstName());
        dto.setLastName(profile.getLastName());
        dto.setAge(profile.getAge());


        return dto;
    }


}


