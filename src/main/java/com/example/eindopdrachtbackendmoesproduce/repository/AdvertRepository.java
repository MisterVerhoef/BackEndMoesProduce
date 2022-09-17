package com.example.eindopdrachtbackendmoesproduce.repository;

import com.example.eindopdrachtbackendmoesproduce.models.Advert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, Long> {

    List<Advert> findByPublished(boolean published);
    List<Advert> findByTitleContaining(String title);


    //deleteById veranderd met long id
    void deleteById(long id);
}