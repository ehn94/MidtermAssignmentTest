/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

/**
 *
 * @author ehn19
 */
public class TestPlayer {
    
    @Mock
    Board b; 
    
    @Mock
    Piece p;
    
    @Mock
    Die d1, d2; 
    
    @Mock
    Square s1, s2;
    
    public TestPlayer() {
    }
    
    @Test
    public void testTakeTurn(){
        
        Die[] dice = {d1, d2};
        int fv1 = 4; 
        int fv2 = 2;
        int sum = fv1 + fv2;
        Player player = new Player(dice, p, b);
        
        when(d1.getFaceValue()).thenReturn(4);
        when(d2.getFaceValue()).thenReturn(2);
        when(p.getLocation()).thenReturn(s1);
        when(b.getSquare(s1, sum)).thenReturn(s2);
        player.takeTurn();
        verify(d1).roll();
        verify(d2).roll();
        verify(d1).getFaceValue();
        verify(d2).getFaceValue();
        verify(p).getLocation();
        verify(b).getSquare(s1, sum);
        verify(p).setLocation(s2);
    }

}
