import entity.Employee;

public class Domain {
    public static void main(String[] args)
    {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("Ksenya");
        employee.setLastName("Budanava");

        System.out.println(employee);
    }
}
