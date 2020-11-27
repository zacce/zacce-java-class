package sakkesoft.com;

public class Main {

    public static void main(String[] args) {

        VipCustomer vipcustomer = new VipCustomer();

        VipCustomer sakke_testaa = new VipCustomer("Sakke",10000,"sakke@sci.fi");
        System.out.println(sakke_testaa.getCreaditLimit());
        System.out.println(sakke_testaa.getName());
        System.out.println(sakke_testaa.geteMail());
        VipCustomer emptyVIP = new VipCustomer();
        System.out.println(emptyVIP.getCreaditLimit());
        System.out.println(emptyVIP.getName());
        System.out.println(emptyVIP.geteMail());
        VipCustomer John = new VipCustomer("John",5000);
        System.out.println(John.getCreaditLimit());
        System.out.println(John.getName());
        System.out.println(John.geteMail());
    }
    public static class VipCustomer{
        private String name;
        private double creaditLimit;
        private String eMail;

        public VipCustomer(){
            this("Sakke Testaa",10000,"sakke@sci.fi");
        }


        public VipCustomer(String name, double creaditLimit) {
            this(name, creaditLimit, "john.doe@mail.com");
        }

        public VipCustomer(String name, double creaditLimit, String eMail) {
            this.name = name;
            this.creaditLimit = creaditLimit;
            this.eMail = eMail;
        }

        public String getName() {
            return name;
        }

        public double getCreaditLimit() {
            return creaditLimit;
        }

        public String geteMail() {
            return eMail;
        }
    }
}
