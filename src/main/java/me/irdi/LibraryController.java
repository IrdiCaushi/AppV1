package me.irdi;

import me.irdi.models.Library;
import me.irdi.repositories.LibraryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {


    private final LibraryRepository repository;
    @Autowired
    public LibraryController(LibraryRepository repository){
        this.repository = repository;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Library> getAllBooks() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Library getBookById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyBookById(@PathVariable("id") ObjectId id, @Valid @RequestBody Library library) {
        library.set_id(id);
        repository.save(library);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Library createBook(@Valid @RequestBody Library library) {
        library.set_id(ObjectId.get());
        repository.save(library);
        return library;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}
