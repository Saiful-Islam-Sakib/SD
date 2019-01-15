# define _CRT_SECURE_NO_WARNINGS
# include <iostream>
# include <stdio.h>
# include <conio.h>
# include <String>
# include <stdlib.h>
# include <time.h>
# include "iGraphics.h"
using namespace std;

# define length 800
# define width 600
# define BACKGROUNDSPEED 10
# define FIRESPEED 20
# define SHIPWIDTH 110
# define SHIPHEIGHT 90
# define menuButtonPosition 250
# define NUMBEROFENEMY1 4
# define BOSSLIFE 300
# define bossnumber 1

void newhighscore();
void setRedEnemy();

//my life
int SHIPLIFE_X = 250;

//name input 
bool nameField = false;
int stlen = 0;

//red enemy speed
int redEnemySpeed = 3;
int speedMulti = 100;

//menu up down
int menuUpDown = 0;

//option select
int start = -1;

//sound on off
bool soundOnOff = true;

//background image slice height
int imgheight = 60;

//movement
int fx = 0;
int fy = 0;
int x = 0;

//score
int myscore = 0;
char strscore[9] = { 0 };

int mposx, mposy;

char background[11][50] = { "bg\\1.bmp", "bg\\2.bmp", "bg\\3.bmp", "bg\\4.bmp", "bg\\5.bmp", "bg\\6.bmp", "bg\\7.bmp", "bg\\8.bmp", "bg\\9.bmp", "bg\\10.bmp", "bg\\11.bmp" };
char spaceship[2][50] = { "bc\\1.bmp", "bc\\3.bmp" };
char shootFire[1][50] = { "bc\\f1.bmp" };
char enemyship[4][50] = { "RedPlane\\1.bmp", "RedPlane\\2.bmp", "RedPlane\\3.bmp", "RedPlane\\4.bmp" };
char enemyBullet[1][50] = { "RedPlane\\redBullet.bmp" };
//char capsule[2][50] = { "capsule\\capsule_die", "capsule\\capsule_health" };

//capsule


//restart
void restartgame()
{
	x = 0;
	myscore = 0;
	setRedEnemy();
	redEnemySpeed = 3;
	SHIPLIFE_X = 250;
}
//enemy ship
struct enemy1
{
	int enemy_x;
	int enemy_y;
	int ememy_index;
	bool enemyShow;
	int enemy_life = 3;

	int bullet_x = enemy_x + 48;
	int bullet_y = enemy_y - 20;
	bool bullet_show = true;
};
struct enemy1 redEnemy[NUMBEROFENEMY1];

//set of Background
struct BackGround
{
	int x;
	int y;
};
struct BackGround bg[10];

//set of fires
struct fire
{
	int fire_x = (length / 2) + fx;
	int fire_y = SHIPHEIGHT + 60;
	bool fire_OnOff = false;
};
struct fire fireBall[30];
int fireIndex = 0;

//boss
struct Boss
{
	int boss_x;
	int boss_y;
	bool boss_show;
	bool boss_bullet;
	bool boss_rightmove;
	bool boss_leftmove;
	int laser_x;
	int laser_y;
	bool laser_show;
};
struct Boss b[4];

//shooting fire
void setFire()
{
	//shoot on off checking
	for (int i = 0; i < 30; i++)
	{
		if (fireBall[i].fire_OnOff)
		{
			iShowBMP2(fireBall[i].fire_x, fireBall[i].fire_y, shootFire[0], 0);
		}
	}
	//shoot turn off and place the shoot
	for (int i = 0; i < 30; i++)
	{
		if (fireBall[i].fire_y> width)
		{
			fireBall[i].fire_OnOff = false;
			fireBall[i].fire_x = ((length / 2) - 5) + fx;
			fireBall[i].fire_y = SHIPHEIGHT + 60;
		}
	}
}

