import java.util.*;
public class QuizApplication{
    private static  Scanner scanner=new Scanner(System.in);
    public static void main(String[] args){
        Map<String,String[]>questions=new HashMap<>();
        questions.put("What is the capital of West Bengal?",
          new String[]{"A.Malda","B.Nadia","C.Kolkata","D.Kharagpur","C"});
        questions.put("what is the powerhouse of the cell?",
          new String[]{"A.Ribosome","B.Mitochondria","C.Golgi Apparatus","D.Nucleus","B"});
        int question TimeLimit=10;
        int score=0;
        for(Map.Entry<String,String[]>entry:questions.entrySet()){
            String question=entry.getKey();
            String[]options=entry.getValue();
            System.out.println(question);
            for(String option:options){
                System.out.println(option);
            }
            TimerTask task=new TimerTask(){
              public void run(){
                System.out.println("Time's up!");
              }
            };
            Timer timer=new Timer();
            timer.schedule(task,questionTimeLimit*1000);
            System.out.print("Enter your answer:");
            String answer=scanner.nextLine().toUpperCase();
            timer.cancel();
            if(answer.equals(options[4])){
              System.out.println("Correct!");
              score++;
            }else{
              System.out.println("Incorrect!");
            }        
        }
        System.out.println("Quiz ended.Your score:"+score+"/"+questions.size());
    }
}