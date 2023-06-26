public class JobLeadsList {
    //Attributes
    private Node head; // first node in list
    private Node tail; // last node in list

    JobLeadsList() {
        head = null;
        tail = null;
    }

    //1 - Adding new node to the FRONT of the double linked list
    public void add_to_front(String companyName, String contactName, String contactPhone,
                             String jobTitle, String jobDescription) {
        JobLead newJobLead = new JobLead(companyName, contactName, contactPhone, jobTitle, jobDescription);
        Node newNode = new Node(newJobLead);

        //if the list is empty, add new node as the head
        if (head == null) {
            head = newNode;
            System.out.println("Adding Job Lead Successful");
        } else {
            //make the next pointer of new node point to head and previous pointer as NULL
            newNode.next = head;
            newNode.prev = null;

            //change prev pointer of head node point to the new node
            head.prev = newNode;

            //move the head pointer to the new node
            head = newNode;
            System.out.println("Adding Job Lead Successful");
        }
    }

    //2 - Adding new node to the BACK of the double linked list
    public void add_to_tail(String companyName, String contactName, String contactPhone,
                            String jobTitle, String jobDescription) {
        JobLead newJobLead = new JobLead(companyName, contactName, contactPhone, jobTitle, jobDescription);
        Node newNode = new Node(newJobLead);

        //if the list is empty, add new node as the head
        if (head == null) {
            head = newNode;
            System.out.println("Adding Job Lead Successful");
        } else {
            //traversing the list till the last node
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            //change the next pointer of last node point to the new node
            last.next = newNode;

            //make prev pointer of the new node point to the last node
            newNode.prev = last;

            //make the new node as the tail
            tail = newNode;
            System.out.println("Adding Job Lead Successful");
        }
    }

    //3 - Removing node from list
    public void remove_lead(String companyName, String jobTitle) {
        boolean found = false;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            //remove head node if the node they want to delete IS the head node
            if (head.lead.getCompanyName().equalsIgnoreCase(companyName)
                    && head.lead.getJobTitle().equalsIgnoreCase(jobTitle)) {
                head = head.next;
                head.prev = null;
                found = true;
            }

            //remove last node if the node they want to delete IS the last node
            else if (tail.lead.getCompanyName().equalsIgnoreCase(companyName)
                    && tail.lead.getJobTitle().equalsIgnoreCase(jobTitle)) {

                //move tail pointer to the node BEFORE the last node
                //because the node before the tail is now the NEW tail
                tail = tail.prev;
                tail.next = null;
                found = true;
            }

            //remove node in any other place
            else {
                Node current = head;
                Node beforeCurrent;
                Node afterCurrent;
                while (current.next != null) {
                    if (current.lead.getCompanyName().equalsIgnoreCase(companyName)
                            && current.lead.getJobTitle().equalsIgnoreCase(jobTitle)) {
                        //change next pointer in the node BEFORE current point to the
                        //node AFTER current if necessary
                        if (current.prev != null) {
                            beforeCurrent = current.prev;
                            beforeCurrent.next = current.next;
                        }

                        //change prev pointer in the node AFTER current point to the
                        //node BEFORE current if necessary
                        if (current.next != null) {
                            afterCurrent = current.next;
                            afterCurrent.prev = current.prev;
                        }

                        found = true;
                        break;
                    } else {
                        current = current.next;
                    }
                }
            }

            //printing message if job lead was found or not
            if (found) {
                System.out.println("Job Lead Deleted");
            } else {
                System.out.println("Error:  Job Lead Not Found");
            }
        }
    }

    //4 - Printing list from HEAD to TAIL
    public void print_head_to_tail() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node current = head;
            while (current.next != null) {
                System.out.println(current.lead.toString());
                current = current.next;
            }

            //printing last node in list because it won't print in the while-loop
            System.out.println(current.lead.toString());
        }
    }

    //5 - Printing list form TAIL to HEAD
    public void print_tail_to_head() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            //traversing the list until the tail
            Node tail2 = head;
            while (tail2.next != null) {
                tail2 = tail2.next;
            }

            //traversing linked list from tail
            //and printing the nodes with toString method
            while (tail2 != head) {
                System.out.println(tail2.lead.toString());
                tail2 = tail2.prev;
            }

            //printing head node in the list because it won't in while-loop
            System.out.println(tail2.lead.toString());
        }
    }
}