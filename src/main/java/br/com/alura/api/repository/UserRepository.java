package br.com.alura.api.repository;

import br.com.alura.api.dto.UserDTO;
import br.com.alura.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByUsername(String username);

    List<UserDTO> findByUsernameContains(String username);
}
