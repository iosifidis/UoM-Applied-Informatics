package gr.uom.thema2;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MultiList {

    private ArrayList<Multi> mList;

    public MultiList(String ip){
        String url = "http://" + ip + "/exams/services23.php";

        try{
            OkHttpHandler okHttpHandler = new OkHttpHandler();

            mList = okHttpHandler.populateDropDown(url);
            Log.d("MultiList", "Number of items in mList: " + mList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllOpers() {
        List<String> temp = new ArrayList<>();
        for (int i=0;i<mList.size();i++) {
            String oper1 = mList.get(i).getOper1();
            String oper2 = mList.get(i).getOper2();
            String tempShow = oper1 + " * " + oper2;
            temp.add(tempShow);
        }
        return temp;
    }

    public String getImage1(String oper) {
        for (int i = 0; i < mList.size(); i++) {
            String currentOper = mList.get(i).getOper1() + " * " + mList.get(i).getOper2();
            if (currentOper.equals(oper)) {
                return mList.get(i).getImage1();
            }
        }
        return null;
    }

    public String getImage2(String oper) {
        for (int i = 0; i < mList.size(); i++) {
            String currentOper = mList.get(i).getOper1() + " * " + mList.get(i).getOper2();
            if (currentOper.equals(oper)) {
                return mList.get(i).getImage2();
            }
        }
        return null;
    }

    public String getOper1(String oper) {
        for (int i = 0; i < mList.size(); i++) {
            String currentOper = mList.get(i).getOper1() + " * " + mList.get(i).getOper2();
            if (currentOper.equals(oper)) {
                return mList.get(i).getOper1();
            }
        }
        return null;
    }

    public String getOper2(String oper) {
        for (int i = 0; i < mList.size(); i++) {
            String currentOper = mList.get(i).getOper1() + " * " + mList.get(i).getOper2();
            if (currentOper.equals(oper)) {
                return mList.get(i).getOper2();
            }
        }
        return null;
    }

    public String getRes(String oper) {
        for (int i = 0; i < mList.size(); i++) {
            String currentOper = mList.get(i).getOper1() + " * " + mList.get(i).getOper2();
            if (currentOper.equals(oper)) {
                return mList.get(i).getRes();
            }
        }
        return null;
    }
}
