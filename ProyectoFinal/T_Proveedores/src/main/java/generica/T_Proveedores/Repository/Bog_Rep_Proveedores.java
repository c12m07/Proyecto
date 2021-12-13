package generica.T_Proveedores.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import generica.T_Proveedores.Model.Bog_Mod_Proveedores;

public interface Bog_Rep_Proveedores extends MongoRepository<Bog_Mod_Proveedores, String> {

}