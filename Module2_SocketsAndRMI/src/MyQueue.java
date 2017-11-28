
public class MyQueue {


        private final static int CAPACITY = 7;
        static String qitems[] = new String[CAPACITY];
        private static int front = 0, end = 0, count=0;

        public void addqueue(String name) 
         {
            qitems[end] = name;
            count++;
            if(count==7)
            {
               takequeue();
               System.out.println("Queue is full");
            }
               end = (end + 1) % 7;
           }


         public void takequeue() 
         {
            System.out.println("Item removed:"+qitems[front]);
               front = (front +1) % 7;
         }

         public void displayNames() 
         {
             System.out.println(" 3 names entered are: ");
                for (int x = 0; x < 3; x++) 
                {
                    System.out.println( qitems[x]) ;
                }
         }   
         
         public static void main(String [] args) {             
             MyQueue q = new MyQueue();
             q.addqueue("a");
             q.addqueue("b");
             q.addqueue("c");
             q.addqueue("d");
             q.addqueue("e");
             q.addqueue("f");
             q.addqueue("g");
             q.addqueue("h");
         }
    }
