package generica.T_Productos.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import generica.T_Productos.Model.Med_Mod_Productos;

public interface Med_Rep_Productos extends MongoRepository<Med_Mod_Productos, String> {

}