import java.util.Scanner;
public class FarmGame {
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		String name=nameEntry();
		int money=selectDifficulty(name);
		double multi=selectDifficulty2(name);
		int year=(int)game(name, money, multi);
		System.out.println(("OOPS, YOU'RE BROKE!").toLowerCase());
		System.out.println("farmer "+name+(" LASTED "+(year-1)+" YEARS").toLowerCase());
		System.out.println(("THANK YOU FOR PLAYING FARM GAME").toLowerCase());
	}
	public static int game(String name, int money, double multi) {
		int dairy=1;
		int[] moneydairy=imp(money,dairy);
		int loop=0;
		int year=0;
		while(loop==0) {
			year+=1;
			moneydairy=yearly(name, moneydairy[0], year, moneydairy[1], multi);
			if(moneydairy[0]<550) {
				loop=1;
			}
		}
		return year;
	}
	public static int[] yearly(String name, int money, int year, int dairy, double multi) {
		int epic=0;
		int animal=0;
		int wh=0;
		int oa=0;
		int ba=0;
		int ry=0;
		int co=0;
		int dc=0;
		int bc=0;
		int sh=0;
		int ho=0;
		int turn=1;
		int rent=0;
		money-=500;
		int acres=4;
		System.out.println("\nyear "+year+", farmer "+name+", money "+money);
		if(year!=1) {
			System.out.println(("LIVING COST WAS 500 MONEY").toLowerCase());
		}
		while(turn==1) {
			if(animal%4!=0) {
				System.out.println((animal*10+" ACRES OUT OF AN ANIMAL 40-ACRE USED").toLowerCase());
			}
			System.out.println((money+" MONEY LEFT").toLowerCase());
			System.out.println((acres*40+" EMPTY PLANT ACRES LEFT").toLowerCase());
			System.out.println(("WHAT WOULD YOU LIKE TO BUY, FARMER ").toLowerCase()+name+"?");
			System.out.println(("SAY THE NAME OF A PRODUCT TO BUY IT, OR YOU CAN SAY \"RENT\" TO RENT ADDITIONAL ACRES").toLowerCase());
			System.out.println(("YOU CAN ALSO SAY \"HELP\" FOR PRICING AND ACRE RULES, \"LOAN\" TO LOAN OUT AN ACRE, OR YOU CAN SAY \"END\" TO END YOUR TURN").toLowerCase());
			String thing=scan.nextLine().toUpperCase();
			if(thing.equals("END")){
				turn=0;
			}else if(thing.equals("HELP")) {
				rules();
			}else if(thing.equals("WHEAT")&&acres>0&&money>=100) {
				System.out.println(("BOUGHT WHEAT FOR 100 MONEY").toLowerCase());
				money-=100;
				acres-=1;
				wh+=1;
			}else if(thing.equals("OATS")&&acres>0&&money>=100) {
				System.out.println(("BOUGHT OATS FOR 100 MONEY").toLowerCase());
				money-=100;
				acres-=1;
				oa+=1;
			}else if(thing.equals("BARLEY")&&acres>0&&money>=100) {
				System.out.println(("BOUGHT BARLEY FOR 100 MONEY").toLowerCase());
				money-=100;
				acres-=1;
				ba+=1;
			}else if(thing.equals("RYE")&&acres>0&&money>=100) {
				System.out.println(("BOUGHT RYE FOR 100 MONEY").toLowerCase());
				money-=100;
				acres-=1;
				ry+=1;
			}else if(thing.equals("CORN")&&acres>0&&money>=200) {
				System.out.println(("BOUGHT CORN FOR 200 MONEY").toLowerCase());
				money-=200;
				acres-=1;
				co+=1;
			}else if((thing.equals("DAIRY")||thing.equals("DAIRY COW"))&&(animal%4>0||acres>0)&&money>=100) {
				if(dairy==1&&money>=200) {
					System.out.println(("TO BUY DAIRY COWS, YOU MUST PAY A ONE TIME DAIRY COST OF 200 MONEY").toLowerCase());
					System.out.println(("PAID DAIRY COST FOR 200 MONEY").toLowerCase());
					money-=200;
					dairy=0;
					epic=200;
				}
				System.out.println(("BOUGHT DAIRY COW FOR 100 MONEY").toLowerCase());
				money-=100;
				dc+=1;
				animal+=1;
				if(animal%4==1) {
					acres-=1;
				}
			}else if((thing.equals("BEEF")||thing.equals("BEEF COW"))&&(animal%4>0||acres>0)&&money>=100) {
				System.out.println(("BOUGHT BEEF COW FOR 100 MONEY").toLowerCase());
				money-=100;
				bc+=1;
				animal+=1;
				if(animal%4==1) {
					acres-=1;
				}
			}else if(thing.equals("SHEEP")&&(animal%4>0||acres>0)&&money>=100) {
				System.out.println(("BOUGHT SHEEP FOR 100 MONEY").toLowerCase());
				money-=100;
				sh+=1;
				animal+=1;
				if(animal%4==1) {
					acres-=1;
				}
			}else if((thing.equals("HOGS")||thing.equals("HOG"))&&money>=100) {
				if(ho<6) {
					System.out.println(("BOUGHT HOG FOR 100 MONEY").toLowerCase());
					money-=100;
					ho+=1;
				}else {
					System.out.println(("HOG OWNING CAP OF 6 ALREADY HIT ").toLowerCase());
				}
			}else if(thing.equals("RENT")&&money>=100){
				if(rent<4) {
					System.out.println(("RENTED OUT 40 ACRES FOR 100 MONEY").toLowerCase());
					money-=100;
					acres+=1;
					rent+=1;
				}else {
					System.out.println(("RENTING CAP OF 160 ACRES ALREADY HIT").toLowerCase());
				}
			}else if((thing.equals("LOAN")||thing.equals("LOAN OUT"))&&acres>=1){
				System.out.println(("LOANED OUT 40 ACRES, GETTING 100 MONEY").toLowerCase());
				acres-=1;
				money+=100;
				rent-=1;
			}else{
				System.out.println(("YOU EITHER DON'T HAVE ENOUGH MONEY / ACRES, OR YOU MISSPELLED WHAT YOU WANTED TO BUY").toLowerCase());
			}	
		}
		int sum=endOfYear(wh*100,oa*100,ba*100,ry*100,co*200,dc*100,bc*100,sh*100,ho*100,epic,multi);
		money=sum+money;
		enter();
		int[] moneydairy=imp(money,dairy);
		return moneydairy;
	}
	public static int endOfYear(int wh, int oa, int ba, int ry, int co, int dc, int bc, int sh, int ho, int dairy,double multi) {
		int presum=wh+oa+ba+ry+co+dc+bc+sh+ho+dairy;
		double rwh=(Math.round(Math.random()*4) / 2.0)+multi;
		double roa=(Math.round(Math.random()*4) / 2.0)+multi;
		double rba=(Math.round(Math.random()*4) / 2.0)+multi;
		double rry=(Math.round(Math.random()*4) / 2.0)+multi;
		double rco=(Math.round(Math.random()*4) / 2.0)+multi;
		double rdc=(Math.round(Math.random()*4) / 2.0)+multi;
		double rbc=(Math.round(Math.random()*4) / 2.0)+multi;
		double rsh=(Math.round(Math.random()*4) / 2.0)+multi;
		double rho=(Math.round(Math.random()*4) / 2.0)+multi;
		wh=random(wh,rwh,"WHEAT");
		oa=random(oa,roa,"OATS");
		ba=random(ba,rba,"BARLEY");
		ry=random(ry,rry,"RYE");
		co=random(co,rco,"CORN");
		dc=random(dc,rdc,"DAIRY COWS");
		bc=random(bc,rbc,"BEEF COWS");
		sh=random(sh,rsh,"SHEEP");
		ho=random(ho,rho,"HOGS");
		int sum=wh+oa+ba+ry+co+dc+bc+sh+ho;
		System.out.println(("THE SUM OF THE END MONEY AFTER PAYMENT OF YEARLY RENT IS "+(sum-500)+", AS COMPARED TO THE MONEY SPENT, "+presum).toLowerCase());
		return sum;
	}
	public static int random(int original, double random, String product) {
		int thing=(original*(int)(random*10))/10;
		if(thing>original) {
			System.out.println(("x"+random+" MULTIPLIER ON "+product+", "+(thing-original)+" MONEY EARNED").toLowerCase());
		}else if(thing<original) {
			System.out.println(("x"+random+" MULTIPLIER ON "+product+", "+(original-thing)+" MONEY LOST").toLowerCase());
		}else if(thing==original) {
			if(original==0) {
				System.out.println(("x"+random+" MULTIPLIER ON "+product+", NO MONEY RISKED").toLowerCase());
			}else {
				System.out.println(("x"+random+" MULTIPLIER ON "+product+", NO MONEY LOST").toLowerCase());
			}
		}
		return thing;
	}
	public static String nameEntry() {
		System.out.println(("FARM GAME IS PORTED FROM A PENCIL AND PAPER GAME I PLAYED IN US HISTORY CLASS\n").toLowerCase());
		System.out.println(("WELCOME, TO FARM GAME").toLowerCase());
		System.out.println(("PLEASE INPUT FARMER'S NAME").toLowerCase());
		String name=scan.nextLine();
		return name;
	}
	public static int selectDifficulty(String name) {
		System.out.println("\nfarmer "+name+(", PLEASE INPUT YOUR DIFFICULTY LEVEL OF STARTING MONEY").toLowerCase());
		System.out.println(("\"EASY\" = 2000 MONEY, \"HARD\" = 500 MONEY, ANYTHING ELSE = 1000 MONEY").toLowerCase());
		String difficulty=scan.nextLine().toUpperCase();
		if(difficulty.equals("EASY")) {
			System.out.println(("STARTING MONEY SET TO 2000").toLowerCase());
			return 2500;
		}else if(difficulty.equals("HARD")) {
			System.out.println(("STARTING MONEY SET TO 500").toLowerCase());
			return 1000;
		}
		System.out.println(("STARTING MONEY SET TO 1000").toLowerCase());
		return 1500;
	}
	public static void enter(){
		   System.out.println(("PRESS \"ENTER\" TO CONTINUE").toLowerCase());
		   scan.nextLine();
		}
	public static void rules() {
		System.out.println(("PLANTS: 'WHEAT', 'OATS', 'BARLEY' & 'RYE' COST 100 MONEY EACH, 'CORN' COSTS 200 MONEY EACH").toLowerCase());
		System.out.println(("ANIMALS: 'SHEEP', 'BEEF' COWS, AND 'HOGS' COST 100 MONEY EACH").toLowerCase());
		System.out.println(("'DAIRY' COWS COST 100 MONEY EACH, WITH A ONE TIME 200 MONEY COST TO SET UP MILKING STATION").toLowerCase());
		System.out.println(("EACH PLANT TAKES UP 40 ACRES (CALLED A 40-ACRE HERE), WHILE 'SHEEP', 'DAIRY' & 'BEEF' COWS TAKE UP 10 ACRES EACH").toLowerCase());
		System.out.println(("AN ANIMAL 40-ACRE CAN HOLD UP TO 4 ANIMALS, BUT NOTHING ELSE").toLowerCase());
		System.out.println(("'HOGS' ROAM FREELY AND AS SUCH TAKE UP NO ACRES. ONE CAN HAVE UP TO 6 EACH YEAR").toLowerCase());
		System.out.println(("YOU HAVE 160 ACRES PAID FOR BY THE 500 MONEY LIVING WAGE").toLowerCase());
		System.out.println(("YOU MAY CHOOSE TO 'LOAN' OUT LAND FOR 100 MONEY PER 40 ACRES").toLowerCase());
		System.out.println(("YOU MAY 'RENT' AN ADDITIONAL 160 WHEN NEEDED, 100 MONEY FOR 40 ACRES").toLowerCase());
		System.out.println(("IN THE END OF THE YEAR, EACH THING BOUGHT WILL GET A MULTIPLIER, AND MONEY WILL EITHER BE ADDED OR TAKEN AWAY").toLowerCase());
	}
	static int[] imp(int a, int b) { 
		int[] moneydairy = new int[2]; 
		moneydairy[0] = a; 
		moneydairy[1] = b; 
		return moneydairy; 
    } 
	public static double selectDifficulty2(String name) {
		System.out.println("\nfarmer "+name+(", PLEASE INPUT YOUR DIFFICULTY LEVEL OF ADDITION TO MULTIPLIERS").toLowerCase());
		System.out.println(("\"EASY\" = +1 MULTIPLIER, \"HARD\" = +0 MULTIPLIER, ANYTHING ELSE = +0.5 MULTIPLIER").toLowerCase());
		String difficulty=scan.nextLine().toUpperCase();
		if(difficulty.equals("EASY")) {
			System.out.println(("MULTIPLIERS SET TO +x1").toLowerCase());
			return 1;
		}else if(difficulty.equals("HARD")) {
			System.out.println(("MULTIPLIERS SET TO +x0").toLowerCase());
			return 0;
		}
		System.out.println(("MULTIPLIERS SET TO +x.5").toLowerCase());
		return 0.5;
	}
}