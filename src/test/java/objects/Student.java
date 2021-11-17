package objects;

public class Student {
    // Atributi objekta , zdesj studenta; chto to v nix potom kladem i mozhem poluchitj infu
    private String firstName; //peremennaja, private - dostup toljko v etom klasse
    private String lastName; // u atributov chto vnutri classa, estj dostup vidimosti, dlja objektov budet private
    private int age;
    private String phone; //chtobi prinjal, napr, (371)2838838
    private String email;

    // constructors,mozhet bitj u kazdogo objekta odin ili neskolko, obichno pishutjsa posle atributov i pered getters and setters

    public Student(String firstName, String lastName) { //chto nuzhno objazateljno ukazatj, bez chego ne mozhem sozdatj object
        this.firstName = firstName;
        this.lastName = lastName;
// avtomaticheski vstavitj konstruktor - code- generate - constructor
        }

        public Student(){} //pustoj constructor, chtobi sozdatj pustoj object - v objectspractice nadja

        // funkcii atributa - getters / setters

        public String getFirstName() { //getter - vernutj imja
            return firstName; //chto vozvrashaem

        }

        public void setFirstName(String firstName)
        { //peremennaja firstName sozdana vnutri metoda i prinadlezhit emu, dostupna toljko emu
            this.firstName = firstName; //this-etot class(tekushij class),esli net this-to peremennaja prebadlezhit metodu
        }

        //auto getter and setter - code- generate - getter and setter
        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName){
            this.lastName = lastName; //soxranjaem kak atribut
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone){
            this.phone = phone;
        }
        public void setPhone(long phone){ //metod, chtobi telefon bil ciframi i prinimal long, u pavla long
        this.phone = String.valueOf(phone); //peredelivaem long v string i soxranjaem kak atribut

        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email){
            this.email = email;
        }

        // Custom methods, ix obichno pishut posle getter and setter ; neobjazateljni, no mogu bitj, chtobi oblegchitj metod

        public String getFullName() { //metod, kot vozvrashaet srazu imja i familiju

            return firstName + " " + lastName;
        }
    }
