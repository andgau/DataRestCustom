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

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.sinjava.data.jpa.domain.Hotel;

@RepositoryRestResource(collectionResourceRel = "hotel", path = "hotel")
interface HotelRepository extends PagingAndSortingRepository<Hotel, Long> {

	// Some examples
	// http://localhost:8080/hotel/search/findByName?name=Hilton Diagonal Mar
	Hotel findByName(@Param("name") String name);

	// Some examples Hotel getCity getName (chained)
	// http://localhost:8080/hotel/search/findByCityName?city=Barcelona
	List<Hotel> findByCityName(@Param("city") String cityName);

}
