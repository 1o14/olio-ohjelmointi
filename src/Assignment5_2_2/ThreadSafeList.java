package Assignment5_2_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ThreadSafeList<T> {
    private final List<T> list;

    public ThreadSafeList() {
        this.list = Collections.synchronizedList(new ArrayList<>());
    }

    public void addElement(T element) {
        synchronized (list) {
            list.add(element); // Lisätään elementti listaan
            System.out.println(Thread.currentThread().getName() + " added: " + element);
        }
    }

    public int getSize() {
        synchronized (list) {
            return list.size(); // Palautetaan listan koko
        }
    }

    public void removeElement(T element) {
        synchronized (list) {
            if (list.contains(element)) { // Tarkistetaan onko elementti listassa ennen poistoa
                list.remove(element);
                System.out.println(Thread.currentThread().getName() + " removed: " + element);
            } else {
                System.out.println(Thread.currentThread().getName() + " could not find: " + element);
            }
        }
    }
}

class ThreadSafeTest {
    public static void main(String[] args) {
        ThreadSafeList<String> safeList = new ThreadSafeList<>();

        Runnable addTask = () -> {
            for (int i = 0; i < 5; i++) {
                safeList.addElement("Item" + i); // Lisätään elementtejä listaan
                System.out.println(Thread.currentThread().getName() + " List size: " + safeList.getSize()); // Tulostetaan listan koko
            }
        };

        Runnable removeTask = () -> {
            for (int i = 0; i < 3; i++) {
                safeList.removeElement("Item" + i); // Yritetään poistaa elementti
                System.out.println(Thread.currentThread().getName() + " List size: " + safeList.getSize()); // Tulostetaan listan koko poiston jälkeen
            }
        };

        Thread thread1 = new Thread(addTask, "Thread-1");
        Thread thread2 = new Thread(addTask, "Thread-2");
        Thread thread3 = new Thread(removeTask, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
