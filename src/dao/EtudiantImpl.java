package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Classe;
import entity.Etudiant;

public class EtudiantImpl implements IEtudiant{
	
	private DB db = new DB();
	private ResultSet rs;
	private int ok;

	@Override
	public int add(Etudiant e) {
		String sql = "INSERT INTO etudiant VALUES(NULL, ?, ?, ?, ?, ?)";
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, e.generateMatricule());
			db.getPstm().setString(2, e.getNom());
			db.getPstm().setString(3, e.getPrenom());
			db.getPstm().setDouble(4, e.getMoyenne());
			int idClasse = e.getClasse().getId();
			db.getPstm().setInt(5, idClasse);
			ok = db.executeMaj();
			if(ok == 1) {
				String req = "UPDATE classe SET effectif = effectif + 1 WHERE id = ?";
				try {
					db.initPrepar(req);
					db.getPstm().setInt(1, idClasse);
					ok = db.executeMaj();
					db.closeConnection();
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	@Override
	public int update(Etudiant e) {
		String sql = "UPDATE etudiant SET nom = ?, prenom = ?, moyenne = ? WHERE id = ?";
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, e.getNom());
			db.getPstm().setString(2, e.getPrenom());
			db.getPstm().setDouble(3, e.getMoyenne());
			db.getPstm().setInt(4, e.getId());
			ok = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM etudiant WHERE id = ?";
		try {
			int idClasse = get(id).getClasse().getId();
			db.initPrepar(sql);
			db.getPstm().setInt(1, id);
			ok = db.executeMaj();
			if(ok == 1) {
				String req = "UPDATE classe SET effectif = effectif - 1 WHERE id = ?";
				try {
					db.initPrepar(req);
					db.getPstm().setInt(1, idClasse);
					ok = db.executeMaj();
					db.closeConnection();
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	@Override
	public List<Etudiant> list() {
		List<Etudiant> etudiants = new ArrayList<>();
		String sql = "SELECT * FROM etudiant ORDER BY nom ASC";
		try {
			db.initPrepar(sql);
			rs = db.executeSelect();
			while(rs.next()) {
				Etudiant e = new Etudiant();
				e.setId(rs.getInt("id"));
				e.setMatricule(rs.getString("matricule"));
				e.setNom(rs.getString("nom"));
				e.setPrenom(rs.getString("prenom"));
				e.setMoyenne(rs.getDouble("moyenne"));
				IClasse classeDao = new ClasseImpl();
				Classe cl = classeDao.get(rs.getInt("classe"));
				e.setClasse(cl);
				etudiants.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return etudiants;
	}

	@Override
	public Etudiant get(int id) {
		Etudiant e = null;
		String sql = "SELECT * FROM etudiant WHERE id = ?";
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, id);
			rs = db.executeSelect();
			if(rs.next()) {
				e = new Etudiant();
				e.setId(rs.getInt("id"));
				e.setMatricule(rs.getString("matricule"));
				e.setNom(rs.getString("nom"));
				e.setPrenom(rs.getString("prenom"));
				e.setMoyenne(rs.getDouble("moyenne"));
				IClasse classeDao = new ClasseImpl();
				Classe cl = classeDao.get(rs.getInt("classe"));
				e.setClasse(cl);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}

	@Override
	public List<Etudiant> getEtudiantsByClasse(String classe) {
		List<Etudiant> etudiants = new ArrayList<>();
		String sql = "SELECT * FROM etudiant e, classe c WHERE e.classe=c.id AND c.nom = ? ORDER BY e.nom ASC";
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, classe);
			rs = db.executeSelect();
			while(rs.next()) {
				Etudiant e = new Etudiant();
				e.setId(rs.getInt("id"));
				e.setMatricule(rs.getString("matricule"));
				e.setNom(rs.getString("nom"));
				e.setPrenom(rs.getString("prenom"));
				e.setMoyenne(rs.getDouble("moyenne"));
				IClasse classeDao = new ClasseImpl();
				Classe cl = classeDao.get(rs.getInt("classe"));
				e.setClasse(cl);
				etudiants.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return etudiants;
	}

}
