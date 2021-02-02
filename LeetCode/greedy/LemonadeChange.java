package greedy;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/02 9:34
 * @Description: 860. 柠檬水找零 https://leetcode-cn.com/problems/lemonade-change/
 */
public class LemonadeChange {
    public boolean lemonadeChange1(int[] bills) {
        // 账单为5，five++
        // 账单为10，five--,ten++
        // 账单为20，先ten--,five-- or 3次five--
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            if (bill == 10) {
                if (five < 0) return false;
                five--;
                ten++;
            }
            if (bill == 20) {
                if (ten > 0 && five > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else return false;
            }
        }
        return true;
    }

    public boolean lemonadeChange2(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            else if (bill == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
}
