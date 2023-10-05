package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Autor;
import application.model.AutorRepository;


@Controller
@RequestMapping("/Autor")
public class AutorController {
    @Autowired
    private AutorRepository AutorRepo;


    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("Autors", AutorRepo.findAll());
        return "/Autor/list";
  
    
}

@RequestMapping("/insert")

public String insert(){
    return "/Autor/insert";
}


@RequestMapping
(value ="/insert", method = RequestMethod.POST)
public String insert(@RequestParam("nome") String nome){
    Autor Autor =new Autor();
    Autor.setNome(nome);

    AutorRepo.save(Autor);

    return "/Autor/list";
}

@RequestMapping("/update")

public String update(){
    return "/Autor/update";
}

@RequestMapping(value ="/update", method = RequestMethod.POST)
public String update(@RequestParam("id") int id, @RequestParam("nome") String nome ){
 Optional<Autor> Autor = AutorRepo.findById(id);   
    if(Autor.isPresent()){
         Autor.get().setNome(nome);
         AutorRepo.save(Autor.get());
    }
    return "/Autor/list";
}

@RequestMapping("/delete")
public String delete(Model model, @RequestParam("id") int id){
   Optional<Autor> Autor = AutorRepo.findById(id);
   
   if(Autor.isPresent()){
    model.addAttribute("Autor", Autor.get());
    return "/Autor/delete";
}
return "/Autor/list";
}

}
