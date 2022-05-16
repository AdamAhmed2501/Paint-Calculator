import java.time.Year;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

//      ------------------------------------------------------------------------------------------------
//      STEP 1. DEFINING THE AMOUNT OF WALLS

        System.out.println("How many walls would you like to calculate coverage for?");
        int nwalls = myScanner.nextInt();

        float totalwallarea = 0;

        for (int y = 1; y <= nwalls; y++){
        //      ------------------------------------------------------------------------------------------------
        //      STEP 1.1 DEFINING THE AREA OF THE INDIVIDUAL WALLS

                        System.out.println("What is the length of wall number " + y + ", in metres?");
                                float walllength = myScanner.nextFloat();

                        System.out.println("What is the height of your wall number " + y + ", in metres?");
                                float wallheight = myScanner.nextFloat();

                                System.out.println("How many coats of paint would you like to apply to wall number " + y + "?");
                                int ncoats = myScanner.nextInt();

                        float basicwallarea = (wallheight * walllength);


        //      ------------------------------------------------------------------------------------------------
        //      STEP 1.2 DEFINING DOORS, WINDOWS AND SOCKETS

                        float totaldoorarea = 0;
                        float totalwindowarea = 0;


                        System.out.println("How many doors are there in wall number " + y + "?");
                                int ndoor = myScanner.nextInt();

                        if (ndoor > 0) {
                                for (int i = 1; i <= ndoor; i++) {
                                        System.out.println("What is the height, in metres, of door number " + i + " in wall number " + y + "?");
                                        float doorheight = myScanner.nextFloat();

                                        System.out.println("What is the width, in metres, of door number " + i + " in wall number " + y + "?");
                                        float doorwidth = myScanner.nextFloat();

                                        float doorarea = doorheight * doorwidth;
                                        totaldoorarea = totaldoorarea + doorarea;
                                }
                        }

                        System.out.println("How many windows are there in wall number " + y + "?");
                                int nwindow = myScanner.nextInt();

                        if (nwindow > 0) {
                                for (int i = 1; i <= nwindow; i++) {
                                        System.out.println("What is the height, in metres, of window number " + i + " in wall number " + y + "?");
                                        float windowheight = myScanner.nextFloat();

                                        System.out.println("What is the width, in metres, of window number " + i + " in wall number " + y + "?");
                                        float windowlength = myScanner.nextFloat();

                                        float windowarea = windowheight * windowlength;
                                        totalwindowarea = totalwindowarea + windowarea;
                                }
                        }


                        System.out.println("How many switches are there in wall number " + y + "?");
                        int nswitches = myScanner.nextInt();
                        float switcharea = (nswitches * 0.0128f);

                        System.out.println("How many plug sockets are there in wall number " + y + "?");
                        int nplugs = myScanner.nextInt();
                        float plugarea = (nplugs * 0.0064f);

                        float advwallarea = basicwallarea - totaldoorarea - totalwindowarea - plugarea - switcharea;
                        float wallareapluscoats = advwallarea*ncoats;

                        System.out.println("The area of wall number " + y + " is " + advwallarea + " m2.");

                        totalwallarea = totalwallarea + wallareapluscoats;

                        }
//      ------------------------------------------------------------------------------------------------
//      STEP 2. SUGGESTING HOW MANY LITRES ARE NEEDED

                float overshoot = 1.1f;

                float litresneeded = ((totalwallarea * overshoot) / 6);

                System.out.println("Based on a coverage of 6m2 per litre, and an overshoot of 10%, you will need " + litresneeded + "L to cover your wall.");


//      ------------------------------------------------------------------------------------------------
//      STEP 3. DEFINING THE SIZE OF THE BUCKETS

                System.out.println("What is the size of the paint buckets you intend to purchase, in litres?");
                        float bucketsize = myScanner.nextFloat();

                float bucketsreq = (litresneeded / bucketsize);


//      ------------------------------------------------------------------------------------------------
//      STEP 4. SUGGESTING HOW MANY BUCKETS ARE REQUIRED

                System.out.println("You will need " + (Math.ceil(bucketsreq)) + " x " + bucketsize + "L .");

                }
        }

