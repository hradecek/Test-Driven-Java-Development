package ch02.mongo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendshipsMongo {

    private final FriendsCollection friends;

    public FriendshipsMongo() {
        friends = new FriendsCollection();
    }

    public void makeFriends(String person1, String person2) {
        addFriend(person1, person2);
        addFriend(person2, person1);
    }

    public List<String> getFriendsList(String person) {
        Person p = friends.findByName(person);
        if (p == null) {
            return Collections.emptyList();
        }
        return p.getFriends();
    }

    public boolean areFriends(String person1, String person2) {
        Person p = friends.findByName(person1);
        return p != null && p.getFriends().contains(person2);
    }

    private void addFriend(String person, String friend) {
        Person p = friends.findByName(person);
        if (p == null) {
            p = new Person(person);
        }
        p.addFriend(friend);
        friends.save(p);
    }
}
