package com.felipesilva.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipesilva.cursomc.domain.Categoria;
import com.felipesilva.cursomc.domain.Pedido;
import com.felipesilva.cursomc.repositories.PedidoRepository;
import com.felipesilva.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + " Tipo: " + Categoria.class.getName()));
	}

}
