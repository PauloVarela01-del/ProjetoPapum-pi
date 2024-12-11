package ifrn.pi.papum01.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.papum01.models.Produto;
import ifrn.pi.papum01.repository.ProdutoRepository;

@Controller
public class ProdutoControllers {

	@Autowired
	private ProdutoRepository pr;

	@RequestMapping("/cadastro/produto")
	public String salvarProduto(Produto produto) {
		return "produtos/CadastrarProdutos";
	}

	// @PostMapping("/Produto") //Produto
	// public String adicionar(Produto produto) {

	// pr.save(produto);

	/// return "produto-adicionado";
	// }

	@PostMapping("/Produto")
	public String adicionar(Produto produto) {
		System.out.println(produto);
		pr.save(produto);
		return "redirect:/Produto";

	}

	@GetMapping("/Produto") // Responsavel por Salvar e exibir os produtos //post
	public ModelAndView listar() {
		List<Produto> produtos = pr.findAll();
		ModelAndView mv = new ModelAndView("lista");
		mv.addObject("produtos", produtos);
		return mv;
	}

	@GetMapping("/{codigo}/selecionar")
	public ModelAndView selecionarProduto(@PathVariable Long codigo) {
		ModelAndView mv = new ModelAndView();// sempre quando enviamos para um form precisamos do model andview
		Optional<Produto> opt = pr.findById(codigo); // pega os dados do evento
		if (opt.isEmpty()) { // verifica se o <produto> estar dentro do opt se não estiver redireciona para a
								// LISTA
			mv.setViewName("redirect:/Produto");// seleciona a pagina do redirecionamento
			return mv;
		}

		Produto produto = opt.get(); // se existir extrai para uma variavel PRODUTO
		mv.setViewName("produtos/CadastrarProdutos");// é alterado, o nome da pagina
		mv.addObject("produto", produto);// dentro da pagina coloca o objeto produto
		return mv;
	}

	@GetMapping("/{codigo}/remover")
	public String removerProduto(@PathVariable Long codigo) {
		ModelAndView mv = new ModelAndView();
		Optional<Produto> opt = pr.findById(codigo);
		if (opt.isEmpty()) {
              
		}
		Produto produto = opt.get();
		pr.delete(produto);
		return "redirect:/Produto";
	}

}
