package com.jotacodes.clientebazar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jotacodes.clientebazar.models.Client;

public interface IClientRepository  extends JpaRepository<Client,Long>{

}
