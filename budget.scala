/* 
- Budget app that sets limits for monthly wage of a person
- Each person has there own personal budget
- Can swap between people
- Frontend?
- 50% needs
- 30% wants
- 20% save
- Pattern matching with the months
- May, June, July spend more money than other months
- Date: 5/3/25
- check for git
 */
import scala.io.StdIn.readLine
import scala.io.StdIn


@main def start() = 
    println("Enter a name")
    val userNameInput = StdIn.readLine()
    val user1 = Person(userNameInput)
    println("Enter monthly income")
    val SetIncome = user1.incomes(Income().addIncome(StdIn.readDouble()))
    var realIncome = user1.getIncomes_()
    //println("Set month and income")
    //val userMonthInput = StdIn.readLine()
    //val SetMonth = user1.setMonth(userMonthInput)
    //val monthBudget = user1.budgetForMonth(SetMonth, realIncome)
    //val monthIncome = user1.budgetForMonth()
    //val monthIncome = user1.budgetForMonth()
    println(s"Your name is saved as ${user1.name}")
    //val monthBudget = user1.budgetForMonth(SetMonth, realIncome)
    //println("Set month and income")
    //println(user1.budgetForMonth("may", (1000.00)))
    println("Enter the month to budget")
    println(s"Your month and needs, wants, savings budget is ${user1.budgetForMonth(StdIn.readLine(), realIncome)}")
    val purchase = user1.makePurchase("game", 60.00)
    println(purchase)
    println(s"Current income is ${user1.getIncomes_()}")

/* 
    - function for adding money to account
    - function for calculating monthly budget
    - function for calculating items you want to buy **
    - When buying an item choose which type of purchase it is and take out the correct cash from that purchase type. E.g if a purchase is a need, only take money from the needs
 */
case class Person(name: String):
    //private val Name = name
    private var incomes_ : Double = 0
    private var month = "may"
    // Sets budget for the month for the user. It get the method from the income class and in that the class the monthly income.
    def budgetForMonth(time: String, money: Double ): (Double, Double, Double) =
        var monthMoney = Income().monthlyIncome(time, money)
        monthMoney
        //print(monthMoney)
        //println(Income().monthlyIncome(time, money))

    
    // Adds income to the users account. Uses addIncome thats set in the income class. It returns the variable member called "income_" which returns the current income of the user. 
    def incomes(expenses: Double): Unit =
        var expense = Income().addIncome(expenses)
        incomes_ = expense
        incomes_
    // Getter method that retrievs income from the private methdo
    def getIncomes_(): Double =
        incomes_
    // Sets the month of the 
    def setMonth(x: String): String =
        var monthSetter = Month().setTime(x)
        month = monthSetter
        month
    
    def makePurchase(item: String, cost: Double): (String, Double) =
        val bought = item
        incomes_ = incomes_ - cost
        /*
        purchaseType match
            case "needs" =>
        */
        (item, incomes_)
        
// class for all income methods
class Income():

    private var _income : Double = 0

    def monthlyIncome(month: String, y: Double): (Double, Double, Double) =
        var needs = y * 0.5
        val wants = y * 0.3
        val save  = y * 0.2
        val time = Month().setTime(month)
        time match
            case "may" => (y * 0.7, y * 0.2, y * 0.1)
            case "june" => (y * 0.7, y * 0.2, y * 0.1)
            case "july" => (y * 0.7, y * 0.2, y * 0.1)
            case _ =>
        //println(s" Spending for needs ${needs}, wants ${wants}, save ${save}")
        (needs, wants, save)
        

    // Adds income to account
    def addIncome(add: Double): Double = 
        var newIncome = _income + add
        _income = newIncome
        _income
    // Returns the current income to the account
    def income_(): Double = _income

// sets month for user        
class Month():
    // variable for settting the month in Budget
    private var currentMonth : String = "January"
    // method that sets the month for users budget
    def setTime(month: String): String =
        var month = currentMonth
        currentMonth





