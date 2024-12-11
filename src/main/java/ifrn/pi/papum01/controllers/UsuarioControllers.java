package ifrn.pi.papum01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
