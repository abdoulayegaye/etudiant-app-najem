package dao;

import java.util.List;

import entity.Etudiant;

public interface IEtudiant extends Repository<Etudiant>{
	public List<Etudiant> getEtudiantsByClasse(String classe);
}
