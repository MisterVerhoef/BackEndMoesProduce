package com.example.eindopdrachtbackendmoesproduce.repository;

import com.example.eindopdrachtbackendmoesproduce.models.Profile;
import com.example.eindopdrachtbackendmoesproduce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {

    Optional<Profile> findByUsername(String username);

}
