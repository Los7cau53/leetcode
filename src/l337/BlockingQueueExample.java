package l337;
/**
 * http://tutorials.jenkov.com/java-concurrency/blocking-queues.html
 * 
 * http://tutorials.jenkov.com/java-util-concurrent/blockingqueue.html
 
 https://www.journaldev.com/1034/java-blockingqueue-example
 * 
 * 
 */
import java.util.LinkedList;
import java.util.List;

 class BlockingQueue {

  private List<Object> queue = new LinkedList<Object>();
  private int  limit = 10;

  public BlockingQueue(int limit){
    this.limit = limit;
  }


  public synchronized void enqueue(Object item)
  throws InterruptedException  {
    while(this.queue.size() == this.limit) {
      wait();
    }
    if(this.queue.size() == 0) {
      notifyAll();
    }
    this.queue.add(item);
  }


  public synchronized Object dequeue()
  throws InterruptedException{
    while(this.queue.size() == 0){
      wait();
    }
    if(this.queue.size() == this.limit){
      notifyAll();
    }

    return this.queue.remove(0);
  }

}


public  class BlockingQueueExample {

    public static void main(String[] args) throws Exception {

    	BlockingQueue queue = new BlockingQueue(1);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }
}

 class Producer implements Runnable{

    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.enqueue("1");
            Thread.sleep(1000);
            queue.enqueue("2");
            Thread.sleep(1000);
            queue.enqueue("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

 class Consumer implements Runnable{

    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
