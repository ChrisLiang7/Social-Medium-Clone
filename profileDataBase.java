import DataStructures.*;
import java.util.Iterator;

/*
Use a graph to track friend relationships among members of the network.
Add a feature to enable people to see a list of their friends’ friends.
 */
/**
 * @class profileDataBase
 * @author Zhisong Liang
 */

public class profileDataBase {
    private DictionaryInterface<String, profile> profileRecord;
    private UndirectedGraph<profile> friendsNetWork;

    //default constructor
    public profileDataBase(){
        profileRecord = new LinkedDictionary<>();
        //Use Linked dictionary to keep the database of profiles.
        //Can get access to a profile with its key.
        //function well for adding and deleting profiles.

        friendsNetWork = new UndirectedGraph<>();
        //Use undirected graph to handle the whole friend network.
        //Why undirected graph?
        //easier and faster to handle (add/delete and search) a large network.
        //friends network should be bi-directional.
        //i.e. I am jimmy's friend, then jimmy should be my friend as well.
        //a lot of algorithms can be used for traversing.
    }

    //add profile into profileRecord
    public void addProfile(String name, profile newProfile){
        if(!profileRecord.contains(name)){
            profileRecord.add(name, newProfile); //add to the dictionary.
            friendsNetWork.addVertex(newProfile);//add vertex to the graph.
        }else{
            System.out.println("This name has already been used.");
        }
    }

    //delete profile from profileRecord.
    public void deleteProfile(String name){
        if(profileRecord.contains(name)){
            profile record = searchProfile(name);
            profileRecord.remove(name); //delete from the dictionary
            friendsNetWork.removeVertex(record); //delete from the graph
        }else{
            System.out.println("This profile doesn't exist in our profile record.");
        }
    }

    //Search for profile and return it.
    public profile searchProfile(String name){
        if(profileRecord.contains(name)){
            return profileRecord.getValue(name);
        }else{
            System.out.println("profile not found.");
        }
        return null;
    }

    //add friend relationship between two users.
    //it should be bi-direction.
    public void addFriend(String name1, String name2){
        profile person1 = searchProfile(name1);
        profile person2 = searchProfile(name2);
        person1.addFriend(person2);//add friend in linked list (Profile).
        friendsNetWork.addEdge(person1, person2);//add friend in undirected graph (ProfileDataBase).
    }

    //delete friend relationship between two users.
    //it should be bi-direction.
    public void deleteFriend(String name1, String name2){
        profile person1 = searchProfile(name1);
        profile person2 = searchProfile(name2);
        person1.deleteFriend(person2);//delete friend in linked list (Profile).
        friendsNetWork.removeEdge(person1,person2);//delete friend in undirected graph (ProfileDataBase).
    }

    /** Display one's friend list and their friends' friend list..
     * @param name your name
     */
    public void displayFriendListOfFriends(String name) {
        profile thisProfile = searchProfile(name); //find the object of the profile.
        if(thisProfile == null){
            //prompt if not found.
            System.out.println("User " + name + " does not exist in the network.");
            return;
        }

        //Get iterator of this vertex(you) in the undirected graph.
        Iterator<VertexInterface<profile>> friend = friendsNetWork.getVertex(thisProfile).getNeighborIterator();
        System.out.println(name + "\'s friends has these friends: ");

        //iterate through all the connected vertex(your friends) of this vertex(you).
        while (friend.hasNext()) {
            VertexInterface<profile> thisFiend = friend.next();
            String thisFriendName = thisFiend.getLabel().getName();
            System.out.print(thisFriendName + ": "); //print their names.

            //Get iterator of each vertex(your friends) connected with this vertex(you).
            Iterator<VertexInterface<profile>> friendsFriend = thisFiend.getNeighborIterator();

            //Iterate through all the connected vertex(their friends) of this vertex(your friends).
            while (friendsFriend.hasNext()) {
                String thisName = friendsFriend.next().getLabel().getName();
                System.out.print(thisName + " ");//print their names.
            }
            System.out.println("");
        }
    }
}