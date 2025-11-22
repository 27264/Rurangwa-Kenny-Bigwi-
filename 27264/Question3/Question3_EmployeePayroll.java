import java.util.Scanner;

class EmployeeDataException extends Exception {
    public EmployeeDataException(String message) {
        super(message);
    }
}

class Entity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public Entity(int id, String createdDate, String updatedDate) throws EmployeeDataException {
        if (id <= 0) throw new EmployeeDataException("ID must be greater than 0");
        if (createdDate == null || createdDate.trim().isEmpty()) 
            throw new EmployeeDataException("Created date cannot be null or empty");
        if (updatedDate == null || updatedDate.trim().isEmpty()) 
            throw new EmployeeDataException("Updated date cannot be null or empty");
        
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

class Company extends Entity {
    private String companyName;
    private String address;
    private String phoneNumber;
    private String email;

    public Company(int id, String createdDate, String updatedDate, String companyName, 
                   String address, String phoneNumber, String email) throws EmployeeDataException {
        super(id, createdDate, updatedDate);
        
        if (!phoneNumber.matches("\\d{10}")) 
            throw new EmployeeDataException("Phone number must be exactly 10 digits");
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new EmployeeDataException("Invalid email format");
        
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

class Department extends Company {
    private String departmentName;
    private String departmentCode;

    public Department(int id, String createdDate, String updatedDate, String companyName,
                     String address, String phoneNumber, String email, String departmentName,
                     String departmentCode) throws EmployeeDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email);
        
        if (departmentCode.length() < 3 || !departmentCode.matches("^[a-zA-Z0-9]+$")) 
            throw new EmployeeDataException("Department code must be alphanumeric and at least 3 characters");
        
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public String getDepartmentCode() { return departmentCode; }
    public void setDepartmentCode(String departmentCode) { this.departmentCode = departmentCode; }
}

class Manager extends Department {
    private String managerName;
    private String managerEmail;
    private String phone;
    private int yearsOfExperience;

    public Manager(int id, String createdDate, String updatedDate, String companyName,
                  String address, String phoneNumber, String email, String departmentName,
                  String departmentCode, String managerName, String managerEmail,
                  String phone, int yearsOfExperience) throws EmployeeDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              departmentName, departmentCode);
        
        if (!managerEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new EmployeeDataException("Invalid manager email format");
        if (!phone.matches("\\d{10}")) 
            throw new EmployeeDataException("Manager phone must be exactly 10 digits");
        if (yearsOfExperience < 0) 
            throw new EmployeeDataException("Years of experience must be >= 0");
        
        this.managerName = managerName;
        this.managerEmail = managerEmail;
        this.phone = phone;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
    public String getManagerEmail() { return managerEmail; }
    public void setManagerEmail(String managerEmail) { this.managerEmail = managerEmail; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }
}

class Employee extends Manager {
    private String employeeName;
    private String designation;
    private String employeeEmail;
    private String employeePhone;

    public Employee(int id, String createdDate, String updatedDate, String companyName,
                   String address, String phoneNumber, String email, String departmentName,
                   String departmentCode, String managerName, String managerEmail,
                   String phone, int yearsOfExperience, String employeeName,
                   String designation, String employeeEmail, String employeePhone) 
                   throws EmployeeDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              departmentName, departmentCode, managerName, managerEmail, phone,
              yearsOfExperience);
        
        if (designation == null || designation.trim().isEmpty()) 
            throw new EmployeeDataException("Designation cannot be empty");
        if (!employeeEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new EmployeeDataException("Invalid employee email format");
        if (!employeePhone.matches("\\d{10}")) 
            throw new EmployeeDataException("Employee phone must be exactly 10 digits");
        
        this.employeeName = employeeName;
        this.designation = designation;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
    }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    public String getEmployeeEmail() { return employeeEmail; }
    public void setEmployeeEmail(String employeeEmail) { this.employeeEmail = employeeEmail; }
    public String getEmployeePhone() { return employeePhone; }
    public void setEmployeePhone(String employeePhone) { this.employeePhone = employeePhone; }
}

class Attendance extends Employee {
    private int totalDays;
    private int presentDays;
    private int absentDays;

