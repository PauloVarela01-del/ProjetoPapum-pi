package ifrn.pi.papum01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ifrn.pi.papum01.models.Produto;
import ifrn.pi.papum01.repository.ProdutoRepository;

@Controller
public class ProdutoControllers {
	
	
	
	@Autowired // auto vincular para criar objeto
	private ProdutoRepository pr;
	
	
	@RequestMapping("/cadastro/produto")
	public String CadastrarProduto() {
		return "CadastrarProdutos";
	}
	@PostMapping("/Produto")
	public String adicionar(Produto produto) {
		
		System.out.println(produto);
		pr.save(produto);
		
		return "produto-adicionado";
	}
}
