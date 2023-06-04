public class Customer {

    private String name;
    private String afm;
    private BankAccount account;

    public Customer() {
    }

    public Customer(BankAccount account){
        this.account = account;
    }

    public Customer(String aName, String someAFM, BankAccount account){
        this.name = aName;
        this.afm = someAFM;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getAfm() {
        return afm;
    }

    public Customer setAfm(String afm) {
        this.afm = afm;
        return this;
    }

    public BankAccount getAccount() {
        return account;
    }

    public Customer build(){
        return this;
    }

    public Customer setAccount(BankAccount account) {
        this.account = account;
        return this;
    }

    public String toString(){
        return "Customer " + name + " with afm "+afm;
    }
}
