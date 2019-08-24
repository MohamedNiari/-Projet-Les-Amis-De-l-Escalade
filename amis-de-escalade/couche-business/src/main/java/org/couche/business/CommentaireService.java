package org.couche.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.couche.consumer.repos.CommentaireRepository;
import org.couche.model.entities.Commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaireService {

	@Autowired
	CommentaireRepository commentaireRepository;

	public void test() throws ParseException {
		// Enregistrer un nouveau commentaire
		Commentaire commentaire = new Commentaire();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		commentaire.setDate_du_commentaire(format.parse("24/8/2019"));
		commentaire.setTexte("Excellent parcours sur le secteur 9");

		commentaireRepository.save(commentaire);

		// Trouver un commentaire par ID
		Optional<Commentaire> result = commentaireRepository.findById(1L);
		result.ifPresent(comment -> System.out.println(comment));

		// Trouver les commentaires par nom d'utilisateur
		List<Commentaire> customers = commentaireRepository.findAllCommentairesByUser(1L);
		customers.forEach(customer -> System.out.println(customer));

		// List all customers
		Iterable<Commentaire> iterator = commentaireRepository.findAll();
		iterator.forEach(customer -> System.out.println(customer));

		// Count number of customer
		long count = commentaireRepository.count();
		System.out.println("Number of customers: " + count);
	}

}
