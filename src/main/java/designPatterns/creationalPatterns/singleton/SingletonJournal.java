package designPatterns.creationalPatterns.singleton;

public class SingletonJournal {
    // Единственный экземпляр класса
    private static SingletonJournal instance;

    // Приватный конструктор, чтобы предотвратить создание экземпляров извне
    private SingletonJournal() {
        // Инициализация журнала
    }

    // Статический метод для получения экземпляра
    public static SingletonJournal getInstance() {
        if (instance == null) {
            instance = new SingletonJournal();
        }
        return instance;
    }

    // Методы для работы с журналом
    public void addGrade(String studentName, int grade) {
        System.out.println("Adding grade " + grade + " for student " + studentName);
    }
}