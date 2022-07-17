package com.example.pet.service;
import com.example.pet.entity.User;
import com.example.pet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);
        if(user == null)
            throw new UsernameNotFoundException("User not found");
        return (UserDetails) user;
    }
    public User findUser(User user){
        User findedUser = userRepository.findByLogin(user.getLogin());
        if(findedUser==null)return null;
        if(findedUser.getPass().equalsIgnoreCase(user.getPass())==false)return null;
        return findedUser;
    }
    public User findUserById(Long userId){
        return userRepository.findById(userId).get();
    }
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
    public boolean createUser(User user){
        User findedUser = userRepository.findByLogin(user.getLogin());
        if(findedUser!=null)return false;
        try
        {
            //user.setPass(passwordEncoder.encode(user.getPass()));
            userRepository.save(user);
        }catch (Exception ex){
            return false;
        }
        return true;
    }
    public void saveUser(User user){
        userRepository.save(user);
    }
}
