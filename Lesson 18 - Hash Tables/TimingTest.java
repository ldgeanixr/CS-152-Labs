/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash_tables;

/**
 * Observation: the higher the number of buckets, faster the operation
 * @author admin
 */
public class TimingTest {

//        public static void main(String[] args) {
//     
//        Set<Integer> set = new LLQHashTableSet(10);
// 
//        System.out.println("Starting timing tests...");
//        long time1, time2, duration;
//        time1 = System.currentTimeMillis();
//     
//        for (int i = 0; i < 500000; i++) {
//             set.add(i);
//        }
//   
//        time2 = System.currentTimeMillis();
//        duration = time2 - time1;
// 
//        System.out.println("Time taken in ms: " + duration);
//        
//        //1st trial: 2329741 (38.8 min)
//        //2nd trial: 2528163  (42 min 10 sec)
//        //3rd trial: 2283086  (38 min 5 sec)
//        // average:  2380330 (39.7 min)
//    }
    
//    public static void main(String[] args) {
//     
//        Set<Integer> set = new LLQHashTableSet(100);
// 
//        System.out.println("Starting timing tests...");
//        long time1, time2, duration;
//        time1 = System.currentTimeMillis();
//     
//        for (int i = 0; i < 500000; i++) {
//             set.add(i);
//        }
//   
//        time2 = System.currentTimeMillis();
//        duration = time2 - time1;
// 
//        System.out.println("Time taken in ms: " + duration);
//        
//        //1st trial: 273109 (4 min 35 sec)
//        //2nd trial: 246843 (4 min 7 sec)
//        //3rd trial: 257195 (4 min 17 sec)
//        // average:  259049 (4.3 min)
//    }
    
//    public static void main(String[] args) {
//     
//        Set<Integer> set = new LLQHashTableSet(5000);
// 
//        System.out.println("Starting timing tests...");
//        long time1, time2, duration;
//        time1 = System.currentTimeMillis();
//     
//        for (int i = 0; i < 500000; i++) {
//             set.add(i);
//        }
//   
//        time2 = System.currentTimeMillis();
//        duration = time2 - time1;
// 
//        System.out.println("Time taken in ms: " + duration);
//        
//        //1st trial: 4257 (4 sec)
//        //2nd trial: 4299 (4 sec)
//        //3rd trial: 4393 (4 sec)
//        // average:  4316 (4.3 sec)
//    }
    
        public static void main(String[] args) {
     
        Set<Integer> set = new LLQHashTableSet(5000000);
 
        System.out.println("Starting timing tests...");
        long time1, time2, duration;
        time1 = System.currentTimeMillis();
     
        for (int i = 0; i < 500000; i++) {
             set.add(i);
        }
   
        time2 = System.currentTimeMillis();
        duration = time2 - time1;
 
        System.out.println("Time taken in ms: " + duration);
        
        // average:  168 (0.1 sec)
    }
}
