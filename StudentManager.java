import java.util.*;

public class StudentManager {

    // DATA STRUCTURES
    private ArrayList<Student> students = new ArrayList<>(); // List ADT
    private HashMap<String, Student> studentMap = new HashMap<>(); // Hash ADT

    /* ================= ADD ================= */
    public void addStudent(Student s) {
        if (studentMap.containsKey(s.getId())) {
            System.out.println("Student ID already exists!");
            return;
        }
        students.add(s);
        studentMap.put(s.getId(), s);
        System.out.println("Student added successfully.");
    }

    /* ================= EDIT ================= */
    public void editStudent(String id, String newName, double newMarks) {
        Student s = studentMap.get(id);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }
        s.setName(newName);
        s.setMarks(newMarks);
        System.out.println("Student updated successfully.");
    }

    /* ================= DELETE ================= */
    public void deleteStudent(String id) {
        Student s = studentMap.remove(id);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }
        students.remove(s);
        System.out.println("Student deleted successfully.");
    }

    /* ================= SORT ================= */
    // Algorithm 1: Bubble Sort by Marks
    public void bubbleSortByMarks() {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - i - 1; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    Collections.swap(students, j, j + 1);
                }
            }
        }
        System.out.println("Sorted by marks using Bubble Sort.");
    }
    /* ================= SORT ================= */
// Algorithm 1: Bubble Sort by Marks (Descending)
    public void bubbleSortByMarkss() {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - i - 1; j++) {
                // ĐỔI DẤU SO SÁNH Ở ĐÂY
                if (students.get(j).getMarks() < students.get(j + 1).getMarks()) {
                    Collections.swap(students, j, j + 1);
                }
            }
        }
        System.out.println("Sorted by marks in descending order using Bubble Sort.");
    }

    // Algorithm 2: TimSort by Name
    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("Sorted by name using TimSort.");
    }

    /* ================= SEARCH ================= */
    // Algorithm 1: Linear Search
    public Student linearSearchByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    // Algorithm 2: Hash Search
    public Student searchById(String id) {
        return studentMap.get(id);
    }

    /* ================= DISPLAY ================= */
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        students.forEach(System.out::println);
    }
}