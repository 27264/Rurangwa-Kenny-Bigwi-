import java.util.Scanner;

class RentalDataException extends Exception {
    public RentalDataException(String message) {
        super(message);
    }
}

class RentalEntity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public RentalEntity(int id, String createdDate, String updatedDate) throws RentalDataException {
        if (id <= 0) throw new RentalDataException("ID must be greater than 0");
        if (createdDate == null || createdDate.trim().isEmpty()) 
            throw new RentalDataException("Created date cannot be null or empty");
        if (updatedDate == null || updatedDate.trim().isEmpty()) 
            throw new RentalDataException("Updated date cannot be null or empty");
        
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

class RentalCompany extends RentalEntity {
    private String companyName;
    private String address;
    private String phoneNumber;
    private String email;

    public RentalCompany(int id, String createdDate, String updatedDate, String companyName, 
                   String address, String phoneNumber, String email) throws RentalDataException {
        super(id, createdDate, updatedDate);
        
        if (!phoneNumber.matches("\\d{10}")) 
            throw new RentalDataException("Phone number must be exactly 10 digits");
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new RentalDataException("Invalid email format");
        
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

class RentalBranch extends RentalCompany {
    private String branchName;
    private String branchCode;

    public RentalBranch(int id, String createdDate, String updatedDate, String companyName,
                     String address, String phoneNumber, String email, String branchName,
                     String branchCode) throws RentalDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email);
        
        if (branchCode.length() < 3 || !branchCode.matches("^[a-zA-Z0-9]+$")) 
            throw new RentalDataException("Branch code must be alphanumeric and at least 3 characters");
        
        this.branchName = branchName;
        this.branchCode = branchCode;
    }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }
    public String getBranchCode() { return branchCode; }
    public void setBranchCode(String branchCode) { this.branchCode = branchCode; }
}

class RentalVehicle extends RentalBranch {
    private String vehicleModel;
    private String vehicleNumber;
    private String vehicleType;
    private int yearOfManufacture;

    public RentalVehicle(int id, String createdDate, String updatedDate, String companyName,
                  String address, String phoneNumber, String email, String branchName,
                  String branchCode, String vehicleModel, String vehicleNumber,
                  String vehicleType, int yearOfManufacture) throws RentalDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              branchName, branchCode);
        
        if (vehicleNumber == null || vehicleNumber.trim().isEmpty()) 
            throw new RentalDataException("Vehicle number cannot be empty");
        if (yearOfManufacture < 1900 || yearOfManufacture > 2025) 
            throw new RentalDataException("Year of manufacture must be between 1900 and 2025");
        
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getVehicleModel() { return vehicleModel; }
    public void setVehicleModel(String vehicleModel) { this.vehicleModel = vehicleModel; }
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
    public int getYearOfManufacture() { return yearOfManufacture; }
    public void setYearOfManufacture(int yearOfManufacture) { this.yearOfManufacture = yearOfManufacture; }
}

class RentalCustomer extends RentalVehicle {
    private String customerName;
    private String customerEmail;
    private String phone;
    private String licenseNumber;

    public RentalCustomer(int id, String createdDate, String updatedDate, String companyName,
                   String address, String phoneNumber, String email, String branchName,
                   String branchCode, String vehicleModel, String vehicleNumber,
                   String vehicleType, int yearOfManufacture, String customerName,
                   String customerEmail, String phone, String licenseNumber) 
                   throws RentalDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              branchName, branchCode, vehicleModel, vehicleNumber, vehicleType,
              yearOfManufacture);
        
        if (!customerEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new RentalDataException("Invalid customer email format");
        if (!phone.matches("\\d{10}")) 
            throw new RentalDataException("Customer phone must be exactly 10 digits");
        if (licenseNumber == null || licenseNumber.trim().isEmpty()) 
            throw new RentalDataException("License number cannot be empty");
        
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.phone = phone;
        this.licenseNumber = licenseNumber;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
}

class Rental extends RentalCustomer {
    private String rentalDate;
    private String returnDate;
    private int numberOfDays;

