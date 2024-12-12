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
    	return"redirect:/usuario/lista"; // usuarios/usuario-adicionado
    }
    
    @GetMapping("/usuario/lista")
    public ModelAndView listar() {
    	List<Usuario> usuarios = ur.findAll();
    	ModelAndView mv = new ModelAndView("usuarios/lista");
    	mv.addObject("usuarios",usuarios);
    	return mv;
    	
    }
    
    
    
    @GetMapping("/{id}/remover/usuario")
    public String removerUsuario(@PathVariable Long id) {
    	ModelAndView md = new ModelAndView();
    	Optional<Usuario> opt = ur.findById(id);
    	if(!opt.isEmpty()) {
    		
    	}
    	Usuario usuario  = opt.get();
    	ur.delete(usuario);
    	
    	return"redirect:/usuario/lista";
    }
    
    @GetMapping("/{id}/selecionar/usuario")
    public ModelAndView selecionar(@PathVariable Long id) {
    	ModelAndView md = new ModelAndView();
    	Optional<Usuario> opt = ur.findById(id);
    	if(opt.isEmpty()) {
    		
         md.setViewName("redirect:/usuarios/lista");
         return md;
    	}
    	Usuario usuario = opt.get();
    	md.setViewName("/usuarios/lista");
    	md.addObject("usuarios", usuario);
    	return md;
    	
    }
    
    
    
}
