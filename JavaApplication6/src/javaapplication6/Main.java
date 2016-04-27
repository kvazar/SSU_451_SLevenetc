/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author верыкенку
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                  Scanner sc = new Scanner(System.in);
          System.out.println("Jahre Anfang");
           try {
        int firstYear = sc.nextInt();
         System.out.println("Jahre Beende");
        int lastYear = sc.nextInt();
       
            if(firstYear > lastYear || lastYear < 0 || firstYear < 0){
                throw new Exception("cxvxcv");
            }
       
        final LocalDate startDate = LocalDate.of(firstYear, 1, 1);   // 1 Января 2001
        final LocalDate endDate = LocalDate.of(lastYear, 1, 1);     // 1 Января 3001
        long result = 0L;
        LocalDate iter = startDate;
        while (iter.getDayOfMonth()!= 13) {     // Переходим к ближайшему 13-ому числу месяца
            iter = iter.plusDays(1);
        }
        while (iter.compareTo(endDate) < 0) {   // Пока текущая дата меньше конечной
            if (iter.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                result++;
               // iter.getMonth();
                System.out.println(iter.getMonth() + " " +iter.getYear());
            }
            iter = iter.plusMonths(1);          // Плюсуем месяц
        }
      } catch (Exception e) {
               System.out.println("dfsd");
        }   
    }
    
    static long countDeathFridays(final LocalDate startDate, final LocalDate endDate) {
        long result = 0L;
        LocalDate iter = startDate;
        while (iter.getDayOfMonth()!= 13) {     // Переходим к ближайшему 13-ому числу месяца
            iter = iter.plusDays(1);
        }
        while (iter.compareTo(endDate) < 0) {   // Пока текущая дата меньше конечной
            if (iter.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                result++;
            }
            iter = iter.plusMonths(1);          // Плюсуем месяц
        }
        return result;
    }
}
