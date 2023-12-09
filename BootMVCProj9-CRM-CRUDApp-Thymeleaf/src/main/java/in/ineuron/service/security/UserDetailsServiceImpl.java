package in.ineuron.service.security;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.ineuron.dao.security.IUserDetailsRepo;

@Service
public class UserDetailsServiceImpl implements IUserDetailsService {

	@Autowired
	private IUserDetailsRepo repo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("UserDetailsServiceImpl.loadUserByUsername()");

		 Optional<in.ineuron.model.security.UserDetails> optional = repo.findByUname(username);
		if (!optional.isPresent()) {
			throw new IllegalArgumentException("User not found");
		} else {
			in.ineuron.model.security.UserDetails userDetails1 = optional.get();
			User user = new User(userDetails1.getUname(), userDetails1.getPwd(), userDetails1.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
			
			return user;
		}
	}

	@Override
	public String register(in.ineuron.model.security.UserDetails userDetails) {
		System.out.println("UserDetailsServiceImpl.register()");

		userDetails.setPwd(passwordEncoder.encode(userDetails.getPwd()));

		in.ineuron.model.security.UserDetails savedUserDetails = repo.save(userDetails);
		return "User registered successfully with id: " + savedUserDetails.getUid();
	}

}
