package cabinet_medical.exception;


public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(Long id) {
        super("Patient with id " + id + " not found.");
    }
}


