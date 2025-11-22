import java.util.Scanner;

class BankingException extends Exception {
    public BankingException(String message) {
        super(message);
    }
}

class Entity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public Entity(int id, String createdDate, String updatedDate) throws BankingException {
        if (id <= 0) throw new BankingException("ID must be greater than 0");
        if (createdDate == null || createdDate.trim().isEmpty()) 
            throw new BankingException("Created date cannot be null");
        if (updatedDate == null || updatedDate.trim().isEmpty()) 
            throw new BankingException("Updated date cannot be null");
        
        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getId() { return id; }
    public String getCreatedDate() { return createdDate; }
    public String getUpdatedDate() { return updatedDate; }
}

class Bank extends Entity {
    private String bankName;
    private String branchCode;
    private String address;

    public Bank(int id, String createdDate, String updatedDate, String bankName,
               String branchCode, String address) throws BankingException {
        super(id, createdDate, updatedDate);
        
        if (branchCode.length() < 3) 
            throw new BankingException("Branch code must be at least 3 characters");
        
        this.bankName = bankName;
        this.branchCode = branchCode;
        this.address = address;
    }

    public String getBankName() { return bankName; }
    public String getBranchCode() { return branchCode; }
    public String getAddress() { return address; }
}

class Account extends Bank {
    private String accountNumber;
    private String accountType;
    private double balance;

