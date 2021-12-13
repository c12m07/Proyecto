package generica.T_Clientes.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import generica.T_Clientes.Model.Bog_Mod_Clientes;

public interface Bog_Rep_Clientes extends MongoRepository<Bog_Mod_Clientes, String>{

}