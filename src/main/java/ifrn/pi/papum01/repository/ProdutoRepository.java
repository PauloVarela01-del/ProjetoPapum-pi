package ifrn.pi.papum01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.papum01.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
		
	
}
