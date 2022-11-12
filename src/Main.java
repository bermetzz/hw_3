public class Main {
    public static void main(String[] args){
        BankAccount bankAccount = new BankAccount();
        System.out.println("you have on your account: ");
        bankAccount.deposit(20000);
        while (true){
            try{
                bankAccount.withDraw(6000);
                System.out.println("success!");

            }catch (LimitException le){

                try {
                    System.out.println("you have withdrawn residual amount from your bank account: "+
                            bankAccount.getAmount());
//                    bankAccount.withDraw((int) bankAccount.getAmount());
                    bankAccount.withDraw((int) le.getRemainingAmount());
                } catch (LimitException e) {
                    e.printStackTrace();
                }
                System.out.println(le.getMessage());
                break;
            }
        }
    }
}
