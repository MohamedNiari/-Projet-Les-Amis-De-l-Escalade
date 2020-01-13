package org.couche.business.services;

import java.util.List;

import org.couche.consumer.dao.implementation.ReservationDaoImplementation;
import org.couche.model.entities.Reservation;
import org.couche.model.entities.Topo;
import org.couche.model.entities.Utilisateur;

public class ReservationService {

	private static ReservationDaoImplementation reservationDao;

	public ReservationService() {
		reservationDao = new ReservationDaoImplementation();
	}
	
	public void create(Reservation reservation) {
		reservationDao.openCurrentSessionwithTransaction();
		reservationDao.create(reservation);
		reservationDao.closeCurrentSessionwithTransaction();
	}

	public void update(Reservation reservation) {
		reservationDao.openCurrentSessionwithTransaction();
		reservationDao.update(reservation);
		reservationDao.closeCurrentSessionwithTransaction();
	}

	public Reservation findById(Long id) {
		reservationDao.openCurrentSession();
		Reservation reservation = reservationDao.findById(id);
		reservationDao.closeCurrentSession();
		return reservation;
	}

	public void delete(Long id) {
		reservationDao.openCurrentSessionwithTransaction();
		Reservation reservation = reservationDao.findById(id);
		reservationDao.delete(reservation);
		reservationDao.closeCurrentSessionwithTransaction();
	}
	
	public void delete(Reservation reservation) {
		reservationDao.openCurrentSessionwithTransaction();
		reservationDao.delete(reservation);
		reservationDao.closeCurrentSessionwithTransaction();
	}

	public List<Reservation> findAll() {
		reservationDao.openCurrentSession();
		List<Reservation> reservations = reservationDao.findAll();
		reservationDao.closeCurrentSession();
		return reservations;
	}

	public void deleteAll() {
		reservationDao.openCurrentSessionwithTransaction();
		reservationDao.deleteAll();
		reservationDao.closeCurrentSessionwithTransaction();
	}

	public List<Reservation> findByUtilisateur(Long utilisateurId) {
		reservationDao.openCurrentSession();
		List<Reservation> reservations = (List<Reservation>) reservationDao.findByUtilisateur(utilisateurId);
		reservationDao.closeCurrentSession();
		return reservations;
	}
	
	public Boolean isTopoEnAttente(Topo topo, Utilisateur utilisateur) {
		reservationDao.openCurrentSession();
		Boolean topoAttente = reservationDao.isTopoEnAttente(topo, utilisateur);
		reservationDao.closeCurrentSession();
		return topoAttente;
	}

}
