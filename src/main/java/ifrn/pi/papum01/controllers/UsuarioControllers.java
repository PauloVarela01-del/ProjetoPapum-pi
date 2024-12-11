package ifrn.pi.papum01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.papum01.models.Produto;
import ifrn.pi.papum01.models.Usuario;
import ifrn.pi.papum01.repository.UsuarioRepository;

@Controller
public class UsuarioControllers {
     
	@Autowired
    private UsuarioRepository ur;
	
    @RequestMapping("/cadastro/usuario")
	public String form() {
		return "usuarios/formUsuario";
	}
    
    
    
    @PostMapping("/usuarios")
    public String cadastrar(Usuario usuario) {
    	System.out.println(usuario);
    	ur.save(usuario);
    	return"usuarios/usuario-adicionado";
    }
    @GetMapping("/usuarios/lista") // Responsavel por Salvar e exibir os produtos //post
	public ModelAndView listar() {
		List<Usuario> usuarios = ur.findAll();
		ModelAndView mv = new ModelAndView("lista");
		mv.addObject("Usuario", usuarios);
		return mv;
    }
    
}
