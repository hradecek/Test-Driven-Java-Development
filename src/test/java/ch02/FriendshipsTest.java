package ch02;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FriendshipsTest {

    private Friendships friendships;

    @Before
    public void before() {
        friendships = new Friendships();
        friendships.makeFriends("Joe", "Audrey");
        friendships.makeFriends("Joe", "Peter");
        friendships.makeFriends("Joe", "Michael");
        friendships.makeFriends("Joe", "Britney");
        friendships.makeFriends("Joe", "Paul");
    }

    @Test
    public void alexDoesNotHaveFriends() {
        assertTrue("Alex does not have friends", friendships.getFriendsList("Alex").isEmpty());
    }

    @Test
    public void joeHas5Friends() {
        assertEquals("Joe has 5 friends", 5, friendships.getFriendsList("Joe").size());
    }

    @Test
    public void joeIsFriendWithEveryone() {
        final List<String> friendsOfJoe = Arrays.asList("Audrey", "Peter", "Michael", "Britney", "Paul");
        assertTrue(friendships.getFriendsList("Joe").containsAll(friendsOfJoe));
    }
}
