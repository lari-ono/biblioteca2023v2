package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Autor;
import application.model.Genero;
import application.model.AutorRepository;
import application.model.GeneroRepository;
import application.model.LivroRepository;

@Controller
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private livroRepository livroRepo;


    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("livros", livroRepo.findAll());
        return "/livro/list";
  
    
}

@RequestMapping("/insert")

public String insert(){
    return "/livro/insert";
}


@RequestMapping
(value ="/insert", method = RequestMethod.POST)
public String insert(@RequestParam("nome") String nome){
    livro livro =new livro();
    livro.setNome(nome);

    livroRepo.save(livro);

    return "/livro/list";
}

@RequestMapping("/update")

public String update(){
    return "/livro/update";
}

@RequestMapping(value ="/update", method = RequestMethod.POST)
public String update(@RequestParam("id") int id, @RequestParam("nome") String nome ){
 Optional<livro> livro = livroRepo.findById(id);   
    if(livro.isPresent()){
         livro.get().setNome(nome);
         livroRepo.save(livro.get());
    }
    return "/livro/list";
}

@RequestMapping("/delete")
public String delete(Model model, @RequestParam("id") int id){
   Optional<livro> livro = livroRepo.findById(id);
   
   if(livro.isPresent()){
    model.addAttribute("livro", livro.get());
    return "/livro/delete";
}
return "/livro/list";
}

}
