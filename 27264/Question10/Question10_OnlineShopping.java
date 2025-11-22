import java.util.Scanner;

class ShoppingException extends Exception {
    public ShoppingException(String message) {
        super(message);
    }
}

class ShoppingEntity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public ShoppingEntity(int id, String createdDate, String updatedDate) throws ShoppingException {
        if (id <= 0) throw new ShoppingException("ID must be greater than 0");
        if (createdDate == null || createdDate.trim().isEmpty()) 
            throw new ShoppingException("Created date cannot be null or empty");
        if (updatedDate == null || updatedDate.trim().isEmpty()) 
            throw new ShoppingException("Updated date cannot be null or empty");
        
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

class Store extends ShoppingEntity {
    private String storeName;
    private String address;
    private String phoneNumber;
    private String email;

    public Store(int id, String createdDate, String updatedDate, String storeName, 
                   String address, String phoneNumber, String email) throws ShoppingException {
        super(id, createdDate, updatedDate);
        
        if (!phoneNumber.matches("\\d{10}")) 
            throw new ShoppingException("Phone number must be exactly 10 digits");
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new ShoppingException("Invalid email format");
        
        this.storeName = storeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

class Category extends Store {
    private String categoryName;
    private String categoryCode;

    public Category(int id, String createdDate, String updatedDate, String storeName,
                  String address, String phoneNumber, String email, String categoryName,
                  String categoryCode) throws ShoppingException {
        super(id, createdDate, updatedDate, storeName, address, phoneNumber, email);
        
        if (categoryCode.length() < 3 || !categoryCode.matches("^[a-zA-Z0-9]+$")) 
            throw new ShoppingException("Category code must be alphanumeric and at least 3 characters");
        
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getCategoryCode() { return categoryCode; }
    public void setCategoryCode(String categoryCode) { this.categoryCode = categoryCode; }
}

class Product extends Category {
    private String productName;
    private String brand;
    private String productEmail;
    private String phone;

    public Product(int id, String createdDate, String updatedDate, String storeName,
                  String address, String phoneNumber, String email, String categoryName,
                  String categoryCode, String productName, String brand,
                  String productEmail, String phone) throws ShoppingException {
        super(id, createdDate, updatedDate, storeName, address, phoneNumber, email,
              categoryName, categoryCode);
        
        if (brand == null || brand.trim().isEmpty()) 
            throw new ShoppingException("Brand cannot be empty");
        if (!productEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) 
            throw new ShoppingException("Invalid product email format");
        if (!phone.matches("\\d{10}")) 
            throw new ShoppingException("Product phone must be exactly 10 digits");
        
        this.productName = productName;
        this.brand = brand;
        this.productEmail = productEmail;
        this.phone = phone;
    }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getProductEmail() { return productEmail; }
    public void setProductEmail(String productEmail) { this.productEmail = productEmail; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}

class ShoppingCustomer extends Product {
    private String customerName;
    private String customerType;
    private int yearsOfMembership;

    public ShoppingCustomer(int id, String createdDate, String updatedDate, String storeName,
                String address, String phoneNumber, String email, String categoryName,
                String categoryCode, String productName, String brand,
                String productEmail, String phone, String customerName, String customerType,
                int yearsOfMembership) throws ShoppingException {
        super(id, createdDate, updatedDate, storeName, address, phoneNumber, email,
              categoryName, categoryCode, productName, brand, productEmail, phone);
        
        if (!customerType.equals("Regular") && !customerType.equals("Premium")) 
            throw new ShoppingException("Customer type must be 'Regular' or 'Premium'");
        if (yearsOfMembership < 0) 
            throw new ShoppingException("Years of membership must be >= 0");
        
        this.customerName = customerName;
        this.customerType = customerType;
        this.yearsOfMembership = yearsOfMembership;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getCustomerType() { return customerType; }
    public void setCustomerType(String customerType) { this.customerType = customerType; }
    public int getYearsOfMembership() { return yearsOfMembership; }
    public void setYearsOfMembership(int yearsOfMembership) { this.yearsOfMembership = yearsOfMembership; }
}

class Order extends ShoppingCustomer {
    private String orderNumber;
    private int quantity;
    private String orderStatus;
    private String contactNumber;

    public Order(int id, String createdDate, String updatedDate, String storeName,
                  String address, String phoneNumber, String email, String categoryName,
                  String categoryCode, String productName, String brand,
                  String productEmail, String phone, String customerName, String customerType,
                  int yearsOfMembership, String orderNumber, int quantity, String orderStatus,
                  String contactNumber) throws ShoppingException {
        super(id, createdDate, updatedDate, storeName, address, phoneNumber, email,
              categoryName, categoryCode, productName, brand, productEmail, phone,
              customerName, customerType, yearsOfMembership);
        
        if (quantity <= 0) throw new ShoppingException("Quantity must be > 0");
        if (!orderStatus.equals("Processing") && !orderStatus.equals("Shipped") && !orderStatus.equals("Delivered")) 
            throw new ShoppingException("Order status must be 'Processing', 'Shipped', or 'Delivered'");
        
        this.orderNumber = orderNumber;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
        this.contactNumber = contactNumber;
    }

    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}

class ShoppingPayment extends Order {
    private String paymentMethod;
    private String transactionId;
    private double price;

    public ShoppingPayment(int id, String createdDate, String updatedDate, String storeName,
                    String address, String phoneNumber, String email, String categoryName,
                    String categoryCode, String productName, String brand,
                    String productEmail, String phone, String customerName, String customerType,
                    int yearsOfMembership, String orderNumber, int quantity, String orderStatus,
                    String contactNumber, String paymentMethod, String transactionId,
                    double price) throws ShoppingException {
        super(id, createdDate, updatedDate, storeName, address, phoneNumber, email,
              categoryName, categoryCode, productName, brand, productEmail, phone,
              customerName, customerType, yearsOfMembership, orderNumber, quantity, orderStatus, contactNumber);
        
        if (price <= 0) 
            throw new ShoppingException("Price must be > 0");
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) 
            throw new ShoppingException("Payment method cannot be empty");
        if (transactionId == null || transactionId.trim().isEmpty()) 
            throw new ShoppingException("Transaction ID cannot be empty");
        
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

class Shipping extends ShoppingPayment {
    private String shippingAddress;
    private String carrier;
    private double shippingCost;

    public Shipping(int id, String createdDate, String updatedDate, String storeName,
                    String address, String phoneNumber, String email, String categoryName,
                    String categoryCode, String productName, String brand,
                    String productEmail, String phone, String customerName, String customerType,
                    int yearsOfMembership, String orderNumber, int quantity, String orderStatus,
                    String contactNumber, String paymentMethod, String transactionId,
                    double price, String shippingAddress, String carrier,
                    double shippingCost) throws ShoppingException {
        super(id, createdDate, updatedDate, storeName, address, phoneNumber, email,
              categoryName, categoryCode, productName, brand, productEmail, phone,
              customerName, customerType, yearsOfMembership, orderNumber, quantity, orderStatus, contactNumber,
              paymentMethod, transactionId, price);
        
        if (shippingAddress == null || shippingAddress.trim().isEmpty()) 
            throw new ShoppingException("Shipping address cannot be null");
        if (shippingCost < 0) 
            throw new ShoppingException("Shipping cost must be >= 0");
        
        this.shippingAddress = shippingAddress;
        this.carrier = carrier;
        this.shippingCost = shippingCost;
    }

    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }
    public String getCarrier() { return carrier; }
    public void setCarrier(String carrier) { this.carrier = carrier; }
    public double getShippingCost() { return shippingCost; }
    public void setShippingCost(double shippingCost) { this.shippingCost = shippingCost; }
}

class ShoppingInvoice extends Shipping {
    private double taxAmount;
    private double discount;
    private double totalAmount;

    public ShoppingInvoice(int id, String createdDate, String updatedDate, String storeName,
               String address, String phoneNumber, String email, String categoryName,
               String categoryCode, String productName, String brand,
               String productEmail, String phone, String customerName, String customerType,
               int yearsOfMembership, String orderNumber, int quantity, String orderStatus,
               String contactNumber, String paymentMethod, String transactionId,
               double price, String shippingAddress, String carrier,
               double shippingCost, double taxAmount, double discount) 
               throws ShoppingException {
        super(id, createdDate, updatedDate, storeName, address, phoneNumber, email,
              categoryName, categoryCode, productName, brand, productEmail, phone,
              customerName, customerType, yearsOfMembership, orderNumber, quantity, orderStatus, contactNumber,
              paymentMethod, transactionId, price, shippingAddress, carrier, shippingCost);
        
        if (taxAmount < 0) throw new ShoppingException("Tax amount must be >= 0");
        if (discount < 0) throw new ShoppingException("Discount must be >= 0");
        
        this.taxAmount = taxAmount;
        this.discount = discount;
        this.totalAmount = 0;
    }

    public double getTaxAmount() { return taxAmount; }
    public void setTaxAmount(double taxAmount) { this.taxAmount = taxAmount; }
    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}

final class OrderRecord extends ShoppingInvoice {
    public OrderRecord(int id, String createdDate, String updatedDate, String storeName,
                         String address, String phoneNumber, String email, String categoryName,
                         String categoryCode, String productName, String brand,
                         String productEmail, String phone, String customerName, String customerType,
                         int yearsOfMembership, String orderNumber, int quantity, String orderStatus,
                         String contactNumber, String paymentMethod, String transactionId,
                         double price, String shippingAddress, String carrier,
                         double shippingCost, double taxAmount, double discount) 
                         throws ShoppingException {
        super(id, createdDate, updatedDate, storeName, address, phoneNumber, email,
              categoryName, categoryCode, productName, brand, productEmail, phone,
              customerName, customerType, yearsOfMembership, orderNumber, quantity, orderStatus, contactNumber,
              paymentMethod, transactionId, price, shippingAddress, carrier, shippingCost,
              taxAmount, discount);
    }

    public double calculateTotalAmount() {
        double total = getPrice() + getShippingCost();
        setTotalAmount(total);
        return total;
    }

    public void displayRecord() {
        System.out.println("\n" + Question10_OnlineShopping.STUDENT_ID + " - ========== ONLINE SHOPPING SYSTEM ==========");
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Record ID: " + getId());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Created Date: " + getCreatedDate());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Updated Date: " + getUpdatedDate());
        System.out.println("\n" + Question10_OnlineShopping.STUDENT_ID + " - --- Store Details ---");
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Store Name: " + getStoreName());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Address: " + getAddress());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Phone: " + getPhoneNumber());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Email: " + getEmail());
        System.out.println("\n" + Question10_OnlineShopping.STUDENT_ID + " - --- Category Details ---");
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Category Name: " + getCategoryName());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Category Code: " + getCategoryCode());
        System.out.println("\n" + Question10_OnlineShopping.STUDENT_ID + " - --- Product Details ---");
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Product Name: " + getProductName());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Brand: " + getBrand());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Product Email: " + getProductEmail());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Product Phone: " + getPhone());
        System.out.println("\n" + Question10_OnlineShopping.STUDENT_ID + " - --- Customer Details ---");
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Customer Name: " + getCustomerName());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Customer Type: " + getCustomerType());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Years of Membership: " + getYearsOfMembership());
        System.out.println("\n" + Question10_OnlineShopping.STUDENT_ID + " - --- Order Details ---");
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Order Number: " + getOrderNumber());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Quantity: " + getQuantity());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Order Status: " + getOrderStatus());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Contact Number: " + getContactNumber());
        System.out.println("\n" + Question10_OnlineShopping.STUDENT_ID + " - --- Payment Details ---");
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Payment Method: " + getPaymentMethod());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Transaction ID: " + getTransactionId());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Price: $" + getPrice());
        System.out.println("\n" + Question10_OnlineShopping.STUDENT_ID + " - --- Shipping Details ---");
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Shipping Address: " + getShippingAddress());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Carrier: " + getCarrier());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Shipping Cost: $" + getShippingCost());
        System.out.println("\n" + Question10_OnlineShopping.STUDENT_ID + " - --- Invoice Details ---");
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Tax Amount: $" + getTaxAmount());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Discount: $" + getDiscount());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Total Amount: $" + getTotalAmount());
        System.out.println(Question10_OnlineShopping.STUDENT_ID + " - ============================================\n");
    }
}

