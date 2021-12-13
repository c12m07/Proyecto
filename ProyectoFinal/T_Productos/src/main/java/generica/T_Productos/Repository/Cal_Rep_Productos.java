package generica.T_Productos.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import generica.T_Productos.Model.Cal_Mod_Productos;

public interface Cal_Rep_Productos extends MongoRepository<Cal_Mod_Productos, String> {

}