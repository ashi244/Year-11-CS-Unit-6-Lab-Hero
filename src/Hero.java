import java.util.Random;
public class Hero {
    private String name;
    private int hitPoints;
    public Hero(String name){
        hitPoints = 100;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getHitPoints(){
        return hitPoints;
    }
    public String toString(){
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }
    public void attack(Hero opponent){
        Random rand = new Random();
        double randomNum = rand.nextDouble()*0.99;
        if (randomNum < 0.5){
            opponent.hitPoints = opponent.hitPoints - 10;
        }
        else{
            this.hitPoints = this.hitPoints - 10;
        }
    }
    public void senzuBean(){
        this.hitPoints = 100;
    }
    private void fightUntilTheDeathHelper(Hero opponent){
        while ((opponent.hitPoints > 0) && (this.hitPoints > 0)){
            attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent){
        opponent.hitPoints = 100;
        this.hitPoints = 100;
        fightUntilTheDeathHelper(opponent);
        return opponent.name + ": " + opponent.hitPoints + "       " + this.name + ": " + opponent.hitPoints;
    }
    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int [] wins = new int[2];
        while (n > 0){
            fightUntilTheDeath(opponent);
            if (opponent.hitPoints == 0){
                wins[0]++;
            }
            else{
                wins[1]++;
            }
            opponent.hitPoints = 100;
            this.hitPoints = 100;
            n--;
        }
        return wins;
    }
    public String nFightsToTheDeath(Hero opponent, int n){
        int [] wins = nFightsToTheDeathHelper(opponent,n);
        String playerOne = opponent.name + ": " + wins[0] + " wins";
        String playerTwo = this.name + ": " + wins[1] + " wins";
        if (wins[0] > wins[1]){
            return playerOne + "\n" + playerTwo + "\n" + opponent.name + " wins!";
        }
        else if (wins[1] > wins[0]){
            return playerOne + "\n" + playerTwo + "\n" + this.name + " wins!";
        }
        else{
            return playerOne + "\n" + playerTwo + "\nOMG! It was actually a draw!";
        }
    }
    public void dramaticFightToTheDeath(Hero opponent){
        while ((opponent.hitPoints != 0) && (this.hitPoints != 0)){
            fightUntilTheDeath(opponent);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
