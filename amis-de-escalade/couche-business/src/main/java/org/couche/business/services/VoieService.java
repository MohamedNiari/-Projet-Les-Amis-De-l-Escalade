package org.couche.business.services;

import java.util.List;

import org.couche.consumer.dao.implementation.VoieDaoImplementation;
import org.couche.model.entities.Secteur;
import org.couche.model.entities.Voie;

public class VoieService {

	private static VoieDaoImplementation voieDao;

	public VoieService() {
		voieDao = new VoieDaoImplementation();
	}
	
	public void createVoie(Integer nombreLongueurs, Integer numeroVoie, Secteur secteur) {
		voieDao.openCurrentSessionwithTransaction();
		voieDao.createVoie(nombreLongueurs, numeroVoie, secteur);
		voieDao.closeCurrentSessionwithTransaction();
		
	}

	public void create(Voie voie) {
		voieDao.openCurrentSessionwithTransaction();
		voieDao.create(voie);
		voieDao.closeCurrentSessionwithTransaction();
	}

	public void update(Voie voie) {
		voieDao.openCurrentSessionwithTransaction();
		voieDao.update(voie);
		voieDao.closeCurrentSessionwithTransaction();
	}

	public Voie findById(Long id) {
		voieDao.openCurrentSession();
		Voie voie = voieDao.findById(id);
		voieDao.closeCurrentSession();
		return voie;
	}

	public void delete(Long id) {
		voieDao.openCurrentSessionwithTransaction();
		Voie voie = voieDao.findById(id);
		voieDao.delete(voie);
		voieDao.closeCurrentSessionwithTransaction();
	}

	public List<Voie> findAll() {
		voieDao.openCurrentSession();
		List<Voie> voies = voieDao.findAll();
		voieDao.closeCurrentSession();
		return voies;
	}

	public void deleteAll() {
		voieDao.openCurrentSessionwithTransaction();
		voieDao.deleteAll();
		voieDao.closeCurrentSessionwithTransaction();
	}

	public List<Voie> findBySecteur(Long secteurid) {
		voieDao.openCurrentSession();
		List<Voie> voies = voieDao.findBySecteur(secteurid);
		voieDao.closeCurrentSession();
		return voies;

	}

}
