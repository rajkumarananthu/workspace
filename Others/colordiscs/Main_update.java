import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame implements ActionListener
{
	Label one;
	TextField player;
	Label two;
	TextField position;
	Button sub,restart;
	int mat[][]=new int[5][6];
	MyFrame(String str)
	{
		super(str);
		one=new Label("Player");
		two=new Label("Position");
		player=new TextField(5);
		position=new TextField(5);
		sub=new Button("submit");
		restart = new Button("Restart");
		this.setLayout(new FlowLayout());
		this.add(one);
		this.add(player);
		this.add(two);
		this.add(position);
		this.add(sub);
		this.add(restart);
		sub.addActionListener(this);
		restart.addActionListener(this);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<6;j++)
				mat[i][j]=0;
		}
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		g.drawOval(50,75,30,30);	//1[0][0]
		g.drawOval(100,75,30,30);	//2[0][1]
		g.drawOval(150,75,30,30);	//3[0][2]
		g.drawOval(200,75,30,30);	//4[0][3]
		g.drawOval(250,75,30,30);	//5[0][4]
		g.drawOval(300,75,30,30);	//6[0][5]
		g.drawOval(50,125,30,30);	//7[1][0]
		g.drawOval(100,125,30,30);	//8[1][1]
		g.drawOval(150,125,30,30);	//9[1][2]
		g.drawOval(200,125,30,30);	//10[1][3]
		g.drawOval(250,125,30,30);	//11[1][4]
		g.drawOval(300,125,30,30);	//12[1][5]
		g.drawOval(50,175,30,30);	//13[2][0]
		g.drawOval(100,175,30,30);	//14[2][1]
		g.drawOval(150,175,30,30);	//15[2][2]
		g.drawOval(200,175,30,30);	//16[2][3]
		g.drawOval(250,175,30,30);	//17[2][4]
		g.drawOval(300,175,30,30);	//18[2][5]
		g.drawOval(50,225,30,30);	//19[3][0]
		g.drawOval(100,225,30,30);	//20[3][1]
		g.drawOval(150,225,30,30);	//21[3][2]
		g.drawOval(200,225,30,30);	//22[3][3]
		g.drawOval(250,225,30,30);	//23[3][4]
		g.drawOval(300,225,30,30);	//24[3][5]
		g.drawOval(50,275,30,30);	//25[4][0]
		g.drawOval(100,275,30,30);	//26[4][1]
		g.drawOval(150,275,30,30);	//27[4][2]
		g.drawOval(200,275,30,30);	//28[4][3]
		g.drawOval(250,275,30,30);	//29[4][4]
		g.drawOval(300,275,30,30);	//30[4][5]
		g.drawString("hello\n Player-1:red color\n Player-2:Blue color",50,350);
		g.drawString("  hello",50,375);
	}
	public void actionPerformed(ActionEvent e)
	{
		Graphics g=this.getGraphics();
		if (e.getSource() == restart)
		{
			repaint();
			for(int i = 0 ;i<5;i++)
			{
				for(int j=0;j<6;j++)
					mat[i][j] = 0;
			}
		}
		else if(e.getSource()==sub)
		{
			String ex= player.getText();
			if(ex.equals("1"))
			{
				String posi=position.getText();
				g.setColor(Color.red);
				if(posi.equals("1")&&(mat[0][0]==0))
				{
					g.fillOval(50,75,30,30);
					mat[0][0]=1;
					check(0,0);
				}
				else if(posi.equals("2")&&(mat[0][1]==0))
				{
					g.fillOval(100,75,30,30);
					mat[0][1]=1;
					check(0,1);
				}
				else if(posi.equals("3")&&(mat[0][2]==0))
				{
					g.fillOval(150,75,30,30);
					mat[0][2]=1;
					check(0,2);
				}
				else if(posi.equals("4")&&(mat[0][3]==0))
				{
					g.fillOval(200,75,30,30);
					mat[0][3]=1;
					check(0,3);
				}
				else if(posi.equals("5")&&(mat[0][4]==0))
				{
					g.fillOval(250,75,30,30);
					mat[0][4]=1;
					check(0,4);
				}
				else if(posi.equals("6")&&(mat[0][5]==0))
				{
					g.fillOval(300,75,30,30);
					mat[0][5]=1;
					check(0,5);
				}
				else if(posi.equals("7")&&(mat[1][0]==0))
				{
					g.fillOval(50,125,30,30);
					mat[1][0]=1;
					check(1,0);
				}
				else if(posi.equals("8")&&(mat[1][1]==0))
				{
					g.fillOval(100,125,30,30);
					mat[1][1]=1;
					check(1,1);
				}
				else if(posi.equals("9")&&(mat[1][2]==0))
				{
					g.fillOval(150,125,30,30);
					mat[1][2]=1;
					check(1,2);
				}
				else if(posi.equals("10")&&(mat[1][3]==0))
				{
					g.fillOval(200,125,30,30);
					mat[1][3]=1;
					check(1,3);
				}
				else if(posi.equals("11")&&(mat[1][4]==0))
				{
					g.fillOval(250,125,30,30);
					mat[1][4]=1;
					check(1,4);
				}
				else if(posi.equals("12")&&(mat[1][5]==0))
				{
					g.fillOval(300,125,30,30);
					mat[1][5]=1;
					check(1,5);
				}
				else if(posi.equals("13")&&(mat[2][0]==0))
				{
					g.fillOval(50,175,30,30);
					mat[2][0]=1;
					check(2,0);
				}
				else if(posi.equals("14")&&(mat[2][1]==0))
				{
					g.fillOval(100,175,30,30);
					mat[2][1]=1;
					check(2,1);
				}
				else if(posi.equals("15")&&(mat[2][2]==0))
				{
					g.fillOval(150,175,30,30);
					mat[2][2]=1;
					check(2,2);
				}
				else if(posi.equals("16")&&(mat[2][3]==0))
				{
					g.fillOval(200,175,30,30);
					mat[2][3]=1;
					check(2,3);
				}
				else if(posi.equals("17")&&(mat[2][4]==0))
				{
					g.fillOval(250,175,30,30);
					mat[2][4]=1;
					check(2,4);
				}
				else if(posi.equals("18")&&(mat[2][5]==0))
				{
					g.fillOval(300,175,30,30);
					mat[2][5]=1;
					check(2,5);
				}
				else if(posi.equals("19")&&(mat[3][0]==0))
				{
					g.fillOval(50,225,30,30);
					mat[3][0]=1;
					check(3,0);
				}
				else if(posi.equals("20")&&(mat[3][1]==0))
				{
					g.fillOval(100,225,30,30);
					mat[3][1]=1;
					check(3,1);
				}
				else if(posi.equals("21")&&(mat[3][2]==0))
				{
					g.fillOval(150,225,30,30);
					mat[3][2]=1;
					check(3,2);
				}
				else if(posi.equals("22")&&(mat[3][3]==0))
				{
					g.fillOval(200,225,30,30);
					mat[3][3]=1;
					check(3,3);
				}
				else if(posi.equals("23")&&(mat[3][4]==0))
				{
					g.fillOval(250,225,30,30);
					mat[3][4]=1;
					check(3,4);
				}
				else if(posi.equals("24")&&(mat[3][5]==0))
				{
					g.fillOval(300,225,30,30);
					mat[3][5]=1;
					check(3,5);
				}
				else if(posi.equals("25")&&(mat[4][0]==0))
				{
					g.fillOval(50,275,30,30);
					mat[4][0]=1;
					check(4,0);
				}
				else if(posi.equals("26")&&(mat[4][1]==0))
				{
					g.fillOval(100,275,30,30);
					mat[4][1]=1;
					check(4,1);
				}
				else if(posi.equals("27")&&(mat[4][2]==0))
				{
					g.fillOval(150,275,30,30);
					mat[4][2]=1;
					check(4,2);
				}
				else if(posi.equals("28")&&(mat[4][3]==0))
				{
					g.fillOval(200,275,30,30);
					mat[4][3]=1;
					check(4,3);
				}
				else if(posi.equals("29")&&(mat[4][4]==0))
				{
					g.fillOval(250,275,30,30);
					mat[4][4]=1;
					check(4,4);
				}
				else if(posi.equals("30")&&(mat[4][5]==0))
				{
					g.fillOval(300,275,30,30);
					mat[4][5]=1;
					check(4,5);
				}
			}
			else if(ex.equals("2"))
			{
				String posi=position.getText();
				g.setColor(Color.blue);
				if(posi.equals("1")&&(mat[0][0]==0))
				{
					g.fillOval(50,75,30,30);
					mat[0][0]=2;
					check(0,0);
				}
				else if(posi.equals("2")&&(mat[0][1]==0))
				{
					g.fillOval(100,75,30,30);
					mat[0][1]=2;
					check(0,1);
				}
				else if(posi.equals("3")&&(mat[0][2]==0))
				{
					g.fillOval(150,75,30,30);
					mat[0][2]=2;
					check(0,2);
				}
				else if(posi.equals("4")&&(mat[0][3]==0))
				{
					g.fillOval(200,75,30,30);
					mat[0][3]=2;
					check(0,3);
				}
				else if(posi.equals("5")&&(mat[0][4]==0))
				{
					g.fillOval(250,75,30,30);
					mat[0][4]=2;
					check(0,4);
				}
				else if(posi.equals("6")&&(mat[0][5]==0))
				{
					g.fillOval(300,75,30,30);
					mat[0][5]=2;
					check(0,5);
				}
				else if(posi.equals("7")&&(mat[1][0]==0))
				{
					g.fillOval(50,125,30,30);
					mat[1][0]=2;
					check(1,0);
				}
				else if(posi.equals("8")&&(mat[1][1]==0))
				{
					g.fillOval(100,125,30,30);
					mat[1][1]=2;
					check(1,1);
				}
				else if(posi.equals("9")&&(mat[1][2]==0))
				{
					g.fillOval(150,125,30,30);
					mat[1][2]=2;
					check(1,2);
				}
				else if(posi.equals("10")&&(mat[1][3]==0))
				{
					g.fillOval(200,125,30,30);
					mat[1][3]=2;
					check(1,3);
				}
				else if(posi.equals("11")&&(mat[1][4]==0))
				{
					g.fillOval(250,125,30,30);
					mat[1][4]=2;
					check(1,4);
				}
				else if(posi.equals("12")&&(mat[1][5]==0))
				{
					g.fillOval(300,125,30,30);
					mat[1][5]=2;
					check(1,5);
				}
				else if(posi.equals("13")&&(mat[2][0]==0))
				{
					g.fillOval(50,175,30,30);
					mat[2][0]=2;
					check(2,0);
				}
				else if(posi.equals("14")&&(mat[2][1]==0))
				{
					g.fillOval(100,175,30,30);
					mat[2][1]=2;
					check(2,1);
				}
				else if(posi.equals("15")&&(mat[2][2]==0))
				{
					g.fillOval(150,175,30,30);
					mat[2][2]=2;
					check(2,2);
				}
				else if(posi.equals("16")&&(mat[2][3]==0))
				{
					g.fillOval(200,175,30,30);
					mat[2][3]=2;
					check(2,3);
				}
				else if(posi.equals("17")&&(mat[2][4]==0))
				{
					g.fillOval(250,175,30,30);
					mat[2][4]=2;
					check(2,4);
				}
				else if(posi.equals("18")&&(mat[2][5]==0))
				{
					g.fillOval(300,175,30,30);
					mat[2][5]=2;
					check(2,5);
				}
				else if(posi.equals("19")&&(mat[3][0]==0))
				{
					g.fillOval(50,225,30,30);
					mat[3][0]=2;
					check(3,0);
				}
				else if(posi.equals("20")&&(mat[3][1]==0))
				{
					g.fillOval(100,225,30,30);
					mat[3][1]=2;
					check(3,1);
				}
				else if(posi.equals("21")&&(mat[3][2]==0))
				{
					g.fillOval(150,225,30,30);
					mat[3][2]=2;
					check(3,2);
				}
				else if(posi.equals("22")&&(mat[3][3]==0))
				{
					g.fillOval(200,225,30,30);
					mat[3][3]=2;
					check(3,3);
				}
				else if(posi.equals("23")&&(mat[3][4]==0))
				{
					g.fillOval(250,225,30,30);
					mat[3][4]=2;
					check(3,4);
				}
				else if(posi.equals("24")&&(mat[3][5]==0))
				{
					g.fillOval(300,225,30,30);
					mat[3][5]=2;
					check(3,5);
				}
				else if(posi.equals("25")&&(mat[4][0]==0))
				{
					g.fillOval(50,275,30,30);
					mat[4][0]=2;
					check(4,0);
				}
				else if(posi.equals("26")&&(mat[4][1]==0))
				{
					g.fillOval(100,275,30,30);
					mat[4][1]=2;
					check(4,1);
				}
				else if(posi.equals("27")&&(mat[4][2]==0))
				{
					g.fillOval(150,275,30,30);
					mat[4][2]=2;
					check(4,2);
				}
				else if(posi.equals("28")&&(mat[4][3]==0))
				{
					g.fillOval(200,275,30,30);
					mat[4][3]=2;
					check(4,3);
				}
				else if(posi.equals("29")&&(mat[4][4]==0))
				{
					g.fillOval(250,275,30,30);
					mat[4][4]=2;
					check(4,4);
				}
				else if(posi.equals("30")&&(mat[4][5]==0))
				{
					g.fillOval(300,275,30,30);
					mat[4][5]=2;
					check(4,5);
				}
			}
		}
	}
	public void check(int i,int j)
	{
		if(hor_check(i,j)||ver_check(i,j)||diag_check(i,j))
		{
			int c=mat[i][j];
			Graphics g=this.getGraphics();
			g.drawString("player"+c+"win",50,400);
			sub.removeActionListener(this);
		}
	}
	public boolean diag_check(int i,int j)
	{
		if(i == 0)
		{
			if(j == 0)
			{
				if((mat[0][0] == mat[1][1]) && (mat[1][1] == mat[2][2]) && (mat[2][2] == mat[3][3]))
					return true;
				else
					return false;
			}
			else if(j == 1)
			{
				if((mat[0][1] == mat[1][2]) && (mat[1][2] == mat[2][3]) && (mat[2][3] == mat[3][4]))
					return true;
				else
					return false;
			}
			else if (j == 2)
			{
				if((mat[0][2] == mat[1][3]) && (mat[1][3] == mat[2][4]) && (mat[2][4] == mat[3][5]))
					return true;
				else
					return false;
			}
			else if(j == 3)
			{
				if((mat[0][3] == mat[1][2]) && (mat[1][2] == mat[2][1]) && (mat[2][1] == mat[3][0]))
					return true;
				else
					return false;
			}
			else if(j == 4)
			{
				if((mat[0][4] == mat[1][3]) && (mat[1][3] == mat[2][2]) && (mat[2][2] == mat[3][1]))
					return true;
				else
					return false;
			}
			else if(j == 5)
			{
				if((mat[0][5] == mat[1][4]) && (mat[1][4] == mat[2][3]) && (mat[2][3] == mat[3][2]))
					return true;
				else 
					return false;
			}
		}
		else if( i == 1)
		{
			if(j == 0)
			{
				if((mat[1][0] == mat[2][1]) && (mat[2][1] == mat[3][2]) && (mat[3][2] == mat[4][3]))
					return true;
				else 
					return false;
			}
			else if (j == 1)
			{
				if(((mat[1][1] == mat[2][2]) && (mat[2][2] == mat[3][3]) && (mat[3][3] == mat[4][4]))||((mat[1][1] == mat[2][2]) && (mat[2][2] ==mat[3][3]) && (mat[0][0] == mat[1][1])))
					return true;
				else 
					return false;
			}
			else if (j == 2)
			{
				if(((mat[1][2] == mat[0][1]) && (mat[1][2] == mat[2][3]) && (mat[2][3] == mat[3][4]))||((mat[1][2] == mat[2][3]) && (mat[2][3] == mat[3][4]) && (mat[3][4] == mat[4][5]))||((mat[1][2]==mat[0][3])&&(mat[1][2]==mat[2][1]) && (mat[2][1] == mat[3][0])))
					return true;
				else
					return false;
			}
			else if (j == 3)
			{
				if(((mat[1][3]==mat[0][4]) && (mat[1][3] == mat[2][2]) && (mat[2][2] == mat[3][1]))||((mat[1][3] == mat[2][2]) && (mat[2][2] == mat[3][1]) && (mat[3][1] == mat[4][0]))||((mat[1][3]==mat[0][2]) && (mat[1][3] == mat[2][4]) && (mat[2][4] == mat[3][5])))
					return true;
				else 
					return false;
			}
			else if(j == 4)
			{
				if(((mat[1][4] == mat[0][5]) && (mat[1][4] == mat[2][3]) && (mat[2][3] == mat[3][2]))||((mat[1][4] == mat[2][3]) && (mat[2][3] == mat[3][2]) && (mat[3][2] == mat[4][1])))
					return true;
				else 
					return false;
			}
			else if (j == 5)
			{
				if((mat[1][5] == mat[2][4]) && (mat[2][4] == mat[3][3]) && (mat[4][2] == mat[3][3]))
					return true;
				else 
					return false;
			}
		}
		else if(i == 2)
		{
			if(j == 1)
			{
				if(((mat[2][1] == mat[1][0]) && (mat[1][0] == mat[3][2]) && (mat[3][2] == mat[4][3]))||((mat[2][1] == mat[3][0]) && (mat[3][0] == mat[1][2]) && (mat[1][2] == mat[0][3])))
					return true;
				else
					return false;
			}
			else if(j == 2)
			{
				if (((mat[2][2] == mat[1][1]) && (mat[2][2] == mat[0][0]) && (mat[2][2] == mat[3][3]))||((mat[2][2] == mat[1][1]) && (mat[2][2] == mat[3][3]) && (mat[3][3] == mat[4][4]))||((mat[2][2] == mat[3][1]) && (mat[2][2] == mat[4][0]) && (mat[2][2] == mat[1][3]))||((mat[2][2] == mat[3][1]) && (mat[2][2] == mat[1][3])&& (mat[2][2] == mat[0][4])))
					return true;
				else 
					return false;
			}
			else if(j == 3)
			{
				if(((mat[2][3] == mat[0][1]) && (mat[2][3] == mat[1][2]) && (mat[2][3] == mat[3][4]))||((mat[2][3]== mat[1][2])&&(mat[2][3]==mat[3][4])&&(mat[2][3]==mat[4][5]))||((mat[2][3]==mat[3][2])&&(mat[2][3]==mat[4][1])&&(mat[2][3]==mat[1][4]))||((mat[2][3] == mat[3][2])&&(mat[2][3] == mat[1][4])&&(mat[2][3]==mat[0][5])))
					return true;
				else
					return false;
			}
			else if (j == 4)
			{
				if(((mat[2][4] == mat[1][3]) && (mat[1][3] == mat[0][2]) && (mat[2][4] == mat[3][5]))||((mat[2][4] == mat[3][3])&&(mat[3][3] == mat[4][2])&&(mat[1][5]==mat[4][2])))
					return true;
				else
					return false;
			}
		}
		else if(i == 3)
		{
			if(j==0)
			{
				if((mat[3][0] == mat[2][1])&&(mat[2][1] == mat[1][2])&&(mat[1][2] == mat[0][3]))
					return true;
				else 
					return false;
			}
			else if(j == 1)
			{
				if(((mat[3][1] == mat[4][0]) && (mat[3][1] == mat[2][2])&&(mat[2][2] == mat[1][3]))||((mat[3][1] == mat[2][2]) && (mat[3][1] ==mat[1][3])&&(mat[3][1] == mat[0][4])))
					return true;
				else
					return false;
			}
			else if( j == 2 )
			{
				if(((mat[3][2] == mat[2][1]) && (mat[2][1] == mat[1][0])&&(mat[3][2] == mat[4][3]))||((mat[3][2] == mat[4][1])&& (mat[3][2] == mat[2][3])&& (mat[3][2] == mat[1][4]))||((mat[3][2] == mat[2][3]) && (mat[3][2] == mat[1][4])&&(mat[3][2] == mat[0][5])))
					return true;
				else 
					return false;
			}
			else if (j == 3)
			{
				if(((mat[3][3] == mat[4][2]) && (mat[3][3] ==mat[2][4]) && (mat[3][3] == mat[1][5]))||((mat[3][3] == mat[4][4])&&(mat[3][3] == mat[2][2]) && (mat[3][3] == mat[1][1]))||((mat[3][3] == mat[2][2])&&(mat[2][2] == mat[1][1])&& (mat[1][1] == mat[0][0])))
					return true;
				else 
					return false;
			}
			else if( j == 4 )
			{
				if(((mat[3][4] == mat[4][5])&& (mat[3][4] == mat[2][3]) && (mat[3][4] == mat[1][2]))||((mat[3][4] == mat[0][1]) && (mat[3][4] == mat[1][2]) && (mat[3][4] == mat[2][3])))
					return true;
				else 
					return false;
			}
			else if ( j == 5 )
			{
				if((mat[3][5] == mat[2][4]) && (mat[2][4] == mat[1][3]) && (mat[1][3] == mat[0][2]))
					return true;
				else 
					return false;
			}
		}
		else if(i ==4)
		{
			if(j == 0)
			{
				if((mat[4][0] == mat[3][1]) && (mat[3][1] == mat[2][2])&& (mat[2][2] == mat[1][3]))
					return true;
				else 
					return false;
			}
			else if(j ==1)
			{
				if((mat[4][1] == mat[3][2]) && (mat[3][2] == mat[2][3]) && (mat[2][3] == mat[1][4]))
					return true;
				else 
					return false;
			}
			else if( j == 2 )
			{
				if((mat[4][2] == mat[3][3]) && (mat[3][3] == mat[2][4]) && (mat[2][4] == mat[1][5]))
					return true;
				else 
					return false;
			}
			else if( j == 3 )
			{
				if((mat[4][3] == mat[3][2]) && (mat[3][2] == mat[2][1])&& (mat[2][1] == mat[1][0]))
					return true;
				else 
					return false;
			}
			else if ( j == 4 )
			{
				if((mat[4][4] == mat[3][3]) && (mat[3][3] == mat[2][2]) && (mat[2][2] == mat[1][1]))
					return true;
				else
					return false;
			}
			else if(j == 5)
			{
				if((mat[4][5] == mat[3][4])&&(mat[3][4] == mat[2][3]) && (mat[2][3] == mat[1][2]))
					return true;
				else 
					return false;
			}
		}
		return false;
	}
	public boolean hor_check(int i,int j)
	{
		if(i==0)
		{
			if(j==0)
			{
				if((mat[0][0]==mat[0][1])&&(mat[0][1]==mat[0][2])&&(mat[0][2]==mat[0][3]))
					return true;
				else
					return false;
			}
			else if(j==1)
			{
				if(((mat[0][1]==mat[0][0])&&(mat[0][1]==mat[0][2])&&(mat[0][1]==mat[0][3]))||((mat[0][1]==mat[0][2])&&(mat[0][1]==mat[0][3])&&(mat[0][1]==mat[0][4])))
					return true;
				else
					return false;
			}
			else if(j==2)
			{
				if(((mat[0][2]==mat[0][3])&&(mat[0][2]==mat[0][1])&&(mat[0][2]==mat[0][0]))||((mat[0][2]==mat[0][1])&&(mat[0][2]==mat[0][3])&&(mat[0][2]==mat[0][4]))||((mat[0][2]==mat[0][3])&&(mat[0][2]==mat[0][4])&&(mat[0][2]==mat[0][5])))
						return true;
				else
						return false;
			}
			else if(j==3)
			{
				if(((mat[0][3]==mat[0][2])&&(mat[0][3]==mat[0][1])&&(mat[0][3]==mat[0][0]))||((mat[0][3]==mat[0][1])&&(mat[0][2]==mat[0][3])&&(mat[0][3]==mat[0][4]))||((mat[0][3]==mat[0][2])&&(mat[0][3]==mat[0][4])&&(mat[0][3]==mat[0][5])))
						return true;
				else
						return false;
			}
			else if(j==4)
			{
				if(((mat[0][4]==mat[0][3])&&(mat[0][4]==mat[0][2])&&(mat[0][4]==mat[0][5]))||((mat[0][4]==mat[0][2])&&(mat[0][4]==mat[0][3])&&(mat[0][1]==mat[0][4])))
					return true;
				else
					return false;
			}
			else if(j==5)
			{
				if((mat[0][5]==mat[0][4])&&(mat[0][5]==mat[0][3])&&(mat[0][2]==mat[0][5]))
					return true;
				else
					return false;
			}
		}
		else if(i==1)
		{
			if(j==0)
			{
				if((mat[1][0]==mat[1][1])&&(mat[1][1]==mat[1][2])&&(mat[1][2]==mat[1][3]))
					return true;
				else
					return false;
			}
			else if(j==1)
			{
				if(((mat[1][1]==mat[1][0])&&(mat[1][1]==mat[1][2])&&(mat[1][1]==mat[1][3]))||((mat[1][1]==mat[1][2])&&(mat[1][1]==mat[1][3])&&(mat[1][1]==mat[1][4])))
					return true;
				else
					return false;
			}
			else if(j==2)
			{
				if(((mat[1][2]==mat[1][3])&&(mat[1][2]==mat[1][1])&&(mat[1][2]==mat[1][0]))||((mat[1][2]==mat[1][1])&&(mat[1][2]==mat[1][3])&&(mat[1][2]==mat[1][4]))||((mat[1][2]==mat[1][3])&&(mat[1][2]==mat[1][4])&&(mat[1][2]==mat[1][5])))
						return true;
				else
						return false;
			}
			else if(j==3)
			{
				if(((mat[1][3]==mat[1][2])&&(mat[1][3]==mat[1][1])&&(mat[1][3]==mat[1][0]))||((mat[1][3]==mat[1][1])&&(mat[1][2]==mat[1][3])&&(mat[1][3]==mat[1][4]))||((mat[1][3]==mat[1][2])&&(mat[1][3]==mat[1][4])&&(mat[1][3]==mat[1][5])))
						return true;
				else
						return false;
			}
			else if(j==4)
			{
				if(((mat[1][4]==mat[1][3])&&(mat[1][4]==mat[1][2])&&(mat[1][4]==mat[1][5]))||((mat[1][4]==mat[1][2])&&(mat[1][4]==mat[1][3])&&(mat[1][1]==mat[1][4])))
					return true;
				else
					return false;
			}
			else if(j==5)
			{
				if((mat[1][5]==mat[1][4])&&(mat[1][5]==mat[1][3])&&(mat[1][2]==mat[1][5]))
					return true;
				else
					return false;
			}
		}
		else if(i==2)
		{
			if(j==0)
			{
				if((mat[2][0]==mat[2][1])&&(mat[2][1]==mat[2][2])&&(mat[2][2]==mat[2][3]))
					return true;
				else
					return false;
			}
			else if(j==1)
			{
				if(((mat[2][1]==mat[2][0])&&(mat[2][1]==mat[2][2])&&(mat[2][1]==mat[2][3]))||((mat[2][1]==mat[2][2])&&(mat[2][1]==mat[2][3])&&(mat[2][1]==mat[2][4])))
					return true;
				else
					return false;
			}
			else if(j==2)
			{
				if(((mat[2][2]==mat[2][3])&&(mat[2][2]==mat[2][1])&&(mat[2][2]==mat[2][0]))||((mat[2][2]==mat[2][1])&&(mat[2][2]==mat[2][3])&&(mat[2][2]==mat[2][4]))||((mat[2][2]==mat[2][3])&&(mat[2][2]==mat[2][4])&&(mat[2][2]==mat[2][5])))
						return true;
				else
						return false;
			}
			else if(j==3)
			{
				if(((mat[2][3]==mat[2][2])&&(mat[2][3]==mat[2][1])&&(mat[2][3]==mat[2][0]))||((mat[2][3]==mat[2][1])&&(mat[2][2]==mat[2][3])&&(mat[2][3]==mat[2][4]))||((mat[2][3]==mat[2][2])&&(mat[2][3]==mat[2][4])&&(mat[2][3]==mat[2][5])))
						return true;
				else
						return false;
			}
			else if(j==4)
			{
				if(((mat[2][4]==mat[2][3])&&(mat[2][4]==mat[2][2])&&(mat[2][4]==mat[2][5]))||((mat[2][4]==mat[2][2])&&(mat[2][4]==mat[2][3])&&(mat[2][1]==mat[2][4])))
					return true;
				else
					return false;
			}
			else if(j==5)
			{
				if((mat[2][5]==mat[2][4])&&(mat[2][5]==mat[2][3])&&(mat[2][2]==mat[2][5]))
					return true;
				else
					return false;
			}
		}
		else if(i==3)
		{
			if(j==0)
			{
				if((mat[3][0]==mat[3][1])&&(mat[3][1]==mat[3][2])&&(mat[3][2]==mat[3][3]))
					return true;
				else
					return false;
			}
			else if(j==1)
			{
				if(((mat[3][1]==mat[3][0])&&(mat[3][1]==mat[3][2])&&(mat[3][1]==mat[3][3]))||((mat[3][1]==mat[3][2])&&(mat[3][1]==mat[3][3])&&(mat[3][1]==mat[3][4])))
					return true;
				else
					return false;
			}
			else if(j==2)
			{
				if(((mat[3][2]==mat[3][3])&&(mat[3][2]==mat[3][1])&&(mat[3][2]==mat[3][0]))||((mat[3][2]==mat[3][1])&&(mat[3][2]==mat[3][3])&&(mat[3][2]==mat[3][4]))||((mat[3][2]==mat[3][3])&&(mat[3][2]==mat[3][4])&&(mat[3][2]==mat[3][5])))
						return true;
				else
						return false;
			}
			else if(j==3)
			{
				if(((mat[3][3]==mat[3][2])&&(mat[3][3]==mat[3][1])&&(mat[3][3]==mat[3][0]))||((mat[3][3]==mat[3][1])&&(mat[3][2]==mat[3][3])&&(mat[3][3]==mat[3][4]))||((mat[3][3]==mat[3][2])&&(mat[3][3]==mat[3][4])&&(mat[3][3]==mat[3][5])))
						return true;
				else
						return false;
			}
			else if(j==4)
			{
				if(((mat[3][4]==mat[3][3])&&(mat[3][4]==mat[3][2])&&(mat[3][4]==mat[3][5]))||((mat[3][4]==mat[3][2])&&(mat[3][4]==mat[3][3])&&(mat[3][1]==mat[3][4])))
					return true;
				else
					return false;
			}
			else if(j==5)
			{
				if((mat[3][5]==mat[3][4])&&(mat[3][5]==mat[3][3])&&(mat[3][2]==mat[3][5]))
					return true;
				else
					return false;
			}
		}
		else if(i==4)
		{
			if(j==0)
			{
				if((mat[4][0]==mat[4][1])&&(mat[4][1]==mat[4][2])&&(mat[4][2]==mat[4][3]))
					return true;
				else
					return false;
			}
			else if(j==1)
			{
				if(((mat[4][1]==mat[4][0])&&(mat[4][1]==mat[4][2])&&(mat[4][1]==mat[4][3]))||((mat[4][1]==mat[4][2])&&(mat[4][1]==mat[4][3])&&(mat[4][1]==mat[4][4])))
					return true;
				else
					return false;
			}
			else if(j==2)
			{
				if(((mat[4][2]==mat[4][3])&&(mat[4][2]==mat[4][1])&&(mat[4][2]==mat[4][0]))||((mat[4][2]==mat[4][1])&&(mat[4][2]==mat[4][3])&&(mat[4][2]==mat[4][4]))||((mat[4][2]==mat[4][3])&&(mat[4][2]==mat[4][4])&&(mat[4][2]==mat[4][5])))
						return true;
				else
						return false;
			}
			else if(j==3)
			{
				if(((mat[4][3]==mat[4][2])&&(mat[4][3]==mat[4][1])&&(mat[4][3]==mat[4][0]))||((mat[4][3]==mat[4][1])&&(mat[4][2]==mat[4][3])&&(mat[4][3]==mat[4][4]))||((mat[4][3]==mat[4][2])&&(mat[4][3]==mat[4][4])&&(mat[4][3]==mat[4][5])))
						return true;
				else
						return false;
			}
			else if(j==4)
			{
				if(((mat[4][4]==mat[4][3])&&(mat[4][4]==mat[4][2])&&(mat[4][4]==mat[4][5]))||((mat[4][4]==mat[4][2])&&(mat[4][4]==mat[4][3])&&(mat[4][1]==mat[4][4])))
					return true;
				else
					return false;
			}
			else if(j==5)
			{
				if((mat[4][5]==mat[4][4])&&(mat[4][5]==mat[4][3])&&(mat[4][2]==mat[4][5]))
					return true;
				else
					return false;
			}
		}
		return false;
	}
	public boolean ver_check(int i,int j)
	{
		if(j==0)
		{
			if(i==0)
			{
				if(((mat[0][0]==mat[1][0])&&(mat[0][0]==mat[2][0])&&(mat[0][0]==mat[3][0])))
					return true;
				else
					return false;
			}
			else if(i==1)
			{
				if(((mat[1][0]==mat[0][0])&&(mat[1][0]==mat[2][0])&&(mat[1][0]==mat[3][0]))||((mat[1][0]==mat[2][0])&&(mat[1][0]==mat[3][0])&&(mat[1][0]==mat[4][0])))
					return true;
				else
					return false;
			}
			else if(i==2)
			{
				if(((mat[2][0]==mat[0][0])&&(mat[1][0]==mat[2][0])&&(mat[2][0]==mat[3][0]))||((mat[2][0]==mat[1][0])&&(mat[2][0]==mat[3][0])&&(mat[2][0]==mat[4][0])))
					return true;
				else
					return false;
			}
			else if(i==3)
			{
				if(((mat[3][0]==mat[0][0])&&(mat[3][0]==mat[2][0])&&(mat[3][0]==mat[1][0]))||((mat[3][0]==mat[2][0])&&(mat[1][0]==mat[3][0])&&(mat[3][0]==mat[4][0])))
					return true;
				else
					return false;
			}
			else if(i==4)
			{
				if((mat[4][0]==mat[3][0])&&(mat[4][0]==mat[2][0])&&(mat[4][0]==mat[1][0]))
					return true;
				else
					return false;
			}
		}
		else if(j==1)
		{
			if(i==0)
			{
				if(((mat[0][1]==mat[1][1])&&(mat[0][1]==mat[2][1])&&(mat[0][1]==mat[3][1])))
					return true;
				else
					return false;
			}
			else if(i==1)
			{
				if(((mat[1][1]==mat[0][1])&&(mat[1][1]==mat[2][1])&&(mat[1][1]==mat[3][1]))||((mat[1][1]==mat[2][1])&&(mat[1][1]==mat[3][1])&&(mat[1][1]==mat[4][1])))
					return true;
				else
					return false;
			}
			else if(i==2)
			{
				if(((mat[2][1]==mat[0][1])&&(mat[1][1]==mat[2][1])&&(mat[2][1]==mat[3][1]))||((mat[2][1]==mat[1][1])&&(mat[2][1]==mat[3][1])&&(mat[2][1]==mat[4][1])))
					return true;
				else
					return false;
			}
			else if(i==3)
			{
				if(((mat[3][1]==mat[0][1])&&(mat[3][1]==mat[2][1])&&(mat[3][1]==mat[1][1]))||((mat[3][1]==mat[2][1])&&(mat[1][1]==mat[3][1])&&(mat[3][1]==mat[4][1])))
					return true;
				else
					return false;
			}
			else if(i==4)
			{
				if((mat[4][1]==mat[3][1])&&(mat[4][1]==mat[2][1])&&(mat[4][1]==mat[1][1]))
					return true;
				else
					return false;
			}
		}
		else if(j==2)
		{
			if(i==0)
			{
				if(((mat[0][2]==mat[1][2])&&(mat[0][2]==mat[2][2])&&(mat[0][2]==mat[3][2])))
					return true;
				else
					return false;
			}
			else if(i==1)
			{
				if(((mat[1][2]==mat[0][2])&&(mat[1][2]==mat[2][2])&&(mat[1][2]==mat[3][2]))||((mat[1][2]==mat[2][2])&&(mat[1][2]==mat[3][2])&&(mat[1][2]==mat[4][2])))
					return true;
				else
					return false;
			}
			else if(i==2)
			{
				if(((mat[2][2]==mat[0][2])&&(mat[1][2]==mat[2][2])&&(mat[2][2]==mat[3][2]))||((mat[2][2]==mat[1][2])&&(mat[2][2]==mat[3][2])&&(mat[2][2]==mat[4][2])))
					return true;
				else
					return false;
			}
			else if(i==3)
			{
				if(((mat[3][2]==mat[0][2])&&(mat[3][2]==mat[2][2])&&(mat[3][2]==mat[1][2]))||((mat[3][2]==mat[2][2])&&(mat[1][2]==mat[3][2])&&(mat[3][2]==mat[4][2])))
					return true;
				else
					return false;
			}
			else if(i==4)
			{
				if((mat[4][2]==mat[3][2])&&(mat[4][2]==mat[2][2])&&(mat[4][2]==mat[1][2]))
					return true;
				else
					return false;
			}
		}
		else if(j==3)
		{
			if(i==0)
			{
				if(((mat[0][3]==mat[1][3])&&(mat[0][3]==mat[2][3])&&(mat[0][3]==mat[3][3])))
					return true;
				else
					return false;
			}
			else if(i==1)
			{
				if(((mat[1][3]==mat[0][3])&&(mat[1][3]==mat[2][3])&&(mat[1][3]==mat[3][3]))||((mat[1][3]==mat[2][3])&&(mat[1][3]==mat[3][3])&&(mat[1][3]==mat[4][3])))
					return true;
				else
					return false;
			}
			else if(i==2)
			{
				if(((mat[2][3]==mat[0][3])&&(mat[1][3]==mat[2][3])&&(mat[2][3]==mat[3][3]))||((mat[2][3]==mat[1][3])&&(mat[2][3]==mat[3][3])&&(mat[2][3]==mat[4][3])))
					return true;
				else
					return false;
			}
			else if(i==3)
			{
			if(((mat[3][3]==mat[0][3])&&(mat[3][3]==mat[2][3])&&(mat[3][3]==mat[1][3]))||((mat[3][3]==mat[2][3])&&(mat[1][3]==mat[3][3])&&(mat[3][3]==mat[4][3])))
					return true;
				else
					return false;
			}
			else if(i==4)
			{
				if((mat[4][3]==mat[3][3])&&(mat[4][3]==mat[2][3])&&(mat[4][3]==mat[1][3]))
					return true;
				else
					return false;
			}
		}
		else if(j==4)
		{
			if(i==0)
			{
				if(((mat[0][4]==mat[1][4])&&(mat[0][4]==mat[2][4])&&(mat[0][4]==mat[3][4])))
					return true;
				else
					return false;
			}
			else if(i==1)
			{
				if(((mat[1][4]==mat[0][4])&&(mat[1][4]==mat[2][4])&&(mat[1][4]==mat[3][4]))||((mat[1][4]==mat[2][4])&&(mat[1][4]==mat[3][4])&&(mat[1][4]==mat[4][4])))
					return true;
				else
					return false;
			}
			else if(i==2)
			{
				if(((mat[2][4]==mat[0][4])&&(mat[1][4]==mat[2][4])&&(mat[2][4]==mat[3][4]))||((mat[2][4]==mat[1][4])&&(mat[2][4]==mat[3][4])&&(mat[2][4]==mat[4][4])))
					return true;
				else
					return false;
			}
			else if(i==3)
			{
				if(((mat[3][4]==mat[0][4])&&(mat[3][4]==mat[2][4])&&(mat[3][4]==mat[1][4]))||((mat[3][4]==mat[2][4])&&(mat[1][4]==mat[3][4])&&(mat[3][4]==mat[4][4])))
					return true;
				else
					return false;
			}
			else if(i==4)
			{
				if((mat[4][4]==mat[3][4])&&(mat[4][4]==mat[2][4])&&(mat[4][4]==mat[1][4]))
					return true;
				else
					return false;
			}
		}
		else if(j==5)
		{
			if(i==0)
			{
				if(((mat[0][5]==mat[1][5])&&(mat[0][5]==mat[2][5])&&(mat[0][5]==mat[3][5])))
					return true;
				else
					return false;
			}
			else if(i==1)
			{
				if(((mat[1][5]==mat[0][5])&&(mat[1][5]==mat[2][5])&&(mat[1][5]==mat[3][5]))||((mat[1][5]==mat[2][5])&&(mat[1][5]==mat[3][5])&&(mat[1][5]==mat[4][5])))
					return true;
				else
					return false;
			}
			else if(i==2)
			{
				if(((mat[2][5]==mat[0][5])&&(mat[1][5]==mat[2][5])&&(mat[2][5]==mat[3][5]))||((mat[2][5]==mat[1][5])&&(mat[2][5]==mat[3][5])&&(mat[2][5]==mat[4][5])))
					return true;
				else
					return false;
			}
			else if(i==3)
			{
				if(((mat[3][5]==mat[0][5])&&(mat[3][5]==mat[2][5])&&(mat[3][5]==mat[1][5]))||((mat[3][5]==mat[2][5])&&(mat[1][5]==mat[3][5])&&(mat[3][5]==mat[4][5])))
					return true;
				else
					return false;
			}
			else if(i==4)
			{
				if((mat[4][5]==mat[3][5])&&(mat[4][5]==mat[2][5])&&(mat[4][5]==mat[1][5]))
					return true;
				else
					return false;
			}
		}
		return false;
	}
}


class Main
{
	public static void main(String args[])throws Exception
	{
		MyFrame m_f=new MyFrame("Game of colors");
		m_f.setSize(400,500);
		m_f.setVisible(true);
	}
}