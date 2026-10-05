package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

   
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
    @Test
    public void equals_same_object() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_different_class() {
    assertEquals(false, team.equals("test-team"));
    }

    @Test
    public void equals_same_name_and_members() {
        Team other = new Team("test-team");

        assertEquals(true, team.equals(other));
    }

    @Test
    public void equals_different_name() {
        Team other = new Team("other-team");

        assertEquals(false, team.equals(other));
    }

    @Test
    public void equals_same_name_but_different_members() {
        Team other = new Team("test-team");
        other.addMember("Alice");

        assertEquals(false, team.equals(other));
    }
    @Test
    public void hashCode_returns_expected_value() {
    Team t = new Team("foo");
    t.addMember("bar");

    int expectedResult = 130294; 
    int result = t.hashCode();

    assertEquals(expectedResult, result);
}
}
