import java.util.Scanner;

class game {
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\u001B[34m";
    public static String [] coloums = new String [7];
    public static int size1  = 5;
    public static int size2  = 7;
    public static int number_of_player ;
    public static int winning_the_game;
    public static int []points = null ;


    public static void print_the_game(Grid [][] game)
    {
        System.out.print("\t");
        for(int i =0; i < size2 ; i++)
        {
            System.out.print(coloums[i] + "\t");
        }
        System.out.print("\n");
        for(int i = 0 ; i < size1 ; i++)
        {
            System.out.print(i +"\t");

            for(int j = 0 ; j < size2 ; j++)
            {
                if(game[i][j].player == 1)
                {
                    System.out.print(BLUE);         
                    System.out.print(game[i][j].cell + "\t");
                    System.out.print(WHITE);         

                }
                else if (game[i][j].player == 2)
                {
                    System.out.print(YELLOW);         
                    System.out.print(game[i][j].cell + "\t");
                    System.out.print(WHITE);         
                }
                else
                {
                    System.out.print(game[i][j].cell + "\t");
                }
            }
            System.out.print("\n");
        }
    }



    public static boolean exist_and_boomb(int x1 , int y1 , Grid [][]game)
    {
        if(x1 < size1 && x1> -1 && y1 < size2 && y1 > -1)
        {
            if(game[x1][y1].boomb)
            {
                return true;
            }
        }
        return false;
    }

    
    public static boolean exist_and_not_printing(Grid [][]game,int x1 , int y1)
    {
        if(x1 < size1 && x1> -1 && y1 < size2 && y1 > -1)
        {
            if(game[x1][y1].cell.equals("o"))
            {
                return true;
            }
        }
        return false;
    }


    public static int numbers_of_around_booms(Grid [][] game , int x , int y)
    {
        int numbers_of_booms = 0;
        int x1,y1;
        boolean is_boomb;
        x1 = x + 1;
        y1 = y;
        is_boomb = exist_and_boomb(x1, y1, game);
        if(is_boomb)
        {
            numbers_of_booms ++ ;
        }
        
        x1 = x;
        y1 = y + 1;
        is_boomb = exist_and_boomb(x1, y1, game);
        if(is_boomb)
        {
            numbers_of_booms ++ ;
        }


        x1 = x - 1;
        y1 = y;
        is_boomb = exist_and_boomb(x1, y1, game);
        if(is_boomb)
        {
            numbers_of_booms ++ ;
        }


        x1 = x;
        y1 = y - 1;
        is_boomb = exist_and_boomb(x1, y1, game);
        if(is_boomb)
        {
            numbers_of_booms ++ ;
        }


        x1 = x + 1;
        y1 = y + 1;
        is_boomb = exist_and_boomb(x1, y1, game);
        if(is_boomb)
        {
            numbers_of_booms ++ ;
        }


        x1 = x - 1;
        y1 = y - 1;
        is_boomb = exist_and_boomb(x1, y1, game);
        if(is_boomb)
        {
            numbers_of_booms ++ ;
        }


        x1 = x + 1;
        y1 = y - 1;
        is_boomb = exist_and_boomb(x1, y1, game);
        if(is_boomb)
        {
            numbers_of_booms ++ ;
        }


        x1 = x - 1;
        y1 = y + 1;
        is_boomb = exist_and_boomb(x1, y1, game);
        if(is_boomb)
        {
            numbers_of_booms ++ ;
        }


        return numbers_of_booms;

    }


    public static void show_all_around(Grid [][]game , int x , int y)
    {
        int x1,y1;
        boolean is_exist;
        x1 = x + 1;
        y1 = y;
        is_exist = exist_and_not_printing(game,x1, y1);
        if(is_exist)
        {
            int number_of_boombs = numbers_of_around_booms(game, x1, y1);
            winning_the_game --;
            game[x1][y1].player = number_of_player;
            if(number_of_boombs == 0)
            {
                game[x1][y1].cell =  "-";
                show_all_around(game, x1, y1);
            }
            else
            {
                game[x1][y1].cell =  String.valueOf(number_of_boombs);
            }
        }
        


        x1 = x;
        y1 = y + 1;
        is_exist = exist_and_not_printing(game,x1, y1);
        if(is_exist)
        {
            int number_of_boombs = numbers_of_around_booms(game, x1, y1);
            winning_the_game --;
            game[x1][y1].player = number_of_player;
            if(number_of_boombs == 0)
            {
                game[x1][y1].cell =  "-";
                show_all_around(game, x1, y1);
            }
            else
            {
                game[x1][y1].cell =  String.valueOf(number_of_boombs);
            }
        }


        x1 = x - 1;
        y1 = y;
        is_exist = exist_and_not_printing(game,x1, y1);
        if(is_exist)
        {
            int number_of_boombs = numbers_of_around_booms(game, x1, y1);
            winning_the_game --;
            game[x1][y1].player = number_of_player;
            if(number_of_boombs == 0)
            {
                game[x1][y1].cell =  "-";
                show_all_around(game, x1, y1);
            }
            else
            {
                game[x1][y1].cell =  String.valueOf(number_of_boombs);
            }
        }


        x1 = x;
        y1 = y - 1;
        is_exist = exist_and_not_printing(game,x1, y1);
        if(is_exist)
        {
            int number_of_boombs = numbers_of_around_booms(game, x1, y1);
            winning_the_game --;
            game[x1][y1].player = number_of_player;
            if(number_of_boombs == 0)
            {
                game[x1][y1].cell =  "-";
                show_all_around(game, x1, y1);
            }
            else
            {
                game[x1][y1].cell =  String.valueOf(number_of_boombs);
            }
        }

        x1 = x + 1;
        y1 = y + 1;
        is_exist = exist_and_not_printing(game,x1, y1);
        if(is_exist)
        {
            int number_of_boombs = numbers_of_around_booms(game, x1, y1);
            winning_the_game --;
            game[x1][y1].player = number_of_player;
            if(number_of_boombs == 0)
            {
                game[x1][y1].cell =  "-";
                show_all_around(game, x1, y1);
            }
            else
            {
                game[x1][y1].cell =  String.valueOf(number_of_boombs);
            }
        }


        x1 = x - 1;
        y1 = y - 1;
        is_exist = exist_and_not_printing(game,x1, y1);
        if(is_exist)
        {
            int number_of_boombs = numbers_of_around_booms(game, x1, y1);
            winning_the_game --;
            game[x1][y1].player = number_of_player;
            if(number_of_boombs == 0)
            {
                game[x1][y1].cell =  "-";
                show_all_around(game, x1, y1);
            }
            else
            {
                game[x1][y1].cell =  String.valueOf(number_of_boombs);
            }
        }


        x1 = x + 1;
        y1 = y - 1;
        is_exist = exist_and_not_printing(game,x1, y1);
        if(is_exist)
        {
            int number_of_boombs = numbers_of_around_booms(game, x1, y1);
            winning_the_game --;
            game[x1][y1].player = number_of_player;
            if(number_of_boombs == 0)
            {
                game[x1][y1].cell =  "-";
                show_all_around(game, x1, y1);
            }
            else
            {
                game[x1][y1].cell =  String.valueOf(number_of_boombs);
            }
        }


        x1 = x - 1;
        y1 = y + 1;
        is_exist = exist_and_not_printing(game,x1, y1);
        if(is_exist)
        {
            int number_of_boombs = numbers_of_around_booms(game, x1, y1);
            winning_the_game --;
            game[x1][y1].player = number_of_player;
            if(number_of_boombs == 0)
            {
                game[x1][y1].cell =  "-";
                show_all_around(game, x1, y1);
            }
            else
            {
                game[x1][y1].cell =  String.valueOf(number_of_boombs);
            }
        }

    }

    public static void finish_the_game(Grid [][]game, int x , int y)
    {
        for(int i = 0; i < size1 ; i++)
        {
            for( int j = 0 ; j < size2 ; j++)
            {
                if(game[i][j].cell.equals("P") || game[i][j].cell.equals("o"))
                {
                    if(game[i][j].boomb == true)
                    {
                        game[i][j].cell = "B";
                    }
                    else
                    {
                        int number_of_boombs = numbers_of_around_booms(game, i, j);
                        if(number_of_boombs == 0)
                        {
                            game[i][j].cell =  "-";
                        }
                        else
                        {
                            game[i][j].cell =  String.valueOf(number_of_boombs);
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        coloums[0] = "A";
        coloums[1] = "B";
        coloums[2] = "C";
        coloums[3] = "D";
        coloums[4] = "E";
        coloums[5] = "F";
        coloums[6] = "G";  
        number_of_player = 1;
        points = new int[3]  ;
        points[1] = 0;
        points[2] = 0;
        Grid [][]game = new Grid[size1][size2];
        
        Scanner scanIn = new Scanner(System.in); 
        Scanner myInput = new Scanner(System.in);
        
        
        int number_of_boombs;
        System.out.println("plz enter the number of booms");
        number_of_boombs = myInput.nextInt();
        x_y []boombs_array = new x_y[number_of_boombs];
        winning_the_game = (size1 * size2) - number_of_boombs;
        // initilizing the array 
        for(int i = 0 ; i < size1 ; i++)
        {
            for(int j = 0 ; j < size2 ; j++)
            {
                game[i][j] = new Grid();
                game[i][j].boomb = false;
                game[i][j].player = -1;
                game[i][j].cell = "o";
            }
        }

        //putting the booms
        while(number_of_boombs > 0)
        {
            int x = (int) (Math.random()*size1);
            int y = (int) (Math.random()*size1);
            int i =0;
            if(!game[x][y].boomb)
            {
                boombs_array[i] = new x_y();
                boombs_array[i].x = x;
                boombs_array[i].y = y;
                game[x][y].boomb = true;
                number_of_boombs --;
                i++;
            }
        }

        //initilizing printing array
        boolean finish_the_game  = false;
        while(!finish_the_game || winning_the_game == 0)
        {
            print_the_game(game);
            System.out.println("player 1 score is "+points[1]);
            System.out.println("player 2 score is"+points[2]);
            System.out.println("winning the game us :"+winning_the_game);
            System.out.println("player:"+number_of_player);
            System.out.println("plz enter p if the type is boomb or any other key");
            String type  =  scanIn.nextLine();
            System.out.println("plz enter x");
            int x = myInput.nextInt();
            System.out.println("plz enter y");
            String string_y  =  scanIn.nextLine();
            int y  = -1;
            int i = 0 ; 
            while(!coloums[i].equals(string_y))
            {
                i++;
            }
            y = i;
            if(game[x][y].cell != "o" && game[x][y].cell != "P")
            {
                System.out.println("you cant hit this cell");
            }
            else if(type.equals("P"))
            {
                if(game[x][y].boomb == true)
                {
                    points[number_of_player] = points[number_of_player] + 5; 
                }
                else
                {
                    points[number_of_player] = points[number_of_player] - 1;
                }
                game[x][y].cell = "P";
                game[x][y].player = number_of_player;
            }
            else
            {
                if(game[x][y].boomb == true)
                {
                    points[number_of_player] = points[number_of_player] - 250; 
                    finish_the_game(game, x, y);
                    finish_the_game = true;
                }
                else
                {
                    int numbers_of_around_boomb = numbers_of_around_booms(game, x, y);
                    winning_the_game -- ;
                    if(numbers_of_around_boomb == 0)
                    {
                        points[number_of_player] = points[number_of_player] + 1; 
                        game[x][y].cell = "-";
                        game[x][y].player = number_of_player;
                        show_all_around(game, x, y);
                    }
                    else
                    {
                        game[x][y].cell = String.valueOf(numbers_of_around_boomb);
                        points[number_of_player] = points[number_of_player] + numbers_of_around_boomb; 
                        game[x][y].player = number_of_player;
                    }
                }
            }
            if(winning_the_game == 0)
            {
                for(int j =0 ; j <boombs_array.length ; j++)
                {
                    if(game[boombs_array[i].x][boombs_array[i].y].cell != "P")
                    {
                        points[number_of_player] = points[number_of_player] + 100; 
                    }
                }
            }
            if(number_of_player == 1)
            {
                number_of_player ++;
            }
            else
            {
                number_of_player --;
            }
        }
        if(winning_the_game == 0)
        {

            System.out.println("you have won the game");
        }
        print_the_game(game);
    }
}