//collision
bool collision(int x1, int y1, int dx1, int dy1, int x2, int y2, int dx2, int dy2)
{
	if ((x1 + dx1 > x2 && x2 + dx2 > x1) && (y1 + dy1 >y2 && y2 + dy2 > y1))
		return true;
	else
		return false;
}
//regenerate enemy
void regenerateenemy(){
	//regenerate enemy
	for (int i = 0; i < NUMBEROFENEMY1; i++)
	{
		if (!redEnemy[i].enemyShow)
		{
			redEnemy[i].enemy_x = 50 + rand() % 700;
			redEnemy[i].enemy_y = 600 + rand() % 600;
			redEnemy[i].ememy_index = rand() % 4;
			redEnemy[i].enemyShow = true;
			redEnemy[i].enemy_life = 3;
		}
		//regenerate enemy fire
		if (!redEnemy[i].bullet_show)
		{
			redEnemy[i].bullet_x = redEnemy[i].enemy_x + 48;
			redEnemy[i].bullet_y = redEnemy[i].enemy_y - 20;
			redEnemy[i].bullet_show = true;
		}
	}
}
//set enemy bullet
void setEnemyFire()
{
	//shoot on off checking and show
	for (int i = 0; i < 4; i++)
	{
		if (redEnemy[i].bullet_show && redEnemy[i].enemy_y <= 600)
		{
			iShowBMP2(redEnemy[i].bullet_x, redEnemy[i].bullet_y, enemyBullet[0], 0);

		}
	}
	//shoot turn off and place the shoot
	for (int i = 0; i < 4; i++)
	{
		if (redEnemy[i].bullet_y < 0)
		{
			redEnemy[i].bullet_show = false;
			redEnemy[i].bullet_x = redEnemy[i].enemy_x + 48;
			redEnemy[i].bullet_y = redEnemy[i].enemy_y - 20;
		}
	}
}

//boss fire
void bossfire(){
	for (int i = 0; i < 4; i++)
	{
		if (myscore<1)
			b[i].laser_show = false;

		if (b[i].boss_show)
		{
			iShowBMP(b[i].laser_x, b[i].laser_y, "boss\\laser1.bmp");
		}
	}
	for (int i = 0; i < 4; i++)
	{
		if (b[i].laser_y < 0)
		{
			b[i].laser_x = b[i].boss_x + 75;
			b[i].laser_y = b[i].boss_y - 40;
			b[i].laser_show = true;
		}
	}
}
//show boss
bool lifeExtend = true;
void boss(){

	if (myscore >= 100)
	{
		b[0].boss_show = true;

		for (int i = 0; i<NUMBEROFENEMY1; i++)
		{
			b[i].laser_show = true;
			redEnemy[i].enemyShow = false;
			redEnemy[i].bullet_show = false;
		}
		iShowBMP2(b[0].boss_x, b[0].boss_y, "boss\\1.bmp", 255);
	}

}
//home menu
void homeMenu()
{
	iShowBMP(0, 0, "menu\\m.bmp");
	iShowBMP2(0, width - 100, "menu\\Shooter.bmp", 0);

	if (menuUpDown == 4)
		iShowBMP2(0, 0, "menu\\exit2.bmp", 255);
	else
		iShowBMP2(0, 0, "menu\\exit.bmp", 255);

	if (menuUpDown == 5)
	{
		if (soundOnOff == false)
			iShowBMP2(length - 155, 0, "menu\\soundOff2.bmp", 0);
		else
			iShowBMP2(length - 155, 0, "menu\\soundOn2.bmp", 0);
	}
	else
	{
		if (soundOnOff == false)
			iShowBMP2(length - 100, 0, "menu\\soundOff.bmp", 0);
		else
			iShowBMP2(length - 100, 0, "menu\\soundOn.bmp", 0);
	}

	if (menuUpDown == 1)
		iShowBMP2(menuButtonPosition, 380, "menu\\play2.bmp", 255);
	else
		iShowBMP2(menuButtonPosition, 380, "menu\\play.bmp", 255);
	if (menuUpDown == 2)
		iShowBMP2(menuButtonPosition, 250, "menu\\ins2.bmp", 255);
	else
		iShowBMP2(menuButtonPosition, 250, "menu\\ins.bmp", 255);
	if (menuUpDown == 3)
		iShowBMP2(menuButtonPosition, 120, "menu\\score2.bmp", 255);
	else
		iShowBMP2(menuButtonPosition, 120, "menu\\score.bmp", 255);
}

