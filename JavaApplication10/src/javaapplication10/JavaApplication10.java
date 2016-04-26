
package javaapplication10;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class JavaApplication10 {
    public static Map<BigInteger, BigInteger> map = new TreeMap<BigInteger, BigInteger>();
     public static ArrayList<String> arr = new ArrayList<String>();
    public static boolean validate(BigInteger key, BigInteger m){
        BigInteger z = (BigInteger) map.get(key);
        int res;
        if(m == null) res = 1;
        else{
            res =  z.compareTo(m);
        }
        if((((res == 0)||(res == 1))) && map.containsKey(key))
            return true;
        return false;
    }
    
    public static void transaction(BigInteger from, BigInteger to, BigInteger m){
        BigInteger z = (BigInteger)map.get(from);
        BigInteger l = m.negate();
         System.out.println(l);
        z = z.add(l);
        System.out.println(z);
        map.put(from, z);
         z = (BigInteger)map.get(to);
       z = z.add(m);
        map.put(to, z);
        
    }
    
    public static void writeUsingBufferedWriter() {
        File file = new File("C:\\FromC\\result.txt");
        FileWriter fr = null;
        BufferedWriter br = null;
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            int k = 0;
for(Map.Entry<BigInteger, BigInteger> e : map.entrySet()) {
    
    br.write(arr.get(k) + ";");
            br.write(e.getKey() + ";");
            br.write(e.getValue() + ";");
            br.write('\n');
            k++;
        }

        } catch (IOException e) {
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
            }
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = null; 
      String dirPath = "C:\\FromC";
      String dirPath2 = "C:\\FromC\\result.txt";
      String cvsSplitBy = ";";
File f = new File(dirPath);
String line = "";
        BigInteger from;
        BigInteger to;
         BigInteger m;
 br = new BufferedReader(new FileReader(dirPath2)); 
  while ((line = br.readLine()) != null) {
      
        String[] country = line.split(cvsSplitBy);
          arr.add(country[0]);
         System.out.println(country[1].trim());
         from = new BigInteger(country[1].trim());
        to = new BigInteger(country[2]);
 map.put(from, to);
		}

File[] files = f.listFiles();
for(int i = 0; i<files.length; i++){
    if(!files[i].toString().equals("C:\\FromC\\result.txt")){
    br = new BufferedReader(new FileReader(files[i])); 
     while ((line = br.readLine()) != null) {
	String[] country = line.split(cvsSplitBy);
        from = new BigInteger(country[1].trim());
        to = new BigInteger(country[3].trim());
         m = new BigInteger(country[4].trim());
        if( validate(from, m)&&
                validate(to,null))
        {
            transaction(from, to, m);
            System.out.println("Транзакция из " + files[i] + "  Успешно выполнена");
        }
        else System.out.println("Не возможно првести транзакцию из " + files[i]);
       }
    }
}
int k = 0;
for(Map.Entry<BigInteger, BigInteger> e : map.entrySet()) {
    System.out.print(arr.get(k) + ";");
            System.out.print(e.getKey() + ";");
            System.out.println(e.getValue() + ";");
            k++;
        }
writeUsingBufferedWriter();
 }
    
}
