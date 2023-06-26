public class Node {
    public JobLead lead;
    public Node prev; //Node pointer to PREVIOUS node in the list
    public Node next; //Node pointer to NEXT node in the list

    Node(JobLead newJobLead) {
        lead = newJobLead;
    }
    //prev and next is initialized as null by default
}