//enemy collide
void redEnemyShow()
{
	for (int i = 0; i < NUMBEROFENEMY1; i++)
	{
		if (redEnemy[i].enemyShow)
		{
			iShowBMP2(redEnemy[i].enemy_x, redEnemy[i].enemy_y, enemyship[0], 0);
		}
	}

	//kill enemy colliding with fire
	for (int i = 0; i < 30; i++)
	{
		for (int j = 0; j < NUMBEROFENEMY1; j++)
		{
			if (redEnemy[j].enemyShow == true && fireBall[i].fire_OnOff == true)
			{
				if (collision(redEnemy[j].enemy_x, redEnemy[j].enemy_y, 102, 102, fireBall[i].fire_x, fireBall[i].fire_y, 12, 20))
				{
					fireBall[i].fire_OnOff = false;
					fireBall[i].fire_x = ((length / 2) - 5) + fx;
					fireBall[i].fire_y = SHIPHEIGHT + 60;
					redEnemy[j].enemy_life--;
					if (redEnemy[j].enemy_life <= 0)
					{
						redEnemy[j].enemyShow = false;
						myscore += 10;
					}
				}
			}
		}
	}
	//kill enemy colliding with my plane
	for (int i = 0; i < NUMBEROFENEMY1; i++)
	{
		if (redEnemy[i].enemyShow)
		{
			if (collision(redEnemy[i].enemy_x, redEnemy[i].enemy_y, 102, 102, ((length / 2) - (SHIPWIDTH / 2)) + x, imgheight, SHIPWIDTH, SHIPHEIGHT - 20))
			{
				redEnemy[i].enemy_life--;
				myscore += 10;

				if (redEnemy[i].enemy_life <= 0)
				{
					redEnemy[i].enemyShow = false;
				}

				SHIPLIFE_X -= 20;

				if (SHIPLIFE_X <= 0)
				{
					start = 6;
					newhighscore();
				}
			}
		}
	}
}
//collision with my plane and enemy fire
void killme()
{
	for (int i = 0; i < NUMBEROFENEMY1; i++)
	{
		if (collision(((length / 2) - 55) + x, SHIPHEIGHT, SHIPWIDTH, SHIPHEIGHT, redEnemy[i].bullet_x, redEnemy[i].bullet_y, 12, 20))
		{
			redEnemy[i].bullet_show = false;
			redEnemy[i].bullet_x = redEnemy[i].enemy_x + 48;
			redEnemy[i].bullet_y = redEnemy[i].enemy_y - 20;
			if (!redEnemy[i].bullet_show)
				SHIPLIFE_X -= 5;
			if (SHIPLIFE_X <= 0)
			{
				start = 6;
				newhighscore();
			}
		}
	}
}

//score update
bool nh = true;
char str[100], str1[100];
struct players
{
	char name[20];
	int pscore;
}hs[5];

FILE *fp;
char showname[5][20], showscore[5][20];
//highscore page
void hscore()
{

	fp = fopen("score.txt", "r");
	for (int i = 0; i < 5; i++)
	{
		fscanf(fp, "%s %d\n", hs[i].name, &hs[i].pscore);
	}

	for (int i = 0; i < 5; i++)
	{
		sprintf(showname[i], "%s", hs[i].name);
		sprintf(showscore[i], "%d ", hs[i].pscore);
		iText(250, width - 200 - 50 * i, showname[i], GLUT_BITMAP_TIMES_ROMAN_24);
		iText(530, width - 200 - 50 * i, showscore[i], GLUT_BITMAP_TIMES_ROMAN_24);
	}
	fclose(fp);
}

