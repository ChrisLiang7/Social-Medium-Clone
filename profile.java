import DataStructures.LinkedListWithIterator;
import DataStructures.ListWithIteratorInterface;

/**
 * @class profile
 * @author Zhisong Liang
 */

public class profile {
    //properties
    private String name;
    private String status;
    private String gender;
    private int age;
    private ListWithIteratorInterface<profile> friendList;
    //Why Linked List: length of friend list is unfixed,
    //good time complexity to add and remove profile.

    //constructors
    public profile(){
        this("undecided", "undecided", 0);
    }

    public profile(String name){
        this(name, "undecided", 0);
    }

    public profile(String name, String gender, int age){
        this.name = name;
        this.status = "Online";//default status is online;
        this.gender = gender;
        this.age = age;
        friendList = new LinkedListWithIterator<>();
    }

    //accessors
    public String getName(){ return name;}
    public String getStatus(){ return status;}
    public String getGender(){ return gender;}
    public int getAge(){ return age;}
    public ListWithIteratorInterface<profile> getFriendList(){ return friendList;}

    //mutators
    public void setName(String name){ this.name = name;}
    public void setStatus(String status){ this.status = status;}
    public void setGender(String gender){ this.gender = gender;}
    public void setAge(int age){ this.age = age;}

    //Add friends into friend list.
    public void addFriend(profile friend){
        if(!friendList.contains(friend)){
            //Add friend relationship to both of their record.
            friendList.add(friend);
            friend.getFriendList().add(this);
        }else{
            System.out.println(name + " " + friend.getName());
            System.out.println("He/she is already your friend.");
        }
    }

    //delete friends in the list;
    public void deleteFriend(profile friend){
        if(friendList.contains(friend)){
            friendList.remove(friend);
            friend.getFriendList().remove(this);
        }else{
            System.out.println("He/she is not in your friend list.");
        }
    }

    //search a friend's profile and return
    public profile searchFriend(profile friend){
        if(friendList.contains(friend)) {
            return friend;
        }else{
            System.out.println("This person is not in your friend list.");
            return null;
        }
    }

    //display the friend list of this profile.
    public void displayFriendList() {
        if(!friendList.isEmpty()){
            System.out.print(this.getName() + "'s friends: ") ;
            for (int i = 1; i < friendList.getLength(); i++){
                System.out.print(friendList.getEntry(i).getName() + ", ");
            }
            System.out.println(friendList.getEntry(friendList.getLength()).getName());
        }else{
            System.out.println(this.getName() + "'s friends: None");
        }
    }
}
