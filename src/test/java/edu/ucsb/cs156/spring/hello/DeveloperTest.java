package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // <https://bit.ly/cs156-f24-teams>
        assertEquals("Jeffery W.", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void getGithubId_returns_correct_id() {
        assertEquals("billybobjoe123",Developer.getGithubId());
    }
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals(t.getName(),"f24-02");
    }
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Edwin"),"Team should contain Edwin");
        assertTrue(t.getMembers().contains("Jakob"),"Team should contain Jakob");
        assertTrue(t.getMembers().contains("Jeffery"),"Team should contain Jeffery");
        assertTrue(t.getMembers().contains("Leo"),"Team should contain Leo");
        assertTrue(t.getMembers().contains("Rushil"),"Team should contain Rushil");
        assertTrue(t.getMembers().contains("Ved"),"Team should contain Ved");
    }

}
