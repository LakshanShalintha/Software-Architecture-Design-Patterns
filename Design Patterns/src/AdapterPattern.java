public class AdapterPattern {

    // Target interface
    interface Target {
        void displayAverageMarks();
    }

    // Adaptee class with specific methods for two subjects
    static class MarksAdaptee {
        private int mathMarks;
        private int scienceMarks;

        public MarksAdaptee(int mathMarks, int scienceMarks) {
            this.mathMarks = mathMarks;
            this.scienceMarks = scienceMarks;
        }

        public int getMathMarks() {
            return mathMarks;
        }

        public int getScienceMarks() {
            return scienceMarks;
        }

        public double calculateAverage() {
            return (mathMarks + scienceMarks) / 2.0;
        }

        public int calculateSum() {
            return mathMarks + scienceMarks;
        }
    }

    // Adapter class implementing Target and using MarksAdaptee
    static class MarksAdapter implements Target {
        private MarksAdaptee adaptee;

        public MarksAdapter(MarksAdaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void displayAverageMarks() {
            double average = adaptee.calculateAverage();
            int sum = adaptee.calculateSum();
            System.out.println("Marks after adaptation:");
            System.out.println("Sum of marks: " + sum);
            System.out.println("Average marks: " + average);
        }
    }

    // Main method to demonstrate the Adapter pattern with marks
    public static void main(String[] args) {
        MarksAdaptee adaptee = new MarksAdaptee(85, 90);

        // Display individual marks before adaptation
        System.out.println("Marks before adaptation:");
        int sum = adaptee.calculateSum();
        System.out.println("Math marks: " + adaptee.getMathMarks());
        System.out.println("Science marks: " + adaptee.getScienceMarks());
        System.out.println("Sum of marks: " + sum);
        System.out.println("----------------------------------");

        // Adapt and display average marks
        Target target = new MarksAdapter(adaptee);
        target.displayAverageMarks();  // Should print the average marks of the two subjects
    }
}
