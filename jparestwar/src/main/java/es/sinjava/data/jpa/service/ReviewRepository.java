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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.sinjava.data.jpa.domain.Hotel;
import es.sinjava.data.jpa.domain.Review;

@RepositoryRestResource(collectionResourceRel = "review", path = "review")
interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {

//	http://localhost:8080/review/search/findByHotelName?hotel=The Langham
	Page<Review> findByHotelName(@Param("hotel")String hotelName, Pageable pageable);

	Review findByHotelAndIndex(Hotel hotel, int index);

	// Without a projection
	// http://localhost:8080/review/1
	// With ReviewDetailsProjection "simple"
	// http://localhost:8080/review/1?projection=simple
	
	
}
