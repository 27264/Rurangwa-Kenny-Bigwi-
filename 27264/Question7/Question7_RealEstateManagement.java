import java.util.Scanner;

class RealEstateException extends Exception {
    public RealEstateException(String message) {
        super(message);
    }
}

class Entity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public Entity(int id, String createdDate, String updatedDate) throws RealEstateException {
        if (id <= 0) throw new RealEstateException("ID must be greater than 0");
        if (createdDate == null || createdDate.trim().isEmpty()) 
            throw new RealEstateException("Created date cannot be null or empty");
        if (updatedDate == null || updatedDate.trim().isEmpty()) 
            throw new RealEstateException("Updated date cannot be null or empty");
        
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

class Agency extends Entity {
    private String agencyName;
    private String address;
    private String phoneNumber;
    private String email;

    public Agency(int id, String createdDate, String updatedDate, String agencyName, 
                   String address, String phoneNumber, String email) throws RealEstateException {
        super(id, createdDate, updatedDate);
        
        if (!phoneNumber.matches("\\d{10}")) 
            throw new RealEstateException("Phone number must be exactly 10 digits");
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new RealEstateException("Invalid email format");
        
        this.agencyName = agencyName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getAgencyName() { return agencyName; }
    public void setAgencyName(String agencyName) { this.agencyName = agencyName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

class Agent extends Agency {
    private String agentName;
    private String agentCode;

    public Agent(int id, String createdDate, String updatedDate, String agencyName,
                  String address, String phoneNumber, String email, String agentName,
                  String agentCode) throws RealEstateException {
        super(id, createdDate, updatedDate, agencyName, address, phoneNumber, email);
        
        if (agentCode.length() < 3 || !agentCode.matches("^[a-zA-Z0-9]+$")) 
            throw new RealEstateException("Agent code must be alphanumeric and at least 3 characters");
        
        this.agentName = agentName;
        this.agentCode = agentCode;
    }

    public String getAgentName() { return agentName; }
    public void setAgentName(String agentName) { this.agentName = agentName; }
    public String getAgentCode() { return agentCode; }
    public void setAgentCode(String agentCode) { this.agentCode = agentCode; }
}

class Property extends Agent {
    private String propertyType;
    private String location;
    private String propertyEmail;
    private String phone;

    public Property(int id, String createdDate, String updatedDate, String agencyName,
                  String address, String phoneNumber, String email, String agentName,
                  String agentCode, String propertyType, String location,
                  String propertyEmail, String phone) throws RealEstateException {
        super(id, createdDate, updatedDate, agencyName, address, phoneNumber, email,
              agentName, agentCode);
        
        if (propertyType == null || propertyType.trim().isEmpty()) 
            throw new RealEstateException("Property type cannot be empty");
        if (!propertyEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new RealEstateException("Invalid property email format");
        if (!phone.matches("\\d{10}")) 
            throw new RealEstateException("Property phone must be exactly 10 digits");
        
        this.propertyType = propertyType;
        this.location = location;
        this.propertyEmail = propertyEmail;
        this.phone = phone;
    }

    public String getPropertyType() { return propertyType; }
    public void setPropertyType(String propertyType) { this.propertyType = propertyType; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getPropertyEmail() { return propertyEmail; }
    public void setPropertyEmail(String propertyEmail) { this.propertyEmail = propertyEmail; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}

class Seller extends Property {
    private String sellerName;
    private String sellerType;
    private int yearsOwned;

    public Seller(int id, String createdDate, String updatedDate, String agencyName,
                String address, String phoneNumber, String email, String agentName,
                String agentCode, String propertyType, String location,
                String propertyEmail, String phone, String sellerName, String sellerType,
                int yearsOwned) throws RealEstateException {
        super(id, createdDate, updatedDate, agencyName, address, phoneNumber, email,
              agentName, agentCode, propertyType, location, propertyEmail, phone);
        
        if (!sellerType.equals("Individual") && !sellerType.equals("Corporate")) 
            throw new RealEstateException("Seller type must be 'Individual' or 'Corporate'");
        if (yearsOwned < 0) 
            throw new RealEstateException("Years owned must be >= 0");
        
        this.sellerName = sellerName;
        this.sellerType = sellerType;
        this.yearsOwned = yearsOwned;
    }

    public String getSellerName() { return sellerName; }
    public void setSellerName(String sellerName) { this.sellerName = sellerName; }
    public String getSellerType() { return sellerType; }
    public void setSellerType(String sellerType) { this.sellerType = sellerType; }
    public int getYearsOwned() { return yearsOwned; }
    public void setYearsOwned(int yearsOwned) { this.yearsOwned = yearsOwned; }
}

class Buyer extends Seller {
    private String buyerName;
    private int age;
    private String buyerType;
    private String contactNumber;

    public Buyer(int id, String createdDate, String updatedDate, String agencyName,
                  String address, String phoneNumber, String email, String agentName,
                  String agentCode, String propertyType, String location,
                  String propertyEmail, String phone, String sellerName, String sellerType,
                  int yearsOwned, String buyerName, int age, String buyerType,
                  String contactNumber) throws RealEstateException {
        super(id, createdDate, updatedDate, agencyName, address, phoneNumber, email,
              agentName, agentCode, propertyType, location, propertyEmail, phone,
              sellerName, sellerType, yearsOwned);
        
        if (age <= 0) throw new RealEstateException("Age must be > 0");
        if (!buyerType.equals("FirstTime") && !buyerType.equals("Investor") && !buyerType.equals("Corporate")) 
            throw new RealEstateException("Buyer type must be 'FirstTime', 'Investor', or 'Corporate'");
        
        this.buyerName = buyerName;
        this.age = age;
        this.buyerType = buyerType;
        this.contactNumber = contactNumber;
    }

    public String getBuyerName() { return buyerName; }
    public void setBuyerName(String buyerName) { this.buyerName = buyerName; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getBuyerType() { return buyerType; }
    public void setBuyerType(String buyerType) { this.buyerType = buyerType; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}

class Agreement extends Buyer {
    private String agreementDate;
    private int agreementNumber;
    private double agreementFee;

    public Agreement(int id, String createdDate, String updatedDate, String agencyName,
                    String address, String phoneNumber, String email, String agentName,
                    String agentCode, String propertyType, String location,
                    String propertyEmail, String phone, String sellerName, String sellerType,
                    int yearsOwned, String buyerName, int age, String buyerType,
                    String contactNumber, String agreementDate, int agreementNumber,
                    double agreementFee) throws RealEstateException {
        super(id, createdDate, updatedDate, agencyName, address, phoneNumber, email,
              agentName, agentCode, propertyType, location, propertyEmail, phone,
              sellerName, sellerType, yearsOwned, buyerName, age, buyerType, contactNumber);
        
        if (agreementDate == null || agreementDate.trim().isEmpty()) 
            throw new RealEstateException("Agreement date cannot be null");
        if (agreementFee <= 0) 
            throw new RealEstateException("Agreement fee must be > 0");
        
        this.agreementDate = agreementDate;
        this.agreementNumber = agreementNumber;
        this.agreementFee = agreementFee;
    }

    public String getAgreementDate() { return agreementDate; }
    public void setAgreementDate(String agreementDate) { this.agreementDate = agreementDate; }
    public int getAgreementNumber() { return agreementNumber; }
    public void setAgreementNumber(int agreementNumber) { this.agreementNumber = agreementNumber; }
    public double getAgreementFee() { return agreementFee; }
    public void setAgreementFee(double agreementFee) { this.agreementFee = agreementFee; }
}

class Payment extends Agreement {
    private String paymentMethod;
    private String transactionId;
    private double price;

    public Payment(int id, String createdDate, String updatedDate, String agencyName,
                    String address, String phoneNumber, String email, String agentName,
                    String agentCode, String propertyType, String location,
                    String propertyEmail, String phone, String sellerName, String sellerType,
                    int yearsOwned, String buyerName, int age, String buyerType,
                    String contactNumber, String agreementDate, int agreementNumber,
                    double agreementFee, String paymentMethod, String transactionId,
                    double price) throws RealEstateException {
        super(id, createdDate, updatedDate, agencyName, address, phoneNumber, email,
              agentName, agentCode, propertyType, location, propertyEmail, phone,
              sellerName, sellerType, yearsOwned, buyerName, age, buyerType, contactNumber,
              agreementDate, agreementNumber, agreementFee);
        
        if (price <= 0) 
            throw new RealEstateException("Price must be > 0");
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) 
            throw new RealEstateException("Payment method cannot be empty");
        if (transactionId == null || transactionId.trim().isEmpty()) 
            throw new RealEstateException("Transaction ID cannot be empty");
        
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.price = price;
    }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

class Commission extends Payment {
    private double commissionRate;
    private double taxRate;
    private double totalCommission;

    public Commission(int id, String createdDate, String updatedDate, String agencyName,
               String address, String phoneNumber, String email, String agentName,
               String agentCode, String propertyType, String location,
               String propertyEmail, String phone, String sellerName, String sellerType,
               int yearsOwned, String buyerName, int age, String buyerType,
               String contactNumber, String agreementDate, int agreementNumber,
               double agreementFee, String paymentMethod, String transactionId,
               double price, double commissionRate, double taxRate) 
               throws RealEstateException {
        super(id, createdDate, updatedDate, agencyName, address, phoneNumber, email,
              agentName, agentCode, propertyType, location, propertyEmail, phone,
              sellerName, sellerType, yearsOwned, buyerName, age, buyerType, contactNumber,
              agreementDate, agreementNumber, agreementFee, paymentMethod, transactionId, price);
        
        if (commissionRate <= 0) throw new RealEstateException("Commission rate must be > 0");
        if (taxRate < 0) throw new RealEstateException("Tax rate must be >= 0");
        
        this.commissionRate = commissionRate;
        this.taxRate = taxRate;
        this.totalCommission = 0;
    }

    public double getCommissionRate() { return commissionRate; }
    public void setCommissionRate(double commissionRate) { this.commissionRate = commissionRate; }
    public double getTaxRate() { return taxRate; }
    public void setTaxRate(double taxRate) { this.taxRate = taxRate; }
    public double getTotalCommission() { return totalCommission; }
    public void setTotalCommission(double totalCommission) { this.totalCommission = totalCommission; }
}

final class RealEstateRecord extends Commission {
    public RealEstateRecord(int id, String createdDate, String updatedDate, String agencyName,
                         String address, String phoneNumber, String email, String agentName,
                         String agentCode, String propertyType, String location,
                         String propertyEmail, String phone, String sellerName, String sellerType,
                         int yearsOwned, String buyerName, int age, String buyerType,
                         String contactNumber, String agreementDate, int agreementNumber,
                         double agreementFee, String paymentMethod, String transactionId,
                         double price, double commissionRate, double taxRate) 
                         throws RealEstateException {
        super(id, createdDate, updatedDate, agencyName, address, phoneNumber, email,
              agentName, agentCode, propertyType, location, propertyEmail, phone,
              sellerName, sellerType, yearsOwned, buyerName, age, buyerType, contactNumber,
              agreementDate, agreementNumber, agreementFee, paymentMethod, transactionId, price,
              commissionRate, taxRate);
    }

    public double calculateCommission() {
        double commission = (getPrice() * getCommissionRate()) / 100;
        setTotalCommission(commission);
        return commission;
    }

    public void displayRecord() {
        System.out.println("\n" + Question7_RealEstateManagement.STUDENT_ID + " - ========== REAL ESTATE MANAGEMENT SYSTEM ==========");
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Record ID: " + getId());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Created Date: " + getCreatedDate());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Updated Date: " + getUpdatedDate());
        System.out.println("\n" + Question7_RealEstateManagement.STUDENT_ID + " - --- Agency Details ---");
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Agency Name: " + getAgencyName());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Address: " + getAddress());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Phone: " + getPhoneNumber());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Email: " + getEmail());
        System.out.println("\n" + Question7_RealEstateManagement.STUDENT_ID + " - --- Agent Details ---");
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Agent Name: " + getAgentName());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Agent Code: " + getAgentCode());
        System.out.println("\n" + Question7_RealEstateManagement.STUDENT_ID + " - --- Property Details ---");
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Property Type: " + getPropertyType());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Location: " + getLocation());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Property Email: " + getPropertyEmail());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Property Phone: " + getPhone());
        System.out.println("\n" + Question7_RealEstateManagement.STUDENT_ID + " - --- Seller Details ---");
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Seller Name: " + getSellerName());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Seller Type: " + getSellerType());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Years Owned: " + getYearsOwned());
        System.out.println("\n" + Question7_RealEstateManagement.STUDENT_ID + " - --- Buyer Details ---");
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Buyer Name: " + getBuyerName());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Age: " + getAge());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Buyer Type: " + getBuyerType());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Contact Number: " + getContactNumber());
        System.out.println("\n" + Question7_RealEstateManagement.STUDENT_ID + " - --- Agreement Details ---");
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Agreement Date: " + getAgreementDate());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Agreement Number: " + getAgreementNumber());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Agreement Fee: $" + getAgreementFee());
        System.out.println("\n" + Question7_RealEstateManagement.STUDENT_ID + " - --- Payment Details ---");
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Payment Method: " + getPaymentMethod());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Transaction ID: " + getTransactionId());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Price: $" + getPrice());
        System.out.println("\n" + Question7_RealEstateManagement.STUDENT_ID + " - --- Commission Details ---");
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Commission Rate: " + getCommissionRate() + "%");
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Tax Rate: " + getTaxRate() + "%");
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Total Commission: $" + getTotalCommission());
        System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - ===================================================\n");
    }
}

