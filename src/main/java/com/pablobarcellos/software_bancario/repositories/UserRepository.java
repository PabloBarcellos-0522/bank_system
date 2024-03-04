package com.pablobarcellos.software_bancario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablobarcellos.software_bancario.models.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
    
}
