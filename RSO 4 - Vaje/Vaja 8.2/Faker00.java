import com.github.javafaker.Faker;
import java.util.Locale;
public class Faker00 {
      
    public void fakinTest() {
       //Faker faker = new Faker();
       Faker faker = new Faker( new Locale("it"));
       // Faker faker = new Faker( new Locale("de"));

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton

        String streetAddress = faker.address().streetAddress(); 
                                       // 60018 Sawayn Brooks Suite 44
              
        System.out.println(""+name+", "+firstName+", "+lastName+", "+
                         streetAddress+", "+faker.address().city()+" "+  
                         faker.address().zipCode());
        System.out.println("About my beer (info): ");
        System.out.println(""+faker.beer().name());
        /* polja so pobrana iz tegale demota:
         * https://java-faker.herokuapp.com/
         * recimo za pir:
            Beer.yeast, Beer.malt, Beer.hop, Beer.style, Beer.name
        */
    }

}
