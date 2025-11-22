import java.util.Scanner;

class SchoolDataException extends Exception {
    public SchoolDataException(String message) {
        super(message);
    }
}

class SchoolEntity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public SchoolEntity(int id, String createdDate, String updatedDate) throws SchoolDataException {
        if (id <= 0) throw new SchoolDataException("ID must be greater than 0");
        if (createdDate == null || createdDate.trim().isEmpty()) 
            throw new SchoolDataException("Created date cannot be null or empty");
        if (updatedDate == null || updatedDate.trim().isEmpty()) 
            throw new SchoolDataException("Updated date cannot be null or empty");
        
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

class School extends SchoolEntity {
    private String schoolName;
    private String address;
    private String phoneNumber;
    private String email;

    public School(int id, String createdDate, String updatedDate, String schoolName, 
                   String address, String phoneNumber, String email) throws SchoolDataException {
        super(id, createdDate, updatedDate);
        
        if (!phoneNumber.matches("\\d{10}")) 
            throw new SchoolDataException("Phone number must be exactly 10 digits");
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new SchoolDataException("Invalid email format");
        
        this.schoolName = schoolName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getSchoolName() { return schoolName; }
    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

class SchoolDepartment extends School {
    private String departmentName;
    private String departmentCode;

    public SchoolDepartment(int id, String createdDate, String updatedDate, String schoolName,
                     String address, String phoneNumber, String email, String departmentName,
                     String departmentCode) throws SchoolDataException {
        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email);
        
        if (departmentCode.length() < 3 || !departmentCode.matches("^[a-zA-Z0-9]+$")) 
            throw new SchoolDataException("Department code must be alphanumeric and at least 3 characters");
        
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public String getDepartmentCode() { return departmentCode; }
    public void setDepartmentCode(String departmentCode) { this.departmentCode = departmentCode; }
}

class Teacher extends SchoolDepartment {
    private String teacherName;
    private String subject;
    private String teacherEmail;
    private String phone;

    public Teacher(int id, String createdDate, String updatedDate, String schoolName,
                 String address, String phoneNumber, String email, String departmentName,
                 String departmentCode, String teacherName, String subject,
                 String teacherEmail, String phone) throws SchoolDataException {
        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
              departmentName, departmentCode);
        
        if (subject == null || subject.trim().isEmpty()) 
            throw new SchoolDataException("Subject cannot be empty");
        if (!teacherEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new SchoolDataException("Invalid teacher email format");
        if (!phone.matches("\\d{10}")) 
            throw new SchoolDataException("Teacher phone must be exactly 10 digits");
        
        this.teacherName = teacherName;
        this.subject = subject;
        this.teacherEmail = teacherEmail;
        this.phone = phone;
    }

    public String getTeacherName() { return teacherName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getTeacherEmail() { return teacherEmail; }
    public void setTeacherEmail(String teacherEmail) { this.teacherEmail = teacherEmail; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}

class Student extends Teacher {
    private String studentName;
    private int studentAge;
    private String studentGrade;
    private String studentContact;

    public Student(int id, String createdDate, String updatedDate, String schoolName,
                  String address, String phoneNumber, String email, String departmentName,
                  String departmentCode, String teacherName, String subject,
                  String teacherEmail, String phone, String studentName, int studentAge,
                  String studentGrade, String studentContact) throws SchoolDataException {
        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
              departmentName, departmentCode, teacherName, subject, teacherEmail, phone);
        
        if (studentAge <= 0) throw new SchoolDataException("Student age must be > 0");
        if (studentGrade == null || studentGrade.trim().isEmpty()) 
            throw new SchoolDataException("Student grade cannot be empty");
        
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentGrade = studentGrade;
        this.studentContact = studentContact;
    }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public int getStudentAge() { return studentAge; }
    public void setStudentAge(int studentAge) { this.studentAge = studentAge; }
    public String getStudentGrade() { return studentGrade; }
    public void setStudentGrade(String studentGrade) { this.studentGrade = studentGrade; }
    public String getStudentContact() { return studentContact; }
    public void setStudentContact(String studentContact) { this.studentContact = studentContact; }
}

class Course extends Student {
    private String courseName;
    private String courseCode;
    private int creditHours;

    public Course(int id, String createdDate, String updatedDate, String schoolName,
                 String address, String phoneNumber, String email, String departmentName,
                 String departmentCode, String teacherName, String subject,
                 String teacherEmail, String phone, String studentName, int studentAge,
                 String studentGrade, String studentContact, String courseName,
                 String courseCode, int creditHours) throws SchoolDataException {
        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
              departmentName, departmentCode, teacherName, subject, teacherEmail, phone,
              studentName, studentAge, studentGrade, studentContact);
        
        if (courseCode == null || courseCode.trim().isEmpty()) 
            throw new SchoolDataException("Course code cannot be empty");
        if (creditHours <= 0) 
            throw new SchoolDataException("Credit hours must be > 0");
        
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
    }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public int getCreditHours() { return creditHours; }
    public void setCreditHours(int creditHours) { this.creditHours = creditHours; }
}

class Exam extends Course {
    private String examDate;
    private String examType;
    private int duration;

    public Exam(int id, String createdDate, String updatedDate, String schoolName,
               String address, String phoneNumber, String email, String departmentName,
               String departmentCode, String teacherName, String subject,
               String teacherEmail, String phone, String studentName, int studentAge,
               String studentGrade, String studentContact, String courseName,
               String courseCode, int creditHours, String examDate, String examType,
               int duration) throws SchoolDataException {
        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
              departmentName, departmentCode, teacherName, subject, teacherEmail, phone,
              studentName, studentAge, studentGrade, studentContact, courseName, courseCode,
              creditHours);
        
        if (examDate == null || examDate.trim().isEmpty()) 
            throw new SchoolDataException("Exam date cannot be empty");
        if (duration <= 0) 
            throw new SchoolDataException("Exam duration must be > 0");
        
        this.examDate = examDate;
        this.examType = examType;
        this.duration = duration;
    }

    public String getExamDate() { return examDate; }
    public void setExamDate(String examDate) { this.examDate = examDate; }
    public String getExamType() { return examType; }
    public void setExamType(String examType) { this.examType = examType; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
}

class Result extends Exam {
    private double obtainedMarks;
    private double maxMarks;
    private double percentage;

    public Result(int id, String createdDate, String updatedDate, String schoolName,
                 String address, String phoneNumber, String email, String departmentName,
                 String departmentCode, String teacherName, String subject,
                 String teacherEmail, String phone, String studentName, int studentAge,
                 String studentGrade, String studentContact, String courseName,
                 String courseCode, int creditHours, String examDate, String examType,
                 int duration, double obtainedMarks, double maxMarks) 
                 throws SchoolDataException {
        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
              departmentName, departmentCode, teacherName, subject, teacherEmail, phone,
              studentName, studentAge, studentGrade, studentContact, courseName, courseCode,
              creditHours, examDate, examType, duration);
        
        if (obtainedMarks < 0) throw new SchoolDataException("Obtained marks must be >= 0");
        if (maxMarks <= 0) throw new SchoolDataException("Max marks must be > 0");
        if (obtainedMarks > maxMarks) 
            throw new SchoolDataException("Obtained marks cannot exceed max marks");
        
        this.obtainedMarks = obtainedMarks;
        this.maxMarks = maxMarks;
        this.percentage = 0;
    }

    public double getObtainedMarks() { return obtainedMarks; }
    public void setObtainedMarks(double obtainedMarks) { this.obtainedMarks = obtainedMarks; }
    public double getMaxMarks() { return maxMarks; }
    public void setMaxMarks(double maxMarks) { this.maxMarks = maxMarks; }
    public double getPercentage() { return percentage; }
    public void setPercentage(double percentage) { this.percentage = percentage; }
}

class Fee extends Result {
    private double tutionFee;
    private double libraryFee;
    private double totalFee;