    public Rental(int id, String createdDate, String updatedDate, String companyName,
                 String address, String phoneNumber, String email, String branchName,
                 String branchCode, String vehicleModel, String vehicleNumber,
                 String vehicleType, int yearOfManufacture, String customerName,
                 String customerEmail, String phone, String licenseNumber,
                 String rentalDate, String returnDate, int numberOfDays) 
                 throws RentalDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              branchName, branchCode, vehicleModel, vehicleNumber, vehicleType,
              yearOfManufacture, customerName, customerEmail, phone, licenseNumber);
        
        if (rentalDate == null || rentalDate.trim().isEmpty()) 
            throw new RentalDataException("Rental date cannot be empty");
        if (returnDate == null || returnDate.trim().isEmpty()) 
            throw new RentalDataException("Return date cannot be empty");
        if (numberOfDays <= 0) 
            throw new RentalDataException("Number of days must be > 0");
        
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.numberOfDays = numberOfDays;
    }

    public String getRentalDate() { return rentalDate; }
    public void setRentalDate(String rentalDate) { this.rentalDate = rentalDate; }
    public String getReturnDate() { return returnDate; }
    public void setReturnDate(String returnDate) { this.returnDate = returnDate; }
    public int getNumberOfDays() { return numberOfDays; }
    public void setNumberOfDays(int numberOfDays) { this.numberOfDays = numberOfDays; }
}

class RentalCharge extends Rental {
    private double dailyRate;
    private double rentalCharge;
    private double penaltyCharge;

    public RentalCharge(int id, String createdDate, String updatedDate, String companyName,
                 String address, String phoneNumber, String email, String branchName,
                 String branchCode, String vehicleModel, String vehicleNumber,
                 String vehicleType, int yearOfManufacture, String customerName,
                 String customerEmail, String phone, String licenseNumber,
                 String rentalDate, String returnDate, int numberOfDays,
                 double dailyRate, double rentalCharge, double penaltyCharge) 
                 throws RentalDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              branchName, branchCode, vehicleModel, vehicleNumber, vehicleType,
              yearOfManufacture, customerName, customerEmail, phone, licenseNumber,
              rentalDate, returnDate, numberOfDays);
        
        if (dailyRate <= 0) 
            throw new RentalDataException("Daily rate must be > 0");
        if (rentalCharge < 0) 
            throw new RentalDataException("Rental charge must be >= 0");
        if (penaltyCharge < 0) 
            throw new RentalDataException("Penalty charge must be >= 0");
        
        this.dailyRate = dailyRate;
        this.rentalCharge = rentalCharge;
        this.penaltyCharge = penaltyCharge;
    }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }
    public double getRentalCharge() { return rentalCharge; }
    public void setRentalCharge(double rentalCharge) { this.rentalCharge = rentalCharge; }
    public double getPenaltyCharge() { return penaltyCharge; }
    public void setPenaltyCharge(double penaltyCharge) { this.penaltyCharge = penaltyCharge; }
}

class RentalPayment extends RentalCharge {
    private String paymentMethod;
    private String paymentDate;
    private double amountPaid;

    public RentalPayment(int id, String createdDate, String updatedDate, String companyName,
                  String address, String phoneNumber, String email, String branchName,
                  String branchCode, String vehicleModel, String vehicleNumber,
                  String vehicleType, int yearOfManufacture, String customerName,
                  String customerEmail, String phone, String licenseNumber,
                  String rentalDate, String returnDate, int numberOfDays,
                  double dailyRate, double rentalCharge, double penaltyCharge,
                  String paymentMethod, String paymentDate, double amountPaid) 
                  throws RentalDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              branchName, branchCode, vehicleModel, vehicleNumber, vehicleType,
              yearOfManufacture, customerName, customerEmail, phone, licenseNumber,
              rentalDate, returnDate, numberOfDays, dailyRate, rentalCharge, penaltyCharge);
        
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) 
            throw new RentalDataException("Payment method cannot be empty");
        if (amountPaid < 0) 
            throw new RentalDataException("Amount paid must be >= 0");
        
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.amountPaid = amountPaid;
    }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getPaymentDate() { return paymentDate; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }
    public double getAmountPaid() { return amountPaid; }
    public void setAmountPaid(double amountPaid) { this.amountPaid = amountPaid; }
}

