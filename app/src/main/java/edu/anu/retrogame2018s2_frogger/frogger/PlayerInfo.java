package edu.anu.retrogame2018s2_frogger.frogger;

public class PlayerInfo implements Comparable<PlayerInfo> {
    private String name;
    private int level;
    private int time;

    public PlayerInfo(String name, int level, int time) {
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
    public int compareTo(PlayerInfo o) {
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
