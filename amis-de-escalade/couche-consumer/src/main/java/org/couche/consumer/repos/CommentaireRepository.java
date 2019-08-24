package org.couche.consumer.repos;

import java.util.List;

import org.couche.model.entities.Commentaire;
import org.couche.model.entities.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/*
 * Repository du framework Spring Data.
 * Surcouche de Hibernate.
 * Gère les interfaces pour l'accès aux données et génère les CRUD
 */
public interface CommentaireRepository extends CrudRepository<Commentaire, Long> {
	@Query("FROM Commentaire commentaire WHERE commentaire.utilisateur.id_Utilisateur = :userId")

	List<Commentaire> findAllCommentairesByUser(@Param("userId") Long userId);

}
