package algorithm;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class s1803078__lab_5 {

	public static void main(String[] args) {

		File f = new File("greedy.txt");
		try {

			Scanner ob = new Scanner(f);

			int testcase = ob.nextInt();
			System.out.println("Solution no           Fractional Amount                Total weight                           Total Profit");
			for (int tt = 1; tt <= testcase; tt++) {
				
				int capacity = ob.nextInt();
				Vector<Double> v = new Vector();
				HashMap<Double , Integer> FractionalAmount = new HashMap();
	                                 Vector<Integer> fractionalVector = new Vector();
				HashMap<Double, Integer> hp = new HashMap();
				HashMap<Double, Integer> hw = new HashMap();

				for (int ii = 0; ii < 5; ii++) {
					int x = ob.nextInt();
					int w = ob.nextInt();
					int p = ob.nextInt();
					double rate = p * 1.0 / w;
					hp.put(rate, p);
					hw.put(rate, w);
					FractionalAmount.put(rate, ii+1);
					v.add(rate);
				}
				//System.out.println(capacity);
				Collections.sort(v, Collections.reverseOrder());

				//System.out.println(hp);
				//System.out.println(hw);
				int weight = 0;
				double TotalProfit = 0;
				int i = 0;
				while (weight + hw.get(v.get(i)) < capacity) {
					weight += hw.get(v.get(i));
					TotalProfit += hp.get(v.get(i));
					fractionalVector.add(FractionalAmount.get(v.get(i)));//kon kon object full neya hoyese segula ei vector e add korsi
					i++;
				}
				int last_weight = hw.get(v.get(i));        

				int baki_weight = capacity - weight;           

				double lastfraction = baki_weight * 1.0 / last_weight;
				TotalProfit += lastfraction * hp.get(v.get(i));
				weight += lastfraction * hw.get(v.get(i));
				
				int last_object=FractionalAmount.get(v.get(i));
				
				
				System.out.print(tt+"               ");
				System.out.print("{");
				for(int jj=0;jj<fractionalVector.size();jj++)
				{
					System.out.print("x"+fractionalVector.get(jj)+"=1,");
				}
				System.out.print("x"+last_object+"=");
				System.out.printf("%.2f",lastfraction);
				
				System.out.print("}");

				System.out.print("                "+weight+"                         "+TotalProfit);
				System.out.println();
				//ystem.out.println(weight);
				//System.out.println(TotalProfit);
			}
		} catch (Exception e) {
			System.out.println("exception found");
		}
	}
}