    public Fee(int id, String createdDate, String updatedDate, String schoolName,
              String address, String phoneNumber, String email, String departmentName,
              String departmentCode, String teacherName, String subject,
              String teacherEmail, String phone, String studentName, int studentAge,
              String studentGrade, String studentContact, String courseName,
              String courseCode, int creditHours, String examDate, String examType,
              int duration, double obtainedMarks, double maxMarks, double tutionFee,
              double libraryFee) throws SchoolDataException {
        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
              departmentName, departmentCode, teacherName, subject, teacherEmail, phone,
              studentName, studentAge, studentGrade, studentContact, courseName, courseCode,
              creditHours, examDate, examType, duration, obtainedMarks, maxMarks);
        
        if (tutionFee <= 0) throw new SchoolDataException("Tution fee must be > 0");
        if (libraryFee < 0) throw new SchoolDataException("Library fee must be >= 0");
        
        this.tutionFee = tutionFee;
        this.libraryFee = libraryFee;
        this.totalFee = 0;
    }

    public double getTutionFee() { return tutionFee; }
    public void setTutionFee(double tutionFee) { this.tutionFee = tutionFee; }
    public double getLibraryFee() { return libraryFee; }
    public void setLibraryFee(double libraryFee) { this.libraryFee = libraryFee; }
    public double getTotalFee() { return totalFee; }
    public void setTotalFee(double totalFee) { this.totalFee = totalFee; }
}

final class StudentRecord extends Fee {
    public StudentRecord(int id, String createdDate, String updatedDate, String schoolName,
                        String address, String phoneNumber, String email, String departmentName,
                        String departmentCode, String teacherName, String subject,
                        String teacherEmail, String phone, String studentName, int studentAge,
                        String studentGrade, String studentContact, String courseName,
                        String courseCode, int creditHours, String examDate, String examType,
                        int duration, double obtainedMarks, double maxMarks, double tutionFee,
                        double libraryFee) throws SchoolDataException {
        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
              departmentName, departmentCode, teacherName, subject, teacherEmail, phone,
              studentName, studentAge, studentGrade, studentContact, courseName, courseCode,
              creditHours, examDate, examType, duration, obtainedMarks, maxMarks, tutionFee,
              libraryFee);
    }

