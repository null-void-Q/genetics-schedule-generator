import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Table implements Comparable<Table> {
    private int id;
    private ArrayList<Entry> entries;
    private int fitness;



    public Table(int id, ArrayList<Entry> entries) {
        this.id = id;
        this.entries = entries;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Entry> getEnteries() {
        return entries;
    }

    public void setEnteries(ArrayList<Entry> entries) {
        this.entries = entries;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;

    }

    @Override
    public int compareTo(Table o) {
        if (this == o) return 0;
        if (!(o instanceof Table)) return -2;

        if(this.getFitness() > o.getFitness())
            return 1;
        else if(this.getFitness() == o.getFitness())
            return 0;
        else
            return -1;

    }

    public void calculateFitness(){
        setFitness(timeRoomConflicts()+lecturerTimeConflict()+hoursViolations());
    }

    public int timeRoomConflicts(){ //calculate how many entries have the same (room and time)
        int count=0;
        HashMap<Integer,Entry> ht =new HashMap<>();
        ArrayList<Entry> e = getEnteries();
        for(int i=0;i<e.size();i++) {
            int hash=e.get(i).hashCode();
            if (ht.get(hash) == null)
                ht.put(hash, e.get(i));
            else
                count++;
        }
        return count;
    }
    public int lecturerTimeConflict(){//calculate how many classes a teacher has in the same time slot
        int count=0;
        HashMap<Integer,Entry> ht =new HashMap<>();
        ArrayList<Entry> e = getEnteries();
        for(int i=0;i<e.size();i++) {
            int hash=e.get(i).timeLecturerHash();
            if (ht.get(hash) == null)
                ht.put(hash, e.get(i));
            else
                count++;
        }
        return count;
    }
     public int hoursViolations(){ //add hours for each teacher in a hash table and then check the violations
        int violations=0;

         HashMap<Integer,Integer> ht =new HashMap<>();
         ArrayList<Entry> e = getEnteries();
         for(int i=0;i<e.size();i++) {
             Entry en=e.get(i);
             int hours=0;
             if(Course.getCourses().get(en.getCourse()).isLab())
                 hours=2;
             else
                 hours=3;
             int hash=en.getLecturer();
             if (ht.get(hash) == null)
                 ht.put(hash,hours);
             else
                 ht.put(hash,ht.get(hash)+hours);
         }

         for(int i=0;i<ht.size();i++) {
             int hours=ht.getOrDefault(i, 0);
             if (hours > 18 || hours <12)
                 violations++;
         }

        return violations;

     }
}
