package com.pablobarcellos.software_bancario.sevices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pablobarcellos.software_bancario.models.User;
import com.pablobarcellos.software_bancario.repositories.ContaRepository;
import com.pablobarcellos.software_bancario.repositories.UserRepository;


@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ContaRepository contaRepository;

    public User findById(Integer idUser)
    {
        Optional<User> user = this.userRepository.findById(idUser);
        return user.orElseThrow( () -> new RuntimeException("Usuário não encontrado!"));
    }

    @Transactional
    public User create(User obj)
    {
        obj.setIdUser(null);
        obj = this.userRepository.save(obj);
        this.contaRepository.saveAll(obj.getContas());
        return obj;
    }

    @Transactional
    public User update(User obj)
    {
        User newObj = findById(obj.getIdUser());
        newObj.setPassword(obj.getPassword());
        return this.userRepository.save(newObj);
    }

    public void delete(Integer id)
    {
        findById(id);
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel excluir, pois há entidades relacionadas!");
        }
    }
}
