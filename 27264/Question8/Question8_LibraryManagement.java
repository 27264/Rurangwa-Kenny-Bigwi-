import java.util.Scanner;

class LibraryException extends Exception {
    public LibraryException(String message) {
        super(message);
    }
}

class LibraryEntity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public LibraryEntity(int id, String createdDate, String updatedDate) throws LibraryException {
        if (id <= 0) throw new LibraryException("ID must be greater than 0");
        if (createdDate == null || createdDate.trim().isEmpty()) 
            throw new LibraryException("Created date cannot be null or empty");
        if (updatedDate == null || updatedDate.trim().isEmpty()) 
            throw new LibraryException("Updated date cannot be null or empty");
        
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

class LibrarySystem extends LibraryEntity {
    private String libraryName;
    private String address;
    private String phoneNumber;
    private String email;

    public LibrarySystem(int id, String createdDate, String updatedDate, String libraryName, 
                   String address, String phoneNumber, String email) throws LibraryException {
        super(id, createdDate, updatedDate);
        
        if (!phoneNumber.matches("\\d{10}")) 
            throw new LibraryException("Phone number must be exactly 10 digits");
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new LibraryException("Invalid email format");
        
        this.libraryName = libraryName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getLibraryName() { return libraryName; }
    public void setLibraryName(String libraryName) { this.libraryName = libraryName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

class LibrarySection extends LibrarySystem {
    private String sectionName;
    private String sectionCode;

    public LibrarySection(int id, String createdDate, String updatedDate, String libraryName,
                  String address, String phoneNumber, String email, String sectionName,
                  String sectionCode) throws LibraryException {
        super(id, createdDate, updatedDate, libraryName, address, phoneNumber, email);
        
        if (sectionCode.length() < 3 || !sectionCode.matches("^[a-zA-Z0-9]+$")) 
            throw new LibraryException("Section code must be alphanumeric and at least 3 characters");
        
        this.sectionName = sectionName;
        this.sectionCode = sectionCode;
    }

    public String getSectionName() { return sectionName; }
    public void setSectionName(String sectionName) { this.sectionName = sectionName; }
    public String getSectionCode() { return sectionCode; }
    public void setSectionCode(String sectionCode) { this.sectionCode = sectionCode; }
}

class LibraryBook extends LibrarySection {
    private String bookTitle;
    private String author;
    private String bookEmail;
    private String phone;

    public LibraryBook(int id, String createdDate, String updatedDate, String libraryName,
                  String address, String phoneNumber, String email, String sectionName,
                  String sectionCode, String bookTitle, String author,
                  String bookEmail, String phone) throws LibraryException {
        super(id, createdDate, updatedDate, libraryName, address, phoneNumber, email,
              sectionName, sectionCode);
        
        if (author == null || author.trim().isEmpty()) 
            throw new LibraryException("Author cannot be empty");
        if (!bookEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new LibraryException("Invalid book email format");
        if (!phone.matches("\\d{10}")) 
            throw new LibraryException("Book phone must be exactly 10 digits");
        
        this.bookTitle = bookTitle;
        this.author = author;
        this.bookEmail = bookEmail;
        this.phone = phone;
    }

    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getBookEmail() { return bookEmail; }
    public void setBookEmail(String bookEmail) { this.bookEmail = bookEmail; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}

class LibraryMember extends LibraryBook {
    private String memberName;
    private String membershipType;
    private int yearsOfMembership;

    public LibraryMember(int id, String createdDate, String updatedDate, String libraryName,
                String address, String phoneNumber, String email, String sectionName,
                String sectionCode, String bookTitle, String author,
                String bookEmail, String phone, String memberName, String membershipType,
                int yearsOfMembership) throws LibraryException {
        super(id, createdDate, updatedDate, libraryName, address, phoneNumber, email,
              sectionName, sectionCode, bookTitle, author, bookEmail, phone);
        
        if (!membershipType.equals("Regular") && !membershipType.equals("Premium")) 
            throw new LibraryException("Membership type must be 'Regular' or 'Premium'");
        if (yearsOfMembership < 0) 
            throw new LibraryException("Years of membership must be >= 0");
        
        this.memberName = memberName;
        this.membershipType = membershipType;
        this.yearsOfMembership = yearsOfMembership;
    }

    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }
    public int getYearsOfMembership() { return yearsOfMembership; }
    public void setYearsOfMembership(int yearsOfMembership) { this.yearsOfMembership = yearsOfMembership; }
}

class LibraryBorrow extends LibraryMember {
    private String borrowDate;
    private int borrowDays;
    private String returnStatus;
    private String contactNumber;

    public LibraryBorrow(int id, String createdDate, String updatedDate, String libraryName,
                  String address, String phoneNumber, String email, String sectionName,
                  String sectionCode, String bookTitle, String author,
                  String bookEmail, String phone, String memberName, String membershipType,
                  int yearsOfMembership, String borrowDate, int borrowDays, String returnStatus,
                  String contactNumber) throws LibraryException {
        super(id, createdDate, updatedDate, libraryName, address, phoneNumber, email,
              sectionName, sectionCode, bookTitle, author, bookEmail, phone,
              memberName, membershipType, yearsOfMembership);
        
        if (borrowDays <= 0) throw new LibraryException("Borrow days must be > 0");
        if (!returnStatus.equals("Returned") && !returnStatus.equals("NotReturned") && !returnStatus.equals("Lost")) 
            throw new LibraryException("Return status must be 'Returned', 'NotReturned', or 'Lost'");
        
        this.borrowDate = borrowDate;
        this.borrowDays = borrowDays;
        this.returnStatus = returnStatus;
        this.contactNumber = contactNumber;
    }

    public String getBorrowDate() { return borrowDate; }
    public void setBorrowDate(String borrowDate) { this.borrowDate = borrowDate; }
    public int getBorrowDays() { return borrowDays; }
    public void setBorrowDays(int borrowDays) { this.borrowDays = borrowDays; }
    public String getReturnStatus() { return returnStatus; }
    public void setReturnStatus(String returnStatus) { this.returnStatus = returnStatus; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}

class LibraryFine extends LibraryBorrow {
    private String fineReason;
    private int daysLate;
    private double fineAmount;

    public LibraryFine(int id, String createdDate, String updatedDate, String libraryName,
                    String address, String phoneNumber, String email, String sectionName,
                    String sectionCode, String bookTitle, String author,
                    String bookEmail, String phone, String memberName, String membershipType,
                    int yearsOfMembership, String borrowDate, int borrowDays, String returnStatus,
                    String contactNumber, String fineReason, int daysLate,
                    double fineAmount) throws LibraryException {
        super(id, createdDate, updatedDate, libraryName, address, phoneNumber, email,
              sectionName, sectionCode, bookTitle, author, bookEmail, phone,
              memberName, membershipType, yearsOfMembership, borrowDate, borrowDays, returnStatus, contactNumber);
        
        if (fineReason == null || fineReason.trim().isEmpty()) 
            throw new LibraryException("Fine reason cannot be null");
        if (fineAmount < 0) 
            throw new LibraryException("Fine amount must be >= 0");
        
        this.fineReason = fineReason;
        this.daysLate = daysLate;
        this.fineAmount = fineAmount;
    }

    public String getFineReason() { return fineReason; }
    public void setFineReason(String fineReason) { this.fineReason = fineReason; }
    public int getDaysLate() { return daysLate; }
    public void setDaysLate(int daysLate) { this.daysLate = daysLate; }
    public double getFineAmount() { return fineAmount; }
    public void setFineAmount(double fineAmount) { this.fineAmount = fineAmount; }
}

class LibraryPayment extends LibraryFine {
    private String paymentMethod;
    private String transactionId;
    private double paymentAmount;

    public LibraryPayment(int id, String createdDate, String updatedDate, String libraryName,
                    String address, String phoneNumber, String email, String sectionName,
                    String sectionCode, String bookTitle, String author,
                    String bookEmail, String phone, String memberName, String membershipType,
                    int yearsOfMembership, String borrowDate, int borrowDays, String returnStatus,
                    String contactNumber, String fineReason, int daysLate,
                    double fineAmount, String paymentMethod, String transactionId,
                    double paymentAmount) throws LibraryException {
        super(id, createdDate, updatedDate, libraryName, address, phoneNumber, email,
              sectionName, sectionCode, bookTitle, author, bookEmail, phone,
              memberName, membershipType, yearsOfMembership, borrowDate, borrowDays, returnStatus, contactNumber,
              fineReason, daysLate, fineAmount);
        
        if (paymentAmount < 0) 
            throw new LibraryException("Payment amount must be >= 0");
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) 
            throw new LibraryException("Payment method cannot be empty");
        if (transactionId == null || transactionId.trim().isEmpty()) 
            throw new LibraryException("Transaction ID cannot be empty");
        
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public double getPaymentAmount() { return paymentAmount; }
    public void setPaymentAmount(double paymentAmount) { this.paymentAmount = paymentAmount; }
}

class LibraryRecordData extends LibraryPayment {
    private double processingFee;
    private double membershipFee;
    private double totalFine;

    public LibraryRecordData(int id, String createdDate, String updatedDate, String libraryName,
               String address, String phoneNumber, String email, String sectionName,
               String sectionCode, String bookTitle, String author,
               String bookEmail, String phone, String memberName, String membershipType,
               int yearsOfMembership, String borrowDate, int borrowDays, String returnStatus,
               String contactNumber, String fineReason, int daysLate,
               double fineAmount, String paymentMethod, String transactionId,
               double paymentAmount, double processingFee, double membershipFee) 
               throws LibraryException {
        super(id, createdDate, updatedDate, libraryName, address, phoneNumber, email,
              sectionName, sectionCode, bookTitle, author, bookEmail, phone,
              memberName, membershipType, yearsOfMembership, borrowDate, borrowDays, returnStatus, contactNumber,
              fineReason, daysLate, fineAmount, paymentMethod, transactionId, paymentAmount);
        
        if (processingFee < 0) throw new LibraryException("Processing fee must be >= 0");
        if (membershipFee < 0) throw new LibraryException("Membership fee must be >= 0");
        
        this.processingFee = processingFee;
        this.membershipFee = membershipFee;
        this.totalFine = 0;
    }

    public double getProcessingFee() { return processingFee; }
    public void setProcessingFee(double processingFee) { this.processingFee = processingFee; }
    public double getMembershipFee() { return membershipFee; }
    public void setMembershipFee(double membershipFee) { this.membershipFee = membershipFee; }
    public double getTotalFine() { return totalFine; }
    public void setTotalFine(double totalFine) { this.totalFine = totalFine; }
}

final class LibraryManagementRecord extends LibraryRecordData {
    public LibraryManagementRecord(int id, String createdDate, String updatedDate, String libraryName,
                         String address, String phoneNumber, String email, String sectionName,
                         String sectionCode, String bookTitle, String author,
                         String bookEmail, String phone, String memberName, String membershipType,
                         int yearsOfMembership, String borrowDate, int borrowDays, String returnStatus,
                         String contactNumber, String fineReason, int daysLate,
                         double fineAmount, String paymentMethod, String transactionId,
                         double paymentAmount, double processingFee, double membershipFee) 
                         throws LibraryException {
        super(id, createdDate, updatedDate, libraryName, address, phoneNumber, email,
              sectionName, sectionCode, bookTitle, author, bookEmail, phone,
              memberName, membershipType, yearsOfMembership, borrowDate, borrowDays, returnStatus, contactNumber,
              fineReason, daysLate, fineAmount, paymentMethod, transactionId, paymentAmount,
              processingFee, membershipFee);
    }

    public double calculateFine() {
        double total = getFineAmount() * getDaysLate();
        setTotalFine(total);
        return total;
    }

    public void displayRecord() {
        System.out.println("\n" + Question8_LibraryManagement.STUDENT_ID + " - ========== LIBRARY MANAGEMENT SYSTEM ==========");
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Record ID: " + getId());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Created Date: " + getCreatedDate());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Updated Date: " + getUpdatedDate());
        System.out.println("\n" + Question8_LibraryManagement.STUDENT_ID + " - --- Library Details ---");
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Library Name: " + getLibraryName());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Address: " + getAddress());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Phone: " + getPhoneNumber());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Email: " + getEmail());
        System.out.println("\n" + Question8_LibraryManagement.STUDENT_ID + " - --- Section Details ---");
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Section Name: " + getSectionName());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Section Code: " + getSectionCode());
        System.out.println("\n" + Question8_LibraryManagement.STUDENT_ID + " - --- Book Details ---");
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Book Title: " + getBookTitle());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Author: " + getAuthor());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Book Email: " + getBookEmail());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Book Phone: " + getPhone());
        System.out.println("\n" + Question8_LibraryManagement.STUDENT_ID + " - --- Member Details ---");
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Member Name: " + getMemberName());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Membership Type: " + getMembershipType());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Years of Membership: " + getYearsOfMembership());
        System.out.println("\n" + Question8_LibraryManagement.STUDENT_ID + " - --- Borrow Details ---");
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Borrow Date: " + getBorrowDate());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Borrow Days: " + getBorrowDays());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Return Status: " + getReturnStatus());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Contact Number: " + getContactNumber());
        System.out.println("\n" + Question8_LibraryManagement.STUDENT_ID + " - --- Fine Details ---");
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Fine Reason: " + getFineReason());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Days Late: " + getDaysLate());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Fine Amount: $" + getFineAmount());
        System.out.println("\n" + Question8_LibraryManagement.STUDENT_ID + " - --- Payment Details ---");
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Payment Method: " + getPaymentMethod());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Transaction ID: " + getTransactionId());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Payment Amount: $" + getPaymentAmount());
        System.out.println("\n" + Question8_LibraryManagement.STUDENT_ID + " - --- Record Details ---");
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Processing Fee: $" + getProcessingFee());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Membership Fee: $" + getMembershipFee());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Total Fine: $" + getTotalFine());
        System.out.println(Question8_LibraryManagement.STUDENT_ID + " - ===============================================\n");
    }
}

