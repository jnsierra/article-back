package co.com.ud.service.adm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ud.repository.entity.ArticuloEntity;
import co.com.ud.repository.repo.IArticuloRepository;
import co.com.ud.service.adm.IArticuloService;

@Service
public class ArticuloService implements IArticuloService {
	
	@Autowired
	IArticuloRepository articuloRepository;

	@Override
	public ArticuloEntity guardarArticulo(ArticuloEntity articulo) {
		return articuloRepository.save(articulo);
	}

	@Override
	public Integer getCountNotificationProf(Long idProf) {
		return articuloRepository.getCountNotificationProf(idProf);
	}

}
