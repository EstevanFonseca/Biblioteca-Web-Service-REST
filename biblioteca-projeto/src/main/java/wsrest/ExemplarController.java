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
public class ExemplarController {
	@Autowired 
	private ExemplarRepo exemplarRepo;
	
	@Autowired
	private LivroRepo livroRepo;
	
	@GetMapping("/api/exemplares")
	public List<Exemplar> getExemplares(){
		List<Exemplar> exemplares = new ArrayList<>();
		exemplarRepo.findAll().forEach(exemplares::add);
        return exemplares;
	}
	
	@GetMapping("/api/exemplares/{id}")
    public Exemplar getExemplar(@PathVariable long id) {
        Optional<Exemplar> retorno = exemplarRepo.findById(id);
        Exemplar exemplar = null;
        if(retorno.isPresent()) {
        	exemplar = retorno.get();
        }
        return exemplar;
    }

    @PutMapping("/api/exemplares/{id}")
    public Exemplar updateExemplar(@RequestBody Exemplar e, @PathVariable long id) {
    	Exemplar exemplar = null;
    	exemplar = this.getExemplar(id);
        if(exemplar != null) {
        	exemplarRepo.save(e);
        	exemplar = e;
        }
        return e;
    }

    @DeleteMapping(value = "/api/exemplares/{id}", produces = "application/json")
    public String deleteExemplar(@PathVariable long id) {
    	Exemplar exemplar = this.getExemplar(id);
        boolean result = false;
        if(exemplar != null) {
        	exemplarRepo.delete(exemplar);
            result = true;
        }
        return "{ \"sucess\" : " + (result ? "true" : "false" ) + " }";
    }
    
    @GetMapping("/api/livros/{livroId}/exemplares")
    public List<Exemplar> getExemplarByExemplarId(@PathVariable long livroId) {
        Optional<Livro> optionalLivro = livroRepo.findById(livroId);
        if (!optionalLivro.isPresent()) {
            return null;
        }
        Livro l = optionalLivro.get();
        List<Exemplar> exemplares = new ArrayList<>();
        exemplarRepo.findByLivroId(l.getId_livro()).forEach(exemplares::add);
        return exemplares;
    }
   

    @PostMapping("/api/livros/{livroId}/exemplares")
    public Exemplar createExemplar(@PathVariable long livroId, @RequestBody Exemplar e) {
        Optional<Livro> optionalLivro = livroRepo.findById(livroId);
        if (!optionalLivro.isPresent()) {
            return null;
        }
        Livro l = optionalLivro.get();
        e.setLivro(l);
        exemplarRepo.save(e);
        return e;
    }

    @PutMapping("/api/livros/{livroId}/exemplares/{exemplarId}")
    public Exemplar updateExemplar(@RequestBody Exemplar exemplarRequest, @PathVariable long livroId, @PathVariable long exemplarId) {
        Exemplar exemplar = null;
        exemplar = this.getExemplar(exemplarId);
        if (exemplar == null) {
            return null;
        }

        Optional<Livro> optionalLivro = livroRepo.findById(livroId);
        if (!optionalLivro.isPresent()) {
            return null;
        }
        Livro l = optionalLivro.get();

        exemplar.setNumero(exemplarRequest.getNumero());
        exemplar.setFileira(exemplarRequest.getFileira());
        exemplar.setPrateleira(exemplarRequest.getPrateleira());
        exemplar.setStatus(exemplarRequest.getStatus());
        exemplar.setLivro(l);
        exemplarRepo.save(exemplar);
        return exemplar;
    }
    /*faculdade = livro
     * prof = exemplar
     * 
     * numero;
	private long fileira;
	private long prateleira;
	private String status;
     * */
	
}
