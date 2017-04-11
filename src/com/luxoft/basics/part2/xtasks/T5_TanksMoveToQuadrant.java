package com.luxoft.basics.part2.xtasks;

import javax.swing.*;
import java.awt.*;

public class T5_TanksMoveToQuadrant extends JPanel
{
    int tankX = 0;
    int tankY = 0;
    int cell_width = 64;
    int cell_height = 64;
    int field_sizeX=9;
    int field_sizeY=9;

    public static void main(String[] args) throws Exception
    {
    T5_TanksMoveToQuadrant tq = new T5_TanksMoveToQuadrant();
        tq.runTheGame();
    }
    void runTheGame()
    {
//        moveToQuadrant("h3");
        getDirection("h5");
    }

    /**
     * One method call should smoothly move the tank one quadrant according to given direction.
     *
     * @param direction can be 1 - up, 2 - right, 3 - down, 4 - right
     */
    void move(int direction)
    {
        // TODO YOUR CODE HERE
        if (direction == 3)
        {
            int begincell=tankY;
            int endcell=tankY+cell_height;
            if ((begincell >= 0) && (endcell <= BF_HEIGHT))
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
            if ((begincell >= 0) && (endcell <= BF_WIDTH))
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

    int getDirection(String quadrant)
    {
        int Direction;
        int DirX;
        int DirY;
        String X="abcdefghi";
        DirX =(X.indexOf(quadrant.charAt(0))+1)*cell_width;
//        System.out.println(DirX);
        DirY = Character.getNumericValue(quadrant.charAt(1))*cell_height;
//        System.out.println(DirY);

        if (DirX-tankX > 0) {Direction=2;}
        else if (DirX-tankX < 0) {Direction=4;}
        else if (DirY-tankY>0) {Direction=1;}
        else (DirY-tankY<0) {Direction=3;}
        return Direction;










    }

    void moveToQuadrant(String quadrant)
    {
        for

    }
//    public static int ParseQuadrant (String quadrant)
//    {
//        int xi = quadrant.indexOf(0);
//        int yi = quadrant.indexOf(1);
//        int toX = (xi-65)*;
//    }

    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

//    public static void main(String[] args) throws Exception
//    {
//        T5_TanksMoveToQuadrant bf = new T5_TanksMoveToQuadrant();
//        bf.runTheGame();
//    }

    public T5_TanksMoveToQuadrant() throws Exception
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