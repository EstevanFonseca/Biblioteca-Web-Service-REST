package wsrest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {
	@Autowired
	private LivroRepo livroRepo;
	
	@GetMapping("/api/livros")
	public List<Livro> getLivros(){
		List<Livro> livros = new ArrayList<>();
        livroRepo.findAll().forEach(livros::add);
        return livros;
	}
	
	@GetMapping("/api/livros/{id}")
    public Livro getLivro(@PathVariable long id) {
        Optional<Livro> retorno = livroRepo.findById(id);
        Livro livro = null;
        if(retorno.isPresent()) {
            livro = retorno.get();
        }
        return livro;
    }

    @PostMapping("/api/livros")
    public Livro createLivro(@RequestBody Livro livro) {
        livroRepo.save(livro);
        return livro;
    }

    @PutMapping("/api/livros/{id}")
    public Livro updateLivro(@RequestBody Livro l, @PathVariable long id) {
        Livro livro = null;
        livro = this.getLivro(id);
        if(livro != null) {
            livroRepo.save(l);
            livro = l;
        }
        return l;
    }

    @DeleteMapping(value = "/api/livros/{id}", produces = "application/json")
    public String deleteLivro(@PathVariable long id) {
        Livro livro = this.getLivro(id);
        boolean result = false;
        if(livro != null) {
            livroRepo.delete(livro);
            result = true;
        }
        return "{ \"sucess\" : " + (result ? "true" : "false" ) + " }";
    }
	
}
