import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lec112_Streams1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//@Test
		ArrayList<String> names=new ArrayList<String>();
		names.add("Ashwin");
		names.add("Abhilash");
		names.add("Bitu");
		names.add("Chetan");
		names.add("Abhishek");
		
		long d=names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(d);
		
		long c= Stream.of("Ashwin","Bitu","Chetan","Abhilash","Abhishek").filter(a->
		{
		a.startsWith("A");
		return true;
		}).count();
		System.out.println(c);
		
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	//	Map();
		Collect();
	}
	
	public static void Map() {
		
		Stream.of("Ashwin","Bitu","Chetan","Abhilash","Abhishek").filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		System.out.println("----------------------");
		List<String> a=Arrays.asList("Ashwin","Bitu","Chetan","Abhilash","Abhishek");
		a.stream().filter(a1->a1.startsWith("A")).sorted().map(a1->a1.toUpperCase()).forEach(a1->System.out.println(a1));
		
		//Concat 2 stream - names, a
		ArrayList<String> names=new ArrayList<String>();
		names.add("Virat");
		names.add("Ajinkya");
		names.add("Bitu");
		
		System.out.println("Concat 2 streams");
		Stream<String> any=Stream.concat(names.stream(), a.stream());
		any.forEach(s->System.out.println(s));
		
		//anymatch() which is used with stream to check whether value present or not
		//boolean flag=any.anyMatch(s->s.equalsIgnoreCase("Ashwin"));
	//	System.out.print(flag);
	//	Assert.assertTrue(flag);
		
		
	
	}
	public static void Collect() {
		
		List<Integer> values=Arrays.asList(58,26,26,4,56,3,8,4);
		values.stream().sorted().distinct().forEach(s->System.out.println(s));
		//get 3rd index value from list
		List<Integer> li=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
		
		
	} 

}
