import java.util.Objects;

public class Entry {
    private int time;
    private int room;
    private int lecturer;
    private int course;

    public Entry(int time, int room, int lecturer, int course) {
        this.time = time;
        this.room = room;
        this.lecturer = lecturer;
        this.course = course;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getLecturer() {
        return lecturer;
    }

    public void setLecturer(int lecturer) {
        this.lecturer = lecturer;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;
        Entry entry = (Entry) o;
        return getTime() == entry.getTime() &&
                getRoom() == entry.getRoom();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTime(), getRoom());
    }

    public int timeLecturerHash(){
        return Objects.hash(getTime(), getLecturer());
    }

    @Override
    public String toString() {
        return "Entry{" +
                "time=" + time +
                ", room=" + room +
                ", lecturer=" + lecturer +
                ", course=" + course +
                '}';
    }
}
