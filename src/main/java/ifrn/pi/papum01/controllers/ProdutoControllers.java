package ifrn.pi.papum01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ifrn.pi.papum01.models.Produto;
import ifrn.pi.papum01.repository.ProdutoRepository;

@Controller
public class ProdutoControllers {
<<<<<<< HEAD

	@Autowired
=======
	
	@Autowired 
>>>>>>> refs/remotes/origin/main
	private ProdutoRepository pr;

	@RequestMapping("/cadastro/produto")
	public String CadastrarProduto() {
		return "produtos/CadastrarProdutos";
	}

<<<<<<< HEAD
	// @PostMapping("/Produto") //Produto
	// public String adicionar(Produto produto) {

	 
	// pr.save(produto);

	/// return "produto-adicionado";
	// }

	@PostMapping("/Produto") // Responsavel por Salvar e exibir os produtos
	public ModelAndView listar(Produto produto) {
	    System.out.println(produto);
		pr.save(produto);
		List<Produto> produtos = pr.findAll();
		ModelAndView mv = new ModelAndView("lista");
		mv.addObject("produtos", produtos);
		return mv;

		// produtos/lista

=======
	@PostMapping("/produto")
	public String adicionar(Produto produto) {
		
		System.out.println(produto);
		
		pr.save(produto);
		
		return "produtos/produto-adicionado";
		
		
>>>>>>> refs/remotes/origin/main
	}
	
	

}
