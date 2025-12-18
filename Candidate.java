public class Candidate {
    private int id;
    private String name;

    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Candidate{id=" + id + ", name='" + name + "'}";
    }

    public boolean equals(Candidate c) {
        return this.id == c.id;
    }
}

