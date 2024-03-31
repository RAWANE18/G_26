package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FichePatientDAO {
    private Connection connection;
  
    public FichePatientDAO(){}
    public FichePatientDAO(Connection connection) {
        this.connection = connection;
    }

    boolean existe;

    public Boolean checkIfexist(FichePatient fichePatient) {
        int count=0;
        // Vérifier si l'identifiant existe dans la base de données
        String query = "SELECT COUNT(*) FROM FichePatient WHERE id = ?";
       try{ PreparedStatement preparedStatement = connection.prepareStatement(query);
        
            preparedStatement.setInt(1, fichePatient.Id);
    
    
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
               
            }           
        }catch(SQLException e) {
            e.printStackTrace();
        
        }
        return count!=0;
    }
    
    public void insertFichePatient(FichePatient fichePatient) {
        // Vérifier si le patient existe déjà dans la base de données

        existe = this.checkIfexist(fichePatient);
        if (existe) {
            // Si le patient existe déjà, mettre à jour sa fiche
            updateFichePatient(fichePatient);
        } else {
            // Si le patient n'existe pas, l'insérer dans la base de données
            String sql = "INSERT INTO FichePatient (id, nom, prenom, date_naissance, adresse, telephone, email, sexe, groupe_sanguin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
         try{  PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, fichePatient.Id);
            preparedStatement.setString(2, fichePatient.getNom());
            preparedStatement.setString(3, fichePatient.getPrenom());
            preparedStatement.setDate(4, fichePatient.getDateNaissance());
            preparedStatement.setString(5, fichePatient.getAdresse());
            preparedStatement.setString(6, fichePatient.getNumTel());
            preparedStatement.setString(7, fichePatient.getEmail());
            preparedStatement.setString(8, fichePatient.getSexe());
            preparedStatement.setString(9, fichePatient.getGroupeSanguin());

            
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateFichePatient(FichePatient fichePatient) {
        // Vérifier si le patient existe déjà dans la base de données

        existe = this.checkIfexist(fichePatient);
        if (existe) {
            // Si le patient existe déjà, mettre à jour sa fiche
            String sql = "UPDATE FichePatient SET nom = ?, prenom = ?, date_naissance = ?, adresse = ?, telephone = ?, email = ?, sexe = ?, groupe_sanguin = ? WHERE id = ?";
          try{  PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, fichePatient.Id);
            preparedStatement.setString(2, fichePatient.getNom());
            preparedStatement.setString(3, fichePatient.getPrenom());
            preparedStatement.setDate(4, fichePatient.getDateNaissance());
            preparedStatement.setString(5, fichePatient.getAdresse());
            preparedStatement.setString(6, fichePatient.getNumTel());
            preparedStatement.setString(7, fichePatient.getEmail());
            preparedStatement.setString(8, fichePatient.getSexe());
            preparedStatement.setString(9, fichePatient.getGroupeSanguin());

            
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            // Si le patient n'existe pas, l'insérer dans la base de données
            insertFichePatient(fichePatient);
        }
    }
}
