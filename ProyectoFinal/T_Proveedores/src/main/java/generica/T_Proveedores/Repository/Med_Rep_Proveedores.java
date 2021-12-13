package generica.T_Proveedores.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import generica.T_Proveedores.Model.Med_Mod_Proveedores;

public interface Med_Rep_Proveedores extends MongoRepository<Med_Mod_Proveedores, String> {

}