package pack1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class FichePatientDAO {
    boolean existe;
   public Boolean checkIfexist(FichePatient fichePatient){
    Boolean exist;
        // Vérifier si l'identifiant existe dans la base de données
        String query = "SELECT COUNT(*) FROM fiche_patient WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, fichePatient.Id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            
            if (count > 0) {
                exist=true; 
            } else {
                exist=false;
            }
        }
    
    return exist;
    }
    public void insertFichePatient(FichePatient fichePatient) {
        // Vérifier si le patient existe déjà dans la base de données
             

      existe=this.checkIfexist(fichePatient);
        if( existe){
            // Si le patient existe déjà, mettre à jour sa fiche
            updateFichePatient(fichePatient);
        } else {
            // Si le patient n'existe pas, l'insérer dans la base de données
            String sql = "INSERT INTO fiche_patient (id, nom, prenom, date_naissance, adresse, telephone, email, sexe, groupe_sanguin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
        }
    }

    public void updateFichePatient(FichePatient fichePatient) {
        // Vérifier si le patient existe déjà dans la base de données
        
        existe=this.checkIfexist(fichePatient);
        if (existe) {
            // Si le patient existe déjà, mettre à jour sa fiche
            String sql = "UPDATE fiche_patient SET nom = ?, prenom = ?, date_naissance = ?, adresse = ?, telephone = ?, email = ?, sexe = ?, groupe_sanguin = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
        } else {
            // Si le patient n'existe pas, l'insérer dans la base de données
            insertFichePatient(fichePatient);
        }
    }
}
