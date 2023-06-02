package entity;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Etudiant {
	private int id;
	private String matricule, nom, prenom;
	private double moyenne;
	private Classe classe;
	public Etudiant() {
		super();
	}
	public Etudiant(String nom, String prenom, double moyenne, Classe classe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.moyenne = moyenne;
		this.classe = classe;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public double getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	public String generateMatricule() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String mat = "ET@" + sdf.format(new Date()) + classe.getNom() + "#";
		return mat.toUpperCase();
	}
}