class RentalInvoice extends RentalPayment {
    private String invoiceNumber;
    private double totalCharge;

    public RentalInvoice(int id, String createdDate, String updatedDate, String companyName,
                  String address, String phoneNumber, String email, String branchName,
                  String branchCode, String vehicleModel, String vehicleNumber,
                  String vehicleType, int yearOfManufacture, String customerName,
                  String customerEmail, String phone, String licenseNumber,
                  String rentalDate, String returnDate, int numberOfDays,
                  double dailyRate, double rentalCharge, double penaltyCharge,
                  String paymentMethod, String paymentDate, double amountPaid,
                  String invoiceNumber) throws RentalDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              branchName, branchCode, vehicleModel, vehicleNumber, vehicleType,
              yearOfManufacture, customerName, customerEmail, phone, licenseNumber,
              rentalDate, returnDate, numberOfDays, dailyRate, rentalCharge, penaltyCharge,
              paymentMethod, paymentDate, amountPaid);
        
        if (invoiceNumber == null || invoiceNumber.trim().isEmpty()) 
            throw new RentalDataException("Invoice number cannot be empty");
        
        this.invoiceNumber = invoiceNumber;
        this.totalCharge = 0;
    }

    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
    public double getTotalCharge() { return totalCharge; }
    public void setTotalCharge(double totalCharge) { this.totalCharge = totalCharge; }
}

final class VehicleRentalRecord extends RentalInvoice {
    public VehicleRentalRecord(int id, String createdDate, String updatedDate, String companyName,
                       String address, String phoneNumber, String email, String branchName,
                       String branchCode, String vehicleModel, String vehicleNumber,
                       String vehicleType, int yearOfManufacture, String customerName,
                       String customerEmail, String phone, String licenseNumber,
                       String rentalDate, String returnDate, int numberOfDays,
                       double dailyRate, double rentalCharge, double penaltyCharge,
                       String paymentMethod, String paymentDate, double amountPaid,
                       String invoiceNumber) throws RentalDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              branchName, branchCode, vehicleModel, vehicleNumber, vehicleType,
              yearOfManufacture, customerName, customerEmail, phone, licenseNumber,
              rentalDate, returnDate, numberOfDays, dailyRate, rentalCharge, penaltyCharge,
              paymentMethod, paymentDate, amountPaid, invoiceNumber);
    }

    public double calculateTotalCharge() {
        double total = getRentalCharge() + getPenaltyCharge();
        setTotalCharge(total);
        return total;
    }

    public void displayRecord() {
        System.out.println("\n========== VEHICLE RENTAL SYSTEM ==========");
        System.out.println("Record ID: " + getId());
        System.out.println("Created Date: " + getCreatedDate());
        System.out.println("Updated Date: " + getUpdatedDate());
        System.out.println("\n--- Company Details ---");
        System.out.println("Company Name: " + getCompanyName());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
        System.out.println("\n--- Branch Details ---");
        System.out.println("Branch Name: " + getBranchName());
        System.out.println("Branch Code: " + getBranchCode());
        System.out.println("\n--- Vehicle Details ---");
        System.out.println("Vehicle Model: " + getVehicleModel());
        System.out.println("Vehicle Number: " + getVehicleNumber());
        System.out.println("Vehicle Type: " + getVehicleType());
        System.out.println("Year of Manufacture: " + getYearOfManufacture());
        System.out.println("\n--- Customer Details ---");
        System.out.println("Customer Name: " + getCustomerName());
        System.out.println("Customer Email: " + getCustomerEmail());
        System.out.println("Customer Phone: " + getPhone());
        System.out.println("License Number: " + getLicenseNumber());
        System.out.println("\n--- Rental Details ---");
        System.out.println("Rental Date: " + getRentalDate());
        System.out.println("Return Date: " + getReturnDate());
        System.out.println("Number of Days: " + getNumberOfDays());
        System.out.println("\n--- Charge Details ---");
        System.out.println("Daily Rate: $" + getDailyRate());
        System.out.println("Rental Charge: $" + getRentalCharge());
        System.out.println("Penalty Charge: $" + getPenaltyCharge());
        System.out.println("\n--- Payment Details ---");
        System.out.println("Payment Method: " + getPaymentMethod());
        System.out.println("Payment Date: " + getPaymentDate());
        System.out.println("Amount Paid: $" + getAmountPaid());
        System.out.println("\n--- Invoice Details ---");
        System.out.println("Invoice Number: " + getInvoiceNumber());
        System.out.println("Total Charge: $" + getTotalCharge());
        System.out.println("===============================================\n");
    }
}

