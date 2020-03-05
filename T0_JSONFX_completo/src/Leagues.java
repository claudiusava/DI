public class Leagues {

    private String strTeamBadge;
    private String strTeam;
    private String strStadium;
    private String strDescriptionEN;
    private  String strLeague;

    public Leagues(String strTeamBadge, String strTeam, String strStadium, String strDescriptionEN, String strLeague) {
        this.strTeamBadge = strTeamBadge;
        this.strTeam = strTeam;
        this.strStadium = strStadium;
        this.strDescriptionEN = strDescriptionEN;
        this.strLeague = strLeague;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    @Override
    public String toString() {
        return  strTeam;
    }
}

