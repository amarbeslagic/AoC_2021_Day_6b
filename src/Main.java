import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("inputs//input_AoC_6b.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String s = br.readLine();

        String [] listOfStrings = s.split(",");

        Map<String, Long> mapaOfFish = new HashMap<String, Long>();

        int numOfMap = 0;

        //Insert string of fishes in map
        for(int j=0; j<9; j++){
            long counter = 0;
            for (int i = 0; i < listOfStrings.length; i++) {
                long elementOfString = Long.parseLong(listOfStrings[i]);
                if(elementOfString == numOfMap){
                    counter++;
                }
            }

            String str = String.valueOf(j);

            mapaOfFish.put(str, counter);

            numOfMap++;

        }

        int numOfDays = 256;

        long temp1 = 0;
        long temp2 = 0;

        for (int i=0; i<numOfDays; i++){


            for(int j=8; j>=0; j--){
                if(j>0){
                    temp1 = mapaOfFish.get(String.valueOf(j-1));
                    String key = String.valueOf(j-1);
                    //int val = mapaOfFish.get(String.valueOf(j));
                    mapaOfFish.put(key, temp2);
                    temp2 = temp1;
                }
                else{
                    Long valOfNew = temp2;
                    Long valOfOld = mapaOfFish.get(String.valueOf(6));

                    mapaOfFish.put("6", temp2 + valOfOld);
                    mapaOfFish.put("8", temp2);

                }
            }

        }

        System.out.println(mapaOfFish.get("0"));
        System.out.println(mapaOfFish.get("1"));
        System.out.println(mapaOfFish.get("2"));
        System.out.println(mapaOfFish.get("3"));
        System.out.println(mapaOfFish.get("4"));
        System.out.println(mapaOfFish.get("5"));
        System.out.println(mapaOfFish.get("6"));
        System.out.println(mapaOfFish.get("7"));
        System.out.println(mapaOfFish.get("8"));


        Long sum = 0L;

        for (int i=0; i<9; i++){
            sum += mapaOfFish.get(String.valueOf(i));
        }

        System.out.println(sum);

    }
}