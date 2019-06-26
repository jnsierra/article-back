package co.com.ud.service.adm.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import co.com.ud.repository.entity.IdeaEntity;
import co.com.ud.repository.entity.UsuarioEntity;
import co.com.ud.repository.repo.IIdeaRepository;
import co.com.ud.service.adm.IIdeaService;
import co.com.ud.service.adm.IUsuarioService;
@Service
public class IdeaService implements IIdeaService {
	
	@Autowired
	IIdeaRepository ideaRepository;
	@Autowired
	IUsuarioService usuarioService;
	
	private static final Logger logger = LoggerFactory.getLogger(IdeaService.class);

	@Override
	public IdeaEntity guardarIdea(IdeaEntity idea) {
		String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
		logger.info("Usuario Loggeado: ".concat(usuario));
		//Buscamos el id del usuario logeado
		List<UsuarioEntity> usuariosId = usuarioService.getByCorreo(usuario);
		Assert.notEmpty(usuariosId, "Error al buscar el id del usuario logeado");
		logger.info("Este es el id del usuario loggeado: " + usuariosId.get(0).getId());
		idea.setUsuario(usuariosId.get(0));
		return ideaRepository.save(idea);
	}

	@Override
	public List<IdeaEntity> getIdeaByUsuario(Long idUsuario) {
		return ideaRepository.buscarIdeasPorUsuario(idUsuario);
	}

}
