package com.example.lab1b.web;

import com.example.lab1b.model.Accomodation;
import com.example.lab1b.model.dto.AccomodationDto;
import com.example.lab1b.service.AccomodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accomodations")
public class AccomodationController {

    private final AccomodationService accomodationService;

    public AccomodationController(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
    }

    @GetMapping
    public List<Accomodation> findAll(){
        return this.accomodationService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Accomodation> save(@RequestBody AccomodationDto accomodationDto){
        return accomodationService.save(accomodationDto)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Accomodation> update(@PathVariable Long id, @RequestBody AccomodationDto accomodation){
        return accomodationService.update(id, accomodation)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(accomodationService.findById(id).isPresent()){
            accomodationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/rent/{id}")
    public ResponseEntity<Accomodation> rent(@PathVariable Long id){
        return accomodationService.rent(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
