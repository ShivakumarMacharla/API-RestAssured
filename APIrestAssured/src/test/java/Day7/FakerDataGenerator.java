package Day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	
	@Test
	void testGenerateDummyData() {
		
		Faker faker = new Faker();
		
	   String FirstName = faker.name().firstName();
	   String LastName = faker.name().lastName();
		
	   String FullName = faker.name().fullName();
		
	   String userName = faker.name().username();
	   String password = faker.internet().password();
		
	   String Email = faker.internet().safeEmailAddress();
	   
	String name  = faker.howIMetYourMother().character();
	   
	   System.out.println("FirstName: "+FirstName);
	   System.out.println("LastName: "+LastName);
	   System.out.println("FullName: "+FullName);
	   System.out.println("userName: "+userName);
	   System.out.println("password: "+password);
	   System.out.println("Email: "+Email);
	   System.out.println("name: "+name);
	}

}
