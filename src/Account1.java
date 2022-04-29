import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

class Account{
    private int id = 0;   //账户名
    private double balance = 0;   //余额
    static private double annualInterestRate = 0;      //年利率
    private java.util.Date dateCreate = new java.util.Date();  //开户日期
    Account(){  //创建默认账户
        dateCreate = new Date();
    }

    Account(int ID,double Balances){  //创建指定用户和初始余额
        id = ID;
        balance = Balances;
        dateCreate = new Date();
    }

    public int getID(){  //访问 ID
        return id;
    }

    public void setID(int name){  //修改 ID
        id = name;
    }

    public double getBalance(){  //访问 余额
        return balance;
    }

    public void setBalance(double newbalance){  //修改 余额
        balance =  newbalance;
    }

    public double getAnnualInterestRate(){   //访问 年利率
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double newrate){   //修改 年利率
        annualInterestRate = newrate;
    }

    public java.util.Date getDateCreate(){  //访问 开户日期
        return dateCreate;
    }

    public double getMonthlyInterestRate(){  //返回月利率;
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest(){  //返回月利息
        return balance * getMonthlyInterestRate();
    }

    public void withDraw(double drawMoney){  //取款
        if (balance >= drawMoney)
            balance = balance - drawMoney;
    }

    public void deposit(double saveMoney){  //存款
        balance = balance + saveMoney;
    }
}

public class Account1 extends Account{
    private String name; //客户名
    private ArrayList<Transaction> transactions;  //存储交易明细
    public Account1(String Name,int ID,double Balances){  //创建具有指定名字，id和余额的账户
        name = Name;
        setID(ID);
        setBalance(Balances);
        this.transactions = new ArrayList<Transaction>();
    }
    public void Draw(double Money){   //取款
        withDraw(Money);
        transactions.add( new Transaction('W',Money,getBalance(),"交易成功"));
    }
    public void Deposit(double Money){  //存款
        deposit(Money);
        transactions.add( new Transaction('D',Money,getBalance(),"交易成功"));
    }
    public String getName(){  //访问 客户名
        return name;
    }
    public void setName(String Name){  //修改 客户名
        name = Name;
    }
    public static void main(String[] args) {
        Account1 account = new Account1("George",1122,1000.0);
        account.setAnnualInterestRate(1.5/100);
        account.Deposit(30.0);
        account.Deposit(40.0);
        account.Deposit(50.0);
        account.Draw(5.0);
        account.Draw(4.0);
        account.Draw(2.0);
        System.out.println("客户名：" + account.getName() + " 年利率：" + account.getAnnualInterestRate() + " 当前余额：" + account.getBalance() + "美元");
        System.out.print(account.transactions.toString());
    }
}

class Transaction{
    private Date date;  //该交易的日期
    private char type;  //交易类型，如“W”代表取款，“D”代表存款
    private double amount;  //交易量
    private double balance; //交易后新的余额
    private String description;  //交易描述
    Transaction(char Type,double Amount,double Balance,String Description){
        type = Type;
        amount = Amount;
        balance = Balance;
        description = Description;
        date = new Date();
    }
    public Date getDate(){  //访问 交易日期
        return date;
    }
    public char getType(){  //访问 交易类型
        return type;
    }
    public double getAmount(){  //访问 交易量
        return amount;
    }
    public double getBalance(){  //访问 交易后余额
        return balance;
    }
    @Override
    public String toString(){
        return "交易记录：" + new SimpleDateFormat("yyyy-MM-dd").format(date) + " " + type + " " + amount + " " + balance + " 美元 " + description + "\n";
    }
}