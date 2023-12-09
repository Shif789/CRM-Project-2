package in.ineuron.dao.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.security.UserDetails;

public interface IUserDetailsRepo extends JpaRepository<UserDetails, Integer> {

	public Optional<UserDetails> findByUname(String uname); 
}
