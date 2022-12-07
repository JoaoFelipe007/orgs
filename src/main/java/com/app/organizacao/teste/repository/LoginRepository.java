/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.organizacao.teste.repository;

import com.app.organizacao.teste.entity.Login;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    @Query("select lg from Login lg where lg.login = ?1")
    Optional<Login> findByLogin (String Login);
}