public class Question10_OnlineShopping {
    public static final String STUDENT_ID = "27264";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println(Question10_OnlineShopping.STUDENT_ID + " - ========== ONLINE SHOPPING SYSTEM ==========\n");
            
            System.out.print("Enter Record ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Created Date (YYYY-MM-DD): ");
            String createdDate = scanner.nextLine();
            
            System.out.print("Enter Updated Date (YYYY-MM-DD): ");
            String updatedDate = scanner.nextLine();
            
            System.out.print("Enter Store Name: ");
            String storeName = scanner.nextLine();
            
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            
            System.out.print("Enter Store Phone (10 digits): ");
            String phoneNumber = scanner.nextLine();
            
            System.out.print("Enter Store Email: ");
            String email = scanner.nextLine();
            
            System.out.print("Enter Category Name: ");
            String categoryName = scanner.nextLine();
            
            System.out.print("Enter Category Code (alphanumeric, min 3 chars): ");
            String categoryCode = scanner.nextLine();
            
            System.out.print("Enter Product Name: ");
            String productName = scanner.nextLine();
            
            System.out.print("Enter Brand: ");
            String brand = scanner.nextLine();
            
            System.out.print("Enter Product Email: ");
            String productEmail = scanner.nextLine();
            
            System.out.print("Enter Product Phone (10 digits): ");
            String productPhone = scanner.nextLine();
            
