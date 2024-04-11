package net.weg.biblioteca.controller;

import lombok.AllArgsConstructor;
import net.weg.biblioteca.model.dtos.get.BookGetDTO;
import net.weg.biblioteca.model.dtos.get.CopyGetDTO;
import net.weg.biblioteca.model.dtos.post.BookPostDTO;
import net.weg.biblioteca.model.dtos.post.CopyPostDTO;
import net.weg.biblioteca.model.entity.User;
import net.weg.biblioteca.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/book/")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    ResponseEntity<BookGetDTO>  postBook(@RequestBody BookPostDTO bookPostDTO){
        try {
            return ResponseEntity.ok(bookService.create(bookPostDTO));

        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }





    @PostMapping("copy")
    CopyGetDTO postCopy(@RequestBody CopyPostDTO copyPostDTO){
    return bookService.createCopy(copyPostDTO);
    }





    @PatchMapping("title/{bookId}")
    ResponseEntity<BookGetDTO>patchTitle(@PathVariable Long bookId, @RequestParam String title){
        try {
            return ResponseEntity.ok(bookService.patchTitle(bookId, title));

        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PatchMapping("autor/{bookId}")
    ResponseEntity<BookGetDTO>patchAutor(@PathVariable Long bookId,@RequestParam String autor){
        try {
            return ResponseEntity.ok(bookService.patchAutor(bookId, autor));

        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PatchMapping("publish/{bookId}")
    ResponseEntity<BookGetDTO>patchPublishYear(@PathVariable Long bookId,@RequestParam Integer publishYear){
        try {
            return ResponseEntity.ok(bookService.patchPublishYear(bookId, publishYear));

        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("{bookId}")
    ResponseEntity<BookGetDTO>getBook(@PathVariable Long bookId){
        try {
            return ResponseEntity.ok(bookService.getOne(bookId));

        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping()
    ResponseEntity<Collection<BookGetDTO>>getBook(){
        try {
            return ResponseEntity.ok(bookService.getAll());

        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
