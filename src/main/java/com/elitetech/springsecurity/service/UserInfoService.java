package com.elitetech.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.elitetech.springsecurity.entity.UserInfo;
import com.elitetech.springsecurity.repository.UserInfoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

	 @Autowired
	    private UserInfoRepository userInfoRepository;
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<UserInfo> userInfo = userInfoRepository.findByEmail(username);
	        return userInfo.map(UserInfoDetails::new)
	                .orElseThrow(()-> new UsernameNotFoundException("User not found"+username));
	    }
	    public UserInfo getOneUser(String name)
	    {
	    	return userInfoRepository.findByName(name).orElse(null);
	    }
	    public UserInfo addUser(UserInfo userInfo){
	        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
	        return userInfoRepository.save(userInfo);
	    }
	    public List<UserInfo> getAllUser(){
	         return userInfoRepository.findAll();
	    }
   
    	    public Optional<UserInfo> getUser(Integer id){
    	        return userInfoRepository.findById(id);
    	    }
    	public UserInfo getUserByEmail(String email)
    	{
    		return userInfoRepository.findByEmail(email).orElse(null);
    	}
    	public long countUsers() {
    	    return userInfoRepository.count();
    	}

}

