package gr.uom.teammatches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TeamList {
    ArrayList<Team> teamList = new ArrayList<Team>();

    public TeamList(String ip) {
        String url= "http://"+ip+"/matches/getMembers.php";

        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            teamList = okHttpHandler.populatePlayers(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllBrands() {
        List<String> temp = new ArrayList<String>();
        for (int i = 0; i< teamList.size(); i++) {
            temp.add(teamList.get(i).getName());
        }
        return temp;
    }

    public HashMap<String,String> getAllPlayers(String b) {
        for (int i = 0; i< teamList.size(); i++) {
            if (teamList.get(i).hasName(b)) {
                return teamList.get(i).getMembers();
            }
        }
        return null;
    }

    public String getImageForTeam(String team) {
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).hasName(team)) {
                return teamList.get(i).getImage();
            }
        }
        return null;
    }


}
