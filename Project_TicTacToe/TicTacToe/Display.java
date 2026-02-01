package TicTacToe;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Display implements ActionListener {
	private int width;
	private int height;
	private String title;
	JFrame frame;
	JButton button[][] = new JButton[3][3];
	JButton reset = new JButton("Reset");
	JButton exit = new JButton("Exit");
	JLabel playerTurn = new JLabel();
	private int x,y,turn = 0;
	private int player1[][] = new int [3][3];
	private int board[][] = new int [3][3];
	private int player2[][] = new int [3][3];
	Icon X = new ImageIcon("Icon1.png");
	Icon O = new ImageIcon("Icon2.png");
	JLabel text = new JLabel();
	public Display(int width,int height,String title)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		makeDisplay();
	}
	public void makeDisplay()
	{
		y = 20;
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		for(int i = 0 ; i < 3 ; i ++)
		{
			for(int j = 0 ; j < 3 ; j ++)
			{
				player1[i][j] = 0;
				board[i][j] = 0;
				player2[i][j] = 0;
				x += 55;
				button[i][j] = new JButton();
				button[i][j].setBounds(x, y, 55, 55);
				button[i][j].setBackground(Color.CYAN);
				button[i][j].addActionListener(this);
				frame.add(button[i][j]);
			}
			y += 55;
			x = 0;
		}
		playerTurn.setText("Player 1 Turn");
		playerTurn.setBounds(30, 185, 75, 30);
		frame.add(playerTurn);
		exit.setBounds(30, 300, 75, 30);
		exit.addActionListener(this);
		frame.add(exit);
		
		reset.setBounds(175, 300, 75, 30);
		reset.addActionListener(this);
		frame.getContentPane().setBackground(new Color(255, 255, 224));
		frame.add(reset);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit)
			System.exit(0);
		if(e.getSource() == reset)
		{
			playerTurn.setText("Player 1 Turn");
			for(int i = 0 ; i < 3 ; i ++)
			{
				for(int j = 0 ; j < 3 ; j ++)
				{
					turn = 0;
					button[i][j].setText("");
					board[i][j] = 0;
					player1[i][j] = 0;
					player2[i][j] = 0;
				}
			}
			addButton();
			text.setText("");
		}
		for(int i = 0 ; i < 3 ; i ++)
		{
			for(int j = 0 ; j < 3 ; j ++)
			{
				if(e.getSource() == button[i][j])
				{
					if(turn % 2 == 0 && player1[i][j] == 0 && player2[i][j] == 0)
					{
						board[i][j] = 1;
						player1[i][j] = 1;
						button[i][j].setText("X");
						playerTurn.setText("Player 2 Turn");
						turn ++;
					}
					else if(turn % 2 == 1  && player1[i][j] == 0 && player2[i][j] == 0)
					{
						player2[i][j] = 1;
						board[i][j] = 1;
						button[i][j].setText("O");
						playerTurn.setText("Player 1 Turn");
						turn ++;
					}
					button[i][j].setFont(new Font("Arial", Font.PLAIN , 27));
					frame.repaint();
				}
			}
		}
		if(player1Win() == true)
		{
			text.setText("player 1 win !");
			text.setBounds(57,200,400,85);
			frame.add(text);
			removeButton();
			frame.setVisible(true);
		}
		else if(player2Win() == true)
		{
			text.setText("player 2 win !");
			text.setBounds(57,200,400,85);
			frame.add(text);
			removeButton();
			frame.setVisible(true);
		}
		else if(checkBoard() == true)
		{
			text.setText("Draw !");
			text.setBounds(123,200,400,35);
			frame.add(text);
			removeButton();
			frame.setVisible(true);
		}
			
	}
	public boolean checkBoard()
	{
		for(int i = 0 ; i < 3 ; i ++)
		{
			for(int j = 0 ; j < 3 ; j ++)
			{
				if(board[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	public boolean player1Win()
	{
		if(check(player1) == true)
			return true;
		return false;
	}
	public boolean player2Win()
	{
		if(check(player2) == true)
			return true;
		return false;
	}
	public void removeButton()
	{
		for(int i = 0 ; i < 3 ; i ++)
		{
			for(int j = 0 ; j < 3 ; j ++)
			{
				button[i][j].removeActionListener(this);
			}
		}
	}
	public void addButton()
	{
		for(int i = 0 ; i < 3 ; i ++)
		{
			for(int j = 0 ; j < 3 ; j ++)
			{
				button[i][j].addActionListener(this);
			}
		}
	}
	public boolean check(int player[][])
	{
		int check = 0;
		//check horizontal
		for(int i = 0 ; i < 3 ; i ++)
		{
			check = 0;
			for(int j = 0; j < 3 ; j ++)
			{
				if(player[i][j] == 1)
				{
					check ++;
				}
			}
			if(check == 3)
				return true;
		}
		//check vertical
		for(int i = 0 ; i < 3 ; i ++)
		{
			check = 0;
			for(int j = 0 ; j < 3 ; j ++)
			{
				if(player[j][i] == 1)
				{
					check ++;
				}
			}
			if(check == 3)
				return true;
		}
		//check diagonal
		check = 0;
		for(int j = 0 ; j < 3 ; j ++)
		{
			if(player[j][j] == 1)
				check ++;
		}
		if(check == 3)
			return true;
		check = 0;
		int j = 2;
		for(int i = 0; i < 3 ; i ++)
		{
			if(player[i][j] == 1)
				check ++;
			j --;
		}
		if(check == 3)
			return true;
		return false;
	}
}
