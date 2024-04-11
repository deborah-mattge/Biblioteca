package net.weg.biblioteca.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.AllArgsConstructor;
import net.weg.biblioteca.model.dtos.get.UserGetDTO;
import net.weg.biblioteca.model.dtos.post.UserPostDTO;
import net.weg.biblioteca.model.entity.User;
import net.weg.biblioteca.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public UserGetDTO create(UserPostDTO userPostDTO){
        User user = new User();
        BeanUtils.copyProperties(userPostDTO, user);
        userRepository.save(user);
        return transformGetDTO(user);
    }
    public UserGetDTO patchEmail(Long id, String email){
        User user = userRepository.findById(id).get();
        user.setEmail(email);
        userRepository.save(user);
        return transformGetDTO(user);
    }
    public UserGetDTO patchPassword(Long id, String password){
        User user = userRepository.findById(id).get();
        user.setPassword(password);
        userRepository.save(user);
        return transformGetDTO(user);
    }
    public UserGetDTO patchName(Long id, String name){
        User user = userRepository.findById(id).get();
        user.setName(name);
        userRepository.save(user);
        return transformGetDTO(user);
    }
    public  UserGetDTO getOne(Long id){
        User user = userRepository.findById(id).get();
        return transformGetDTO(user);
    }
    public Collection<UserGetDTO> getAll(){
        List<User> users = userRepository.findAll();
        Collection<UserGetDTO>userGetDTOS = new ArrayList<>();
        for(User u : users){
            userGetDTOS.add(transformGetDTO(u));
        }
        return userGetDTOS;
    }
    private UserGetDTO transformGetDTO(User user){
        UserGetDTO userGetDTO = new UserGetDTO();
        BeanUtils.copyProperties(user, userGetDTO);
        return  userGetDTO;
    }
}
