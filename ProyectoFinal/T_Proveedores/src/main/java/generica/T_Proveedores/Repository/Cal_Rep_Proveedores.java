package generica.T_Proveedores.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import generica.T_Proveedores.Model.Cal_Mod_Proveedores;

public interface Cal_Rep_Proveedores extends MongoRepository<Cal_Mod_Proveedores, String> {

}