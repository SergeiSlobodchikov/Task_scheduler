package Seminar1;

public class Node {
    private Person person1;
    private Relationship relationship;
    private Person person2;

    public Node(Person person1, Relationship relationship, Person person2) {
        this.person1 = person1;
        this.relationship = relationship;
        this.person2 = person2;
    }

    public Person getPerson1() {
        return person1;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public Person getPerson2() {
        return person2;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", person1, relationship, person2);
    }
}