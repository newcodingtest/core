package hello.core.singletonTest;

public class StateFullService {

    private int price; //상태를 유지하는 필드

    public int order(String name, int price){
        System.out.println("name = " + name + "price " + price);
        //this.price = price; // 싱글톤 패턴에서의 문제가 여기서 터짐!!
        return price;
    }

//    public int getPrice(){
//       // return price;
//    }
}
