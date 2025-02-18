package designPatterns.creationalPatterns.singleton;

public enum EnumSingleton {
    INSTANCE;

        // Методы для работы с журналом
        public void addGrade(String studentName, int grade) {
            System.out.println("Adding grade " + grade + " for student " + studentName);
        }
}
