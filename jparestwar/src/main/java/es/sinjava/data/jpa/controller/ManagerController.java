package es.sinjava.data.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.sinjava.data.jpa.service.CityRepository;
import es.sinjava.data.jpa.domain.City;
import es.sinjava.data.jpa.domain.Counter;

@RestController
@RequestMapping("/customcity")
public class ManagerController implements
		ResourceProcessor<RepositoryLinksResource> {

	@Autowired
	private CityRepository cityRepository;

	@RequestMapping(value = "/countall", produces = "application/json")
	Counter count() {
		Counter counter= new Counter();
		counter.setName(City.class.getName());
		counter.setValue(cityRepository.count());
		return counter;
	}

	@RequestMapping(value = "/{id}", produces = "application/json")
	City build(@PathVariable("id") String id) {
		City city = cityRepository.findByName(id);
		System.out.println("Entrada");
		return city;
	}

	@Override
	public RepositoryLinksResource process(RepositoryLinksResource resource) {
		resource.add(ControllerLinkBuilder.linkTo(ManagerController.class)
				.withRel("customcity"));
		// org.springframework.data.jpa.repository.support.SimpleJpaRepository
		// sjpa;
		return resource;
	}
}
