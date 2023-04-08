package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Integer> {

    //Display all regions in Canada
    List<Region> findByCountry(String country);

    //Display all regions with country name 'United'
    List<Region> findByCountryContains(String country);

    //Display all regions with country name includes 'United' in order
    List<Region> findByCountryContainsOrderByRegionAsc(String country);

    //Display top two regions in United States
    List<Region> findTop2ByCountry(String country);


}
