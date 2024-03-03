package com.pablobarcellos.software_bancario.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Conta")
public class Conta
{
    @Id
    @Column(name = "numeroConta", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroConta;
    
    
    @Column(name = "saldo", unique = true)
    @NotNull
    @NotEmpty
    private Double saldo;


    @Column(name = "extrato", unique = true)
    @NotNull
    @NotEmpty
    @Size(max = 999)
    private String extrato;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User user;

    public Conta()
    {}
    



    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getExtrato() {
        return extrato;
    }

    public void setExtrato(String extrato) {
        this.extrato = extrato;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
