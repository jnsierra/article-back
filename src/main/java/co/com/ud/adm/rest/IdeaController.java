package co.com.ud.adm.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.ud.adm.dto.IdeaDto;
import co.com.ud.repository.entity.IdeaEntity;
import co.com.ud.service.adm.impl.IdeaService;

@RestController
@RequestMapping("/v.1/ideas")
@CrossOrigin(origins = "*")
public class IdeaController {
	@Autowired
	IdeaService ideaService;
	@Autowired
	ModelMapper mapper;

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IdeaDto> save(@RequestBody(required = true) IdeaDto idea) {
		return new ResponseEntity<>(
				mapper.map(ideaService.guardarIdea(mapper.map(idea, IdeaEntity.class)), IdeaDto.class),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/by/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IdeaDto[]> getIdeasByParams(@RequestParam(name = "idUsuario") Long idUsuario) {
		return new ResponseEntity<>(mapper.map(ideaService.getIdeaByUsuario(idUsuario), IdeaDto[].class),
				HttpStatus.OK);
	}

}
