package generica.T_Clientes.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import generica.T_Clientes.Model.Med_Mod_Clientes;

public interface Med_Rep_Clientes extends MongoRepository<Med_Mod_Clientes, String>{

}