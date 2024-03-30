package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RendezVousDAO {
    private Connection connection;

    public RendezVousDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean verifierDisponibilite(String date, String heure) {
        String query = "SELECT * FROM RendezVous WHERE date = ? AND heure = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, date);
            statement.setString(2, heure);
            ResultSet resultSet = statement.executeQuery();
            return !resultSet.next(); // Rendez-vous disponible si aucun résultat trouvé
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void enregistrerRendezVous(RendezVous rendezVous) {
        String query = "INSERT INTO RendezVous (nomPatient, prenomPatient, date, heure) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, rendezVous.getNomPatient());
            statement.setString(2, rendezVous.getPrenomPatient());
            statement.setString(3, rendezVous.getDate());
            statement.setString(4, rendezVous.getHeure());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RendezVous> getAllRendezVous() {
        List<RendezVous> rendezVousList = new ArrayList<>();
        String query = "SELECT * FROM RendezVous";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RendezVous rendezVous = new RendezVous();
                rendezVous.setId(resultSet.getInt("id"));
                rendezVous.setNomPatient(resultSet.getString("nomPatient"));
                rendezVous.setPrenomPatient(resultSet.getString("prenomPatient"));
                rendezVous.setDate(resultSet.getString("date"));
                rendezVous.setHeure(resultSet.getString("heure"));
                rendezVousList.add(rendezVous);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rendezVousList;
    }
}
