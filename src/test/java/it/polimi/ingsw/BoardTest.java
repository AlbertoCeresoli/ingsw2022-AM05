package it.polimi.ingsw;

import static org.junit.jupiter.api.Assertions.*;

import it.polimi.ingsw.Constants.Colors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
     Unit test for Board class. Tests:
     - addToHall
     - removeStudent
     - addToEntrance
     */
public class BoardTest
    {
        Board board;

        @BeforeEach
        void setUp(){
            board = new Board();
        }

        @Test
        @DisplayName("simple cases of addToHall")
        void testAddToHall(){
            int[] V1 = {0,0,0,0,1};
            int[] finalStud1 = {0,0,0,0,1};
            int i=0;
            Map<Colors, Integer> testStud1 = new HashMap<>();
            for (Colors c : Colors.values()){
                testStud1.put(c, V1[i]);
                i++;
            }
            assertTrue(board.addToHall(testStud1),"Test failed");
            i=0;
            for (Colors c : Colors.values()){
                assertEquals(finalStud1[i], board.getStudHall().get(c),"Test failed");
                i++;
            }

            int[] V2 = {0,0,2,3,1};
            int[] finalStud2 = {0,0,2,3,2};
            i=0;
            Map<Colors, Integer> testStud2 = new HashMap<>();
            for (Colors c : Colors.values()){
                testStud2.put(c, V2[i]);
                i++;
            }
            assertTrue(board.addToHall(testStud2),"Test failed");
            i=0;
            for (Colors c : Colors.values()){
                assertEquals(finalStud2[i], board.getStudHall().get(c),"Test failed");
                i++;
            }
        }
/*
        @Test
        @DisplayName("student's overflow for one or more colors")
        void testOverflowAddToHall(){
            int[] testStud1 = {0,0,0,0,1};
            int[] finalStud1 = {0,0,0,0,1};
            int[] testStud2 = {0,1,12,0,13};
            int[] finalStud2 = {0,0,0,0,1};
            assertTrue(board.addToHall(testStud1),"TestStud1 added correctly");
            assertArrayEquals(finalStud1, board.getStudHall(),"Students now are corrects");
            assertFalse(board.addToHall(testStud2),"TestStud2 added correctly");
            assertArrayEquals(finalStud2, board.getStudHall(),"Students now are corrects");
        }

        @Test
        @DisplayName("simple cases")
        void testRemoveFromHall(){
            int[] initialHall = {2,3,0,0,0};
            board.addToHall(initialHall);
            int[] testStud1 = {1,0,0,0,0};
            int[] finalStud1 = {1,3,0,0,0};
            int[] testStud2 = {1,1,0,0,0};
            int[] finalStud2 = {0,2,0,0,0};
            assertTrue(board.removeFromHall(testStud1),"TestStud1 added correctly");
            assertArrayEquals(finalStud1, board.getStudHall(),"Students now are corrects");
            assertTrue(board.removeFromHall(testStud2),"TestStud2 added correctly");
            assertArrayEquals(finalStud2, board.getStudHall(),"Students now are corrects");
        }

        @Test
        @DisplayName("given students are more than the students in studEntrance")
        void testOverflowRemoveFromHall(){
            int[] initialHall= {2,3,0,0,0};
            board.addToHall(initialHall);
            int[] testStud1 = {1,0,0,0,0};
            int[] finalStud1 = {1,3,0,0,0};
            int[] testStud2 = {4,1,0,0,0};
            int[] finalStud2 = {1,3,0,0,0};
            assertTrue(board.removeFromHall(testStud1),"TestStud1 added correctly");
            assertArrayEquals(finalStud1, board.getStudHall(),"Students now are corrects");
            assertFalse(board.removeFromHall(testStud2),"TestStud2 added correctly");
            assertArrayEquals(finalStud2, board.getStudHall(),"Students now are corrects");
        }

        @Test
        @DisplayName("simple cases")
        void testAddToEntrance(){
            int[] testStud1 = {0,0,0,0,1};
            int[] finalStud1 = {0,0,0,0,1};
            int[] testStud2 = {0,0,2,3,1};
            int[] finalStud2 = {0,0,2,3,2};
            assertTrue(board.addToEntrance(testStud1),"TestStud1 added correctly");
            assertArrayEquals(finalStud1, board.getStudEntrance(),"Students now are corrects");
            assertTrue(board.addToEntrance(testStud2),"TestStud2 added correctly");
            assertArrayEquals(finalStud2, board.getStudEntrance(),"Students now are corrects");
        }

        @Test
        @DisplayName("the students exceed the cap of the Entrance")
        void testOverflowAddToEntrance(){
            int[] testStud1 = {0,0,0,0,1};
            int[] finalStud1 = {0,0,0,0,1};
            int[] testStud2 = {0,0,2,3,9};
            int[] finalStud2 = {0,0,0,0,1};
            assertTrue(board.addToEntrance(testStud1),"TestStud1 added correctly");
            assertArrayEquals(finalStud1, board.getStudEntrance(),"Students now are corrects");
            assertFalse(board.addToEntrance(testStud2),"TestStud2 added correctly");
            assertArrayEquals(finalStud2, board.getStudEntrance(),"Students now are corrects");
        }

        @Test
        @DisplayName("simple cases")
        void testRemoveFromEntrance(){
            int[] initialEntrance = {2,3,0,0,0};
            board.addToEntrance(initialEntrance);
            int[] testStud1 = {1,0,0,0,0};
            int[] finalStud1 = {1,3,0,0,0};
            int[] testStud2 = {1,1,0,0,0};
            int[] finalStud2 = {0,2,0,0,0};
            assertTrue(board.removeFromEntrance(testStud1),"TestStud1 added correctly");
            assertArrayEquals(finalStud1, board.getStudEntrance(),"Students now are corrects");
            assertTrue(board.removeFromEntrance(testStud2),"TestStud2 added correctly");
            assertArrayEquals(finalStud2, board.getStudEntrance(),"Students now are corrects");
        }

        @Test
        @DisplayName("given students are more than the students in studEntrance")
        void testOverflowRemoveFromEntrance(){
            int[] initialEntrance = {2,3,0,0,0};
            board.addToEntrance(initialEntrance);
            int[] testStud1 = {1,0,0,0,0};
            int[] finalStud1 = {1,3,0,0,0};
            int[] testStud2 = {4,1,0,0,0};
            int[] finalStud2 = {1,3,0,0,0};
            assertTrue(board.removeFromEntrance(testStud1),"TestStud1 added correctly");
            assertArrayEquals(finalStud1, board.getStudEntrance(),"Students now are corrects");
            assertFalse(board.removeFromEntrance(testStud2),"TestStud2 added correctly");
            assertArrayEquals(finalStud2, board.getStudEntrance(),"Students now are corrects");
        }
 */
    }