    public Attendance(int id, String createdDate, String updatedDate, String companyName,
                     String address, String phoneNumber, String email, String departmentName,
                     String departmentCode, String managerName, String managerEmail,
                     String phone, int yearsOfExperience, String employeeName,
                     String designation, String employeeEmail, String employeePhone,
                     int totalDays, int presentDays, int absentDays) 
                     throws EmployeeDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              departmentName, departmentCode, managerName, managerEmail, phone,
              yearsOfExperience, employeeName, designation, employeeEmail, employeePhone);
        
        if (totalDays <= 0) throw new EmployeeDataException("Total days must be > 0");
        if (presentDays < 0) throw new EmployeeDataException("Present days must be >= 0");
        if (absentDays < 0) throw new EmployeeDataException("Absent days must be >= 0");
        if (presentDays + absentDays != totalDays) 
            throw new EmployeeDataException("Present + Absent days must equal Total days");
        
        this.totalDays = totalDays;
        this.presentDays = presentDays;
        this.absentDays = absentDays;
    }

    public int getTotalDays() { return totalDays; }
    public void setTotalDays(int totalDays) { this.totalDays = totalDays; }
    public int getPresentDays() { return presentDays; }
    public void setPresentDays(int presentDays) { this.presentDays = presentDays; }
    public int getAbsentDays() { return absentDays; }
    public void setAbsentDays(int absentDays) { this.absentDays = absentDays; }
}

class Allowance extends Attendance {
    private double houseRentAllowance;
    private double transportAllowance;
    private double totalAllowance;

    public Allowance(int id, String createdDate, String updatedDate, String companyName,
                    String address, String phoneNumber, String email, String departmentName,
                    String departmentCode, String managerName, String managerEmail,
                    String phone, int yearsOfExperience, String employeeName,
                    String designation, String employeeEmail, String employeePhone,
                    int totalDays, int presentDays, int absentDays, double houseRentAllowance,
                    double transportAllowance) throws EmployeeDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              departmentName, departmentCode, managerName, managerEmail, phone,
              yearsOfExperience, employeeName, designation, employeeEmail, employeePhone,
              totalDays, presentDays, absentDays);
        
        if (houseRentAllowance < 0) throw new EmployeeDataException("HRA must be >= 0");
        if (transportAllowance < 0) throw new EmployeeDataException("Transport allowance must be >= 0");
        
        this.houseRentAllowance = houseRentAllowance;
        this.transportAllowance = transportAllowance;
        this.totalAllowance = 0;
    }

    public double getHouseRentAllowance() { return houseRentAllowance; }
    public void setHouseRentAllowance(double houseRentAllowance) { this.houseRentAllowance = houseRentAllowance; }
    public double getTransportAllowance() { return transportAllowance; }
    public void setTransportAllowance(double transportAllowance) { this.transportAllowance = transportAllowance; }
    public double getTotalAllowance() { return totalAllowance; }
    public void setTotalAllowance(double totalAllowance) { this.totalAllowance = totalAllowance; }
}

class Deduction extends Allowance {
    private double tax;
    private double providentFund;
    private double totalDeduction;

