package es.sinjava.data.jpa.domain.projection;

import org.springframework.data.rest.core.config.Projection;

import es.sinjava.data.jpa.domain.Hotel;
import es.sinjava.data.jpa.domain.Rating;
import es.sinjava.data.jpa.domain.Review;

@Projection(name = "simple", types = { Review.class })
public interface ReviewDetailsProjection {	
	public Hotel getHotel() ;
	public Rating getRating();
}
