import java.util.Scanner;
public class ATMSimulator {
    //任务1:ATM模拟器
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double account = 1000;
        while(true){
            System.out.println("1. 账户余额 2. 取款 3. 存款 0. 退出");
            System.out.print("选择操作:");
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.print("账户余额: " + account);
            }else if(choice == 2){ //取款
                System.out.print("输入金额: ");
                int amount = sc.nextInt();
                if (amount > account) {
                    System.out.print("错误:资金不足。可用性:" + account);
                } else {
                    account = account - amount;
                    System.out.print("取款成功。当前余额:" + account);
                }
            }else if(choice == 3){ //存款
                System.out.print("输入金额:");
                double amount = sc.nextDouble();
                account = account + amount;
                System.out.print("存款成功。当前余额:" + account);
            } else if (choice == 0) {
                System.out.print("退出");
                break;
            }else {
                System.out.print("输入错误，请重新输入！");
            }
        }

    }
}