package com.luxoft.basics.part2.xtasks;

import javax.swing.*;
import java.awt.*;

public class T3_TanksMove extends JPanel
{
    int tankX = 0;
    int tankY = 0;
    int cell_width = 64;
    int cell_height = 64;
    int field_sizeX=9;
    int field_sizeY=9;

    void runTheGame()
    {
        move(2);
        move(2);
        move(3);
        move(3);
        move(4);
        move(4);
        move(1);
        move(1);

        // TODO fill free to add more tests here
    }

    /**
     * One method call should smoothly move the tank one quadrant according to given direction.
     *
     * !!! Method should ignore wrong commands.
     * For expl: it should do nothing when tank at A0 and direction is 1-UP or 4 - LEFT
     *
     * @param direction can be 1 - up, 2 - right, 3 - down, 4 - left
     */
    void move(int direction)
    {
        // TODO YOUR CODE HERE
        if (direction == 3)
        {
            int begincell=tankY;
            int endcell=tankY+cell_height;
            if ((begincell >= 0) && (endcell <= BF_HEIGHT-cell_height))
            {
                System.out.println("Move down");
                while (tankY<=endcell)
                {tankY++;
                repaint();
                sleep(10);
                }

                repaint ();
            sleep(500);
            }
            else System.out.println("Move down is not allowed from this position");
        }
        else         if (direction == 1)
        {
            int begincell=tankY;
            int endcell=tankY+cell_height;
            if ((begincell >= cell_height) && (endcell <= BF_HEIGHT))
            {
                System.out.println("Move up");
                while (tankY>=begincell-cell_height)
                {tankY--;
                    repaint();
                    sleep(10);
                }

                repaint ();
                sleep(500);
            }
            else System.out.println("Move up is not allowed from this position");
        }
        else if (direction == 2)
        {
            int begincell=tankX;
            int endcell=tankX+cell_width;
            if ((begincell >= 0) && (endcell <= BF_WIDTH-cell_width))
            {
                System.out.println("Move right");
                while (tankX<=endcell)
                {tankX++;
                    repaint();
                    sleep(10);
                }

                repaint ();
                sleep(500);
            }
            else System.out.println("Move right is not allowed from this position");
        }
        else if (direction == 4)
        {
            int begincell=tankX;
            int endcell=tankX+cell_width;
            if ((begincell >= cell_width) && (endcell <= BF_WIDTH))
            {
                System.out.println("Move left");
                while (tankX>=begincell-cell_width)
                {tankX--;
                    repaint();
                    sleep(10);
                }

                repaint ();
                sleep(500);
            }
            else System.out.println("Move left is not allowed from this position");
        }
        else
        {
            System.out.println("Direction is not recognized");
        }


    }

//void checkIFPossibleDirection (int direction)
//
//{
//
//}

    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    public static void main(String[] args) throws Exception
    {
        T3_TanksMove bf = new T3_TanksMove();
        bf.runTheGame();
    }

    public T3_TanksMove() throws Exception
    {
        JFrame frame = new JFrame("MOVE TANK FORWARD");
        frame.setLocation(500, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    void sleep(int millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (InterruptedException e)
        {

        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        paintBF(g);

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tankX, tankY, 64, 64);
    }

    private void paintBF(Graphics g)
    {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++)
        {
            for (int h = 0; h < 9; h++)
            {
                if (i % 2 == 0)
                {
                    cc = new Color(252, 241, 177);
                }
                else
                {
                    cc = new Color(233, 243, 255);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }
    }


}