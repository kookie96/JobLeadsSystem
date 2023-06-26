import java.util.*;

public class Assignment12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JobLeadsList jobLeadsList = new JobLeadsList();
        int choice = 0;
        String userCompanyName;
        String userContactName;
        String userContactPhone;
        String userJobTitle;
        String userJobDescrip;

        do {
            System.out.println("1 – Add lead to head of list");
            System.out.println("2 – Add lead to tail of list");
            System.out.println("3 – Delete a lead");
            System.out.println("4 – Print list from head to tail");
            System.out.println("5 – Print list from tail to head");
            System.out.println("6 – Exit");
            System.out.print("Enter Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter Company Name: ");
                    userCompanyName = sc.nextLine();
                    System.out.println("Enter Contact Person Name: ");
                    userContactName = sc.nextLine();
                    System.out.println("Enter Contact Person Phone: ");
                    userContactPhone = sc.nextLine();
                    System.out.println("Enter Job Title: ");
                    userJobTitle = sc.nextLine();
                    System.out.println("Enter Job Description: ");
                    userJobDescrip = sc.nextLine();
                    jobLeadsList.add_to_front(userCompanyName,userContactName,userContactPhone,
                            userJobTitle,userJobDescrip);
                    break;
                case 2:
                    System.out.println("Enter Company Name: ");
                    userCompanyName = sc.nextLine();
                    System.out.println("Enter Contact Person Name: ");
                    userContactName = sc.nextLine();
                    System.out.println("Enter Contact Person Phone: ");
                    userContactPhone = sc.nextLine();
                    System.out.println("Enter Job Title: ");
                    userJobTitle = sc.nextLine();
                    System.out.println("Enter Job Description: ");
                    userJobDescrip = sc.nextLine();
                    jobLeadsList.add_to_tail(userCompanyName,userContactName,userContactPhone,
                            userJobTitle,userJobDescrip);
                    break;
                case 3:
                    System.out.println("Enter Company Name: ");
                    userCompanyName = sc.nextLine();
                    System.out.println("Enter Job Title: ");
                    userJobTitle = sc.nextLine();
                    jobLeadsList.remove_lead(userCompanyName,userJobTitle);
                    break;
                case 4:
                    jobLeadsList.print_head_to_tail();
                    break;
                case 5:
                    jobLeadsList.print_tail_to_head();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Error: Please enter a valid choice (1 thru 6)");
                    break;
            }
        } while (choice != 6);
    }
}