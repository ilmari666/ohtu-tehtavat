
package ohtu;

public class Player {
    private String name;
    private String birthdate;
    private String team;
    private String nationality;
    private int goals;
    private int assists;
    private int penalties;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate=birthdate;
    }
    public String geBirthdate() {
        return birthdate;
    }

    public void setTeam(String team) {
        this.team=team;
    }
    public String getTeam(){
        return team;
    }
    public void setGoals(int goals) {
        this.goals=goals;
    }
    public int getGoals(){
        return goals;
    }
    public void setAssists(int assists) {
        this.assists=assists;
    }
    public int getAssists(){
        return assists;
    }
    public void setPenalties(int penalties) {
        this.penalties=penalties;
    }
    public int getPenalties(){
        return penalties;
    }
    public void setNationality(String nationality) {
        this.nationality=nationality;
    }
    public String getNationality() {
        return nationality;
    }


    @Override
    public String toString() {
        return name+"\t"+team+"\t"+goals+" + "+assists+" = "+(goals+assists);
    }
      
}
