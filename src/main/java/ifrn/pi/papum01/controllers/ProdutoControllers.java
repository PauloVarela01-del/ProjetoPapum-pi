package ifrn.pi.papum01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ifrn.pi.papum01.models.Produto;
import ifrn.pi.papum01.repository.ProdutoRepository;

@Controller
public class ProdutoControllers {
	
	@Autowired 
	private ProdutoRepository pr;
	
	
	@RequestMapping("/cadastro/produto")
	public String CadastrarProduto() {
		return "produtos/CadastrarProdutos";
	}

	@PostMapping("/produto")
	public String adicionar(Produto produto) {
		
		System.out.println(produto);
		
		pr.save(produto);
		
		return "produtos/produto-adicionado";
		
		
	}
	

   
}
