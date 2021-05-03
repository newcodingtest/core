package hello.core.singletonTest;

public class SingletonService {

    //static 으로 하면 클래스 레벨에 올라가기 때문에 하나만 존재하게 된다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출출");
    }


   public static void main(String[] args) {

    }

}