//new highscore update
void newhighscore()
{
	FILE *fp;
	fp = fopen("score.txt", "r");
	for (int i = 0; i<5; i++)
		fscanf(fp, "%s %d\n", hs[i].name, &hs[i].pscore);


	int t;
	char n[10];
	if (nh)
	{
		for (int i = 0; i<4; i++)
		{
			if (hs[i].pscore<myscore)
			{
				hs[5].pscore = myscore;
				strcpy(hs[5].name, str1);
				for (int j = 0; j<5; j++)
				{
					for (int k = 5; k>j; k--)
					{
						if (hs[k].pscore>hs[k - 1].pscore)
						{
							t = hs[k - 1].pscore;
							hs[k - 1].pscore = hs[k].pscore;
							hs[k].pscore = t;

							strcpy(n, hs[k - 1].name);
							strcpy(hs[k - 1].name, hs[k].name);
							strcpy(hs[k].name, n);

						}
					}
				}

				fp = fopen("score.txt", "w");
				for (int i = 0; i<4; i++)
					fprintf(fp, "%s %d \n", hs[i].name, hs[i].pscore);
				fclose(fp);
				nh = false;
				break;
			}
		}
	}
	fclose(fp);
}
//Idraw
void iDraw()
{
	iClear();
	//home menu
	if (start == 0)
	{
		homeMenu();
	}
	//player name
	if (start == 8)
	{
		iShowBMP(0, 0, "menu\\playername.bmp");
		iSetColor(255, 0, 0);
		iText(length / 2 - 100, width / 2 + 50, "ENTER YOUR NAME", GLUT_BITMAP_TIMES_ROMAN_24);
		iSetColor(0, 0, 255);
		iRectangle(length / 2 - 100, width / 2 - 25, 200, 50);
		iSetColor(255, 0, 0);
		iText(250, 250, "*** Click on the Name Bar to Enter the Name ***", GLUT_BITMAP_HELVETICA_12);
		iText(250, 230, "*** Click on the Submit Button After Entering the name to Continue ***", GLUT_BITMAP_HELVETICA_12);
		iShowBMP(0, 0, "menu\\submit.bmp");
		
		if (nameField)
		{
			iSetColor(255, 0, 0);
			iText(325, 300, str, GLUT_BITMAP_TIMES_ROMAN_24);
		}
	}
	//starting the game
	if (start == 1)
	{
		//back_ground rendaring
		for (int i = 0; i <= 10; i++)
		{
			iShowBMP(bg[i].x, bg[i].y, background[i]);
		}
		//enemy ship show + collision with my plane and my fire
		redEnemyShow();

		//enemy fire and my collision
		killme();

		//show boss
		boss();

		//show boss fire
		bossfire();

		//enemy speed up
		if (myscore > speedMulti)
		{
			redEnemySpeed = 6;
		}
		else if (myscore > speedMulti * 5)
		{
			redEnemySpeed = 12;
		}

		//space_ship show
		iShowBMP2(((length / 2) - (SHIPWIDTH / 2)) + x, imgheight, spaceship[0], 0);

		//shoot
		setFire();

		//enemy fire
		setEnemyFire();

		//life bar
		if (SHIPLIFE_X >= 130)
			iSetColor(0, 255, 0);
		else if (SHIPLIFE_X >= 50)
			iSetColor(255, 255, 0);
		else if (SHIPLIFE_X < 50)
			iSetColor(255, 0, 0);

		iFilledRectangle(270, 10, SHIPLIFE_X, 40);
		
		if (myscore >= 100 && lifeExtend)
		{
			SHIPLIFE_X = 250;
			lifeExtend = false;
		}

		//Score
		if (myscore <= 99999999)
		{
			_itoa_s(myscore, strscore, 10);
			iText(118, 21, strscore, GLUT_BITMAP_TIMES_ROMAN_24);
		}

		//bottom image
		iShowBMP2(0, 0, "bg\\btm1.bmp", 0);
	}
	else if (start == 2)
	{
		iShowBMP(0, 0, "menu\\control.bmp");
		iShowBMP2(0, width - 150, "menu\\instructions.bmp", 0);
		iSetColor(255, 255, 0);
		//game control
		iText(50, 400, "Move Right :  RIGHT ARROW", GLUT_BITMAP_TIMES_ROMAN_24);
		iText(50, 350, "Move Left  :  LEFT ARROW", GLUT_BITMAP_TIMES_ROMAN_24);
		iText(50, 300, "Fire       :  SPACE", GLUT_BITMAP_TIMES_ROMAN_24);
		iText(50, 250, "Pause      :  P", GLUT_BITMAP_TIMES_ROMAN_24);
		iText(50, 200, "Resume     :  R", GLUT_BITMAP_TIMES_ROMAN_24);
		//separator
		iSetColor(255, 0, 0);
		iLine(380, 450, 380, 150);
		iSetColor(255, 255, 0);
		//menu conrtrol
		iText(400, 400, "Menu Up : UP ARROW", GLUT_BITMAP_TIMES_ROMAN_24);
		iText(400, 350, "Menu Down : Down ARROW", GLUT_BITMAP_TIMES_ROMAN_24);
		iText(400, 300, "Menu right : RIGHT ARROW", GLUT_BITMAP_TIMES_ROMAN_24);
		iText(400, 250, "Menu left : LEFT ARROW", GLUT_BITMAP_TIMES_ROMAN_24);
		iText(400, 200, "Menu Select : ENTER", GLUT_BITMAP_TIMES_ROMAN_24);
	}
	else if (start == 3)
	{
		iShowBMP(0, 0, "menu\\high_score_background.bmp");
		iShowBMP2(0, width - 150, "menu\\highscore.bmp", 0);
		hscore();
	}
	else if (start == 6)
	{
		//game over
		iShowBMP(0, 0, "gameOver\\gameover1.bmp");
		iShowBMP2(0, width - 150, "gameOver\\gameovertext.bmp", 0);
		iShowBMP2(length / 2 - 250, width - 480, "gameOver\\skeletonface.bmp", 0);
		//Score show after game over
		iShowBMP2(length / 2 - 100, width - 180, "gameOver\\yourScore.bmp", 0);
		iSetColor(0, 0, 255);
		iText(length / 2 - 10, width - 220, strscore, GLUT_BITMAP_TIMES_ROMAN_24);
		iSetColor(255, 255, 255);
		//game over buttons anim
		if (menuUpDown == 1)
			iShowBMP2(length / 2 + 100, width - 300, "gameOver\\main2.bmp", 255);
		else
			iShowBMP2(length / 2 + 100, width - 300, "gameOver\\main.bmp", 255);
		if (menuUpDown == 2)
			iShowBMP2(length / 2 + 100, width - 400, "gameOver\\restart2.bmp", 255);
		else
			iShowBMP2(length / 2 + 100, width - 400, "gameOver\\restart.bmp", 255);
		if (menuUpDown == 3)
			iShowBMP2(length / 2 + 100, width - 500, "gameOver\\exit2.bmp", 255);
		else
			iShowBMP2(length / 2 + 100, width - 500, "gameOver\\exit.bmp", 255);
	}
	else if (start == -1)
	{
		//welcome screen
		iShowBMP(0, 0, "bg\\credit.bmp");
		iShowBMP2((length / 2) - 100, width - 200, "bg\\LogoAust.bmp", 255);
		iText(150, width - 210, "Ahsanullah University of Science and Technology", GLUT_BITMAP_TIMES_ROMAN_24);
		iShowBMP2(0, width - 320, "menu\\Shooter.bmp", 0);
		iText(length - 650, width - 350, "by", GLUT_BITMAP_TIMES_ROMAN_24);
		iText(length - 700, width - 400, "Gazi Mehedi Hasan", GLUT_BITMAP_TIMES_ROMAN_24);
		iText(length - 700, width - 430, "Saiful Islam Sakib", GLUT_BITMAP_TIMES_ROMAN_24);
		iText(length - 700, width - 460, "Shibbir Ahamed", GLUT_BITMAP_TIMES_ROMAN_24);
		iSetColor(255, 0, 0);
		iText(length - 280, 10, "Hit \" ENTER \" to Continue", GLUT_BITMAP_TIMES_ROMAN_24);
		iSetColor(255, 255, 255);
	}
}

