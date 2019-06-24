package co.com.ud.adm.rest;

import java.util.Optional;

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

import co.com.ud.adm.dto.UsuarioDto;
import co.com.ud.repository.entity.UsuarioEntity;
import co.com.ud.service.adm.IUsuarioService;

@RestController
@RequestMapping("/v.1/usuarios")
@CrossOrigin( origins = "*" )
public class UserController {
	
	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	ModelMapper map;
	
	@RequestMapping(value = "/by/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioDto> getUserByUser(@RequestParam("correo")String correo){
		Optional<UsuarioEntity> usuario = usuarioService.getByCorreo(correo);
		if(!usuario.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(map.map(usuario.get(), UsuarioDto.class), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioDto> insert(@RequestBody(required = true) UsuarioDto usuarioDto){
		return new ResponseEntity<>(map.map(usuarioService.insertarUsuario(map.map(usuarioDto, UsuarioEntity.class)), UsuarioDto.class),HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioDto[]> getAll(){
		return new ResponseEntity<>(map.map(usuarioService.getAllUsers(), UsuarioDto[].class ),HttpStatus.OK);
	}

}
