import java.util.Scanner;

class HotelDataException extends Exception {
    public HotelDataException(String message) {
        super(message);
    }
}

class Entity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public Entity(int id, String createdDate, String updatedDate) throws HotelDataException {
        if (id <= 0) throw new HotelDataException("ID must be greater than 0");
        if (createdDate == null || createdDate.trim().isEmpty()) 
            throw new HotelDataException("Created date cannot be null or empty");
        if (updatedDate == null || updatedDate.trim().isEmpty()) 
            throw new HotelDataException("Updated date cannot be null or empty");
        
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

class Hotel extends Entity {
    private String hotelName;
    private String address;
    private String phoneNumber;
    private String email;

    public Hotel(int id, String createdDate, String updatedDate, String hotelName, 
                   String address, String phoneNumber, String email) throws HotelDataException {
        super(id, createdDate, updatedDate);
        
        if (!phoneNumber.matches("\\d{10}")) 
            throw new HotelDataException("Phone number must be exactly 10 digits");
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new HotelDataException("Invalid email format");
        
        this.hotelName = hotelName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getHotelName() { return hotelName; }
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

class Room extends Hotel {
    private int roomNumber;
    private String roomType;
    private double roomPrice;

    public Room(int id, String createdDate, String updatedDate, String hotelName,
                     String address, String phoneNumber, String email, int roomNumber,
                     String roomType, double roomPrice) throws HotelDataException {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email);
        
        if (roomNumber <= 0) 
            throw new HotelDataException("Room number must be > 0");
        if (roomPrice <= 0) 
            throw new HotelDataException("Room price must be > 0");
        
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }
    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    public double getRoomPrice() { return roomPrice; }
    public void setRoomPrice(double roomPrice) { this.roomPrice = roomPrice; }
}

class Customer extends Room {
    private String customerName;
    private String customerEmail;
    private String phone;
    private String idProof;

    public Customer(int id, String createdDate, String updatedDate, String hotelName,
                  String address, String phoneNumber, String email, int roomNumber,
                  String roomType, double roomPrice, String customerName, String customerEmail,
                  String phone, String idProof) throws HotelDataException {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email,
              roomNumber, roomType, roomPrice);
        
        if (!customerEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new HotelDataException("Invalid customer email format");
        if (!phone.matches("\\d{10}")) 
            throw new HotelDataException("Customer phone must be exactly 10 digits");
        if (idProof == null || idProof.trim().isEmpty()) 
            throw new HotelDataException("ID proof cannot be empty");
        
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.phone = phone;
        this.idProof = idProof;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getIdProof() { return idProof; }
    public void setIdProof(String idProof) { this.idProof = idProof; }
}

class Booking extends Customer {
    private String checkInDate;
    private String checkOutDate;
    private int numberOfDays;

    public Booking(int id, String createdDate, String updatedDate, String hotelName,
                   String address, String phoneNumber, String email, int roomNumber,
                   String roomType, double roomPrice, String customerName, String customerEmail,
                   String phone, String idProof, String checkInDate, String checkOutDate,
                   int numberOfDays) throws HotelDataException {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email,
              roomNumber, roomType, roomPrice, customerName, customerEmail, phone, idProof);
        
        if (checkInDate == null || checkInDate.trim().isEmpty()) 
            throw new HotelDataException("Check-in date cannot be empty");
        if (checkOutDate == null || checkOutDate.trim().isEmpty()) 
            throw new HotelDataException("Check-out date cannot be empty");
        if (numberOfDays <= 0) 
            throw new HotelDataException("Number of days must be > 0");
        
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfDays = numberOfDays;
    }

    public String getCheckInDate() { return checkInDate; }
    public void setCheckInDate(String checkInDate) { this.checkInDate = checkInDate; }
    public String getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(String checkOutDate) { this.checkOutDate = checkOutDate; }
    public int getNumberOfDays() { return numberOfDays; }
    public void setNumberOfDays(int numberOfDays) { this.numberOfDays = numberOfDays; }
}

class Service extends Booking {
    private String serviceName;
    private double serviceCharge;
    private String serviceDate;

    public Service(int id, String createdDate, String updatedDate, String hotelName,
                   String address, String phoneNumber, String email, int roomNumber,
                   String roomType, double roomPrice, String customerName, String customerEmail,
                   String phone, String idProof, String checkInDate, String checkOutDate,
                   int numberOfDays, String serviceName, double serviceCharge,
                   String serviceDate) throws HotelDataException {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email,
              roomNumber, roomType, roomPrice, customerName, customerEmail, phone, idProof,
              checkInDate, checkOutDate, numberOfDays);
        
        if (serviceName == null || serviceName.trim().isEmpty()) 
            throw new HotelDataException("Service name cannot be empty");
        if (serviceCharge < 0) 
            throw new HotelDataException("Service charge must be >= 0");
        
