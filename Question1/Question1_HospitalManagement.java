import java.util.Scanner;

class HospitalDataException extends Exception {
    public HospitalDataException(String message) {
        super(message);
    }
}

class Entity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public Entity(int id, String createdDate, String updatedDate) throws HospitalDataException {
        if (id <= 0) throw new HospitalDataException("ID must be greater than 0");
        if (createdDate == null || createdDate.trim().isEmpty()) 
            throw new HospitalDataException("Created date cannot be null or empty");
        if (updatedDate == null || updatedDate.trim().isEmpty()) 
            throw new HospitalDataException("Updated date cannot be null or empty");
        
        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCreatedDate() { return createdDate; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }
    public String getUpdatedDate() { return updatedDate; }
    public void setUpdatedDate(String updatedDate) { this.updatedDate = updatedDate; }
}

class Hospital extends Entity {
    private String hospitalName;
    private String address;
    private String phoneNumber;
    private String email;

    public Hospital(int id, String createdDate, String updatedDate, String hospitalName, 
                   String address, String phoneNumber, String email) throws HospitalDataException {
        super(id, createdDate, updatedDate);
        
        if (!phoneNumber.matches("\\d{10}")) 
            throw new HospitalDataException("Phone number must be exactly 10 digits");
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new HospitalDataException("Invalid email format");
        
        this.hospitalName = hospitalName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getHospitalName() { return hospitalName; }
    public void setHospitalName(String hospitalName) { this.hospitalName = hospitalName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

class Department extends Hospital {
    private String departmentName;
    private String departmentCode;

    public Department(int id, String createdDate, String updatedDate, String hospitalName,
                     String address, String phoneNumber, String email, String departmentName,
                     String departmentCode) throws HospitalDataException {
        super(id, createdDate, updatedDate, hospitalName, address, phoneNumber, email);
        
        if (departmentCode.length() < 3 || !departmentCode.matches("^[a-zA-Z0-9]+$")) 
            throw new HospitalDataException("Department code must be alphanumeric and at least 3 characters");
        
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public String getDepartmentCode() { return departmentCode; }
    public void setDepartmentCode(String departmentCode) { this.departmentCode = departmentCode; }
}

class Doctor extends Department {
    private String doctorName;
    private String specialization;
    private String doctorEmail;
    private String phone;

    public Doctor(int id, String createdDate, String updatedDate, String hospitalName,
                 String address, String phoneNumber, String email, String departmentName,
                 String departmentCode, String doctorName, String specialization,
                 String doctorEmail, String phone) throws HospitalDataException {
        super(id, createdDate, updatedDate, hospitalName, address, phoneNumber, email,
              departmentName, departmentCode);
        
        if (specialization == null || specialization.trim().isEmpty()) 
            throw new HospitalDataException("Specialization cannot be empty");
        if (!doctorEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new HospitalDataException("Invalid doctor email format");
        if (!phone.matches("\\d{10}")) 
            throw new HospitalDataException("Doctor phone must be exactly 10 digits");
        
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.doctorEmail = doctorEmail;
        this.phone = phone;
    }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public String getDoctorEmail() { return doctorEmail; }
    public void setDoctorEmail(String doctorEmail) { this.doctorEmail = doctorEmail; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}

class Nurse extends Doctor {
    private String nurseName;
    private String shift;
    private int yearsOfExperience;

    public Nurse(int id, String createdDate, String updatedDate, String hospitalName,
                String address, String phoneNumber, String email, String departmentName,
                String departmentCode, String doctorName, String specialization,
                String doctorEmail, String phone, String nurseName, String shift,
                int yearsOfExperience) throws HospitalDataException {
        super(id, createdDate, updatedDate, hospitalName, address, phoneNumber, email,
              departmentName, departmentCode, doctorName, specialization, doctorEmail, phone);
        
        if (!shift.equals("Day") && !shift.equals("Night")) 
            throw new HospitalDataException("Shift must be 'Day' or 'Night'");
        if (yearsOfExperience < 0) 
            throw new HospitalDataException("Years of experience must be >= 0");
        
        this.nurseName = nurseName;
        this.shift = shift;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getNurseName() { return nurseName; }
    public void setNurseName(String nurseName) { this.nurseName = nurseName; }
    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }
}

class Patient extends Nurse {
    private String patientName;
    private int age;
    private String gender;
    private String contactNumber;

    public Patient(int id, String createdDate, String updatedDate, String hospitalName,
                  String address, String phoneNumber, String email, String departmentName,
                  String departmentCode, String doctorName, String specialization,
                  String doctorEmail, String phone, String nurseName, String shift,
                  int yearsOfExperience, String patientName, int age, String gender,
                  String contactNumber) throws HospitalDataException {
        super(id, createdDate, updatedDate, hospitalName, address, phoneNumber, email,
              departmentName, departmentCode, doctorName, specialization, doctorEmail, phone,
              nurseName, shift, yearsOfExperience);
        
        if (age <= 0) throw new HospitalDataException("Age must be > 0");
        if (!gender.equals("Male") && !gender.equals("Female") && !gender.equals("Other")) 
            throw new HospitalDataException("Gender must be 'Male', 'Female', or 'Other'");
        
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contactNumber;
    }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}

class Admission extends Patient {
    private String admissionDate;
    private int roomNumber;
    private double roomCharges;

    public Admission(int id, String createdDate, String updatedDate, String hospitalName,
                    String address, String phoneNumber, String email, String departmentName,
                    String departmentCode, String doctorName, String specialization,
                    String doctorEmail, String phone, String nurseName, String shift,
                    int yearsOfExperience, String patientName, int age, String gender,
                    String contactNumber, String admissionDate, int roomNumber,
                    double roomCharges) throws HospitalDataException {
        super(id, createdDate, updatedDate, hospitalName, address, phoneNumber, email,
              departmentName, departmentCode, doctorName, specialization, doctorEmail, phone,
              nurseName, shift, yearsOfExperience, patientName, age, gender, contactNumber);
        
        if (admissionDate == null || admissionDate.trim().isEmpty()) 
            throw new HospitalDataException("Admission date cannot be null");
        if (roomCharges <= 0) 
            throw new HospitalDataException("Room charges must be > 0");
        
        this.admissionDate = admissionDate;
        this.roomNumber = roomNumber;
        this.roomCharges = roomCharges;
    }

    public String getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(String admissionDate) { this.admissionDate = admissionDate; }
    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }
    public double getRoomCharges() { return roomCharges; }
    public void setRoomCharges(double roomCharges) { this.roomCharges = roomCharges; }
}

class Treatment extends Admission {
    private String diagnosis;
    private String treatmentGiven;
    private double treatmentCost;

    public Treatment(int id, String createdDate, String updatedDate, String hospitalName,
                    String address, String phoneNumber, String email, String departmentName,
                    String departmentCode, String doctorName, String specialization,
                    String doctorEmail, String phone, String nurseName, String shift,
                    int yearsOfExperience, String patientName, int age, String gender,
                    String contactNumber, String admissionDate, int roomNumber,
                    double roomCharges, String diagnosis, String treatmentGiven,
                    double treatmentCost) throws HospitalDataException {
        super(id, createdDate, updatedDate, hospitalName, address, phoneNumber, email,
              departmentName, departmentCode, doctorName, specialization, doctorEmail, phone,
              nurseName, shift, yearsOfExperience, patientName, age, gender, contactNumber,
              admissionDate, roomNumber, roomCharges);
        
        if (treatmentCost <= 0) 
            throw new HospitalDataException("Treatment cost must be > 0");
        if (diagnosis == null || diagnosis.trim().isEmpty()) 
            throw new HospitalDataException("Diagnosis cannot be empty");
        if (treatmentGiven == null || treatmentGiven.trim().isEmpty()) 
            throw new HospitalDataException("Treatment given cannot be empty");
        
        this.diagnosis = diagnosis;
        this.treatmentGiven = treatmentGiven;
        this.treatmentCost = treatmentCost;
    }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public String getTreatmentGiven() { return treatmentGiven; }
    public void setTreatmentGiven(String treatmentGiven) { this.treatmentGiven = treatmentGiven; }
    public double getTreatmentCost() { return treatmentCost; }
    public void setTreatmentCost(double treatmentCost) { this.treatmentCost = treatmentCost; }
}

class Bill extends Treatment {
    private double doctorFee;
    private double medicineCost;
    private double totalBill;

    public Bill(int id, String createdDate, String updatedDate, String hospitalName,
               String address, String phoneNumber, String email, String departmentName,
               String departmentCode, String doctorName, String specialization,
               String doctorEmail, String phone, String nurseName, String shift,
               int yearsOfExperience, String patientName, int age, String gender,
               String contactNumber, String admissionDate, int roomNumber,
               double roomCharges, String diagnosis, String treatmentGiven,
               double treatmentCost, double doctorFee, double medicineCost) 
               throws HospitalDataException {
        super(id, createdDate, updatedDate, hospitalName, address, phoneNumber, email,
              departmentName, departmentCode, doctorName, specialization, doctorEmail, phone,
              nurseName, shift, yearsOfExperience, patientName, age, gender, contactNumber,
              admissionDate, roomNumber, roomCharges, diagnosis, treatmentGiven, treatmentCost);
        
        if (doctorFee <= 0) throw new HospitalDataException("Doctor fee must be > 0");
        if (medicineCost <= 0) throw new HospitalDataException("Medicine cost must be > 0");
        
        this.doctorFee = doctorFee;
        this.medicineCost = medicineCost;
        this.totalBill = 0;
    }

    public double getDoctorFee() { return doctorFee; }
    public void setDoctorFee(double doctorFee) { this.doctorFee = doctorFee; }
    public double getMedicineCost() { return medicineCost; }
    public void setMedicineCost(double medicineCost) { this.medicineCost = medicineCost; }
    public double getTotalBill() { return totalBill; }
    public void setTotalBill(double totalBill) { this.totalBill = totalBill; }
}

final class HospitalRecord extends Bill {
    public HospitalRecord(int id, String createdDate, String updatedDate, String hospitalName,
                         String address, String phoneNumber, String email, String departmentName,
                         String departmentCode, String doctorName, String specialization,
                         String doctorEmail, String phone, String nurseName, String shift,
                         int yearsOfExperience, String patientName, int age, String gender,
                         String contactNumber, String admissionDate, int roomNumber,
                         double roomCharges, String diagnosis, String treatmentGiven,
                         double treatmentCost, double doctorFee, double medicineCost) 
                         throws HospitalDataException {
        super(id, createdDate, updatedDate, hospitalName, address, phoneNumber, email,
              departmentName, departmentCode, doctorName, specialization, doctorEmail, phone,
              nurseName, shift, yearsOfExperience, patientName, age, gender, contactNumber,
              admissionDate, roomNumber, roomCharges, diagnosis, treatmentGiven, treatmentCost,
              doctorFee, medicineCost);
    }

    public double generateBill() {
        double total = getRoomCharges() + getTreatmentCost() + getDoctorFee() + getMedicineCost();
        setTotalBill(total);
        return total;
    }

    public void displayRecord() {
        System.out.println("\n========== HOSPITAL MANAGEMENT SYSTEM ==========");
        System.out.println("Record ID: " + getId());
        System.out.println("Created Date: " + getCreatedDate());
        System.out.println("Updated Date: " + getUpdatedDate());
        System.out.println("\n--- Hospital Details ---");
        System.out.println("Hospital Name: " + getHospitalName());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
        System.out.println("\n--- Department Details ---");
        System.out.println("Department: " + getDepartmentName());
        System.out.println("Department Code: " + getDepartmentCode());
        System.out.println("\n--- Doctor Details ---");
        System.out.println("Doctor Name: " + getDoctorName());
        System.out.println("Specialization: " + getSpecialization());
        System.out.println("Doctor Email: " + getDoctorEmail());
        System.out.println("Doctor Phone: " + getPhone());
        System.out.println("\n--- Nurse Details ---");
        System.out.println("Nurse Name: " + getNurseName());
        System.out.println("Shift: " + getShift());
        System.out.println("Years of Experience: " + getYearsOfExperience());
        System.out.println("\n--- Patient Details ---");
        System.out.println("Patient Name: " + getPatientName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Contact Number: " + getContactNumber());
        System.out.println("\n--- Admission Details ---");
        System.out.println("Admission Date: " + getAdmissionDate());
        System.out.println("Room Number: " + getRoomNumber());
        System.out.println("Room Charges: $" + getRoomCharges());
        System.out.println("\n--- Treatment Details ---");
        System.out.println("Diagnosis: " + getDiagnosis());
        System.out.println("Treatment Given: " + getTreatmentGiven());
        System.out.println("Treatment Cost: $" + getTreatmentCost());
        System.out.println("\n--- Billing Details ---");
        System.out.println("Doctor Fee: $" + getDoctorFee());
        System.out.println("Medicine Cost: $" + getMedicineCost());
        System.out.println("Total Bill: $" + getTotalBill());
        System.out.println("===============================================\n");
    }
}

public class Question1_HospitalManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("========== HOSPITAL MANAGEMENT SYSTEM ==========\n");
            
            System.out.print("Enter Record ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Created Date (YYYY-MM-DD): ");
            String createdDate = scanner.nextLine();
            
            System.out.print("Enter Updated Date (YYYY-MM-DD): ");
            String updatedDate = scanner.nextLine();
            
            System.out.print("Enter Hospital Name: ");
            String hospitalName = scanner.nextLine();
            
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            
            System.out.print("Enter Hospital Phone (10 digits): ");
            String phoneNumber = scanner.nextLine();
            
            System.out.print("Enter Hospital Email: ");
            String email = scanner.nextLine();
            
            System.out.print("Enter Department Name: ");
            String departmentName = scanner.nextLine();
            
            System.out.print("Enter Department Code (alphanumeric, min 3 chars): ");
            String departmentCode = scanner.nextLine();
            
            System.out.print("Enter Doctor Name: ");
            String doctorName = scanner.nextLine();
            
            System.out.print("Enter Specialization: ");
            String specialization = scanner.nextLine();
            
            System.out.print("Enter Doctor Email: ");
            String doctorEmail = scanner.nextLine();
            
            System.out.print("Enter Doctor Phone (10 digits): ");
            String doctorPhone = scanner.nextLine();
            
            System.out.print("Enter Nurse Name: ");
            String nurseName = scanner.nextLine();
            
            System.out.print("Enter Shift (Day/Night): ");
            String shift = scanner.nextLine();
            
            System.out.print("Enter Years of Experience: ");
            int yearsOfExperience = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Patient Name: ");
            String patientName = scanner.nextLine();
            
            System.out.print("Enter Patient Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Gender (Male/Female/Other): ");
            String gender = scanner.nextLine();
            
            System.out.print("Enter Contact Number: ");
            String contactNumber = scanner.nextLine();
            
            System.out.print("Enter Admission Date (YYYY-MM-DD): ");
            String admissionDate = scanner.nextLine();
            
            System.out.print("Enter Room Number: ");
            int roomNumber = scanner.nextInt();
            
            System.out.print("Enter Room Charges: ");
            double roomCharges = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Enter Diagnosis: ");
            String diagnosis = scanner.nextLine();
            
            System.out.print("Enter Treatment Given: ");
            String treatmentGiven = scanner.nextLine();
            
            System.out.print("Enter Treatment Cost: ");
            double treatmentCost = scanner.nextDouble();
            
            System.out.print("Enter Doctor Fee: ");
            double doctorFee = scanner.nextDouble();
            
            System.out.print("Enter Medicine Cost: ");
            double medicineCost = scanner.nextDouble();
            
            HospitalRecord record = new HospitalRecord(id, createdDate, updatedDate, hospitalName,
                address, phoneNumber, email, departmentName, departmentCode, doctorName,
                specialization, doctorEmail, doctorPhone, nurseName, shift, yearsOfExperience,
                patientName, age, gender, contactNumber, admissionDate, roomNumber, roomCharges,
                diagnosis, treatmentGiven, treatmentCost, doctorFee, medicineCost);
            
            record.generateBill();
            record.displayRecord();
            
        } catch (HospitalDataException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Input Error: Please enter valid data");
        } finally {
            scanner.close();
        }
    }
}
