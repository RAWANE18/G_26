package pack1;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RendezVous {
    private int id;
    private String nomPatient;
    private String prenomPatient;
    private String date;
    private String heure;

    //getters
    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public int getId() {
        return id;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public String getPrenomPatient() {
        return prenomPatient;
    }

    //setters
    public void setDate(String date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public void setPrenomPatient(String prenomPatient) {
        this.prenomPatient = prenomPatient;
    }

    // Méthode pour générer les plages horaires
    public List<LocalDateTime> generateDateTimeRanges() {
        List<LocalDateTime> dateTimeRanges = new ArrayList<>();
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Générer les plages horaires pour une semaine
        for (int i = 0; i < 7; i++) {
            LocalDateTime startDateTime = currentDateTime.plusDays(i).withHour(8).withMinute(0).withSecond(0);
            LocalDateTime endDateTime = startDateTime.plusMinutes(30);

            while (startDateTime.isBefore(currentDateTime.plusDays(i).withHour(18))) {
                dateTimeRanges.add(startDateTime);
                dateTimeRanges.add(endDateTime);
                startDateTime = endDateTime;
                endDateTime = endDateTime.plusMinutes(30);
            }
        }

        return dateTimeRanges;
    }


    //afficher les dates 
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    public void dateaffiche( List<LocalDateTime>  dateTimeRanges){
    for (LocalDateTime dateTimeRange : dateTimeRanges) {
        System.out.println(dateTimeRange.format(formatter));
    }
}
}
