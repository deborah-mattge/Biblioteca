package net.weg.biblioteca.controller;

import lombok.AllArgsConstructor;
import net.weg.biblioteca.model.dtos.get.ReadingGetDTO;
import net.weg.biblioteca.model.dtos.get.ReservationGetDTO;
import net.weg.biblioteca.model.dtos.get.UserGetDTO;
import net.weg.biblioteca.model.dtos.post.UserPostDTO;
import net.weg.biblioteca.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    ResponseEntity<UserGetDTO> postUser(@RequestBody UserPostDTO userPostDTO) {
        try {
            return ResponseEntity.ok(userService.create(userPostDTO));

        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("name/{userId}")
    ResponseEntity<UserGetDTO> patchName(@PathVariable Long userId, @RequestParam String name) {
        try {
            return ResponseEntity.ok(userService.patchName(userId, name));

        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PatchMapping("password/{userId}")
    ResponseEntity<UserGetDTO> patchPassword(@PathVariable Long userId, @RequestParam String password) {
        try {
            return ResponseEntity.ok(userService.patchPassword(userId, password));

        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PatchMapping("email/{userId}")
    ResponseEntity<UserGetDTO> patchEmail(@PathVariable Long userId, @RequestParam String email) {
        try {
            return ResponseEntity.ok(userService.patchEmail(userId, email));

        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("{userId}")
    ResponseEntity<UserGetDTO> getUser(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(userService.getOne(userId));

        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping()
    ResponseEntity<Collection<UserGetDTO>> getUser() {
        try {
            return ResponseEntity.ok(userService.getAll());

        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("{userId}/book/{copyId}/reservation")
    ResponseEntity<ReservationGetDTO> reservation(@PathVariable Long userId, @PathVariable Long copyId) {
        try {
            return ResponseEntity.ok(userService.reservation(userId, copyId));

        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("{userId}/book/{copyId}/reading")
    ResponseEntity<ReadingGetDTO> reading(@PathVariable Long userId, @PathVariable Long copyId) {
        try {
            return ResponseEntity.ok(userService.reading(userId, copyId));

        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