    public double calculateAverageMarks() {
        double percentage = (getObtainedMarks() / getMaxMarks()) * 100;
        setPercentage(percentage);
        return percentage;
    }

    public void displayRecord() {
        System.out.println("\n" + Question2_SchoolManagement.STUDENT_ID + " - ========== SCHOOL MANAGEMENT SYSTEM ==========");
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Record ID: " + getId());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Created Date: " + getCreatedDate());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Updated Date: " + getUpdatedDate());
        System.out.println("\n" + Question2_SchoolManagement.STUDENT_ID + " - --- School Details ---");
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - School Name: " + getSchoolName());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Address: " + getAddress());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Phone: " + getPhoneNumber());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Email: " + getEmail());
        System.out.println("\n" + Question2_SchoolManagement.STUDENT_ID + " - --- Department Details ---");
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Department: " + getDepartmentName());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Department Code: " + getDepartmentCode());
        System.out.println("\n" + Question2_SchoolManagement.STUDENT_ID + " - --- Teacher Details ---");
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Teacher Name: " + getTeacherName());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Subject: " + getSubject());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Teacher Email: " + getTeacherEmail());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Teacher Phone: " + getPhone());
        System.out.println("\n" + Question2_SchoolManagement.STUDENT_ID + " - --- Student Details ---");
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Student Name: " + getStudentName());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Age: " + getStudentAge());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Grade: " + getStudentGrade());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Contact: " + getStudentContact());
        System.out.println("\n" + Question2_SchoolManagement.STUDENT_ID + " - --- Course Details ---");
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Course Name: " + getCourseName());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Course Code: " + getCourseCode());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Credit Hours: " + getCreditHours());
        System.out.println("\n" + Question2_SchoolManagement.STUDENT_ID + " - --- Exam Details ---");
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Exam Date: " + getExamDate());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Exam Type: " + getExamType());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Duration (minutes): " + getDuration());
        System.out.println("\n" + Question2_SchoolManagement.STUDENT_ID + " - --- Result Details ---");
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Obtained Marks: " + getObtainedMarks());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Max Marks: " + getMaxMarks());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Percentage: " + String.format("%.2f", getPercentage()) + "%");
        System.out.println("\n" + Question2_SchoolManagement.STUDENT_ID + " - --- Fee Details ---");
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Tution Fee: $" + getTutionFee());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Library Fee: $" + getLibraryFee());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Total Fee: $" + getTotalFee());
        System.out.println(Question2_SchoolManagement.STUDENT_ID + " - ===============================================\n");
    }
}

