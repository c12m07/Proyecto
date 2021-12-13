package generica.T_Clientes.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import generica.T_Clientes.Model.Cal_Mod_Clientes;

public interface Cal_Rep_Clientes extends MongoRepository<Cal_Mod_Clientes, String>{

}