public class Question7_RealEstateManagement {
    public static final String STUDENT_ID = "27264";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - ========== REAL ESTATE MANAGEMENT SYSTEM ==========\n");
            
            System.out.print("Enter Record ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Created Date (YYYY-MM-DD): ");
            String createdDate = scanner.nextLine();
            
            System.out.print("Enter Updated Date (YYYY-MM-DD): ");
            String updatedDate = scanner.nextLine();
            
            System.out.print("Enter Agency Name: ");
            String agencyName = scanner.nextLine();
            
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            
            System.out.print("Enter Agency Phone (10 digits): ");
            String phoneNumber = scanner.nextLine();
            
            System.out.print("Enter Agency Email: ");
            String email = scanner.nextLine();
            
            System.out.print("Enter Agent Name: ");
            String agentName = scanner.nextLine();
            
            System.out.print("Enter Agent Code (alphanumeric, min 3 chars): ");
            String agentCode = scanner.nextLine();
            
            System.out.print("Enter Property Type: ");
            String propertyType = scanner.nextLine();
            
            System.out.print("Enter Location: ");
            String location = scanner.nextLine();
            
            System.out.print("Enter Property Email: ");
            String propertyEmail = scanner.nextLine();
            
            System.out.print("Enter Property Phone (10 digits): ");
            String propertyPhone = scanner.nextLine();
            
