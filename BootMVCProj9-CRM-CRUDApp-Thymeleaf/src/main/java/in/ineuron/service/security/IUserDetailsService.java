package in.ineuron.service.security;

import org.springframework.security.core.userdetails.UserDetailsService;

import in.ineuron.model.security.UserDetails;

public interface IUserDetailsService extends UserDetailsService {

	public String register(UserDetails userDetails);
}
