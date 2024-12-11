package ifrn.pi.papum01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.papum01.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
