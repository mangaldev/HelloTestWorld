import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by mdev on 5/27/16.
 */
public class FurtherTesting {

    public String remoteId;
    public Long programMappingSchemeId;
    public String seriesTitle;
    public String title;
    public String airDate;
    public String episodeNumber;
    public String seasonNumber;
    public List<String> creditList;
    public String language;
    public String runTime;
    public String contentType;

    public static class Employee{
        public String name = "default";

        public Employee(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public FurtherTesting(FurtherTesting other) {
        this.remoteId = other.remoteId;
        this.programMappingSchemeId = other.programMappingSchemeId;
        this.seriesTitle = other.seriesTitle;
        this.title = other.title;
        this.airDate = other.airDate;
        this.episodeNumber = other.episodeNumber;
        this.seasonNumber = other.seasonNumber;
        this.creditList = other.creditList;
        this.language = other.language;
        this.runTime = other.runTime;
        this.contentType = other.contentType;
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("a"));
        employeeList.add(new Employee("b"));
        employeeList.add(new Employee("c"));
        employeeList.stream().map(employee -> employee.name = "d").collect(Collectors.toList());
        System.out.println(employeeList);
    }
}
