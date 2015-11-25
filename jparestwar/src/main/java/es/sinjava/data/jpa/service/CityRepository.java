/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package es.sinjava.data.jpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.sinjava.data.jpa.domain.City;

// docs
// http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html


@RepositoryRestResource(collectionResourceRel = "city", path = "city")
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
		
	Page<City> findAll(Pageable pageable);

	City findByName(@Param("name") String name);
	
	// Some examples
	// http://localhost:8080/city/search/findByCountry?country=Spain
	// http://localhost:8080/city/search/findByCountry?country=Australia
	List<City> findByCountry(@Param("country") String country);
	
	// Some examples of custom finders
	// http://localhost:8080/city/search/findByCountryAllIgnoringCase?country=Australia&page=1&size=2&sort=name,desc
	// http://localhost:8080/city/search/findByCountryAllIgnoringCase?country=Australia&page=0&size=2&sort=name
	Page<City> findByCountryAllIgnoringCase(@Param("country") String country,
			Pageable pagable);

}
