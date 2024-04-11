package net.weg.biblioteca.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import net.weg.biblioteca.model.Status;
import net.weg.biblioteca.model.dtos.get.BookGetDTO;
import net.weg.biblioteca.model.dtos.get.CopyGetDTO;
import net.weg.biblioteca.model.dtos.get.ReservationGetDTO;
import net.weg.biblioteca.model.dtos.post.BookPostDTO;
import net.weg.biblioteca.model.dtos.post.CopyPostDTO;
import net.weg.biblioteca.model.entity.*;
import net.weg.biblioteca.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public BookGetDTO create(BookPostDTO bookPostDTO){
        Book book = new Book();
        BeanUtils.copyProperties(bookPostDTO, book);
        bookRepository.save(book);
        return transformGetDTO(book);
    }
    public CopyGetDTO createCopy(CopyPostDTO copyPostDTO){
        Book book = bookRepository.findById(copyPostDTO.getBookId()).get();
        Copy copy = new Copy();
        copy.setBook(book);
        copy.setStatus(Status.AVAILABLE);
        book.getCopies().add(copy);
        bookRepository.save(book);
        CopyGetDTO copyGetDTO = new CopyGetDTO();
        BeanUtils.copyProperties(copy, copyGetDTO);
        copyGetDTO.setBookId(book.getId());
        return copyGetDTO;
    }
    public BookGetDTO patchAutor(Long id, String autor){
        Book book = bookRepository.findById(id).get();
        book.setAutor(autor);
        bookRepository.save(book);
        return transformGetDTO(book);
    }
    public BookGetDTO patchTitle(Long id, String title){
        Book book = bookRepository.findById(id).get();
        book.setTitle(title);
        bookRepository.save(book);
        return transformGetDTO(book);
    }
    public BookGetDTO patchPublishYear(Long id, Integer publishYear){
        Book book = bookRepository.findById(id).get();
        book.setPublishYear(publishYear);
        bookRepository.save(book);
        return transformGetDTO(book);
    }
    public  BookGetDTO getOne(Long id){
        Book book = bookRepository.findById(id).get();
        return transformGetDTO(book);
    }
    public Collection<BookGetDTO> getAll(){
        List<Book> books = bookRepository.findAll();
        Collection<BookGetDTO>bookGetDTOS = new ArrayList<>();
        for(Book u : books){
            bookGetDTOS.add(transformGetDTO(u));
        }
        return bookGetDTOS;
    }

    private BookGetDTO transformGetDTO(Book book){
        BookGetDTO bookGetDTO = new BookGetDTO();
        BeanUtils.copyProperties(book, bookGetDTO);
        return  bookGetDTO;
    }
}