package generica.T_Productos.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import generica.T_Productos.Model.Bog_Mod_Productos;

public interface Bog_Rep_Productos extends MongoRepository<Bog_Mod_Productos, String> {

}