package org.couche.consumer.repos;

import org.couche.model.entities.Commentaire;
import org.springframework.data.repository.CrudRepository;


/*
 * Repository du framework Spring Data.
 * Surcouche de Hibernate.
 * Gère les interfaces pour l'accès aux données et génère les CRUD
 */
public interface CommentaireSpringDataRepository extends CrudRepository<Commentaire, Long> {

}