void iMouseMove(int mx, int my)
{
	//place your codes here
}

void iMouse(int button, int state, int mx, int my)
{
	if (button == GLUT_LEFT_BUTTON && state == GLUT_DOWN)
	{
		if (start == 8)
		{
			if (mx >= 300 && mx <= 500 && my >= 275 && my <= 325)
			{
				nameField = true;
			}
		}
		if (start == 8)
		{
			if (mx > 0 && mx < 65 && my > 0 && my < 32)
			{
				start = 1;
				nameField = false;
				strcpy(str1, str);
				printf("%s\n", str1);
				for (int i = 0; i < stlen; i++)
				{
					str[i] = 0;
				}
				stlen = 0;
			}
		}
	}
	
	if (button == GLUT_RIGHT_BUTTON && state == GLUT_DOWN)
	{
		
	}
}

/*iPassiveMouseMove is called to detect and use
the mouse point without pressing any button */
void iPassiveMouseMove(int mx, int my)
{
	//place your code here

	mposx = mx;
	mposy = my;
	if (mx == 2){}        /*Something to do with mx*/
	else if (my == 2){}   /*Something to do with my*/

}

/*
function iKeyboard() is called whenever the user hits a key in keyboard.
key- holds the ASCII value of the key pressed.
*/
void iKeyboard(unsigned char key)
{
	//fire ON and placing X axis of the fire
	if (key == ' ' && start == 1)
	{
		if (soundOnOff)
			PlaySound("sound\\fire_sound1.wav", NULL, SND_ASYNC);

		fx = x;

		if (fireIndex == 30)
			fireIndex = 0;

		fireBall[fireIndex].fire_OnOff = true;
		fireBall[fireIndex].fire_x = ((length / 2) - 5) + fx;
		++fireIndex;
	}
	//select option (menu)
	//player name entry and game start....
	if (key == '\r' && start == 0 && menuUpDown == 1)
	{
		start = 8;
	}
	if (start == 8 && nameField == true)
	{
		str[stlen] = key;
		stlen++;
	}

	//pause game
	if (key == 'p' && start == 1)
	{
		iPauseTimer(0);
		iPauseTimer(1);
		iPauseTimer(2);
		iPauseTimer(3);
	}
	//resume game
	if (key == 'r' && start == 1)
	{
		iResumeTimer(0);
		iResumeTimer(1);
		iResumeTimer(2);
		iResumeTimer(3);
	}
	//exit
	if (key == '\r' && start == 0 && menuUpDown == 4)
	{
		exit(0);
	}
	//goto instruction and back
	if (key == '\r' && start == 0 && menuUpDown == 2)
	{
		start = 2;
	}
	if (key == '\b' || key == 'b' && start == 2)
	{
		start = 0;
	}
	//goto high_score and back
	if (key == '\r' && start == 0 && menuUpDown == 3)
	{
		start = 3;
		hscore();
	}
	if (key == '\b' || key == 'b' && start == 3)
	{
		start = 0;
	}
	//sound On Off
	if (key == '\r' && start == 0 && menuUpDown == 5)
	{
		if (soundOnOff == true)
		{
			soundOnOff = false;
			PlaySound(0, 0, 0);
		}
		else
		{
			soundOnOff = true;
			PlaySound("sound\\track4.wav", NULL, SND_LOOP | SND_ASYNC);
		}
	}
	if (key == '\r' && start == -1)
	{
		start = 0;
	}
	if (start == 6)
	{
		//home menu
		if (key == '\r' && menuUpDown == 1)
		{
			start = 0;
			restartgame();
		}
		//restart
		if (key == '\r' && menuUpDown == 2)
		{
			restartgame();
			start = 1;
		}
		//quit
		if (key == '\r' && menuUpDown == 3)
		{
			exit(0);
		}
	}
}