        this.serviceName = serviceName;
        this.serviceCharge = serviceCharge;
        this.serviceDate = serviceDate;
    }

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
    public double getServiceCharge() { return serviceCharge; }
    public void setServiceCharge(double serviceCharge) { this.serviceCharge = serviceCharge; }
    public String getServiceDate() { return serviceDate; }
    public void setServiceDate(String serviceDate) { this.serviceDate = serviceDate; }
}

class Payment extends Service {
    private String paymentMethod;
    private String paymentDate;
    private double amountPaid;

    public Payment(int id, String createdDate, String updatedDate, String hotelName,
                   String address, String phoneNumber, String email, int roomNumber,
                   String roomType, double roomPrice, String customerName, String customerEmail,
                   String phone, String idProof, String checkInDate, String checkOutDate,
                   int numberOfDays, String serviceName, double serviceCharge,
                   String serviceDate, String paymentMethod, String paymentDate,
                   double amountPaid) throws HotelDataException {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email,
              roomNumber, roomType, roomPrice, customerName, customerEmail, phone, idProof,
              checkInDate, checkOutDate, numberOfDays, serviceName, serviceCharge, serviceDate);
        
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) 
            throw new HotelDataException("Payment method cannot be empty");
        if (amountPaid < 0) 
            throw new HotelDataException("Amount paid must be >= 0");
        
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

class Bill extends Payment {
    private double roomCharge;
    private double totalBill;

    public Bill(int id, String createdDate, String updatedDate, String hotelName,
               String address, String phoneNumber, String email, int roomNumber,
               String roomType, double roomPrice, String customerName, String customerEmail,
               String phone, String idProof, String checkInDate, String checkOutDate,
               int numberOfDays, String serviceName, double serviceCharge,
               String serviceDate, String paymentMethod, String paymentDate,
               double amountPaid, double roomCharge) throws HotelDataException {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email,
              roomNumber, roomType, roomPrice, customerName, customerEmail, phone, idProof,
              checkInDate, checkOutDate, numberOfDays, serviceName, serviceCharge, serviceDate,
              paymentMethod, paymentDate, amountPaid);
        
        if (roomCharge <= 0) throw new HotelDataException("Room charge must be > 0");
        
        this.roomCharge = roomCharge;
        this.totalBill = 0;
    }

    public double getRoomCharge() { return roomCharge; }
    public void setRoomCharge(double roomCharge) { this.roomCharge = roomCharge; }
    public double getTotalBill() { return totalBill; }
    public void setTotalBill(double totalBill) { this.totalBill = totalBill; }
}

class Feedback extends Bill {
    private int rating;
    private String comments;

    public Feedback(int id, String createdDate, String updatedDate, String hotelName,
                   String address, String phoneNumber, String email, int roomNumber,
                   String roomType, double roomPrice, String customerName, String customerEmail,
                   String phone, String idProof, String checkInDate, String checkOutDate,
                   int numberOfDays, String serviceName, double serviceCharge,
                   String serviceDate, String paymentMethod, String paymentDate,
                   double amountPaid, double roomCharge, int rating, String comments) 
                   throws HotelDataException {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email,
              roomNumber, roomType, roomPrice, customerName, customerEmail, phone, idProof,
              checkInDate, checkOutDate, numberOfDays, serviceName, serviceCharge, serviceDate,
              paymentMethod, paymentDate, amountPaid, roomCharge);
        
        if (rating < 1 || rating > 5) 
            throw new HotelDataException("Rating must be between 1 and 5");
        
        this.rating = rating;
        this.comments = comments;
    }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
}

