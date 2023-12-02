package hellocucumber;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class StudentsSteps {
    private List<Student> students;

    @Given("the following students information:")
    public void givenTheFollowingStudentsInformation(List<Student> students) {
        this.students = students;
    }

    @When("the students are sorted by age")
    public void iSortStudentsByAge() {
        students.sort(Comparator.comparingInt(Student::getAge));
    }

    @Then("the youngest student is at least {int} years old")
    public void iShouldFindTheFollowingStudents(int minAge) {
        int youngestAge = students.get(0).getAge();
        assertTrue(youngestAge >= minAge);
    }

    @DataTableType
    public Student studentDataTable(Map<String, String> row) {
        String name = row.get("name");
        int age = Integer.parseInt(row.get("age"));
        int course = Integer.parseInt(row.get("course"));

        return new Student(name, age, course);
    }
}