            System.out.print("Enter Customer Name: ");
            String customerName = scanner.nextLine();
            
            System.out.print("Enter Customer Type (Regular/Premium): ");
            String customerType = scanner.nextLine();
            
            System.out.print("Enter Years of Membership: ");
            int yearsOfMembership = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Order Number: ");
            String orderNumber = scanner.nextLine();
            
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Order Status (Processing/Shipped/Delivered): ");
            String orderStatus = scanner.nextLine();
            
            System.out.print("Enter Contact Number: ");
            String contactNumber = scanner.nextLine();
            
            System.out.print("Enter Payment Method: ");
            String paymentMethod = scanner.nextLine();
            
            System.out.print("Enter Transaction ID: ");
            String transactionId = scanner.nextLine();
            
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Enter Shipping Address: ");
            String shippingAddress = scanner.nextLine();
            
            System.out.print("Enter Carrier: ");
            String carrier = scanner.nextLine();
            
            System.out.print("Enter Shipping Cost: ");
            double shippingCost = scanner.nextDouble();
            
            System.out.print("Enter Tax Amount: ");
            double taxAmount = scanner.nextDouble();
            
            System.out.print("Enter Discount: ");
            double discount = scanner.nextDouble();
            
            OrderRecord record = new OrderRecord(id, createdDate, updatedDate, storeName,
                address, phoneNumber, email, categoryName, categoryCode, productName, brand,
                productEmail, productPhone, customerName, customerType, yearsOfMembership,
                orderNumber, quantity, orderStatus, contactNumber, paymentMethod, transactionId, price,
                shippingAddress, carrier, shippingCost, taxAmount, discount);
            
            record.calculateTotalAmount();
            record.displayRecord();
            
        } catch (ShoppingException e) {
            System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(Question10_OnlineShopping.STUDENT_ID + " - Input Error: Please enter valid data");
        } finally {
            scanner.close();
        }
    }
}
