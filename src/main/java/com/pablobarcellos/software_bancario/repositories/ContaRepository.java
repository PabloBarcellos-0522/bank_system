package com.pablobarcellos.software_bancario.repositories;

// import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablobarcellos.software_bancario.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer>
{
    // List<Conta> findByUser_Contas(Conta user);

    Optional<Conta> findById(Integer idUser);
}
