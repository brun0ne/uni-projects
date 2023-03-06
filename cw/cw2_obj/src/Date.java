public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(){
        this.day = 25;
        this.month = 10;
        this.year = 2022;
    }

    public int getDay() { return this.day; }
    public int getMonth() { return this.month; }
    public int getYear() { return this.year; }

    public void setDay(int day) { this.day = day; }
    public void setMonth(int month) { this.month = month; }
    public void setYear(int year) { this.year = year; }

    public String toString(){
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean isLeapYear(){
        return (this.year % 400 == 0) || (this.year % 4 == 0 && this.year % 100 != 0);
    }

    public int howManyDaysInMonth(){
        if(this.month == 2)
            return this.isLeapYear() ? 29 : 28;
        else if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11){
            return 30;
        }
        else{
            return 31;
        }
    }

    public boolean isCorrect(){
        if (this.year < 0)
            return false;



        return true;
    }
}
