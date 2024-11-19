package ifrn.pi.papum01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutoControllers {
	@RequestMapping("/cadastrarProduto")
	public String form() {
		return"produto/formProduto";
	}
	
}
