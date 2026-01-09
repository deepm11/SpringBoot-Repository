package com.example.SpringBoot_D21.Service;

import com.example.SpringBoot_D21.Repository.UserRepository;
import com.example.SpringBoot_D21.dto.UserDto;
import com.example.SpringBoot_D21.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;
    private Long idCounter = 1L;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User createUser(UserDto dto) {
        User user = new User(idCounter++, dto.getName(), dto.getEmail());
        repository.save(user);
        return user;
    }

    public User updateUser(Long id, UserDto dto) {
        User user = repository.findById(id);
        if (user == null) return null;

        User updated = new User(id, dto.getName(), dto.getEmail());
        repository.delete(user);
        repository.save(updated);
        return updated;
    }

    public boolean deleteUser(Long id) {
        User user = repository.findById(id);
        if (user == null) return false;

        repository.delete(user);
        return true;
    }
}