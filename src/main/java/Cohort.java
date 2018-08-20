import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Cohort {
    private String name;
    private List<Student> students;
    private List<Student> pairs;
    public Cohort(String name) {
        this.students = new ArrayList<Student>();
        this.pairs = new ArrayList<Student>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> getPairs() {
        return pairs;
    }

    public void setPairs(List<Student> pairs) {
        this.pairs = pairs;
    }
}//end
