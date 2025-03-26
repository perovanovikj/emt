package com.example.lab1b.config;

import com.example.lab1b.model.Accomodation;
import com.example.lab1b.model.Country;
import com.example.lab1b.model.Host;
import com.example.lab1b.model.enumerations.Category;
import com.example.lab1b.repository.AccomodationRepository;
import com.example.lab1b.repository.CountryRepository;
import com.example.lab1b.repository.HostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final AccomodationRepository accomodationRepository;
    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(AccomodationRepository accomodationRepository,
                           HostRepository hostRepository,
                           CountryRepository countryRepository) {
        this.accomodationRepository = accomodationRepository;
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init() {
        // Initialize countries
        Country usa = new Country("United States", "North America");
        Country uk = new Country("United Kingdom", "Europe");

        countryRepository.save(usa);
        countryRepository.save(uk);

        // Initialize hosts
        Host johnDoe = new Host("John", "Doe", usa);
        Host janeSmith = new Host("Jane", "Smith", uk);

        hostRepository.save(johnDoe);
        hostRepository.save(janeSmith);

        // Initialize accommodations
        accomodationRepository.save(new Accomodation("Sunny Beach House", Category.HOUSE, johnDoe, 5));
        accomodationRepository.save(new Accomodation("Cozy City Apartment", Category.APARTMENT, janeSmith, 3));
        accomodationRepository.save(new Accomodation("Mountain View Hotel", Category.HOTEL, johnDoe, 50));
    }
}
