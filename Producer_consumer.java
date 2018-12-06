class Item{
    public static Item instance;
    private Item(){}
    public static Item getInstance(){if(instance==null){instance=new Item();}return instance;}
    boolean item=false;
    int data;
    public synchronized void produce(int i)throws InterruptedException{
        if(item==true){
            wait();
        }
        item=true;
        data=i;
        System.out.println("Produced Item==>"+i);
        notifyAll();
    }
    public synchronized void consume()throws InterruptedException{
        if(item==false){
            wait();
        }
        item=false;
        System.out.println("Consumed item==>"+data);
        notifyAll();
    }
}
class Producer extends Thread{
    public void run(){
        Item item=Item.getInstance();
        for(int i=0;i<=10;i++){
            System.out.println("Producer is proiducings==>"+i);
            try{
                item.produce(i);    
            }
            catch(Exception e){System.out.println("exception occured");}
            
        }
    }
}
class Consumer extends Thread{
    public void run(){
        Item item=Item.getInstance();
        for(int i=0;i<=10;i++){
            System.out.println("Consumer is consuming==>"+i);
            try{
                item.consume();    
            }
            catch(Exception e){System.out.println("exception occured");}
        }
    }
}
class ex 
{ 
    public static void main(String arg[]) 
    { 
        Producer p1=new Producer();
        Consumer c1=new Consumer();
        p1.start();
        c1.start();
    } 
} 
