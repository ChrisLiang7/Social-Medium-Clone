/**
 * @class TestDriver
 * @author Zhisong Liang
 *  This class use for testing and showing the function.
 */

public class TestDriver {
    public static void main(String[] args) {
        profileDataBase Record = new profileDataBase();

        System.out.println("Liang's Network. Welcome.");
        System.out.println("-------------------------\n");

        //create profile and add to the network database.
        setProfile(Record);
        setFriendRelationship(Record);

        //check displayFriendsfriend()
        System.out.println("\n1. check displayFriendsfriend()");
        System.out.println("\n---Check Jack's friends' friend---");
        Record.displayFriendListOfFriends("Jack");
        System.out.println("\n---Check Paul's friends' friend---");
        Record.displayFriendListOfFriends("Paul");

        //check deleteProfile()
        System.out.println("\n2. check deleteProfile()");
        System.out.println("--------------------------");
        System.out.println("Now delete Jack from the Network");
        Record.deleteProfile("Jack");
        System.out.println("\n---Check Jack's friends' friend---");
        Record.displayFriendListOfFriends("Jack");
        System.out.println("\n---Check Pual's friends' friend---");
        Record.displayFriendListOfFriends("Paul");

        //check deleteFriend()
        System.out.println("\n3. check deleteFriend()");
        System.out.println("---Now remove Cindy and Paul's friend relations---");
        Record.deleteFriend("Cindy", "Paul");
        System.out.println("\n---Check Cindy's friends' friend---");
        Record.displayFriendListOfFriends("Cindy");
        System.out.println("\n---Check Pual's friends' friend---");
        Record.displayFriendListOfFriends("Paul");
    }

    public static void displayProfile(profile person){
        System.out.println("------------------------");
        System.out.println("Name: " + person.getName());
        System.out.println("Status: " + person.getStatus());
        System.out.println("Gender: " + person.getGender());
        System.out.println("Age: " + person.getAge());
        person.displayFriendList();
    }

    public static void setProfile(profileDataBase Record){
        Record.addProfile("Jack", new profile("Jack", "male", 18));
        Record.addProfile("Tim", new profile("Tim", "male", 52));
        Record.addProfile("Sander", new profile("Sander", "female", 33));
        Record.addProfile("Thompson", new profile("Thompson", "male", 22));
        Record.addProfile("Cindy", new profile("Cindy", "female", 15));
        Record.addProfile("David", new profile("David", "male", 18));
        Record.addProfile("Jennifer", new profile("Jennifer", "female", 27));
        Record.addProfile("Paul", new profile("Pual", "male", 17));
        Record.addProfile("Jason", new profile("Jason", "male", 15));
    }

    public static void setFriendRelationship(profileDataBase Record){
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
    }


    /** OutPut:
     * Liang's Network. Welcome.
     * -------------------------
     *
     * 1. check displayFriendsfriend()
     *
     * ---Check Jack's friends' friend---
     * Jack's friend has these friends:
     * Tim: Jack Cindy David
     * Cindy: Jack Tim Sander Pual
     * Pual: Jack Jennifer Jason Cindy
     * Thompson: Jack
     * Jason: Pual Jack Sander
     *
     * ---Check Paul's friends' friend---
     * Paul's friend has these friends:
     * Jack: Tim Cindy Pual Thompson Jason
     * Jennifer: Pual
     * Jason: Pual Jack Sander
     * Cindy: Jack Tim Sander Pual
     *
     * 2. check deleteProfile()
     * --------------------------
     * Now delete Jack from the Network
     *
     * ---Check Jack's friends' friend---
     * profile not found.
     * User Jack does not exist in the network.
     *
     * ---Check Pual's friends' friend---
     * Paul's friend has these friends:
     * Jennifer: Pual
     * Jason: Pual Sander
     * Cindy: Tim Sander Pual
     *
     * 3. check deleteFriend()
     * ---Now remove Cindy and Paul's friend relations---
     *
     * ---Check Cindy's friends' friend---
     * Cindy's friend has these friends:
     * Tim: Cindy David
     * Sander: Cindy Jason
     *
     * ---Check Pual's friends' friend---
     * Paul's friend has these friends:
     * Jennifer: Pual
     * Jason: Pual Sander
     *
     * Process finished with exit code 0
     */
}
