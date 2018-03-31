/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash_table_performance;

import hash_functions.BSTHashTableSet;
import hash_functions.HashTableSet;
import hash_functions.LLQHashTableSet;
import java.util.Random;

/**
 *
 * @author admin
 */
public class TimingTest2 {
        public static void main (String[] args)
    {
        Random rand = new Random();
//        HashTableSet<Integer> set = new LLQHashTableSet(10);       
// 
//        System.out.println("Starting timing tests...");
//        long time1, time2, duration;
//        time1 = System.currentTimeMillis();
//     
//        for (int i = 0; i < 50000; i++) {
//             set.add(rand.nextInt());
//        }
//   
//        time2 = System.currentTimeMillis();
//        duration = time2 - time1;
// 
//        System.out.println("Time taken in ms: " + duration);
//        
//        average:  9524ms, 9 sec
//        System.out.println(set.getLoadFactor());   // 5000
//        System.out.println(set.getBucketSizeStandardDev());  // 80.38
        
        
        
        
        
//          HashTableSet<Integer> set = new LLQHashTableSet(100);       
// 
//        System.out.println("Starting timing tests...");
//        long time1, time2, duration;
//        time1 = System.currentTimeMillis();
//     
//        for (int i = 0; i < 50000; i++) {
//             set.add(rand.nextInt());
//        }
//   
//        time2 = System.currentTimeMillis();
//        duration = time2 - time1;
// 
//        System.out.println("Time taken in ms: " + duration);
//        
//        // avg: 1183ms, 1 sec
//        System.out.println(set.getLoadFactor());   // 500
//        System.out.println(set.getBucketSizeStandardDev());  // 23.024
        
        
        
        
//        HashTableSet<Integer> set = new LLQHashTableSet(5000);
//        System.out.println("Starting timing tests...");
//        long time1, time2, duration;
//        time1 = System.currentTimeMillis();
//     
//        for (int i = 0; i < 50000; i++) {
//             set.add(i);
//        }
//   
//        time2 = System.currentTimeMillis();
//        duration = time2 - time1;
// 
//        System.out.println("Time taken in ms: " + duration);
//        
//
//        // average:   31 ms
//        System.out.println(set.getLoadFactor());   // 10
//        System.out.println(set.getBucketSizeStandardDev());  // 0
        
        
        
        
        
        
        
        
        
        
        
//        HashTableSet<Integer> set = new BSTHashTableSet(10);       
// 
//        System.out.println("Starting timing tests...");
//        long time1, time2, duration;
//        time1 = System.currentTimeMillis();
//     
//        for (int i = 0; i < 50000; i++) {
//             set.add(rand.nextInt());
//        }
//   
//        time2 = System.currentTimeMillis();
//        duration = time2 - time1;
// 
//        System.out.println("Time taken in ms: " + duration);
//        
//         avg 56ms, 0s
//        System.out.println(set.getLoadFactor());   // 5000
//        System.out.println(set.getBucketSizeStandardDev());  // 62.257        
        
        
        
        
        
//        HashTableSet<Integer> set = new BSTHashTableSet(100);       
// 
//        System.out.println("Starting timing tests...");
//        long time1, time2, duration;
//        time1 = System.currentTimeMillis();
//     
//        for (int i = 0; i < 50000; i++) {
//             set.add(rand.nextInt());
//        }
//   
//        time2 = System.currentTimeMillis();
//        duration = time2 - time1;
// 
//        System.out.println("Time taken in ms: " + duration);
//        
//
////       avg: 47 ms, 0s
//        System.out.println(set.getLoadFactor());   // 500
//        System.out.println(set.getBucketSizeStandardDev());  // 23.952
        
        
        
        
        
        HashTableSet<Integer> set = new BSTHashTableSet(5000);       
 
        System.out.println("Starting timing tests...");
        long time1, time2, duration;
        time1 = System.currentTimeMillis();
     
        for (int i = 0; i < 50000; i++) {
             set.add(rand.nextInt());
        }
   
        time2 = System.currentTimeMillis();
        duration = time2 - time1;
 
        System.out.println("Time taken in ms: " + duration);
        
        // avg; 23ms, 0s
        System.out.println(set.getLoadFactor());   // 10
        System.out.println(set.getBucketSizeStandardDev());  // 3.13
        
    }
}
