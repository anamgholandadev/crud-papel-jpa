package br.ufrn.imd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.ufrn.imd.domain.Papel;
import br.ufrn.imd.repositories.PapelRepository;

@RestController
@RequestMapping("/papeis")
public class PapelService {

	@Autowired
	private PapelRepository repository;

	@RequestMapping()
	public List<Papel> getUsers() {
		return (List<Papel>) repository.findAll();
	}

	@GetMapping("/{id}")
	public Papel getPapelById(@PathVariable Long id) {
		return repository.findById(id).orElse(null);
	}

	@PostMapping()
	public Papel createPapel(@RequestBody Papel papel) {
		return repository.save(papel);
	}

	@PutMapping("/{id}")
	public Papel updatePapel(@PathVariable Long id, @RequestBody Papel papel) {
		if (repository.existsById(id)) {
			papel.setId(id);
			return repository.save(papel);
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public void deletePapel(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@DeleteMapping("/all")
	public void deleteAllPapeis() {
		repository.deleteAll();
	}

}
