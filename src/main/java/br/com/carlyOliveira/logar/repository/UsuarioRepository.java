package br.com.carlyOliveira.logar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.carlyOliveira.logar.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

}
