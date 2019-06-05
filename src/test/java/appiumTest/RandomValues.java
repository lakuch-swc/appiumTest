package appiumTest;

public class RandomValues {

    public int getRandomAlias(){
        int max = 1000;
        int min = 1;
        int range = max - min + 1;
        int alias = (int)(Math.random() * range) + min;
        return alias;
    }

    public String getRandomName(){
        String testName = "Test" + getRandomAlias();
        return testName;
    }

    public String getPassword(){
        String password = "Te$tTe$t123";
        return password;
    }
}
