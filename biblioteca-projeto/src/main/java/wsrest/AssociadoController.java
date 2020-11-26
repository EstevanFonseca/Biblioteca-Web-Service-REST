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
public class AssociadoController {
	@Autowired
	private AssociadoRepo associadoRepo;
	
	@GetMapping("/api/associados")
	public List<Associado> getAssociados(){
		List<Associado> associados = new ArrayList<>();
        associadoRepo.findAll().forEach(associados::add);
        return associados;
	}
	
	@GetMapping("/api/associados/{id}")
    public Associado getAssociado(@PathVariable long id) {
        Optional<Associado> retorno = associadoRepo.findById(id);
        Associado associado = null;
        if(retorno.isPresent()) {
        	associado = retorno.get();
        }
        return associado;
    }

    @PostMapping("/api/associados")
    public Associado createAssociado(@RequestBody Associado associado) {
    	associadoRepo.save(associado);
        return associado;
    }

    @PutMapping("/api/associados/{id}")
    public Associado updateAssociado(@RequestBody Associado a, @PathVariable long id) {
    	Associado associado = null;
    	associado = this.getAssociado(id);
        if(associado != null) {
        	associadoRepo.save(a);
        	associado = a;
        }
        return a;
    }

    @DeleteMapping(value = "/api/associados/{id}", produces = "application/json")
    public String deleteAssociado(@PathVariable long id) {
    	Associado associado = this.getAssociado(id);
        boolean result = false;
        if(associado != null) {
        	associadoRepo.delete(associado);
            result = true;
        }
        return "{ \"sucess\" : " + (result ? "true" : "false" ) + " }";
    }
	
}
