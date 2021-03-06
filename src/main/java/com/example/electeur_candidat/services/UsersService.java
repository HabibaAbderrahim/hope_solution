package com.example.electeur_candidat.services;


import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.DTO.PasswordDTO;
import com.example.electeur_candidat.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsersService extends UserDetailsService{

    public MessageResponse save(Users user);
    public MessageResponse delete(Integer id);
    public MessageResponse update(Users user);
    public List<Users> findAll();
    public Users findById(Integer id);
    public MessageResponse changePassword(PasswordDTO pwdDTO);

}
