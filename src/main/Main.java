package main;

import dao.ClasseImpl;
import dao.EtudiantImpl;
import dao.IClasse;
import dao.IEtudiant;
import entity.Classe;
import entity.Etudiant;

public class Main {

	public static void main(String[] args) {
		//Pour les classes
		IClasse classeDao = new ClasseImpl();
		/*Classe cl = new Classe();
		cl.setNom("DITI3");
		int ok = classeDao.add(cl);
		if(ok == 1)
			System.out.println("Classe enregistrée avec succés !");
		else
			System.out.println("Erreur !");
		System.out.println("Liste des classes");
		for (Classe c : classeDao.list()) {
			System.out.println("ID : " + c.getId());
			System.out.println("NOM : " + c.getNom());
			System.out.println("EFFECTIF : " + c.getEffectif());
		}
		int idClasse = 3;
		Classe classe = classeDao.get(idClasse);
		classe.setNom("M2IAGE");
		classe.setEffectif(4);
		if(classe != null) {
			System.out.println("ID : " + classe.getId());
			System.out.println("NOM : " + classe.getNom());
			System.out.println("EFFECTIF : " + classe.getEffectif());
		}else {
			System.out.println("Aucune classe d'ID : " + idClasse);
		}
		int ok = classeDao.update(classe);
		if(ok == 1)
			System.out.println("Classe modifiée avec succés !");
		else
			System.out.println("Erreur !");
		int ok = classeDao.delete(3);
		if(ok == 1)
			System.out.println("Classe supprimée avec succés !");
		else
			System.out.println("Erreur !");*/
		
		
		//Pour les étudiants
		IEtudiant etuDao = new EtudiantImpl();
		/*Etudiant e = new Etudiant();
		e.setNom("NOURA");
		e.setPrenom("Olé");
		e.setMoyenne(16.5);
		e.setClasse(classeDao.get(2));
		int ok = etuDao.add(e);
		if(ok == 1)
			System.out.println("Etudiant enregistré avec succés !");
		else
			System.out.println("Erreur !");*/
		
		/*System.out.println("Liste des étudiants");
		for (Etudiant e : etuDao.getEtudiantsByClasse("L3IAGE")) {
			System.out.println("Matricule : " + e.getMatricule());
			System.out.println("Nom : " + e.getNom());
			System.out.println("Prenom : " + e.getPrenom());
			System.out.println("Moyenne : " + e.getMoyenne());
			System.out.println("Classe : " + e.getClasse().getNom());
		}*/
		
		/*Etudiant e = etuDao.get(4);
		e.setNom("DIOP");
		e.setPrenom("Fatou");
		e.setMoyenne(12.5);
		int ok = etuDao.update(e);
		if(ok == 1)
			System.out.println("Etudiant modifié avec succés !");
		else
			System.out.println("Erreur !");*/
		
		int ok = etuDao.delete(3);
		if(ok == 1)
			System.out.println("Etudiant supprimé avec succés !");
		else
			System.out.println("Erreur !");
	}

}
