import java.util.ArrayList;
import java.util.List;

public class OrgStructureMod {
    public static class Employee {
        boolean isEngineer;
        List<Employee> reportees;

        public Employee(boolean isEngi)
        {
            isEngineer = isEngi;
            reportees = new ArrayList<>(); // Initialize the list
        }
    }

    public Employee ShrinkTree(Employee root)
    {
        rec(root);
        return root;
    }

    private List<Employee> rec(Employee root) {
        List<Employee> engineers = new ArrayList<>();

        for (Employee emp : root.reportees) {
            engineers.addAll(rec(emp));
        }

        if (root.isEngineer) {
            // Replace reportees with only engineers
            root.reportees = engineers;
            engineers = new ArrayList<>();
            engineers.add(root);
        }

        return engineers;
    }
}
