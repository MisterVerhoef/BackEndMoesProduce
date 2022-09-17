package com.example.eindopdrachtbackendmoesproduce.controllers;

import com.example.eindopdrachtbackendmoesproduce.models.Advert;
import com.example.eindopdrachtbackendmoesproduce.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




    @CrossOrigin
    @RestController
    @RequestMapping("/api")
    public class AdvertController {

        @Autowired
        AdvertRepository advertRepository;


        @GetMapping("/adverts")
        public ResponseEntity<List<Advert>> getAllAdverts(@RequestParam(required = false) String title) {
            try {
                List<Advert> adverts = new ArrayList<>();

                if (title == null)
                    advertRepository.findAll().forEach(adverts::add);
                else
                    advertRepository.findByTitleContaining(title).forEach(adverts::add);

                if (adverts.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                return new ResponseEntity<>(adverts, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @GetMapping("/adverts/{id}")
        public ResponseEntity<Advert> getAdvertById(@PathVariable("id") long id) {

            Optional<Advert> advertData = advertRepository.findById(id);

            if (advertData.isPresent()) {

                return new ResponseEntity<>(advertData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }

        @PostMapping("/adverts")
        public ResponseEntity<Advert> createAdvert(@RequestBody Advert advert) {

            try {
                Advert _advert = advertRepository.save(new Advert(advert.getTitle(), advert.getDescription(), false));
                return new ResponseEntity<>(_advert, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PutMapping("/adverts/{id}")
        public ResponseEntity<Advert> updateAdvert(@PathVariable("id") long id, @RequestBody Advert advert) {

            Optional<Advert> advertData = advertRepository.findById(id);

            if (advertData.isPresent()) {
                Advert _advert = advertData.get();
                _advert.setTitle(advert.getTitle());
                _advert.setDescription(advert.getDescription());
                _advert.setPublished(advert.isPublished());
                return new ResponseEntity<>(advertRepository.save(_advert), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        }

        @DeleteMapping("/adverts/{id}")
        public ResponseEntity<HttpStatus> deleteAdvert(@PathVariable("id")long id) {
            try {
                advertRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @DeleteMapping("/adverts")
        public ResponseEntity<HttpStatus> deleteAllTAdverts() {

            try {
                advertRepository.deleteAll();
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


        @GetMapping("/adverts/published")
        public ResponseEntity<List<Advert>> findByPublished() {

            try {
                List<Advert> adverts = advertRepository.findByPublished(true);

                if (adverts.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(adverts, HttpStatus.OK);
            } catch (Exception e) {

                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

            }

        }



    }


