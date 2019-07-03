package co.com.ud.adm.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ud.adm.dto.ArticuloDto;
import co.com.ud.repository.entity.ArticuloEntity;
import co.com.ud.service.adm.IArticuloService;
import co.com.ud.service.adm.IIdeaService;

@RestController
@RequestMapping(value = "/v.1/articulos")
@CrossOrigin(origins = "*")
public class ArticuloController {
	
	@Autowired
	IArticuloService articuloService;
	@Autowired
	IIdeaService ideaService;
	@Autowired
	ModelMapper mapper;
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArticuloDto> saveArticulo(@RequestBody(required = true) ArticuloDto articulo){
		articulo = mapper.map(articuloService.guardarArticulo(mapper.map(articulo, ArticuloEntity.class)), ArticuloDto.class) ;
		if( articulo != null && articulo.getId() != null && articulo.getIdeaId() != null ) {
			ideaService.updateEstadoIdeaEnEspera(articulo.getIdeaId());
		}
		return new ResponseEntity<>(articulo, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/profesor/notificaciones/{idProfesor}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> getNumRevisionProfesor(@PathVariable("idProfesor") Long idProf){
		Integer contador = articuloService.getCountNotificationProf(idProf);
		return new ResponseEntity<Integer>( contador , HttpStatus.OK);
	}

}