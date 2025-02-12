package Assignment5_1_2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

class ParallelSumCalculator {
    private int[] numbers; // Taulukko, jonka summa lasketaan
    private int numThreads; // Käytettävien threads määrä

    public ParallelSumCalculator(int size, int numThreads) {
        numbers = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100) + 1; // Satunnaiset luvut väliltä 1-100
        }
        this.numThreads = numThreads;
    }

    public int calculateSum() {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Integer>> futures = new ArrayList<>();
        int chunkSize = (int) Math.ceil((double) numbers.length / numThreads);

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, numbers.length);
            futures.add(executor.submit(new SumTask(numbers, start, end)));
        }

        int totalSum = 0;
        for (Future<Integer> future : futures) {
            try {
                totalSum += future.get(); // Haetaan osasummat ja lisätään kokonaispottiin
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return totalSum;
    }

    private static class SumTask implements Callable<Integer> {
        private int[] numbers;
        private int start, end;

        public SumTask(int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        }
    }
}

public class ParallelNumberSummation {
    public static void main(String[] args) {
        int arraySize = 100000; // Määritellään taulukon koko
        int numThreads = Runtime.getRuntime().availableProcessors(); // Prosessoriytimien määrä

        ParallelSumCalculator calculator = new ParallelSumCalculator(arraySize, numThreads);
        int totalSum = calculator.calculateSum();
        System.out.println("Total sum: " + totalSum);
    }
}