public class Question5_VehicleRental {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("========== VEHICLE RENTAL SYSTEM ==========\n");
            
            System.out.print("Enter Record ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Created Date (YYYY-MM-DD): ");
            String createdDate = scanner.nextLine();
            
            System.out.print("Enter Updated Date (YYYY-MM-DD): ");
            String updatedDate = scanner.nextLine();
            
            System.out.print("Enter Company Name: ");
            String companyName = scanner.nextLine();
            
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            
            System.out.print("Enter Company Phone (10 digits): ");
            String phoneNumber = scanner.nextLine();
            
            System.out.print("Enter Company Email: ");
            String email = scanner.nextLine();
            
            System.out.print("Enter Branch Name: ");
            String branchName = scanner.nextLine();
            
            System.out.print("Enter Branch Code (alphanumeric, min 3 chars): ");
            String branchCode = scanner.nextLine();
            
            System.out.print("Enter Vehicle Model: ");
            String vehicleModel = scanner.nextLine();
            
            System.out.print("Enter Vehicle Number: ");
            String vehicleNumber = scanner.nextLine();
            
            System.out.print("Enter Vehicle Type: ");
            String vehicleType = scanner.nextLine();
            
            System.out.print("Enter Year of Manufacture: ");
            int yearOfManufacture = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Customer Name: ");
            String customerName = scanner.nextLine();
            
            System.out.print("Enter Customer Email: ");
            String customerEmail = scanner.nextLine();
            
            System.out.print("Enter Customer Phone (10 digits): ");
            String customerPhone = scanner.nextLine();
            
            System.out.print("Enter License Number: ");
            String licenseNumber = scanner.nextLine();
            
            System.out.print("Enter Rental Date (YYYY-MM-DD): ");
            String rentalDate = scanner.nextLine();
            
            System.out.print("Enter Return Date (YYYY-MM-DD): ");
            String returnDate = scanner.nextLine();
            
            System.out.print("Enter Number of Days: ");
            int numberOfDays = scanner.nextInt();
            
            System.out.print("Enter Daily Rate: ");
            double dailyRate = scanner.nextDouble();
            
            System.out.print("Enter Rental Charge: ");
            double rentalCharge = scanner.nextDouble();
            
            System.out.print("Enter Penalty Charge: ");
            double penaltyCharge = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Enter Payment Method: ");
            String paymentMethod = scanner.nextLine();
            
            System.out.print("Enter Payment Date (YYYY-MM-DD): ");
            String paymentDate = scanner.nextLine();
            
            System.out.print("Enter Amount Paid: ");
            double amountPaid = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Enter Invoice Number: ");
            String invoiceNumber = scanner.nextLine();
            
            VehicleRentalRecord record = new VehicleRentalRecord(id, createdDate, updatedDate, companyName,
                address, phoneNumber, email, branchName, branchCode, vehicleModel, vehicleNumber,
                vehicleType, yearOfManufacture, customerName, customerEmail, customerPhone,
                licenseNumber, rentalDate, returnDate, numberOfDays, dailyRate, rentalCharge,
                penaltyCharge, paymentMethod, paymentDate, amountPaid, invoiceNumber);
            
            record.calculateTotalCharge();
            record.displayRecord();
            
        } catch (RentalDataException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Input Error: Please enter valid data");
        } finally {
            scanner.close();
        }
    }
}
