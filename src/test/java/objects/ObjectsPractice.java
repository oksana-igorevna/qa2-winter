package objects;

import org.junit.jupiter.api.Test;

public class ObjectsPractice {
    @Test
    public void workingWithObjects() { //kak test vsegda public, chtobi u junit bil dostup,vsegda void- nechego vozvrashatj
        Student pavel = new Student("Pavel",  "Testerovich"); //kopija objekta,  peremennaja pavel i tip dannix student, mozhem xranitj toljko objekt student
        //chtobi zapisatj v pavla infu ispoljzuem setters
      //  pavel.setFirstName("Pavel"); vmesto etix dvux strok imja i familija zapisani v new student posle sozdanija constructor
      //  pavel.setLastName("Testerovich");
        pavel.setAge(80);
        pavel.setPhone(37188885555L);

        Student nadja = new Student(); //student - objekt, nadja - peremennaja
        nadja.setFirstName("Nadezhda");
        nadja.setLastName("Lubova");
        nadja.setAge(69);
        nadja.setPhone("911");

        //cerez setter mozhem v objekti polozitj znachenija, cerez getter potom ix poluchitj
        //25+13 -> 38 ; "25" +"13" -> 2513 (stroki skleivaet)
        System.out.println("First student: " + nadja.getFirstName() + " " + nadja.getLastName()); //getter - chtobi raspechatatj v console
        System.out.println("Second student: " + pavel.getFirstName() + " " + pavel.getLastName());

        //ispoljzuja custom method
       System.out.println("First student: " + nadja.getFullName());
       System.out.println("Second student: " + pavel.getFullName());
    }
}
