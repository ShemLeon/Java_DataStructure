package _5_Queue;
import unit4.collectionsLib.Queue;

class Customer {
    private String name;        
    private int ticketsCount;   
    private String phoneNumber; 

    public Customer(String name, int ticketsCount, String phoneNumber) {
        this.name = name;
        this.ticketsCount = ticketsCount;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getTicketsCount() {
        return ticketsCount;
    }

    public void setTicketsCount(int ticketsCount) {
        if (ticketsCount >= 0) {
            this.ticketsCount = ticketsCount;
        } else {
            System.out.println("Error: tickets count cannot be negative");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Error: invalid phone number");
        }
    }

    @Override
    public String toString() {
        return "Клиент: " + name + 
               ", Билетов: " + ticketsCount + 
               ", Телефон: " + phoneNumber;
    }
}

public class Ex3_CustomerObj {
    public static void addCustomer(Queue<Customer> queue, Customer customer) {
        if (queue == null || customer == null) {
            System.out.println("Error: queue or customer not initialized");
            return;
        }
        queue.insert(customer);
    }

    public static Customer serveCustomer(Queue<Customer> queue) {
        if (queue == null || queue.isEmpty()) {
            System.out.println("Error: queue is empty or not initialized");
            return null;
        }
        return queue.remove();
    }

    public static Queue<Customer> mergeTwoQueues(Queue<Customer> queue1, Queue<Customer> queue2) {
        if (queue1 == null || queue2 == null) {
            System.out.println("Error: one of the queues is not initialized");
            return new Queue<Customer>();
        }

        Queue<Customer> result = new Queue<Customer>();
        Queue<Customer> temp1 = new Queue<Customer>();
        Queue<Customer> temp2 = new Queue<Customer>();

        // Копируем элементы в временные очереди и восстанавливаем исходные
        while (!queue1.isEmpty()) {
            Customer c = queue1.remove();
            temp1.insert(c);
        }
        while (!temp1.isEmpty()) {
            queue1.insert(temp1.remove());
        }
        
        while (!queue2.isEmpty()) {
            Customer c = queue2.remove();
            temp2.insert(c);
        }
        while (!temp2.isEmpty()) {
            queue2.insert(temp2.remove());
        }

        // Теперь работаем с копиями для создания новой очереди
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            result.insert(queue1.remove());
            result.insert(queue2.remove());
        }

        // Добавляем оставшиеся элементы
        while (!queue1.isEmpty()) result.insert(queue1.remove());
        while (!queue2.isEmpty()) result.insert(queue2.remove());
        
        // Восстанавливаем исходные очереди из временных
        while (!temp1.isEmpty()) {
            queue1.insert(temp1.remove());
        }
        while (!temp2.isEmpty()) {
            queue2.insert(temp2.remove());
        }

        return result;
    }

    private static void printQueueObj(Queue<Customer> queue) {
        Queue<Customer> temp = new Queue<Customer>();
        while (!queue.isEmpty()) {
            Customer c = queue.remove();
            System.out.println(c);
            temp.insert(c);
        }
        while (!temp.isEmpty()) {
            queue.insert(temp.remove());
        }
    }

    public static void main(String[] args) {
        // Create two queues of customers
        Queue<Customer> queue1 = new Queue<Customer>();
        Queue<Customer> queue2 = new Queue<Customer>();

        // Add customers to the first queue
        addCustomer(queue1, new Customer("Иван", 2, "123-456"));
        addCustomer(queue1, new Customer("Мария", 1, "234-567"));
        addCustomer(queue1, new Customer("Петр", 3, "345-678"));

        // Add customers to the second queue
        addCustomer(queue2, new Customer("Анна", 2, "456-789"));
        addCustomer(queue2, new Customer("Сергей", 1, "567-890"));

        System.out.println("Queue 1:");
        printQueueObj(queue1);
        
        System.out.println("\nQueue 2:");
        printQueueObj(queue2);

        Queue<Customer> mergedQueue = mergeTwoQueues(queue1, queue2);
        System.out.println("\nMerged queue:");
        printQueueObj(mergedQueue);
    }
}