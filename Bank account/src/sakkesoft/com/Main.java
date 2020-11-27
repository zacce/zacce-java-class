package sakkesoft.com;

public class Main {

    public static void main(String[] args) {
    BankAccount bankaccount = new BankAccount();
        bankaccount.accountNumber="12345-1234";
        bankaccount.customerName="John Doe";
        bankaccount.phoneNumber="040-1234567";
        bankaccount.Email="john.doe@mail.com";
        bankaccount.depositFunds(10000);
        bankaccount.withdrawFunds(305.50);
        //System.out.println(bankaccount.getBalance());

    }
    public static class BankAccount{
        private String accountNumber;
        private double balance;
        private String customerName;
        private String Email;
        private String phoneNumber;

        public void setAccountNumber(String accountNumber){
            this.accountNumber=accountNumber;
        }
        public void setBalance(double balance){
            this.balance=balance;
        }
        public void setCustomerName(String customerName){
            this.customerName=customerName;
        }
        public void setEmail(String email){
            this.Email=email;
        }
        public void setPhoneNumber(String phoneNumber){
            this.phoneNumber=phoneNumber;
        }
        public String getAccountNumber(){
            return this.accountNumber;
        }
        public double getBalance(){
            return this.balance;
        }
        public String getCustomerName(){
            return this.customerName;
        }
        public String getEmail(){
            return this.Email;
        }
        public String getPhoneNumber(){
            return this.phoneNumber;
        }
        public void depositFunds(double deposit){
           // System.out.println("original balance= "+getBalance());
            deposit=getBalance()+deposit;
            setBalance(deposit);;
            System.out.println("Tilille tallennettu ="+getBalance());
        }
        public void withdrawFunds(double withdraw){
            if (this.balance-withdraw <0){
                System.out.println("Nosto "+withdraw+" Tilillä ei ole tarpeeksi rahaa "+getBalance());
            }else {
                System.out.println("original balance= " + getBalance());
                System.out.println("Nosto "+withdraw);
                withdraw = getBalance() - withdraw;
                setBalance(withdraw);
                System.out.println("Tilillä ="+getBalance());
            }
        }

    }
}
