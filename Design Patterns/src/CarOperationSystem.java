public class CarOperationSystem {
    // Private static variable to hold the single instance of the class
    private static CarOperationSystem instance;

    // Private constructor to prevent instantiation from outside
    private CarOperationSystem() {
        // Initialization code if needed
    }

    // Public static method to get the single instance of the class
    public static synchronized CarOperationSystem getInstance() {
        // Lazy initialization: create the instance if it doesn't exist yet
        if (instance == null) {
            instance = new CarOperationSystem();
        }
        return instance;
    }

    // Method to perform car operations
    public void operateCar(String operation) {
        // Logic for operating the car
        System.out.println("Performing operation: " + operation);
    }

    // Other methods of the car operation system
    // ...

    // Main method to test the car operation system
    public static void main(String[] args) {
        // Get the instance of the car operation system
        CarOperationSystem carSystem = CarOperationSystem.getInstance();

        // Perform car operations
        carSystem.operateCar("Start Engine");
        carSystem.operateCar("Accelerate");
        carSystem.operateCar("Brake");
    }
}