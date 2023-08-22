package gr.uom.thema2;

public class Multi {

    private String image1;
    private String image2;
    private String oper1;
    private String oper2;
    private String res;

    public Multi(String image1, String image2, String oper1, String oper2, String res) {
        this.image1 = image1;
        this.image2 = image2;
        this.oper1 = oper1;
        this.oper2 = oper2;
        this.res = res;
    }

    public String getImage1() {
        return image1;
    }

    public String getImage2() {
        return image2;
    }
    public String getOper1() {
        return oper1;
    }

    public String getOper2() {
        return oper2;
    }

    public String getRes() {
        return res;
    }

}