    public Account(int id, String createdDate, String updatedDate, String bankName,
                  String branchCode, String address, String accountNumber,
                  String accountType, double balance) throws BankingException {
        super(id, createdDate, updatedDate, bankName, branchCode, address);
        
        if (balance < 0) throw new BankingException("Balance must be >= 0");
        
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountType() { return accountType; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}

class Customer extends Account {
    private String customerName;
    private String email;
    private String phoneNumber;

    public Customer(int id, String createdDate, String updatedDate, String bankName,
                   String branchCode, String address, String accountNumber,
                   String accountType, double balance, String customerName,
                   String email, String phoneNumber) throws BankingException {
        super(id, createdDate, updatedDate, bankName, branchCode, address,
              accountNumber, accountType, balance);
        
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new BankingException("Invalid email format");
        if (!phoneNumber.matches("\\d{10}")) 
            throw new BankingException("Phone must be 10 digits");
        
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerName() { return customerName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
}

class Transaction extends Customer {
    private String transactionId;
    private String transactionType;
    private double amount;

    public Transaction(int id, String createdDate, String updatedDate, String bankName,
                      String branchCode, String address, String accountNumber,
                      String accountType, double balance, String customerName,
                      String email, String phoneNumber, String transactionId,
                      String transactionType, double amount) throws BankingException {
        super(id, createdDate, updatedDate, bankName, branchCode, address,
              accountNumber, accountType, balance, customerName, email, phoneNumber);
        
        if (amount <= 0) throw new BankingException("Amount must be > 0");
        
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public String getTransactionId() { return transactionId; }
    public String getTransactionType() { return transactionType; }
    public double getAmount() { return amount; }
}

class Deposit extends Transaction {
    private double depositAmount;
    private String depositDate;

    public Deposit(int id, String createdDate, String updatedDate, String bankName,
                  String branchCode, String address, String accountNumber,
                  String accountType, double balance, String customerName,
                  String email, String phoneNumber, String transactionId,
                  String transactionType, double amount, double depositAmount,
                  String depositDate) throws BankingException {
        super(id, createdDate, updatedDate, bankName, branchCode, address,
              accountNumber, accountType, balance, customerName, email, phoneNumber,
              transactionId, transactionType, amount);
        
        if (depositAmount <= 0) throw new BankingException("Deposit amount must be > 0");
        
        this.depositAmount = depositAmount;
        this.depositDate = depositDate;
    }

    public double getDepositAmount() { return depositAmount; }
    public String getDepositDate() { return depositDate; }
}

class Withdrawal extends Deposit {
    private double withdrawalAmount;
    private String withdrawalDate;

    public Withdrawal(int id, String createdDate, String updatedDate, String bankName,
                     String branchCode, String address, String accountNumber,
                     String accountType, double balance, String customerName,
                     String email, String phoneNumber, String transactionId,
                     String transactionType, double amount, double depositAmount,
                     String depositDate, double withdrawalAmount,
                     String withdrawalDate) throws BankingException {
        super(id, createdDate, updatedDate, bankName, branchCode, address,
              accountNumber, accountType, balance, customerName, email, phoneNumber,
              transactionId, transactionType, amount, depositAmount, depositDate);
        
        if (withdrawalAmount <= 0) throw new BankingException("Withdrawal amount must be > 0");
        
        this.withdrawalAmount = withdrawalAmount;
        this.withdrawalDate = withdrawalDate;
    }

    public double getWithdrawalAmount() { return withdrawalAmount; }
    public String getWithdrawalDate() { return withdrawalDate; }
}

class Loan extends Withdrawal {
    private double loanAmount;
    private double interestRate;
    private int duration;

    public Loan(int id, String createdDate, String updatedDate, String bankName,
               String branchCode, String address, String accountNumber,
               String accountType, double balance, String customerName,
               String email, String phoneNumber, String transactionId,
               String transactionType, double amount, double depositAmount,
               String depositDate, double withdrawalAmount, String withdrawalDate,
               double loanAmount, double interestRate, int duration) throws BankingException {
        super(id, createdDate, updatedDate, bankName, branchCode, address,
              accountNumber, accountType, balance, customerName, email, phoneNumber,
              transactionId, transactionType, amount, depositAmount, depositDate,
              withdrawalAmount, withdrawalDate);
        
        if (loanAmount <= 0) throw new BankingException("Loan amount must be > 0");
        if (interestRate <= 0) throw new BankingException("Interest rate must be > 0");
        if (duration <= 0) throw new BankingException("Duration must be > 0");
        
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.duration = duration;
    }

    public double getLoanAmount() { return loanAmount; }
    public double getInterestRate() { return interestRate; }
    public int getDuration() { return duration; }
}

class Payment extends Loan {
    private double paymentAmount;
    private String paymentDate;

    public Payment(int id, String createdDate, String updatedDate, String bankName,
                  String branchCode, String address, String accountNumber,
                  String accountType, double balance, String customerName,
                  String email, String phoneNumber, String transactionId,
                  String transactionType, double amount, double depositAmount,
                  String depositDate, double withdrawalAmount, String withdrawalDate,
                  double loanAmount, double interestRate, int duration,
                  double paymentAmount, String paymentDate) throws BankingException {
        super(id, createdDate, updatedDate, bankName, branchCode, address,
              accountNumber, accountType, balance, customerName, email, phoneNumber,
              transactionId, transactionType, amount, depositAmount, depositDate,
              withdrawalAmount, withdrawalDate, loanAmount, interestRate, duration);
        
        if (paymentAmount <= 0) throw new BankingException("Payment amount must be > 0");
        
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
    }

    public double getPaymentAmount() { return paymentAmount; }
    public String getPaymentDate() { return paymentDate; }
}

final class AccountRecord extends Payment {
    private double calculatedInterest;

    public AccountRecord(int id, String createdDate, String updatedDate, String bankName,
                        String branchCode, String address, String accountNumber,
                        String accountType, double balance, String customerName,
                        String email, String phoneNumber, String transactionId,
                        String transactionType, double amount, double depositAmount,
                        String depositDate, double withdrawalAmount, String withdrawalDate,
                        double loanAmount, double interestRate, int duration,
                        double paymentAmount, String paymentDate) throws BankingException {
        super(id, createdDate, updatedDate, bankName, branchCode, address,
              accountNumber, accountType, balance, customerName, email, phoneNumber,
              transactionId, transactionType, amount, depositAmount, depositDate,
              withdrawalAmount, withdrawalDate, loanAmount, interestRate, duration,
              paymentAmount, paymentDate);
        this.calculatedInterest = 0;
    }

    public double calculateInterest() {
        calculatedInterest = (getLoanAmount() * getInterestRate() * getDuration()) / 100;
        return calculatedInterest;
    }

    public void displayRecord() {
        System.out.println("\n" + Question6_BankingSystem.STUDENT_ID + " - ========== BANKING SYSTEM ==========");
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Record ID: " + getId());
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Created: " + getCreatedDate());
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Updated: " + getUpdatedDate());
        System.out.println("\n" + Question6_BankingSystem.STUDENT_ID + " - --- Bank Details ---");
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Bank: " + getBankName());
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Branch Code: " + getBranchCode());
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Address: " + getAddress());
        System.out.println("\n" + Question6_BankingSystem.STUDENT_ID + " - --- Account Details ---");
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Account Number: " + getAccountNumber());
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Account Type: " + getAccountType());
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Balance: $" + getBalance());
        System.out.println("\n" + Question6_BankingSystem.STUDENT_ID + " - --- Customer Details ---");
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Name: " + getCustomerName());
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Email: " + getEmail());
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Phone: " + getPhoneNumber());
        System.out.println("\n" + Question6_BankingSystem.STUDENT_ID + " - --- Transaction Details ---");
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Transaction ID: " + getTransactionId());
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Type: " + getTransactionType());
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Amount: $" + getAmount());
        System.out.println("\n" + Question6_BankingSystem.STUDENT_ID + " - --- Deposit Details ---");
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Deposit Amount: $" + getDepositAmount());
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Deposit Date: " + getDepositDate());
        System.out.println("\n" + Question6_BankingSystem.STUDENT_ID + " - --- Withdrawal Details ---");
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Withdrawal Amount: $" + getWithdrawalAmount());
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Withdrawal Date: " + getWithdrawalDate());
        System.out.println("\n" + Question6_BankingSystem.STUDENT_ID + " - --- Loan Details ---");
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Loan Amount: $" + getLoanAmount());
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Interest Rate: " + getInterestRate() + "%");
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Duration: " + getDuration() + " months");
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Calculated Interest: $" + calculatedInterest);
        System.out.println("\n" + Question6_BankingSystem.STUDENT_ID + " - --- Payment Details ---");
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Payment Amount: $" + getPaymentAmount());
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - Payment Date: " + getPaymentDate());
        System.out.println(Question6_BankingSystem.STUDENT_ID + " - =====================================\n");
    }
}

public class Question6_BankingSystem {
    public static final String STUDENT_ID = "27264";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println(Question6_BankingSystem.STUDENT_ID + " - === BANKING SYSTEM ===\n");
            
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Created Date: ");
            String created = sc.nextLine();
            
            System.out.print("Updated Date: ");
            String updated = sc.nextLine();
            
            System.out.print("Bank Name: ");
            String bankName = sc.nextLine();
            
            System.out.print("Branch Code (min 3 chars): ");
            String branchCode = sc.nextLine();
            
            System.out.print("Address: ");
            String address = sc.nextLine();
            
            System.out.print("Account Number: ");
            String accountNumber = sc.nextLine();
            
            System.out.print("Account Type: ");
            String accountType = sc.nextLine();
            
            System.out.print("Balance: ");
            double balance = sc.nextDouble();
            sc.nextLine();
            
            System.out.print("Customer Name: ");
            String customerName = sc.nextLine();
            
            System.out.print("Email: ");
            String email = sc.nextLine();
            
            System.out.print("Phone (10 digits): ");
            String phone = sc.nextLine();
            
            System.out.print("Transaction ID: ");
            String transactionId = sc.nextLine();
            
            System.out.print("Transaction Type: ");
            String transactionType = sc.nextLine();
            
            System.out.print("Transaction Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            
            System.out.print("Deposit Amount: ");
            double depositAmount = sc.nextDouble();
            sc.nextLine();
            
            System.out.print("Deposit Date: ");
            String depositDate = sc.nextLine();
            
            System.out.print("Withdrawal Amount: ");
            double withdrawalAmount = sc.nextDouble();
            sc.nextLine();
            
            System.out.print("Withdrawal Date: ");
            String withdrawalDate = sc.nextLine();
            
            System.out.print("Loan Amount: ");
            double loanAmount = sc.nextDouble();
            
            System.out.print("Interest Rate (%): ");
            double interestRate = sc.nextDouble();
            
            System.out.print("Duration (months): ");
            int duration = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Payment Amount: ");
            double paymentAmount = sc.nextDouble();
            sc.nextLine();
            
            System.out.print("Payment Date: ");
            String paymentDate = sc.nextLine();
            
            AccountRecord record = new AccountRecord(id, created, updated, bankName,
                branchCode, address, accountNumber, accountType, balance, customerName,
                email, phone, transactionId, transactionType, amount, depositAmount,
                depositDate, withdrawalAmount, withdrawalDate, loanAmount, interestRate,
                duration, paymentAmount, paymentDate);
            
            record.calculateInterest();
            record.displayRecord();
            
        } catch (BankingException e) {
            System.out.println(Question6_BankingSystem.STUDENT_ID + " - Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(Question6_BankingSystem.STUDENT_ID + " - Input Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