/*
function iSpecialKeyboard() is called whenver user hits special keys like-
function keys, home, end, pg up, pg down, arraows etc. you have to use
appropriate constants to detect them. A list is:
GLUT_KEY_F1, GLUT_KEY_F2, GLUT_KEY_F3, GLUT_KEY_F4, GLUT_KEY_F5, GLUT_KEY_F6,
GLUT_KEY_F7, GLUT_KEY_F8, GLUT_KEY_F9, GLUT_KEY_F10, GLUT_KEY_F11, GLUT_KEY_F12,
GLUT_KEY_LEFT, GLUT_KEY_UP, GLUT_KEY_RIGHT, GLUT_KEY_DOWN, GLUT_KEY_PAGE UP,
GLUT_KEY_PAGE DOWN, GLUT_KEY_HOME, GLUT_KEY_END, GLUT_KEY_INSERT
*/
void iSpecialKeyboard(unsigned char key)
{
	// ship left right
	if (start == 1)
	{
		if (key == GLUT_KEY_RIGHT && x <= ((length / 2) - 70))
		{
			x += 20;
		}
		if (key == GLUT_KEY_LEFT && x >= -((length / 2) - 70))
		{
			x -= 20;
		}
	}

	//main menu up down
	if (start == 0)
	{
		if (key == GLUT_KEY_UP)
		{
			--menuUpDown;
			if (menuUpDown < 1)
			{
				menuUpDown = 5;
			}
		}
		if (key == GLUT_KEY_DOWN)
		{
			++menuUpDown;
			if (menuUpDown > 5)
			{
				menuUpDown = 1;
			}
		}
	}
	//game over menu right left
	if (start == 6)
	{
		if (key == GLUT_KEY_DOWN)
		{
			++menuUpDown;
			if (menuUpDown > 3)
			{
				menuUpDown = 1;
			}
		}
		if (key == GLUT_KEY_UP)
		{
			--menuUpDown;
			if (menuUpDown < 1)
			{
				menuUpDown = 3;
			}
		}
	}
}

