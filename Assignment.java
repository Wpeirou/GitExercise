/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Assignment;

/**
 *
 * @author wongpeirou
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
public class Assignment {
    
        static ArrayList<String> title=new ArrayList<>();
        static ArrayList<String> description=new ArrayList<>();
        static ArrayList<LocalDate>dueDate=new ArrayList<>();
        static ArrayList<String>category=new ArrayList<>();
        static ArrayList<String>priorityL=new ArrayList<>();
        static ArrayList<Boolean>isCompleted =new ArrayList<>();

    public static void main(String[] args) {
        int taskNum=0;
        
        Scanner sc=new Scanner (System.in);
        while(true){
            System.out.println("Welcome to To-Do List App");
            System.out.println("1.Add a new task");
            System.out.println("2.Mark task as complete");
            System.out.println("3.Delete a task");
            System.out.println("4.Sort tasks");
            System.out.println("5.Search tasks");
            System.out.println("6.Add a recurring task");
            System.out.println("8.Edit tasks");
            
        
        System.out.print("Choose an option(1-8): ");
        int option=sc.nextInt();
            System.out.println();
        sc.nextLine();
        switch (option){
            case 1:
                System.out.println("===Add a New Task===");
                System.out.print("Enter task title: ");
                String Title=sc.nextLine();
                title.add(Title);
                System.out.print("Enter task description: ");
                String Description=sc.nextLine();
                description.add(Description);
                System.out.print("Enter due date(YYYY-MM-DD: )");
                String Duedate=sc.nextLine();
                LocalDate DueDate=LocalDate.parse(Duedate);
                dueDate.add(DueDate);
                System.out.print("Enter task category(Homework,Personal,Work): ");
                String Category=sc.nextLine();
                category.add(Category);
                System.out.print("Priority level(Low,Medium,High):");
                String Priority=sc.nextLine();
                priorityL.add(Priority);
                //Initially mark task as incomplete
                isCompleted.add(false);
                System.out.println();
                System.out.println("Task \""+Title+"\" added successfully! ");
                System.out.println();
                
                break;
                
            case 2:
                System.out.println("=== Mark Task as Complete ===");
                //View all task
                if (title.isEmpty())
                {
                    System.out.println("No tasks available");
                }
                else{
                    viewAllTask();
                    System.out.print("Enter the task number you want to mark as complete:");
                    taskNum=sc.nextInt();
                    sc.nextLine();
                    if(taskNum>=1 && taskNum<=title.size())
                    {
                    isCompleted.set(taskNum-1,true);
                        System.out.println("Task \""+title.get(taskNum-1)+"\" marked as complete!");
                        System.out.println();
                    }
                    else 
                    {
                        System.out.println("Invalid task number");
                        System.out.println();
                    
                    }
                    
                }
               break;
               
            case 3:
                viewAllTask();
                System.out.println();
                System.out.println("=== Delete a Task ===");
                System.out.print("Enter the task number you want to delete: ");
                taskNum=sc.nextInt();
                sc.nextLine();
                 if(taskNum>=1 && taskNum<=title.size())
                    {
                    String deletedTittle=title.get(taskNum-1);
                    title.remove(taskNum-1);
                    description.remove(taskNum-1);
                    dueDate.remove(taskNum-1);
                    category.remove(taskNum-1);
                    priorityL.remove(taskNum-1);
                    isCompleted.remove(taskNum-1);
                        System.out.println("Task \""+deletedTittle+"\" deleted successfully!");
                        System.out.println();
              
                    }
                 else
                 {
                     System.out.println("Invalid task number.");
                     System.out.println();
                 }
                 break;
                 
            case 4:
                System.out.println("=== Sort Tasks ===");
                System.out.println("""
                                   Sort by:
                                   1. Due Date (Ascending)
                                   2.Due Date (Descending)
                                   3.Priority(High to Low)
                                   4.Priority(Low to High)
                                   """);
                System.out.print("Choose sorting option(1-4):");
                int sortOption=sc.nextInt();
                sc.nextLine();  // Consume the leftover newline after nextInt()

                
                switch (sortOption){
                    case 1:
                        for (int i=0;i<title.size();i++){
                        for (int j=i+1;j<title.size();j++){
                            if (dueDate.get(i).isAfter(dueDate.get(j)))
                            {
                            swapTask(i,j);
                            }
                            
                        }}
                        break;
                    case 2:
                        for (int i=0;i<title.size();i++)
                        {
                        for (int j=i+1;j<title.size();j++)
                        {
                        if (dueDate.get(i).isBefore(dueDate.get(j)))
                                {
                                    swapTask(i,j);
                                }
                        }
                        }
                        break;
                    case 3:
                         for (int i = 0; i < title.size(); i++) {
                         for (int j = i + 1; j < title.size(); j++) {
                         int priorityComparison = comparePriority(priorityL.get(i), priorityL.get(j));
                         if (priorityComparison < 0) {  // High to Low
                         // Swap tasks
                         swapTask(i, j);
                   }
                }
            }
                        
                         System.out.println("Tasks sorted by Priority (High to Low)!");
                        break;
                    case 4:
            
                        for (int i = 0; i < title.size(); i++) {
                        for (int j = i + 1; j < title.size(); j++) {
                        int priorityComparison = comparePriority(priorityL.get(i), priorityL.get(j));
                        if (priorityComparison > 0) {                  
                        swapTask(i, j);
                    }
                }
            }
                        System.out.println("Tasks sorted by Priority (Low to High)!");
                        break;
        default:
                        System.out.println("Invalid sorting option.");
    }
                for (int i=0;i<title.size();i++)
                {
                    System.out.println(i+1+". "+title.get(i));
                }
                System.out.println();
                //case 6,7,8,then default
        default:
        System.out.println("Please enter an valid option");
            System.out.println();
}
       
  
                }
 
        }
    public static void viewAllTask(){
    System.out.println("View all tasks");
                for (int i=0;i<title.size();i++)
                {
                    System.out.println((i+1)+". "+title.get(i));
                
                }
}
    public static void swapTask(int i,int j){
    Collections.swap(title, i, j);
    Collections.swap(description,i,j);
    Collections.swap(dueDate,i,j);
    Collections.swap(category,i,j);
    Collections.swap(priorityL,i,j);
    Collections.swap(isCompleted,i,j);

    }
    private static int comparePriority(String p1, String p2) {
        List<String> priorityOrder = Arrays.asList("Low", "Medium", "High");
        return Integer.compare(priorityOrder.indexOf(p1), priorityOrder.indexOf(p2));
    }
}

                
    
    
  