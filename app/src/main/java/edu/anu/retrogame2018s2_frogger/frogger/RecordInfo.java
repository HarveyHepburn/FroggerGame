package edu.anu.retrogame2018s2_frogger.frogger;

public class RecordInfo implements Comparable<RecordInfo> {
    private String name;
    private int level;
    private int time;

    public RecordInfo(String name, int level, int time) {
        this.name = name;
        this.level = level;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(RecordInfo o) {
        if (this.getLevel() < o.getLevel()) {
            return 1;
        } else if (this.getLevel() > o.getLevel()) {
            return -1;
        }
        if (this.getTime() < o.getTime())
            return -1;
        return 1;
    }
}
