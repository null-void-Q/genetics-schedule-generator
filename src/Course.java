import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

public class Course {
    private int id;
    private boolean lab;
    private String name;


    static public ArrayList<Course> courses;

    public Course(int id, boolean lab, String name) {
        this.id = id;
        this.lab = lab;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLab() {
        return lab;
    }

    public void setLab(boolean lab) {
        this.lab = lab;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<Course> getCourses() {
        return courses;
    }

    public static void setCourses(ArrayList<Course> courses) {
        Course.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getId() == course.getId();
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", lab=" + lab +
                ", name='" + name + '\'' +
                '}';
    }


    public static void readCourses(){
        Course.courses = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("Courses.txt"))) {
            String line = br.readLine();

            while (line != null) {
                String[] info= line.split(",");
                int id= Integer.parseInt(info[0]);
                String name=info[1];
                boolean islab=false;
                if(info[2].equals("L"))
                    islab=true;

                courses.add(new Course(id,islab,name));

                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void printCourses(){
        try {

            PrintWriter writer = new PrintWriter("courses.txt", "UTF-8");
            for(int i=0;i<courses.size();i++)
                writer.println(courses.get(i).getId()+","+courses.get(i).name+","+(courses.get(i).isLab()?"L":"C"));



            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
