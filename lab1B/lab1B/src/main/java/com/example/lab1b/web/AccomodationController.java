package com.example.lab1b.web;

import com.example.lab1b.model.Accomodation;
import com.example.lab1b.dto.CreateAccomodationDto;
import com.example.lab1b.service.AccomodationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/swagger-ui.html
@RestController
@RequestMapping("/api/accomodations")
@Tag(name = "Accomodation API", description = "Endpoints for managing accommodations")
public class AccomodationController {

    private final AccomodationService accomodationService;

    public AccomodationController(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
    }

    @Operation(summary = "Get all accommodations", description = "Retrieves a list of all available accommodations.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of accommodations retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<Accomodation> findAll() {
        return this.accomodationService.findAll();
    }

    @Operation(summary = "Add a new accommodation", description = "Adds a new accommodation to the system.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Accommodation created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid data")
    })
    @PostMapping("/add")
    public ResponseEntity<Accomodation> save(@RequestBody CreateAccomodationDto accomodationDto) {
        return accomodationService.save(accomodationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update an accommodation", description = "Updates an existing accommodation with new details.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Accommodation updated successfully"),
            @ApiResponse(responseCode = "404", description = "Accommodation not found")
    })
    @PutMapping("/edit/{id}")
    public ResponseEntity<Accomodation> update(@PathVariable Long id, @RequestBody CreateAccomodationDto accomodation) {
        return accomodationService.update(id, accomodation)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete an accommodation", description = "Deletes an accommodation by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Accommodation deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Accommodation not found")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (accomodationService.findById(id).isPresent()) {
            accomodationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Rent an accommodation", description = "Rents an accommodation by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Accommodation rented successfully"),
            @ApiResponse(responseCode = "404", description = "Accommodation not found")
    })
    @PostMapping("/rent/{id}")
    public ResponseEntity<Accomodation> rent(@PathVariable Long id) {
        return accomodationService.rent(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
