import java.util.Scanner;

public class NetWork{
    public static void main(String[] args) {
        NetWork myNetWork = new NetWork();
        profileDataBase Record = myNetWork.initiation();
        Scanner input = new Scanner(System.in);
        int UserInput;

        while(true) {
            System.out.println("\n Enter 1 to sign up.");
            System.out.println(" Enter 2 to log in.");
            System.out.println(" Enter 3 to end the program.\n");
            UserInput = input.nextInt();

            if (UserInput == 1){
                myNetWork.signUp(Record);
                continue;
            } else if (UserInput == 2) {
                myNetWork.logIn(Record);
                continue;
            } else if (UserInput == 3){
                System.out.println("Thank you for using FeetBook.");
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
        }
    }

    /*
    add profile to DataBase.
     */
    public void signUp(profileDataBase record){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the user name:");
        String profileName = input.nextLine();
        record.addProfile(profileName, new User(profileName));

        System.out.println("Hi " + profileName + " you have successfully signed up. Please log in." );
    }

    /*
    Log in profile from Network.
     */
    public void logIn(profileDataBase record){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the profile name:");
        String profileName = input.nextLine();

        User thisProfile = record.searchProfile(profileName);

        displayProfile(thisProfile);

        while (true) {
            System.out.println("\n Enter 1 to display profile information.");
            System.out.println(" Enter 2 to change status.");
            System.out.println(" Enter 3 to change gender.");
            System.out.println(" Enter 4 to change age.");
            System.out.println(" Enter 5 to add friends to your account.");
            System.out.println(" Enter 6 to delete friends to your account.");
            System.out.println(" Enter 7 to display friend lists of friends.");
            System.out.println(" Enter 8 to log out.");
            System.out.println(" Enter 9 to permanently delete your profile from our network.");

            int UserInput = input.nextInt();

            if (UserInput == 1) {
                displayProfile(thisProfile);

            } else if (UserInput == 2) {
                System.out.println("Please enter your new status:");
                input.nextLine();
                thisProfile.setStatus(input.nextLine());

            }else if (UserInput == 3) {
                System.out.println("Please enter your new gender:");
                input.nextLine();
                thisProfile.setGender(input.nextLine());

            }else if (UserInput == 4) {
                System.out.println("Please enter your new status:");
                input.nextLine();
                thisProfile.setAge(input.nextInt());

            } else if (UserInput == 5) {
                System.out.println("Please enter the profile name that you want to add as friend:");
                input.nextLine();
                User friend = record.searchProfile(input.nextLine());
                thisProfile.addFriend(friend);

            } else if (UserInput == 6) {
                System.out.println("Please enter the profile name that you want to delete from your " +
                        " friend List:");
                input.nextLine();
                User friend = record.searchProfile(input.nextLine());
                thisProfile.deleteFriend(friend);

            }else if (UserInput == 7){
                record.displayFriendListOfFriends(thisProfile.getName());

            } else if (UserInput == 8) {
                break;

            } else if (UserInput == 9) {
                record.deleteProfile(thisProfile.getName());

            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    /*
    display the profile of a person.
     */
    public void displayProfile(User person){
        System.out.println("---------------------------------");
        System.out.println("Name: " + person.getName());
        System.out.println("Status: " + person.getStatus());
        System.out.println("Gender: " + person.getGender());
        System.out.println("Age: " + person.getAge());

        person.displayFriendList();
    }

    /*
    Initiate the Network with some initial users.
    Initiate their friend relationship.
     */
    public profileDataBase initiation(){
        profileDataBase Record = new profileDataBase();

        Record.addProfile("Jack", new User("Jack", "male", 18));
        Record.addProfile("Tim", new User("Tim", "male", 52));
        Record.addProfile("Sander", new User("Sander", "female", 33));
        Record.addProfile("Thompson", new User("Thompson", "male", 22));
        Record.addProfile("Cindy", new User("Cindy", "female", 15));
        Record.addProfile("David", new User("David", "male", 18));
        Record.addProfile("Jennifer", new User("Jennifer", "female", 27));
        Record.addProfile("Paul", new User("Pual", "male", 17));
        Record.addProfile("Jason", new User("Jason", "male", 15));

        Record.addFriend("Jack", "Tim");
        Record.addFriend("Jack", "Cindy");
        Record.addFriend("Jack", "Paul");
        Record.addFriend("Jack", "Thompson");
        Record.addFriend("Tim", "Cindy");
        Record.addFriend("Tim", "David");
        Record.addFriend("Cindy", "Sander");
        Record.addFriend("Paul", "Jennifer");
        Record.addFriend("Paul", "Jason");
        Record.addFriend("Paul", "Cindy");
        Record.addFriend("Jason", "Jack");
        Record.addFriend("Jason", "Sander");

        User Jack = Record.searchProfile("Jack");
        User Tim = Record.searchProfile("Tim");
        User Sander = Record.searchProfile("Sander");
        User Thompson = Record.searchProfile("Thompson");
        User Cindy = Record.searchProfile("Cindy");
        User David = Record.searchProfile("David");
        User Jennifer = Record.searchProfile("Jennifer");
        User Paul = Record.searchProfile("Paul");
        User Jason = Record.searchProfile("Jason");

        System.out.println("Welcome to FeetBook!");
        System.out.println("You might know these people.\n");

        displayProfile(Jack);
        displayProfile(Tim);
        displayProfile(Sander);
        displayProfile(Thompson);
        displayProfile(Cindy);
        displayProfile(David);
        displayProfile(Jennifer);
        displayProfile(Paul);
        displayProfile(Jason);

        return Record;
    }
}