    public Deduction(int id, String createdDate, String updatedDate, String companyName,
                    String address, String phoneNumber, String email, String departmentName,
                    String departmentCode, String managerName, String managerEmail,
                    String phone, int yearsOfExperience, String employeeName,
                    String designation, String employeeEmail, String employeePhone,
                    int totalDays, int presentDays, int absentDays, double houseRentAllowance,
                    double transportAllowance, double tax, double providentFund) 
                    throws EmployeeDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              departmentName, departmentCode, managerName, managerEmail, phone,
              yearsOfExperience, employeeName, designation, employeeEmail, employeePhone,
              totalDays, presentDays, absentDays, houseRentAllowance, transportAllowance);
        
        if (tax < 0) throw new EmployeeDataException("Tax must be >= 0");
        if (providentFund < 0) throw new EmployeeDataException("Provident fund must be >= 0");
        
        this.tax = tax;
        this.providentFund = providentFund;
        this.totalDeduction = 0;
    }

    public double getTax() { return tax; }
    public void setTax(double tax) { this.tax = tax; }
    public double getProvidentFund() { return providentFund; }
    public void setProvidentFund(double providentFund) { this.providentFund = providentFund; }
    public double getTotalDeduction() { return totalDeduction; }
    public void setTotalDeduction(double totalDeduction) { this.totalDeduction = totalDeduction; }
}

class Salary extends Deduction {
    private double basicSalary;
    private double netSalary;

    public Salary(int id, String createdDate, String updatedDate, String companyName,
                 String address, String phoneNumber, String email, String departmentName,
                 String departmentCode, String managerName, String managerEmail,
                 String phone, int yearsOfExperience, String employeeName,
                 String designation, String employeeEmail, String employeePhone,
                 int totalDays, int presentDays, int absentDays, double houseRentAllowance,
                 double transportAllowance, double tax, double providentFund,
                 double basicSalary) throws EmployeeDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              departmentName, departmentCode, managerName, managerEmail, phone,
              yearsOfExperience, employeeName, designation, employeeEmail, employeePhone,
              totalDays, presentDays, absentDays, houseRentAllowance, transportAllowance,
              tax, providentFund);
        
        if (basicSalary <= 0) throw new EmployeeDataException("Basic salary must be > 0");
        
        this.basicSalary = basicSalary;
        this.netSalary = 0;
    }

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }
    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }
}

final class PayrollRecord extends Salary {
    public PayrollRecord(int id, String createdDate, String updatedDate, String companyName,
                        String address, String phoneNumber, String email, String departmentName,
                        String departmentCode, String managerName, String managerEmail,
                        String phone, int yearsOfExperience, String employeeName,
                        String designation, String employeeEmail, String employeePhone,
                        int totalDays, int presentDays, int absentDays, double houseRentAllowance,
                        double transportAllowance, double tax, double providentFund,
                        double basicSalary) throws EmployeeDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              departmentName, departmentCode, managerName, managerEmail, phone,
              yearsOfExperience, employeeName, designation, employeeEmail, employeePhone,
              totalDays, presentDays, absentDays, houseRentAllowance, transportAllowance,
              tax, providentFund, basicSalary);
    }

    public double calculateNetSalary() {
        double allowances = getHouseRentAllowance() + getTransportAllowance();
        setTotalAllowance(allowances);
        
        double deductions = getTax() + getProvidentFund();
        setTotalDeduction(deductions);
        
        double netSalary = getBasicSalary() + allowances - deductions;
        setNetSalary(netSalary);
        return netSalary;
    }

    public void displayRecord() {
        System.out.println("\n" + Question3_EmployeePayroll.STUDENT_ID + " - ========== EMPLOYEE PAYROLL SYSTEM ==========");
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Record ID: " + getId());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Created Date: " + getCreatedDate());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Updated Date: " + getUpdatedDate());
        System.out.println("\n" + Question3_EmployeePayroll.STUDENT_ID + " - --- Company Details ---");
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Company Name: " + getCompanyName());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Address: " + getAddress());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Phone: " + getPhoneNumber());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Email: " + getEmail());
        System.out.println("\n" + Question3_EmployeePayroll.STUDENT_ID + " - --- Department Details ---");
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Department: " + getDepartmentName());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Department Code: " + getDepartmentCode());
        System.out.println("\n" + Question3_EmployeePayroll.STUDENT_ID + " - --- Manager Details ---");
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Manager Name: " + getManagerName());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Manager Email: " + getManagerEmail());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Manager Phone: " + getPhone());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Years of Experience: " + getYearsOfExperience());
        System.out.println("\n" + Question3_EmployeePayroll.STUDENT_ID + " - --- Employee Details ---");
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Employee Name: " + getEmployeeName());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Designation: " + getDesignation());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Employee Email: " + getEmployeeEmail());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Employee Phone: " + getEmployeePhone());
        System.out.println("\n" + Question3_EmployeePayroll.STUDENT_ID + " - --- Attendance Details ---");
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Total Days: " + getTotalDays());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Present Days: " + getPresentDays());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Absent Days: " + getAbsentDays());
        System.out.println("\n" + Question3_EmployeePayroll.STUDENT_ID + " - --- Allowance Details ---");
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - House Rent Allowance: $" + getHouseRentAllowance());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Transport Allowance: $" + getTransportAllowance());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Total Allowance: $" + getTotalAllowance());
        System.out.println("\n" + Question3_EmployeePayroll.STUDENT_ID + " - --- Deduction Details ---");
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Tax: $" + getTax());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Provident Fund: $" + getProvidentFund());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Total Deduction: $" + getTotalDeduction());
        System.out.println("\n" + Question3_EmployeePayroll.STUDENT_ID + " - --- Salary Details ---");
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Basic Salary: $" + getBasicSalary());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Net Salary: $" + getNetSalary());
        System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - ===============================================\n");
    }
}

