package com.example.demo.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Account;
import com.example.demo.entity.AccountRepository;

@Service
public class AccountService implements UserDetailsService {
	
	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username == null || username.equals("")) {
			throw new UsernameNotFoundException("username is empty");
		}
		Account user = repository.findByUsername(username);
		if(user == null)
		{
			throw new UsernameNotFoundException("User not found:" + username);
		}
		return user;
	}
	 //adminを登録するメソッド
    @Transactional
    public void registerAdmin(String username, String password, String mailAddress) {
        Account user = new Account(username, passwordEncoder.encode(password), mailAddress);
        user.setAdmin(true);
        repository.save(user);
    }

    //管理者を登録するメソッド
    @Transactional
    public void registerManager(String username, String password, String mailAddress) {
        Account user = new Account(username, passwordEncoder.encode(password), mailAddress);
        user.setManager(true);
        repository.save(user);
    }

    //一般ユーザを登録するメソッド
    @Transactional
    public void registerUser(String username, String password, String mailAddress) {
        Account user = new Account(username, passwordEncoder.encode(password), mailAddress);
        repository.save(user);
    }

}