//background image placement
void setBackground()
{
	int sum = width - imgheight;
	for (int i = 0; i <= 10; i++)
	{
		bg[i].x = 0;
		bg[i].y = sum;
		sum -= imgheight;
	}
}

//Background image change + fire movement
void change()
{
	//background rendaring
	for (int i = 0; i <= 10; i++)
	{
		bg[i].y -= BACKGROUNDSPEED;
		if (bg[i].y <= 0)
		{
			bg[i].y = width;
		}
	}
	//fire movement
	for (int i = 0; i < 30; i++)
	{
		if (fireBall[i].fire_OnOff == true)
			fireBall[i].fire_y += FIRESPEED;
	}
	//enemy fire movement
	for (int i = 0; i < 4; i++)
	{
		if (redEnemy[i].bullet_show == true)
			redEnemy[i].bullet_y -= 10;
	}
	//boss fire movement
	for (int i = 0; i < 4; i++)
	{
		if (b[i].laser_show == true)
			b[i].laser_y -= 10;
	}

}

//set Boss
void setBoss(){
	b[0].boss_x = 300;
	b[0].boss_y = 500;
	b[0].boss_show = true;
}
//move boss
void moveBoss(){
	if (b[0].boss_show)
	{

		b[0].boss_rightmove = true;
		b[0].boss_y -= 1;

		if (b[0].boss_y = 500)
			b[0].boss_y -= 0;
	}
}
//boss xAxis right movement
void bossmove_xright(){
	if (b[0].boss_rightmove)
	{
		b[0].boss_x += 5;
	}
	if (b[0].boss_x >= 650)
	{
		b[0].boss_leftmove = true;
		b[0].boss_rightmove = false;
	}
}
//boss xAxis left movement
void bossmove_xleft(){

	if (b[0].boss_leftmove)
		b[0].boss_x -= 5;

	if (b[0].boss_x <= 0)
	{
		b[0].boss_leftmove = false;
		b[0].boss_rightmove = true;
	}

}
//set enemy position
void setRedEnemy()
{
	for (int i = 0; i < NUMBEROFENEMY1; i++)
	{
		redEnemy[i].enemy_x = 50 + rand() % 700;
		redEnemy[i].enemy_y = 600 + rand() % 600;
		redEnemy[i].ememy_index = rand() % 4;
		redEnemy[i].enemyShow = true;
	}
}

//enemy
void changeEnemy()
{
	//enemy redEnemy
	for (int i = 0; i < NUMBEROFENEMY1; i++)
	{
		redEnemy[i].enemy_y -= redEnemySpeed;
		if (redEnemy[i].enemy_y <= -100)
		{
			redEnemy[i].enemy_y = 600 + rand() % 600;
		}
	}
}

int main()
{
	//game background
	setBackground();

	//red enemy placemnet
	setRedEnemy();

	//boss
	setBoss();
	iSetTimer(25, moveBoss);
	iSetTimer(25, bossmove_xleft);
	iSetTimer(50, bossmove_xright);

	//Re born enemy after death
	iSetTimer(25, regenerateenemy);

	//red enenmy placement
	iSetTimer(10, changeEnemy);

	//background , my fire, enemy fire movement
	iSetTimer(20, change);

	//game over menu index set
	if (start == 6)
		menuUpDown = 0;

	//sound on off
	if (soundOnOff == true)
		PlaySound("sound\\track4.wav", NULL, SND_LOOP | SND_ASYNC);

	//window
	iInitialize(length, width, "***** SHOOTER *****");

	return 0;
}