            System.out.print("Enter Seller Name: ");
            String sellerName = scanner.nextLine();
            
            System.out.print("Enter Seller Type (Individual/Corporate): ");
            String sellerType = scanner.nextLine();
            
            System.out.print("Enter Years Owned: ");
            int yearsOwned = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Buyer Name: ");
            String buyerName = scanner.nextLine();
            
            System.out.print("Enter Buyer Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Buyer Type (FirstTime/Investor/Corporate): ");
            String buyerType = scanner.nextLine();
            
            System.out.print("Enter Contact Number: ");
            String contactNumber = scanner.nextLine();
            
            System.out.print("Enter Agreement Date (YYYY-MM-DD): ");
            String agreementDate = scanner.nextLine();
            
            System.out.print("Enter Agreement Number: ");
            int agreementNumber = scanner.nextInt();
            
            System.out.print("Enter Agreement Fee: ");
            double agreementFee = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Enter Payment Method: ");
            String paymentMethod = scanner.nextLine();
            
            System.out.print("Enter Transaction ID: ");
            String transactionId = scanner.nextLine();
            
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            
            System.out.print("Enter Commission Rate (%): ");
            double commissionRate = scanner.nextDouble();
            
            System.out.print("Enter Tax Rate (%): ");
            double taxRate = scanner.nextDouble();
            
            RealEstateRecord record = new RealEstateRecord(id, createdDate, updatedDate, agencyName,
                address, phoneNumber, email, agentName, agentCode, propertyType, location,
                propertyEmail, propertyPhone, sellerName, sellerType, yearsOwned,
                buyerName, age, buyerType, contactNumber, agreementDate, agreementNumber, agreementFee,
                paymentMethod, transactionId, price, commissionRate, taxRate);
            
            record.calculateCommission();
            record.displayRecord();
            
        } catch (RealEstateException e) {
            System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(Question7_RealEstateManagement.STUDENT_ID + " - Input Error: Please enter valid data");
        } finally {
            scanner.close();
        }
    }
}
