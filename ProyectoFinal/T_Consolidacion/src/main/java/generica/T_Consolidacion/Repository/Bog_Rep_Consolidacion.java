package generica.T_Consolidacion.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import generica.T_Consolidacion.Model.Bog_Mod_Consolidacion;

public interface Bog_Rep_Consolidacion extends MongoRepository<Bog_Mod_Consolidacion, String>{

}