public class Question3_EmployeePayroll {
    public static final String STUDENT_ID = "27264";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - ========== EMPLOYEE PAYROLL SYSTEM ==========\n");
            
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
            
            System.out.print("Enter Department Name: ");
            String departmentName = scanner.nextLine();
            
            System.out.print("Enter Department Code (alphanumeric, min 3 chars): ");
            String departmentCode = scanner.nextLine();
            
            System.out.print("Enter Manager Name: ");
            String managerName = scanner.nextLine();
            
            System.out.print("Enter Manager Email: ");
            String managerEmail = scanner.nextLine();
            
            System.out.print("Enter Manager Phone (10 digits): ");
            String managerPhone = scanner.nextLine();
            
            System.out.print("Enter Manager Years of Experience: ");
            int yearsOfExperience = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Employee Name: ");
            String employeeName = scanner.nextLine();
            
            System.out.print("Enter Designation: ");
            String designation = scanner.nextLine();
            
            System.out.print("Enter Employee Email: ");
            String employeeEmail = scanner.nextLine();
            
            System.out.print("Enter Employee Phone (10 digits): ");
            String employeePhone = scanner.nextLine();
            
            System.out.print("Enter Total Days: ");
            int totalDays = scanner.nextInt();
            
            System.out.print("Enter Present Days: ");
            int presentDays = scanner.nextInt();
            
            System.out.print("Enter Absent Days: ");
            int absentDays = scanner.nextInt();
            
            System.out.print("Enter House Rent Allowance: ");
            double houseRentAllowance = scanner.nextDouble();
            
            System.out.print("Enter Transport Allowance: ");
            double transportAllowance = scanner.nextDouble();
            
            System.out.print("Enter Tax: ");
            double tax = scanner.nextDouble();
            
            System.out.print("Enter Provident Fund: ");
            double providentFund = scanner.nextDouble();
            
            System.out.print("Enter Basic Salary: ");
            double basicSalary = scanner.nextDouble();
            
            PayrollRecord record = new PayrollRecord(id, createdDate, updatedDate, companyName,
                address, phoneNumber, email, departmentName, departmentCode, managerName,
                managerEmail, managerPhone, yearsOfExperience, employeeName, designation,
                employeeEmail, employeePhone, totalDays, presentDays, absentDays,
                houseRentAllowance, transportAllowance, tax, providentFund, basicSalary);
            
            record.calculateNetSalary();
            record.displayRecord();
            
        } catch (EmployeeDataException e) {
            System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(Question3_EmployeePayroll.STUDENT_ID + " - Input Error: Please enter valid data");
        } finally {
            scanner.close();
        }
    }
}
