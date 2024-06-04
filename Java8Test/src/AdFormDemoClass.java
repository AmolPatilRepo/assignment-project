import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdFormDemoClass {

	public static void main(String[] args) {
		
		AdFormDemoClass obj = new AdFormDemoClass();
		
		//get odd numbers from 0 to 99
		Integer num = 99;
		obj.getOddNumbers(num);

		//get Person data
		obj.getPerson();
	}

	private void getOddNumbers(Integer num) {

		//printing list of odd numbers using Predicate
		Predicate<Integer> getOddNum = i -> (i%2 != 0);
		IntStream.range(0, num).filter(n -> getOddNum.test(n)).boxed().forEach(System.out::println);
		
		//printing list of odd numbers directly using Stream
		List<Integer> oddNumList = IntStream.range(0, num).filter(n -> n%2 != 0).boxed().collect(Collectors.toList());
		System.out.println(oddNumList);
	}

	
	/*	Person P -> name, age, designation.
		Sort using lambda with pivot as age more than 25 
		and the results should be saved a map with name as key and designation as value.
	 */
	private void getPerson() {

		//objects of Person class with different name, age and designation
		Person p1 = new Person("Amol", 26, "Developer");
		Person p2 = new Person("Pawan", 30, "Manager");
		Person p3 = new Person("Shreyas", 22, "Tester");
		Person p4 = new Person("Divya", 28, "HR");

		//list of persons
		List<Person> personList = Arrays.asList(p1,p2,p3,p4);
		
		//stream to get list of persons sorted and pivot as age more than 25
		List<Person> sortedList = personList.stream().
									filter(p -> p.getAge() > 25).
										sorted((a1,a2) -> a1.getAge().
												compareTo(a2.getAge())).
													collect(Collectors.toList());
		System.out.println(sortedList);
		
		//stream to get map of persons with name as key and designation as value
		Map<String, String> sortedMap = personList.stream().
											filter(p -> p.getAge() > 25).
												sorted((a1,a2) -> a1.getAge().compareTo(a2.getAge())).
													collect(Collectors.toMap(Person::getName, Person::getDesignation));
		System.out.println(sortedMap);
		
	}
	
}
