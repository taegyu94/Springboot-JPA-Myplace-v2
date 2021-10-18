package com.Yoo.blogpractice.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Yoo.blogpractice.model.User;

import lombok.Getter;

@Getter
public class PrincipalDetails implements UserDetails {

	private User user;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		
		/*collectors.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				return "ROLE_" + user.getRole();
			}
		});*/ //66번줄에 있는 람다식으로 표현.  왜 가능하냐? collectors.add() 에는 파라미터로 GrantedAuthority() 객체만 올수 있고 얘는 getAuthority() 메서드만 가지고 있기때문
		
		collectors.add(()->{ return "ROLE_"+user.getRole(); });
		
		return collectors;
		
	}

}
