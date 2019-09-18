import javax.swing.*;



public class TamagotchiApp {

    public static void main(String[] args) {



        String output = "Tamagotchi Instructions before you begin the game: \n" +
                "• This game monitors the hunger, thirst, boredom and sickness \n" +
                " levels of your pet. \n " +
                "• You can choose what you’d like your pet to do twice a day \n" +
                "(a day is divided in half for this game).\n" +
                "• Your pet is given $25 to begin with. Each day, you're given $5 \n" +
                "more to add to your existing budget.\n "+
                "• Since food and drinks cost money, you might not be able to buy certain \n" +
                "or all food/drinks for your pet due to budget restrictions. \n"+
                "• You can play with your pet free of cost!\n"+
                "• If you feed your pet too much, it will refuse to eat and you \n" +
                " will be prompted to do something else with the pet. \n" +
                "• If you give your pet too much water consecutively, it can also \n"+
                "fall sick and even die from water intoxication!\n"+
                "• Your pet can also fall sick randomly due to changes in weather but \n" +
                "you will have the option to buy medicine depending on your budget.\n"+
                "• If you give your pet too much beer, it can lead to alcohol poisoning, \n" +
                "make your pet sick and potentially cause it to die. In such an instance, \n" +
                "you will be prompted to help your pet with it’s health by giving it \n" +
                "a special drink of water and special nutritious food. \n" +
                "• When you feed your pet, it’ll get bored at a point \n" +
                " and will want to do something other than eating. \n" +
                "• When your pet plays or when you play with your pet,\n"+
                " it will get hungry from the exhaustion. \n" +
                "• Since, you will always know the levels of hunger, thirst, boredom and sickness, \n" +
                " you can choose the right options to keep your pet alive. \n" +
                "• If any of the options hit 100%, your pet will die. \n" +
                "\n";
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, output);
            }
        });


        int i = 0;
        //i is used to count days and if user is in the second half of the day since each day in this game is divided into 2 halves
        int hunger = 0; //used to monitor hunger levels out of 100%
        int thirst = 0; //used to monitor thirst levels out of 100%
        int boredom = 0; //used to monitor boredom levels out of 100%
        int option = 0; //option chosen by user to perform activities with pet
        int op1 = 0; //sub options for feeding the pet
        int op2 = 0; //sub options for giving the pet a drink
        int op3 = 0; //sub options for playing with the pet~ playing prevents boredom
        int number = 0; //used to measure number of days
        int hungry_level = 0; //used to reset options
        int thirsty_level = 0; //used to reset drinking options
        int water_level = 0; //to measure if water is drunk consecutively
        int beer_level = 0; //to measure if beer is consumed consecutively
                           //beer consumed consecutively can lead to alcohol poisoning in the pet if more
                           //than 4 beers are consumed program prompts users messages to prevent alcohol poisoning

        int sickness = 0; //to measure sickness caused by consuming too much water (water intoxication), too much
                          //alcohol (alcohol poisoning) or randomly anytime due to changes in weather

        int budget = 20; //initial budget given to the user to spend on pet
                         // $5 are added to the existing budget every day (not every half day)
        char a;
        int z;
        int j=1;


        while (hunger < 100 || thirst < 100 || boredom < 100 || sickness < 100) {

            if(i%2==0){

                budget = budget + 5;
            }


//the following statements are used to display the hunger, thirst, boredom and sickness levels and budget for each day
            //each day is divided in 2 halves meaning each day, the user has the option to perform 2 activities
            //with the pet

            if (i % 2 == 0) {
                number = i / 2;
                System.out.println("*----------------------------*");
                System.out.println("* Your pet is " + number + " days old!    *");
                System.out.println("*----------------------------*");
                System.out.println(" ");


            } else {
                System.out.println("*----------------------------*");
                if(number<10) {
                    System.out.println("* Your pet is " + number + " days old!    *"); //fix this for number>9
                }
                else{
                    System.out.println("* Your pet is " + number + " days old!   *"); //fix this for number>9

                }
                System.out.println("* You are in the second      *");
                if(number<10) {
                    System.out.println("* half of day " + number + "              *");
                }
                else{
                    System.out.println("* half of day " + number + "             *");

                }
                System.out.println("*----------------------------*");
                System.out.println(" ");
            }


            System.out.println("******************************");


            if(hunger>100){
                hunger=100;
            }
            if(thirst>100){
                thirst=100;
            }
            if(boredom>100){
                boredom=100;
            }
            if(sickness>100){
                sickness=100;
            }
            System.out.println("*     Status of Tamagotchi:  *");
            if (hunger < 10)
                System.out.println("*     Hunger " + hunger + " %             *");
            else
                System.out.println("*     Hunger " + hunger + " %            *");
            if (thirst < 10)
                System.out.println("*     Thirst " + thirst + " %             *");
            else
                System.out.println("*     Thirst " + thirst + " %            *");
            if (boredom < 10)
                System.out.println("*     Boredom " + boredom + " %            *");
            else
                System.out.println("*     Boredom " + boredom + " %           *");
            if (sickness < 10)
                System.out.println("*     Sickness " + sickness + " %           *");
            else
                System.out.println("*     Sickness " + sickness + " %          *");
            if (budget < 0)
                System.out.println("*     Your budget is $" + budget + "     *");
            else
                System.out.println("*     Your budget is $" + budget + "     *");
            System.out.println("******************************");


            System.out.println(" ");

            if (thirst >= 100) {
                break;
            }
            if (hunger >= 100) {
                break;
            }
            if (boredom >= 100) {
                break;
            }
            if (sickness >= 100) {
                break;
            }

            //Math.random is used to randomly make the pet sick under the pretense of weather changes

            double x = Math.floor(Math.random() * 11);
            if (x == 5.0) {
                System.out.println("Your pet is under the weather!");
                System.out.println("You can buy medicine for $6.");
                sickness=sickness+10;
                System.out.println("Now that your pet is sick, it's sickness status is: "+ sickness+"% sick.");
                System.out.println(" ");

                if (budget < 6) {
                    System.out.println("You cannot afford any medicine due to your budget.");

                } else {

                    System.out.println("If you want to purchase medicine, type 'y' else press any other 'character' on your keyboard! ");
                    System.out.println(" ");
                    a = IO.readChar();
                    if (a == 'y' || a == 'Y') {
                        if (sickness < 10) {
                            sickness = 0;
                            System.out.println(" ");
                            System.out.println("The sickness status of your pet is: 0% sick.");
                            System.out.println(" ");
                        } else {
                            sickness = sickness - 10;
                            System.out.println(" ");
                            System.out.println("The sickness status of your pet is: "+ sickness+"% sick.");
                            System.out.println(" ");
                        }
                    } else {

                        sickness = sickness + 10;
                        System.out.println(" ");
                        System.out.println("Since you decided not to give your pet any medicine, your pet got sicker!");
                        System.out.println("The sickness status of your pet is: "+ sickness+"% sick.");
                        System.out.println(" ");
                    }


                }
            }

            //the following code is used to monitor if too much water is consumed consecutively
            //too much water consumption can cause water-intoxication


            if (water_level == 3 || water_level == 4) {
                System.out.println(" ");
                System.out.println("Your pet has had too much water without eating or exercising!");
                System.out.println("Your pet is at the brink of water intoxication!!!!!!!!!!!!!!!");
                System.out.println(" ");

                System.out.println("Choose what your want to do from the following options:");
                System.out.println("1. Feed!");
                System.out.println("2. Give a drink!");
                System.out.println("3. Play!");

                if (budget < 6) {

                    System.out.println("Side Note: ");
                    System.out.print("You can't give your pet Diuretics (that otherwise you would have the option to give) due to budget restrictions!");
                    System.out.println("Try not to give your pet anymore water to prevent water intoxication!.");
                }
                if (budget > 6) {

                    System.out.println("4. Give your pet Diuretics to help with water intoxication!");
                    System.out.println(" ");
                }
                option = IO.readInt();
                System.out.println(" ");



                if (budget > 6) {
                    while (option > 4 || option < 1) {
                        System.out.println(" ");
                        System.out.println("Enter an integer 1 and 4(1 & 4 inclusive)!");
                        option = IO.readInt();
                        System.out.println(" ");
                    }
                }
                if (budget < 6) {
                    while (option > 4 || option < 1) {
                        System.out.println(" ");
                        System.out.println("Enter an integer 1 and 4(1 & 4 inclusive)!");
                        option = IO.readInt();
                        System.out.println(" ");
                    }

                }

                if (option == 4) {
                    if (sickness > 20) {
                        sickness = sickness - 20;
                    } else {
                        sickness = 0;
                    }
                    hungry_level = 0;
                    beer_level = 0;


                    if (i % 2 == 0) {
                        number = i / 2;
                        System.out.println("*----------------------------*");
                        System.out.println("* Your pet is " + number + " days old!    *");
                        System.out.println("*----------------------------*");
                        System.out.println(" ");


                    } else {
                        System.out.println("*----------------------------*");
                        if(number<10) {
                            System.out.println("* Your pet is " + number + " days old!    *"); //fix this for number>9
                        }
                        else{
                            System.out.println("* Your pet is " + number + " days old!   *"); //fix this for number>9

                        }
                        System.out.println("* You are in the second      *");
                        if(number<10) {
                            System.out.println("* half of day " + number + "              *");
                        }
                        else{
                            System.out.println("* half of day " + number + "             *");

                        }
                        System.out.println("*----------------------------*");
                        System.out.println(" ");
                    }


                    System.out.println("******************************");

                    //System.out.println(" ");
                    System.out.println("*     Status of Tamagotchi:  *");
                    if (hunger < 10)
                        System.out.println("*     Hunger " + hunger + " %             *");
                    else
                        System.out.println("*     Hunger " + hunger + " %            *");
                    if (thirst < 10)
                        System.out.println("*     Thirst " + thirst + " %             *");
                    else
                        System.out.println("*     Thirst " + thirst + " %            *");
                    if (boredom < 10)
                        System.out.println("*     Boredom " + boredom + " %            *");
                    else
                        System.out.println("*     Boredom " + boredom + " %           *");
                    if (sickness < 10)
                        System.out.println("*     Sickness " + sickness + " %           *");
                    else
                        System.out.println("*     Sickness " + sickness + " %          *");
                    if (budget < 0)
                        System.out.println("*     Your budget is $" + budget + "     *");
                    else
                        System.out.println("*     Your budget is $" + budget + "     *");
                    System.out.println("******************************");


                    System.out.println(" ");


                    System.out.println(" ");
                    System.out.println("Choose what you want to do. Enter a number from 1-3 from the following options:");
                    System.out.println("1. Feed!");
                    System.out.println("2. Give a drink!");
                    System.out.println("3. Play!");
                    option = IO.readInt();


                }
            }

            //the following code is used to measure if the pet is fed too much food consecutively
            //if the pet if fed too much food, it'll refuse to eat and will only drink or play


            if (hungry_level == 30 || hungry_level > 30) {
                System.out.println(" ");
                System.out.println("Your pet cannot eat anymore due to over eating!");
                System.out.println("Choose what your want to from the following options:");
                System.out.println("1. Give a drink!");
                System.out.println("2. Play!");
                option = IO.readInt();
                System.out.println(" ");
                if (option == 1) {
                    option = 2;
                } else {
                    option = 3;
                }
            } else {

                if (water_level == 3 || water_level == 4) {
                    System.out.print(" ");

                } else {

                    System.out.println(" ");
                    System.out.println("Choose what you want to do. Enter a number from 1-3 from the following options:");
                    System.out.println("1. Feed!");
                    System.out.println("2. Give a drink!");
                    System.out.println("3. Play!");


                    if (beer_level == 20 || beer_level == 30 || beer_level == 40) {

                        System.out.println("If you want to help your pet recover from excessive amounts of alcohol");
                        System.out.println("and give it a combination of a special drink and bowl of special nutritious food, enter 5");
                    }
                    option = IO.readInt();
                    System.out.println(" ");

                    if(option!=5){

                    while (option > 3 || option < 1) {
                        System.out.println(" ");
                        System.out.println("Enter an integer 1 and 3(1 & 3 inclusive)!");
                        option = IO.readInt();
                        System.out.println(" ");
                    }
                    }
                }

            }


            if (beer_level <= 1 && option > 3 || option < 1) {
                while (option > 3 || option < 1) {
                    System.out.println(" ");
                    System.out.println("Enter an integer 1 and 3(1 & 3 inclusive)!");
                    option = IO.readInt();
                    System.out.println(" ");
                }
            }
            if (beer_level == 20 || beer_level == 30 || beer_level == 40 && option == 4 || option > 5) {
                while (option == 4 || option > 5) {

                    System.out.println(" ");
                    System.out.println("Enter 1,2,3 or 5!");
                    option = IO.readInt();
                    System.out.println(" ");
                }

            }

            if (option == 1 && budget < 5) {
                System.out.println(" ");
                System.out.println("Your budget does not allow you to feed your pet!");
                System.out.println("Choose what you want to do. Choose from the following options:");
                System.out.println("1. Give a drink!");
                System.out.println("2. Play!");
                option = IO.readInt();
                System.out.println(" ");

                while (option < 1 || option > 2) {
                    System.out.println("Enter either '1' or '2'!");
                    option = IO.readInt();
                    System.out.println(" ");

                }
                if (option == 1) {
                    option = 2;
                } else {
                    option = 3;
                }


            }

            if (option == 2 && budget < 2) {
                System.out.println(" ");
                System.out.println("Your budget does not allow you to feed your pet or give it any drinks!");
                System.out.println("Choose what you want to do. Choose from the following options:");
                System.out.println("1. Play!");
                option = IO.readInt();
                System.out.println(" ");

                while (option != 1) {
                    System.out.println("Enter the integer '1', since you only have one option from the usual 3. ");
                    option = IO.readInt();
                    System.out.println(" ");

                }
                option = 3;
            }


//Feeding
            //if user decides to feed the pet, the following lines of code are for sub-feeding options (varieties of
            //food


            if (option == 1) {

                if (budget < 8 && budget > 5) {
                    System.out.println("Due to budget restrictions, you can only choose food from the following options:");
                    System.out.println("1. Jalapeno Chips for $5");
                    op1 = IO.readInt();
                    while (op1 != 1) {
                        System.out.println("Enter '1' since you only have the option to feed your pet one food item!");
                        op1 = IO.readInt();
                    }
                    op1 = 2;
                }
                else if (budget > 8 && budget < 12) {
                    System.out.println("Due to budget restrictions, you can only choose food from the following options:");
                    System.out.println("1. Bread for $8");
                    System.out.println("2. Jalapeno Chips for $5");
                    op1 = IO.readInt();
                    while (op1 < 1 || op1 > 2) {
                        System.out.println("Enter '1' or '2' since you only have the option to feed your pet two food items!");
                        op1 = IO.readInt();
                    }


                }
                else {
                    System.out.println(" ");
                    System.out.println("Choose what you want to feed your pet:");
                    System.out.println("1. Bread for $8");
                    System.out.println("2. Jalpeno Chips for $5");
                    System.out.println("3. Veggies for $12");
                    op1 = IO.readInt();
                    System.out.println(" ");
                    if (op1 > 3 || op1 < 1) {
                        while (op1 > 4 || op1 < 1) {
                            System.out.println(" ");
                            System.out.println("Enter an integer 1 and 3(1 & 3 inclusive)!");
                            op1 = IO.readInt();
                            System.out.println(" ");
                        }

                    }
                }


                if (op1 == 1) {

                    if (hunger < 10) {
                        boredom = boredom + 10;
                        hunger = 0;
                        thirst = thirst + 10;
                        hungry_level = hungry_level + 10;
                        budget = budget - 8;
                        water_level = 0;
                        beer_level = 0;
                        i++;
                    } else {
                        boredom = boredom + 10;
                        hunger = hunger - 10;
                        thirst = thirst + 10;
                        hungry_level = hungry_level + 10;
                        budget = budget - 8;
                        water_level = 0;
                        beer_level = 0;
                        i++;
                    }
                } else if (op1 == 2) {
                    if (hunger < 7) {
                        boredom = boredom + 10;
                        hunger = 0;
                        thirst = thirst + 15;
                        hungry_level = hungry_level + 10;
                        budget = budget - 5;
                        water_level = 0;
                        beer_level = 0;
                        i++;
                    } else {
                        boredom = boredom + 10;
                        hunger = hunger - 7;
                        thirst = thirst + 15;
                        hungry_level = hungry_level + 10;
                        budget = budget - 5;
                        water_level = 0;
                        beer_level = 0;
                        i++;
                    }

                } else {
                    if (hunger < 12) {
                        boredom = boredom + 10;
                        hunger = 0;
                        thirst = thirst + 5;
                        hungry_level = hungry_level + 10;
                        budget = budget - 12;
                        water_level = 0;
                        beer_level = 0;
                        i++;
                    } else {
                        boredom = boredom + 10;
                        hunger = hunger - 12;
                        thirst = thirst + 5;
                        hungry_level = hungry_level + 10;
                        budget = budget - 12;
                        water_level = 0;
                        beer_level = 0;
                        i++;
                    }
                }


            }



//Drinks
            //if user decides to give the pet a drink, the following lines of code are for sub-drinking options (varieties of
            //drinks

            if (option == 2) {

                if (budget < 4) {
                    System.out.println("Due to budget restrictions, you can only choose drinks from the following options:");
                    System.out.println("1. Water for $2");
                    System.out.println("2. Lemonade for $3");
                    op2 = IO.readInt();
                    while (op2 < 1 || op2 > 2) {
                        System.out.println("Enter '1' or '2' since you only have two drink options!");
                        op2 = IO.readInt();
                    }
                } else if (budget > 4 && budget < 14) {
                    System.out.println("Due to budget restrictions, you can only choose food from the following options:");
                    System.out.println("1. Water for $2");
                    System.out.println("2. Lemonade for $3");
                    System.out.println("3. Coffee for $4");
                    op2 = IO.readInt();
                    while (op2 < 1 || op2 > 3) {
                        System.out.println("Enter '1', '2' or '3' since you only have three drink options from the usual four!");
                        op2 = IO.readInt();
                    }
                } else {

                    System.out.println(" ");
                    System.out.println("Choose a drink for your pet:");
                    System.out.println("1. Water for $2");
                    System.out.println("2. Lemonade for $3");
                    System.out.println("3. Coffee for $4");
                    System.out.println("4. Beer for $13");
                    op2 = IO.readInt();
                    System.out.println(" ");
                    if (op2 > 4 || op2 < 1) {
                        while (op2 > 3 || op2 < 1) {
                            System.out.println(" ");
                            System.out.println("Enter an integer 1 and 4(1 & 4 inclusive)!");
                            op2 = IO.readInt();
                            System.out.println(" ");
                        }
                    }
                }

                if (op2 == 1) {
                    if (thirst < 15) {
                        boredom = boredom + 10;
                        thirst = 0;
                        thirsty_level = thirsty_level + 1;
                        water_level = water_level + 1;

                        if (water_level == 3) {
                            sickness = sickness + 30;
                        }
                        if (water_level == 4) {
                            sickness = sickness + 10;
                        }
                        if (water_level == 5) {
                            sickness = 100;

                        }
                        budget = budget - 2;
                        hungry_level = 0;
                        beer_level = 0;
                        i++;
                    } else {
                        boredom = boredom + 10;
                        thirst = thirst - 15;
                        thirsty_level = thirsty_level + 1;
                        hungry_level = 0;
                        water_level = water_level + 1;
                        budget = budget - 2;
                        beer_level = 0;
                        i++;
                    }

                } else if (op2 == 2) {
                    if (thirst < 10) {
                        boredom = boredom + 10;
                        thirst = 0;
                        thirsty_level = thirsty_level + 1;
                        budget = budget - 3;
                        hungry_level = 0;
                        water_level = 0;
                        beer_level = 0;
                        i++;
                    } else {
                        boredom = boredom + 10;
                        thirst = thirst - 10;
                        thirsty_level = thirsty_level + 1;
                        budget = budget - 3;
                        hungry_level = 0;
                        water_level = 0;
                        beer_level = 0;
                        i++;
                    }
                } else if (op2 == 3) {
                    if (thirst < 7) {
                        boredom = boredom + 10;
                        thirst = 0;
                        thirsty_level = thirsty_level + 1;
                        budget = budget - 4;
                        hungry_level = 0;
                        water_level = 0;
                        beer_level = 0;
                        i++;
                    } else {
                        boredom = boredom + 10;
                        thirst = thirst - 7;
                        thirsty_level = thirsty_level + 1;
                        budget = budget - 4;
                        hungry_level = 0;
                        water_level = 0;
                        beer_level = 0;
                        i++;
                    }
                } else {
                    if (thirst < 5) {
                        boredom = boredom + 10;
                        thirst = 0;
                        thirsty_level = thirsty_level + 1;
                        budget = budget - 13;
                        hungry_level = 0;
                        water_level = 0;
                        beer_level = beer_level + 10;
                        if (beer_level == 20 || beer_level == 30) {
                            if(beer_level==20){
                                System.out.println("You've had 2 beers back-to back");
                            }

                            if(beer_level==30){
                                System.out.println("You've had 3 beers back-to back");
                            }
                            sickness = sickness + 10;

                        }

                        if (beer_level == 40) {

                            sickness = sickness + 30;
                            System.out.println("You've had 4 beers back-to-back! You are the brink of alcohol poisoning if you have one more beer!");
                        }
                        if (beer_level > 40) {
                            sickness = 100;

                        }


                        i++;
                    } else {
                        thirst = thirst - 5;
                        thirsty_level = thirsty_level + 1;
                        hungry_level = 0;
                        water_level = 0;
                        beer_level = beer_level + 10;
                        budget = budget - 13;
                        if (beer_level == 20 || beer_level == 30) {
                            sickness = sickness + 10;
                            if(beer_level==20){
                                System.out.println(" ");
                                System.out.println("You've had 2 beers back-to back");
                                System.out.println(" ");
                            }

                            if(beer_level==30){
                                System.out.println(" ");
                                System.out.println("You've had 3 beers back-to back");
                                System.out.println(" ");
                            }
                        }

                        if (beer_level == 40) {
                            sickness = sickness + 30;
                            System.out.println(" ");
                            System.out.println("You've had 4 beers back-to-back! You are at the brink of life-threatening alcohol poisoning if you have one more beer!");
                            System.out.println(" ");
                        }
                        if (beer_level > 40) {
                            sickness = 100;
                        }
                        i++;
                    }
                }


            }

            //Play
            //if user decides to play with the pet, the following lines of code are for different kinds of playing
            // options

            if (option == 3) {
                System.out.println(" ");
                System.out.println("Choose an activity:");
                System.out.println("1. Walk!");
                System.out.println("2. Play ball!");
                System.out.println("3. Dance!");
                System.out.println("4. Play a guessing game!");

                op3 = IO.readInt();
                System.out.println(" ");
                if (op3 > 4 || op3 < 1) {
                    while (op3 > 4 || op3 < 1) {
                        System.out.println(" ");
                        System.out.println("Enter an integer 1 and 4(1 & 4 inclusive)!");
                        op3 = IO.readInt();
                        System.out.println(" ");
                    }
                }

                if (op3 == 1) {
                    if (boredom < 10) {
                        boredom = 0;
                        hunger = hunger + 10;
                        hungry_level = 0;
                        water_level = 0;

                        if (beer_level == 20 || beer_level == 30) {
                            sickness = sickness + 10;
                        }
                        if (beer_level == 40) {
                            sickness = sickness + 20;
                        }
                        beer_level = 0;
                        i++;
                    } else {
                        hunger = hunger + 10;
                        boredom = boredom - 10;

                        hungry_level = 0;
                        water_level = 0;
                        if (beer_level == 20 || beer_level == 30) {
                            sickness = sickness + 10;
                        }
                        if (beer_level == 40) {
                            sickness = sickness + 20;
                        }
                        beer_level = 0;
                        i++;
                    }

                } else if (op3 == 2) {
                    if (boredom < 12) {
                        hunger = hunger + 20;
                        boredom = 0;
                        hungry_level = 0;
                        water_level = 0;
                        thirst = thirst + 10;
                        if (beer_level == 20 || beer_level == 30) {
                            sickness = sickness + 10;
                        }
                        if (beer_level == 40) {
                            sickness = sickness + 20;
                        }
                        beer_level = 0;
                        i++;
                    } else {
                        hunger = hunger + 20;
                        boredom = boredom - 12;
                        hungry_level = 0;
                        water_level = 0;
                        thirst = thirst + 10;
                        if (beer_level == 20 || beer_level == 30) {
                            sickness = sickness + 10;
                        }
                        if (beer_level == 40) {
                            sickness = sickness + 20;
                        }
                        beer_level = 0;
                        i++;
                    }

                } else if (op3 == 4) { //code for a game of guessing numbers between the user and the pet

                    System.out.println("Instructions: Your pet can choose a number from 0-20. You  can guess a number between 0-20 (0 and 20 inclusive).");
                    System.out.println("You can try to guess which number your pet choose and your pet will indicate if you choose the right number.");
                    System.out.println("If you didn't choose the right number, your pet will let you know if the number it choose is greater than or smaller than the number you guessed!");
                    System.out.println("Let's begin!");
                    System.out.println(" ");
                    double y = Math.floor(Math.random() * 21);
                    System.out.println("Your pet has chosen a number!");
                    System.out.println("It's your turn. Guess a number (enter an integer)!");
                    z = IO.readInt(); //z is number chosen by user
                    if (z == y) {
                        System.out.println(" ");
                        System.out.println("Your guess is correct!");
                        System.out.println("Game over!");
                        System.out.println(" ");
                        j=1;
                    }
                    while (z != y) {
                        if (y > z) {
                            System.out.println(" ");
                            System.out.println("Your pet choose a number greater than " + z);
                            System.out.println("Guess again!");
                            z = IO.readInt();
                            j++;
                        } else {

                            System.out.println(" ");
                            System.out.println("Your pet choose a number less than " + z);
                            System.out.println("Guess again!");
                            z = IO.readInt();
                            j++;

                        }
                    }
                    if (z == y) {

                        System.out.println(" ");
                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                        System.out.println("$   Your guess is correct!   $");
                        System.out.println("$         Game over!         $");
                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                        System.out.println(" ");
                        if(j==1) {
                            System.out.println("Your pet took only 1 guess to guess the right number! Great job!");
                        }
                        else
                        {
                            System.out.println("Your pet took " + j + " guesses to guess the right number!");
                        }
                        System.out.println("Your pet had a lot of fun playing this game!");
                    }
                    if (j > 5) {
                        hunger = hunger + 25;
                        System.out.println("Your pet is now completely energized and it's boredom level went down to 0% but it got ");
                        System.out.println("hungrier than before because you took more than 5 chances to guess!");
                        System.out.println(" ");
                    } else {
                        hunger = hunger + 10;
                        System.out.println("Your pet is now completely energized and it's boredom level went down to 0% but it got mildly hungry! ");
                        System.out.println(" ");
                    }
                    hungry_level = 0;
                    water_level = 0;
                    boredom = 0;
                    i++;


                }



                else {
                    if (boredom < 15) {
                        boredom = 0;
                        hunger = hunger + 30;
                        hungry_level = 0;
                        water_level = 0;
                        beer_level = 0;
                        thirst = thirst + 20;
                        i++;
                    } else {
                        hunger = hunger + 30;
                        boredom = boredom - 15;
                        hungry_level = 0;
                        water_level = 0;
                        beer_level = 0;
                        thirst = thirst + 20;
                        i++;
                    }

                }
            }

            if (option == 5) { //this option is for commands that take place if the user chooses to help
                               //with too much alcohol consumption by the pet

                if (budget > 6) {
                    System.out.println("Your pet was given a drink of water and nutritious food!");
                    budget = budget - 6;
                    if (beer_level == 20 || beer_level == 30) {


                        if (sickness < 10) {
                            sickness = 0;
                            beer_level = 0;
                        } else
                            sickness = sickness - 10;
                        beer_level = beer_level - 10;
                    }
                    if (beer_level == 40) {

                        if (sickness < 20) {
                            sickness = 0;

                        }
                        sickness = sickness - 20;
                        beer_level = 0;

                    }
                } else {
                    System.out.print("Right now, your budget does not allow you to give your pet special nutrition.");

                }

            }


        }
        //commands that take place if any levels hit 100%

        if (thirst >= 100) {
            System.out.println("Your pet died of thirst at "+number+" days old!");
        }
            if (hunger >= 100) {
                System.out.println("Your pet died of hunger at "+number+" days old!");
            }
        if (boredom >= 100) {
            System.out.println("Your pet died of boredom at "+number+" days old!");

        }
        if (sickness >= 100) {
            System.out.println("Your pet died of sickness at "+number+" days old!");

            if(beer_level>40){
                System.out.println("Your pet died of sickness from alcohol poisoning at "+number+" days old!");
            }
        }




    }
}
