package ifrn.pi.papum01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutoControllers {
	@RequestMapping("/cadastro/produto")
	public String CadastrarProduto() {
		return "CadastrarProdutos";
	}
	@PostMapping("/Produto")
	public String adicionar() {
		return "produto-adicionado";
	}
}