final class ReservationRecord extends Feedback {
    public ReservationRecord(int id, String createdDate, String updatedDate, String hotelName,
                            String address, String phoneNumber, String email, int roomNumber,
                            String roomType, double roomPrice, String customerName, String customerEmail,
                            String phone, String idProof, String checkInDate, String checkOutDate,
                            int numberOfDays, String serviceName, double serviceCharge,
                            String serviceDate, String paymentMethod, String paymentDate,
                            double amountPaid, double roomCharge, int rating, String comments) 
                            throws HotelDataException {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email,
              roomNumber, roomType, roomPrice, customerName, customerEmail, phone, idProof,
              checkInDate, checkOutDate, numberOfDays, serviceName, serviceCharge, serviceDate,
              paymentMethod, paymentDate, amountPaid, roomCharge, rating, comments);
    }

    public double generateBill() {
        double total = getRoomCharge() + getServiceCharge();
        setTotalBill(total);
        return total;
    }

    public void displayRecord() {
        System.out.println("\n========== HOTEL RESERVATION SYSTEM ==========");
        System.out.println("Record ID: " + getId());
        System.out.println("Created Date: " + getCreatedDate());
        System.out.println("Updated Date: " + getUpdatedDate());
        System.out.println("\n--- Hotel Details ---");
        System.out.println("Hotel Name: " + getHotelName());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
        System.out.println("\n--- Room Details ---");
        System.out.println("Room Number: " + getRoomNumber());
        System.out.println("Room Type: " + getRoomType());
        System.out.println("Room Price: $" + getRoomPrice());
        System.out.println("\n--- Customer Details ---");
        System.out.println("Customer Name: " + getCustomerName());
        System.out.println("Customer Email: " + getCustomerEmail());
        System.out.println("Customer Phone: " + getPhone());
        System.out.println("ID Proof: " + getIdProof());
        System.out.println("\n--- Booking Details ---");
        System.out.println("Check-In Date: " + getCheckInDate());
        System.out.println("Check-Out Date: " + getCheckOutDate());
        System.out.println("Number of Days: " + getNumberOfDays());
        System.out.println("\n--- Service Details ---");
        System.out.println("Service Name: " + getServiceName());
        System.out.println("Service Charge: $" + getServiceCharge());
        System.out.println("Service Date: " + getServiceDate());
        System.out.println("\n--- Payment Details ---");
        System.out.println("Payment Method: " + getPaymentMethod());
        System.out.println("Payment Date: " + getPaymentDate());
        System.out.println("Amount Paid: $" + getAmountPaid());
        System.out.println("\n--- Bill Details ---");
        System.out.println("Room Charge: $" + getRoomCharge());
        System.out.println("Total Bill: $" + getTotalBill());
        System.out.println("\n--- Feedback Details ---");
        System.out.println("Rating: " + getRating() + "/5");
        System.out.println("Comments: " + getComments());
        System.out.println("===============================================\n");
    }
}

public class Question4_HotelReservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("========== HOTEL RESERVATION SYSTEM ==========\n");
            
            System.out.print("Enter Record ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Created Date (YYYY-MM-DD): ");
            String createdDate = scanner.nextLine();
            
            System.out.print("Enter Updated Date (YYYY-MM-DD): ");
            String updatedDate = scanner.nextLine();
            
            System.out.print("Enter Hotel Name: ");
            String hotelName = scanner.nextLine();
            
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            
            System.out.print("Enter Hotel Phone (10 digits): ");
            String phoneNumber = scanner.nextLine();
            
            System.out.print("Enter Hotel Email: ");
            String email = scanner.nextLine();
            
            System.out.print("Enter Room Number: ");
            int roomNumber = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Room Type: ");
            String roomType = scanner.nextLine();
            
            System.out.print("Enter Room Price: ");
            double roomPrice = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Enter Customer Name: ");
            String customerName = scanner.nextLine();
            
            System.out.print("Enter Customer Email: ");
            String customerEmail = scanner.nextLine();
            
            System.out.print("Enter Customer Phone (10 digits): ");
            String customerPhone = scanner.nextLine();
            
            System.out.print("Enter ID Proof: ");
            String idProof = scanner.nextLine();
            
            System.out.print("Enter Check-In Date (YYYY-MM-DD): ");
            String checkInDate = scanner.nextLine();
            
            System.out.print("Enter Check-Out Date (YYYY-MM-DD): ");
            String checkOutDate = scanner.nextLine();
            
            System.out.print("Enter Number of Days: ");
            int numberOfDays = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Service Name: ");
            String serviceName = scanner.nextLine();
            
            System.out.print("Enter Service Charge: ");
            double serviceCharge = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Enter Service Date (YYYY-MM-DD): ");
            String serviceDate = scanner.nextLine();
            
            System.out.print("Enter Payment Method: ");
            String paymentMethod = scanner.nextLine();
            
            System.out.print("Enter Payment Date (YYYY-MM-DD): ");
            String paymentDate = scanner.nextLine();
            
            System.out.print("Enter Amount Paid: ");
            double amountPaid = scanner.nextDouble();
            
            System.out.print("Enter Room Charge: ");
            double roomCharge = scanner.nextDouble();
            
            System.out.print("Enter Rating (1-5): ");
            int rating = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Comments: ");
            String comments = scanner.nextLine();
            
            ReservationRecord record = new ReservationRecord(id, createdDate, updatedDate, hotelName,
                address, phoneNumber, email, roomNumber, roomType, roomPrice, customerName,
                customerEmail, customerPhone, idProof, checkInDate, checkOutDate, numberOfDays,
                serviceName, serviceCharge, serviceDate, paymentMethod, paymentDate, amountPaid,
                roomCharge, rating, comments);
            
            record.generateBill();
            record.displayRecord();
            
        } catch (HotelDataException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Input Error: Please enter valid data");
        } finally {
            scanner.close();
        }
    }
}
