import java.util.Scanner;

class AirlineException extends Exception {
    public AirlineException(String message) {
        super(message);
    }
}

class Entity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public Entity(int id, String createdDate, String updatedDate) throws AirlineException {
        if (id <= 0) throw new AirlineException("ID must be greater than 0");
        if (createdDate == null || createdDate.trim().isEmpty()) 
            throw new AirlineException("Created date cannot be null or empty");
        if (updatedDate == null || updatedDate.trim().isEmpty()) 
            throw new AirlineException("Updated date cannot be null or empty");
        
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

class Airline extends Entity {
    private String airlineName;
    private String address;
    private String phoneNumber;
    private String email;

    public Airline(int id, String createdDate, String updatedDate, String airlineName, 
                   String address, String phoneNumber, String email) throws AirlineException {
        super(id, createdDate, updatedDate);
        
        if (!phoneNumber.matches("\\d{10}")) 
            throw new AirlineException("Phone number must be exactly 10 digits");
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new AirlineException("Invalid email format");
        
        this.airlineName = airlineName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getAirlineName() { return airlineName; }
    public void setAirlineName(String airlineName) { this.airlineName = airlineName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

class Flight extends Airline {
    private String flightNumber;
    private String flightCode;

    public Flight(int id, String createdDate, String updatedDate, String airlineName,
                  String address, String phoneNumber, String email, String flightNumber,
                  String flightCode) throws AirlineException {
        super(id, createdDate, updatedDate, airlineName, address, phoneNumber, email);
        
        if (flightCode.length() < 3 || !flightCode.matches("^[a-zA-Z0-9]+$")) 
            throw new AirlineException("Flight code must be alphanumeric and at least 3 characters");
        
        this.flightNumber = flightNumber;
        this.flightCode = flightCode;
    }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    public String getFlightCode() { return flightCode; }
    public void setFlightCode(String flightCode) { this.flightCode = flightCode; }
}

class Passenger extends Flight {
    private String passengerName;
    private String passportNumber;
    private String passengerEmail;
    private String phone;

    public Passenger(int id, String createdDate, String updatedDate, String airlineName,
                  String address, String phoneNumber, String email, String flightNumber,
                  String flightCode, String passengerName, String passportNumber,
                  String passengerEmail, String phone) throws AirlineException {
        super(id, createdDate, updatedDate, airlineName, address, phoneNumber, email,
              flightNumber, flightCode);
        
        if (passportNumber == null || passportNumber.trim().isEmpty()) 
            throw new AirlineException("Passport number cannot be empty");
        if (!passengerEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new AirlineException("Invalid passenger email format");
        if (!phone.matches("\\d{10}")) 
            throw new AirlineException("Passenger phone must be exactly 10 digits");
        
        this.passengerName = passengerName;
        this.passportNumber = passportNumber;
        this.passengerEmail = passengerEmail;
        this.phone = phone;
    }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }
    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }
    public String getPassengerEmail() { return passengerEmail; }
    public void setPassengerEmail(String passengerEmail) { this.passengerEmail = passengerEmail; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}

class Seat extends Passenger {
    private String seatNumber;
    private String seatClass;
    private int availableSeats;

    public Seat(int id, String createdDate, String updatedDate, String airlineName,
                String address, String phoneNumber, String email, String flightNumber,
                String flightCode, String passengerName, String passportNumber,
                String passengerEmail, String phone, String seatNumber, String seatClass,
                int availableSeats) throws AirlineException {
        super(id, createdDate, updatedDate, airlineName, address, phoneNumber, email,
              flightNumber, flightCode, passengerName, passportNumber, passengerEmail, phone);
        
        if (!seatClass.equals("Economy") && !seatClass.equals("Business")) 
            throw new AirlineException("Seat class must be 'Economy' or 'Business'");
        if (availableSeats < 0) 
            throw new AirlineException("Available seats must be >= 0");
        
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.availableSeats = availableSeats;
    }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
    public String getSeatClass() { return seatClass; }
    public void setSeatClass(String seatClass) { this.seatClass = seatClass; }
    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
}

class Ticket extends Seat {
    private String ticketNumber;
    private int ticketQuantity;
    private String bookingStatus;
    private String contactNumber;

    public Ticket(int id, String createdDate, String updatedDate, String airlineName,
                  String address, String phoneNumber, String email, String flightNumber,
                  String flightCode, String passengerName, String passportNumber,
                  String passengerEmail, String phone, String seatNumber, String seatClass,
                  int availableSeats, String ticketNumber, int ticketQuantity, String bookingStatus,
                  String contactNumber) throws AirlineException {
        super(id, createdDate, updatedDate, airlineName, address, phoneNumber, email,
              flightNumber, flightCode, passengerName, passportNumber, passengerEmail, phone,
              seatNumber, seatClass, availableSeats);
        
        if (ticketQuantity <= 0) throw new AirlineException("Ticket quantity must be > 0");
        if (!bookingStatus.equals("Confirmed") && !bookingStatus.equals("Pending") && !bookingStatus.equals("Cancelled")) 
            throw new AirlineException("Booking status must be 'Confirmed', 'Pending', or 'Cancelled'");
        
        this.ticketNumber = ticketNumber;
        this.ticketQuantity = ticketQuantity;
        this.bookingStatus = bookingStatus;
        this.contactNumber = contactNumber;
    }

    public String getTicketNumber() { return ticketNumber; }
    public void setTicketNumber(String ticketNumber) { this.ticketNumber = ticketNumber; }
    public int getTicketQuantity() { return ticketQuantity; }
    public void setTicketQuantity(int ticketQuantity) { this.ticketQuantity = ticketQuantity; }
    public String getBookingStatus() { return bookingStatus; }
    public void setBookingStatus(String bookingStatus) { this.bookingStatus = bookingStatus; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}

class Baggage extends Ticket {
    private String baggageType;
    private int baggageWeight;
    private double baggageFee;

    public Baggage(int id, String createdDate, String updatedDate, String airlineName,
                    String address, String phoneNumber, String email, String flightNumber,
                    String flightCode, String passengerName, String passportNumber,
                    String passengerEmail, String phone, String seatNumber, String seatClass,
                    int availableSeats, String ticketNumber, int ticketQuantity, String bookingStatus,
                    String contactNumber, String baggageType, int baggageWeight,
                    double baggageFee) throws AirlineException {
        super(id, createdDate, updatedDate, airlineName, address, phoneNumber, email,
              flightNumber, flightCode, passengerName, passportNumber, passengerEmail, phone,
              seatNumber, seatClass, availableSeats, ticketNumber, ticketQuantity, bookingStatus, contactNumber);
        
        if (baggageType == null || baggageType.trim().isEmpty()) 
            throw new AirlineException("Baggage type cannot be null");
        if (baggageFee < 0) 
            throw new AirlineException("Baggage fee must be >= 0");
        
        this.baggageType = baggageType;
        this.baggageWeight = baggageWeight;
        this.baggageFee = baggageFee;
    }

    public String getBaggageType() { return baggageType; }
    public void setBaggageType(String baggageType) { this.baggageType = baggageType; }
    public int getBaggageWeight() { return baggageWeight; }
    public void setBaggageWeight(int baggageWeight) { this.baggageWeight = baggageWeight; }
    public double getBaggageFee() { return baggageFee; }
    public void setBaggageFee(double baggageFee) { this.baggageFee = baggageFee; }
}

class Payment extends Baggage {
    private String paymentMethod;
    private String transactionId;
    private double price;

    public Payment(int id, String createdDate, String updatedDate, String airlineName,
                    String address, String phoneNumber, String email, String flightNumber,
                    String flightCode, String passengerName, String passportNumber,
                    String passengerEmail, String phone, String seatNumber, String seatClass,
                    int availableSeats, String ticketNumber, int ticketQuantity, String bookingStatus,
                    String contactNumber, String baggageType, int baggageWeight,
                    double baggageFee, String paymentMethod, String transactionId,
                    double price) throws AirlineException {
        super(id, createdDate, updatedDate, airlineName, address, phoneNumber, email,
              flightNumber, flightCode, passengerName, passportNumber, passengerEmail, phone,
              seatNumber, seatClass, availableSeats, ticketNumber, ticketQuantity, bookingStatus, contactNumber,
              baggageType, baggageWeight, baggageFee);
        
        if (price <= 0) 
            throw new AirlineException("Price must be > 0");
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) 
            throw new AirlineException("Payment method cannot be empty");
        if (transactionId == null || transactionId.trim().isEmpty()) 
            throw new AirlineException("Transaction ID cannot be empty");
        
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

class Invoice extends Payment {
    private double taxAmount;
    private double serviceFee;
    private double totalInvoice;

    public Invoice(int id, String createdDate, String updatedDate, String airlineName,
               String address, String phoneNumber, String email, String flightNumber,
               String flightCode, String passengerName, String passportNumber,
               String passengerEmail, String phone, String seatNumber, String seatClass,
               int availableSeats, String ticketNumber, int ticketQuantity, String bookingStatus,
               String contactNumber, String baggageType, int baggageWeight,
               double baggageFee, String paymentMethod, String transactionId,
               double price, double taxAmount, double serviceFee) 
               throws AirlineException {
        super(id, createdDate, updatedDate, airlineName, address, phoneNumber, email,
              flightNumber, flightCode, passengerName, passportNumber, passengerEmail, phone,
              seatNumber, seatClass, availableSeats, ticketNumber, ticketQuantity, bookingStatus, contactNumber,
              baggageType, baggageWeight, baggageFee, paymentMethod, transactionId, price);
        
        if (taxAmount < 0) throw new AirlineException("Tax amount must be >= 0");
        if (serviceFee < 0) throw new AirlineException("Service fee must be >= 0");
        
        this.taxAmount = taxAmount;
        this.serviceFee = serviceFee;
        this.totalInvoice = 0;
    }

    public double getTaxAmount() { return taxAmount; }
    public void setTaxAmount(double taxAmount) { this.taxAmount = taxAmount; }
    public double getServiceFee() { return serviceFee; }
    public void setServiceFee(double serviceFee) { this.serviceFee = serviceFee; }
    public double getTotalInvoice() { return totalInvoice; }
    public void setTotalInvoice(double totalInvoice) { this.totalInvoice = totalInvoice; }
}

final class TicketRecord extends Invoice {
    public TicketRecord(int id, String createdDate, String updatedDate, String airlineName,
                         String address, String phoneNumber, String email, String flightNumber,
                         String flightCode, String passengerName, String passportNumber,
                         String passengerEmail, String phone, String seatNumber, String seatClass,
                         int availableSeats, String ticketNumber, int ticketQuantity, String bookingStatus,
                         String contactNumber, String baggageType, int baggageWeight,
                         double baggageFee, String paymentMethod, String transactionId,
                         double price, double taxAmount, double serviceFee) 
                         throws AirlineException {
        super(id, createdDate, updatedDate, airlineName, address, phoneNumber, email,
              flightNumber, flightCode, passengerName, passportNumber, passengerEmail, phone,
              seatNumber, seatClass, availableSeats, ticketNumber, ticketQuantity, bookingStatus, contactNumber,
              baggageType, baggageWeight, baggageFee, paymentMethod, transactionId, price,
              taxAmount, serviceFee);
    }

    public double generateInvoice() {
        double total = getPrice() + getBaggageFee();
        setTotalInvoice(total);
        return total;
    }

    public void displayRecord() {
        System.out.println("\n========== AIRLINE TICKETING SYSTEM ==========");
        System.out.println("Record ID: " + getId());
        System.out.println("Created Date: " + getCreatedDate());
        System.out.println("Updated Date: " + getUpdatedDate());
        System.out.println("\n--- Airline Details ---");
        System.out.println("Airline Name: " + getAirlineName());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
        System.out.println("\n--- Flight Details ---");
        System.out.println("Flight Number: " + getFlightNumber());
        System.out.println("Flight Code: " + getFlightCode());
        System.out.println("\n--- Passenger Details ---");
        System.out.println("Passenger Name: " + getPassengerName());
        System.out.println("Passport Number: " + getPassportNumber());
        System.out.println("Passenger Email: " + getPassengerEmail());
        System.out.println("Passenger Phone: " + getPhone());
        System.out.println("\n--- Seat Details ---");
        System.out.println("Seat Number: " + getSeatNumber());
        System.out.println("Seat Class: " + getSeatClass());
        System.out.println("Available Seats: " + getAvailableSeats());
        System.out.println("\n--- Ticket Details ---");
        System.out.println("Ticket Number: " + getTicketNumber());
        System.out.println("Ticket Quantity: " + getTicketQuantity());
        System.out.println("Booking Status: " + getBookingStatus());
        System.out.println("Contact Number: " + getContactNumber());
        System.out.println("\n--- Baggage Details ---");
        System.out.println("Baggage Type: " + getBaggageType());
        System.out.println("Baggage Weight: " + getBaggageWeight() + " kg");
        System.out.println("Baggage Fee: $" + getBaggageFee());
        System.out.println("\n--- Payment Details ---");
        System.out.println("Payment Method: " + getPaymentMethod());
        System.out.println("Transaction ID: " + getTransactionId());
        System.out.println("Price: $" + getPrice());
        System.out.println("\n--- Invoice Details ---");
        System.out.println("Tax Amount: $" + getTaxAmount());
        System.out.println("Service Fee: $" + getServiceFee());
        System.out.println("Total Invoice: $" + getTotalInvoice());
        System.out.println("==============================================\n");
    }
}

public class Question9_AirlineTicketing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("========== AIRLINE TICKETING SYSTEM ==========\n");
            
            System.out.print("Enter Record ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Created Date (YYYY-MM-DD): ");
            String createdDate = scanner.nextLine();
            
            System.out.print("Enter Updated Date (YYYY-MM-DD): ");
            String updatedDate = scanner.nextLine();
            
            System.out.print("Enter Airline Name: ");
            String airlineName = scanner.nextLine();
            
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            
            System.out.print("Enter Airline Phone (10 digits): ");
            String phoneNumber = scanner.nextLine();
            
            System.out.print("Enter Airline Email: ");
            String email = scanner.nextLine();
            
            System.out.print("Enter Flight Number: ");
            String flightNumber = scanner.nextLine();
            
            System.out.print("Enter Flight Code (alphanumeric, min 3 chars): ");
            String flightCode = scanner.nextLine();
            
            System.out.print("Enter Passenger Name: ");
            String passengerName = scanner.nextLine();
            
            System.out.print("Enter Passport Number: ");
            String passportNumber = scanner.nextLine();
            
            System.out.print("Enter Passenger Email: ");
            String passengerEmail = scanner.nextLine();
            
            System.out.print("Enter Passenger Phone (10 digits): ");
            String passengerPhone = scanner.nextLine();
            
            System.out.print("Enter Seat Number: ");
            String seatNumber = scanner.nextLine();
            
            System.out.print("Enter Seat Class (Economy/Business): ");
            String seatClass = scanner.nextLine();
            
            System.out.print("Enter Available Seats: ");
            int availableSeats = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Ticket Number: ");
            String ticketNumber = scanner.nextLine();
            
            System.out.print("Enter Ticket Quantity: ");
            int ticketQuantity = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Booking Status (Confirmed/Pending/Cancelled): ");
            String bookingStatus = scanner.nextLine();
            
            System.out.print("Enter Contact Number: ");
            String contactNumber = scanner.nextLine();
            
            System.out.print("Enter Baggage Type: ");
            String baggageType = scanner.nextLine();
            
            System.out.print("Enter Baggage Weight (kg): ");
            int baggageWeight = scanner.nextInt();
            
            System.out.print("Enter Baggage Fee: ");
            double baggageFee = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Enter Payment Method: ");
            String paymentMethod = scanner.nextLine();
            
            System.out.print("Enter Transaction ID: ");
            String transactionId = scanner.nextLine();
            
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            
            System.out.print("Enter Tax Amount: ");
            double taxAmount = scanner.nextDouble();
            
            System.out.print("Enter Service Fee: ");
            double serviceFee = scanner.nextDouble();
            
            TicketRecord record = new TicketRecord(id, createdDate, updatedDate, airlineName,
                address, phoneNumber, email, flightNumber, flightCode, passengerName, passportNumber,
                passengerEmail, passengerPhone, seatNumber, seatClass, availableSeats,
                ticketNumber, ticketQuantity, bookingStatus, contactNumber, baggageType, baggageWeight, baggageFee,
                paymentMethod, transactionId, price, taxAmount, serviceFee);
            
            record.generateInvoice();
            record.displayRecord();
            
        } catch (AirlineException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Input Error: Please enter valid data");
        } finally {
            scanner.close();
        }
    }
}