public class Question8_LibraryManagement {
    public static final String STUDENT_ID = "27264";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println(Question8_LibraryManagement.STUDENT_ID + " - ========== LIBRARY MANAGEMENT SYSTEM ==========\n");
            
            System.out.print("Enter Record ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Created Date (YYYY-MM-DD): ");
            String createdDate = scanner.nextLine();
            
            System.out.print("Enter Updated Date (YYYY-MM-DD): ");
            String updatedDate = scanner.nextLine();
            
            System.out.print("Enter Library Name: ");
            String libraryName = scanner.nextLine();
            
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            
            System.out.print("Enter Library Phone (10 digits): ");
            String phoneNumber = scanner.nextLine();
            
            System.out.print("Enter Library Email: ");
            String email = scanner.nextLine();
            
            System.out.print("Enter Section Name: ");
            String sectionName = scanner.nextLine();
            
            System.out.print("Enter Section Code (alphanumeric, min 3 chars): ");
            String sectionCode = scanner.nextLine();
            
            System.out.print("Enter Book Title: ");
            String bookTitle = scanner.nextLine();
            
            System.out.print("Enter Author: ");
            String author = scanner.nextLine();
            
            System.out.print("Enter Book Email: ");
            String bookEmail = scanner.nextLine();
            
            System.out.print("Enter Book Phone (10 digits): ");
            String bookPhone = scanner.nextLine();
            
