package Users;

import java.time.LocalDateTime;

public class User {
    private LocalDateTime time;
    private String nameCompany;
    private int weight;

    public User(LocalDateTime time, String nameCompany, int weight) {
        this.time = time;
        this.nameCompany = nameCompany;
        this.weight = weight;
    }

    public LocalDateTime getTime() {
        return time;
    }
    public String getNameCompany() {
        return nameCompany;
    }
    public int getWeight() {
        return weight;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}


