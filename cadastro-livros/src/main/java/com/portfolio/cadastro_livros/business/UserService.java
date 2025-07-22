package com.portfolio.cadastro_livros.business;

import com.portfolio.cadastro_livros.infrastructure.entitys.User;
import com.portfolio.cadastro_livros.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user){
        repository.saveAndFlush(user);
    }

    public User findUserById(Long id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado.")
        );
    }

    public void updateUser(Long id, User user){
        User userEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );
        User userUpdated = User.builder()
                .id(userEntity.getId())
                .name(user.getName() != null ? user.getName() : userEntity.getName())
                .email(user.getEmail() != null ? user.getEmail() : userEntity.getEmail())
                .phone(user.getPhone() != null ? user.getPhone() : userEntity.getPhone())
                .dateBirth(user.getDateBirth() != null ? user.getDateBirth() : userEntity.getDateBirth())
                .build();
        repository.saveAndFlush(userUpdated);
    }

    public void deleteUser(Long id){
        repository.deleteById(id);
    }
}