public class Question2_SchoolManagement {
    public static final String STUDENT_ID = "27264";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println(Question2_SchoolManagement.STUDENT_ID + " - ========== SCHOOL MANAGEMENT SYSTEM ==========\n");
            
            System.out.print("Enter Record ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Created Date (YYYY-MM-DD): ");
            String createdDate = scanner.nextLine();
            
            System.out.print("Enter Updated Date (YYYY-MM-DD): ");
            String updatedDate = scanner.nextLine();
            
            System.out.print("Enter School Name: ");
            String schoolName = scanner.nextLine();
            
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            
            System.out.print("Enter School Phone (10 digits): ");
            String phoneNumber = scanner.nextLine();
            
            System.out.print("Enter School Email: ");
            String email = scanner.nextLine();
            
            System.out.print("Enter Department Name: ");
            String departmentName = scanner.nextLine();
            
            System.out.print("Enter Department Code (alphanumeric, min 3 chars): ");
            String departmentCode = scanner.nextLine();
            
            System.out.print("Enter Teacher Name: ");
            String teacherName = scanner.nextLine();
            
            System.out.print("Enter Subject: ");
            String subject = scanner.nextLine();
            
            System.out.print("Enter Teacher Email: ");
            String teacherEmail = scanner.nextLine();
            
            System.out.print("Enter Teacher Phone (10 digits): ");
            String teacherPhone = scanner.nextLine();
            
            System.out.print("Enter Student Name: ");
            String studentName = scanner.nextLine();
            
            System.out.print("Enter Student Age: ");
            int studentAge = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Student Grade: ");
            String studentGrade = scanner.nextLine();
            
            System.out.print("Enter Student Contact: ");
            String studentContact = scanner.nextLine();
            
            System.out.print("Enter Course Name: ");
            String courseName = scanner.nextLine();
            
            System.out.print("Enter Course Code: ");
            String courseCode = scanner.nextLine();
            
            System.out.print("Enter Credit Hours: ");
            int creditHours = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Exam Date (YYYY-MM-DD): ");
            String examDate = scanner.nextLine();
            
            System.out.print("Enter Exam Type: ");
            String examType = scanner.nextLine();
            
            System.out.print("Enter Exam Duration (minutes): ");
            int duration = scanner.nextInt();
            
            System.out.print("Enter Obtained Marks: ");
            double obtainedMarks = scanner.nextDouble();
            
            System.out.print("Enter Max Marks: ");
            double maxMarks = scanner.nextDouble();
            
            System.out.print("Enter Tution Fee: ");
            double tutionFee = scanner.nextDouble();
            
            System.out.print("Enter Library Fee: ");
            double libraryFee = scanner.nextDouble();
            
            StudentRecord record = new StudentRecord(id, createdDate, updatedDate, schoolName,
                address, phoneNumber, email, departmentName, departmentCode, teacherName,
                subject, teacherEmail, teacherPhone, studentName, studentAge, studentGrade,
                studentContact, courseName, courseCode, creditHours, examDate, examType,
                duration, obtainedMarks, maxMarks, tutionFee, libraryFee);
            
            record.calculateAverageMarks();
            record.setTotalFee(tutionFee + libraryFee);
            record.displayRecord();
            
        } catch (SchoolDataException e) {
            System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(Question2_SchoolManagement.STUDENT_ID + " - Input Error: Please enter valid data");
        } finally {
            scanner.close();
        }
    }
}