            System.out.print("Enter Member Name: ");
            String memberName = scanner.nextLine();
            
            System.out.print("Enter Membership Type (Regular/Premium): ");
            String membershipType = scanner.nextLine();
            
            System.out.print("Enter Years of Membership: ");
            int yearsOfMembership = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Borrow Date (YYYY-MM-DD): ");
            String borrowDate = scanner.nextLine();
            
            System.out.print("Enter Borrow Days: ");
            int borrowDays = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Return Status (Returned/NotReturned/Lost): ");
            String returnStatus = scanner.nextLine();
            
            System.out.print("Enter Contact Number: ");
            String contactNumber = scanner.nextLine();
            
            System.out.print("Enter Fine Reason: ");
            String fineReason = scanner.nextLine();
            
            System.out.print("Enter Days Late: ");
            int daysLate = scanner.nextInt();
            
            System.out.print("Enter Fine Amount: ");
            double fineAmount = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Enter Payment Method: ");
            String paymentMethod = scanner.nextLine();
            
            System.out.print("Enter Transaction ID: ");
            String transactionId = scanner.nextLine();
            
            System.out.print("Enter Payment Amount: ");
            double paymentAmount = scanner.nextDouble();
            
            System.out.print("Enter Processing Fee: ");
            double processingFee = scanner.nextDouble();
            
            System.out.print("Enter Membership Fee: ");
            double membershipFee = scanner.nextDouble();
            
            LibraryManagementRecord record = new LibraryManagementRecord(id, createdDate, updatedDate, libraryName,
                address, phoneNumber, email, sectionName, sectionCode, bookTitle, author,
                bookEmail, bookPhone, memberName, membershipType, yearsOfMembership,
                borrowDate, borrowDays, returnStatus, contactNumber, fineReason, daysLate, fineAmount,
                paymentMethod, transactionId, paymentAmount, processingFee, membershipFee);
            
            record.calculateFine();
            record.displayRecord();
            
        } catch (LibraryException e) {
            System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(Question8_LibraryManagement.STUDENT_ID + " - Input Error: Please enter valid data");
        } finally {
            scanner.close();
        }
    }
}
