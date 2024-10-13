package edu.ucsb.cs156.spring.hello;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.ArrayList;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void equals_returns_correct_result() {
        // Create sample member lists
        ArrayList<String> membersA = new ArrayList<>();
        membersA.add("Alice");
        membersA.add("Bob");

        ArrayList<String> membersB = new ArrayList<>();
        membersB.add("Alice");
        membersB.add("Bob");

        ArrayList<String> membersC = new ArrayList<>();
        membersC.add("Alice");
        membersC.add("Charlie");

        // Create team objects
        Team team1 = new Team("TeamA");
        team1.setMembers(membersA);

        Team team2 = new Team("TeamA");
        team2.setMembers(membersB);

        Team team3 = new Team("TeamB");
        team3.setMembers(membersA);

        Team team4 = new Team("TeamA");
        team4.setMembers(membersC);

        // 1. Test for equality with the same object
        assert team1.equals(team1) : "Team should be equal to itself";

        // 2. Test for equality with an object of a different type
        assert !team1.equals("Some String") : "Team should not be equal to an object of a different type";

        // 3. Test for equality with another Team object with the same name and members
        assert team1.equals(team2) : "Teams with the same name and members should be equal";

        // 4. Test for equality with another Team object with a different name
        assert !team1.equals(team3) : "Teams with different names should not be equal";

        // 5. Test for equality with another Team object with different members
        assert !team1.equals(team4) : "Teams with different members should not be equal";

        // 6. Test for equality with null
        assert !team1.equals(null) : "Team should not be equal to null";
    }

    @Test 
    public void toString_returns_correct_string() {
        // 1. Test an empty team (no name, no members)
        Team team1 = new Team();
        String expectedToString1 = "Team(name=, members=[])";
        assert team1.toString().equals(expectedToString1) : "Expected: " + expectedToString1 + ", but got: " + team1.toString();

        // 2. Test a team with a name but no members
        Team team2 = new Team("TeamA");
        String expectedToString2 = "Team(name=TeamA, members=[])";
        assert team2.toString().equals(expectedToString2) : "Expected: " + expectedToString2 + ", but got: " + team2.toString();

        // 3. Test a team with a name and members
        ArrayList<String> members = new ArrayList<>();
        members.add("Alice");
        members.add("Bob");
        team2.setMembers(members);
        
        String expectedToString3 = "Team(name=TeamA, members=[Alice, Bob])";
        assert team2.toString().equals(expectedToString3) : "Expected: " + expectedToString3 + ", but got: " + team2.toString();
    }
    @Test
    public void hashCode_returns_correct_code() {
        // instantiate t as a Team object
        

        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        int result = t1.hashCode();
        int expectedResult = 130294;
        assertEquals(expectedResult, result);
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
        Team t3 = new Team();
        t3.setName("alex");
        t3.addMember("kevin");
        Team t4 = new Team();
        t4.setName("daniel");
        t4.addMember("eric");
        assertNotEquals(t3.hashCode(), t4.hashCode());
        Team t5 = new Team();
        t3.setName("foo");
        t3.addMember("eyy");
        assertNotEquals(t1, t5);
    }
}
