package com.Yoo.blogpractice.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Yoo.blogpractice.model.User;
import com.Yoo.blogpractice.repository.UserRepository;

@Service
public class PrincipalDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override	// 시큐리티가 로그인 요청을 가로채면서 실행하는 메서드, 해당 username이 DB에 있는지만 확인하면된다.
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User Principal = userRepository.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. : " + username);
				});
		
		return new PrincipalDetails(Principal);
	}

	
}
