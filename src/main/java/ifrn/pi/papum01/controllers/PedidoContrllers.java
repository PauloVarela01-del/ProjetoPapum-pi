package ifrn.pi.papum01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.papum01.models.Pedido;
import ifrn.pi.papum01.repository.PedidoRepository;
import ifrn.pi.papum01.repository.UsuarioRepository;

@Controller
public class PedidoContrllers {
 
	@Autowired
	private PedidoRepository pd;
	@Autowired
	private UsuarioRepository ur;
	
	@RequestMapping("/cadastro/pedido")
	public String form() {
		return "pedidos/formPedido";
	}
	
	@PostMapping("/pedidos")
	public String salvar(Pedido pedido) {
		System.out.println(pedido);
		pd.save(pedido);
		return "redirect:/pedido/lista";
	}
	
	@GetMapping("/pedido/lista")
	public ModelAndView listar() {
	 List<Pedido> pedidos = pd.findAll();
	 ModelAndView mv = new ModelAndView("pedidos/lista");
	 mv.addObject("pedidos",pedidos);
	 return mv;
	}
}
