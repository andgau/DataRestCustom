package es.sinjava.data.jpa.domain.projection;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.fasterxml.jackson.annotation.JsonFormat;

import es.sinjava.data.jpa.domain.Hotel;
import es.sinjava.data.jpa.domain.Rating;
import es.sinjava.data.jpa.domain.Review;

@Projection(name = "dateFormat", types = { Review.class })
public interface ReviewDetailsDateFormatedProjection {	
	 Hotel getHotel() ;
	 Rating getRating();
	 
	 
	 Date getCheckInDate();
}
