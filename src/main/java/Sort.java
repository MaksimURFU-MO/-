import java.util.List;

public class Sort {
    public static void bubbleSort(List<User> dataBase){
        int len = dataBase.size();
        for(int i = 0; i < len - 1; i++){
            boolean swap = false;
            for(int j = 0; j < len - 1 - i; j++){
                if(dataBase.get(j).getTime().isAfter(dataBase.get(j+1).getTime())){
                    User temp = dataBase.get(j);
                    dataBase.set(j,dataBase.get(j+1));
                    dataBase.set(j+1,temp);
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
    }


}
