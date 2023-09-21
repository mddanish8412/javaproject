import java.util.Scanner;

public class StudentGrade {

       public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the Number of Student");
        int numStudents = scanner.nextInt(); // Number of students
        
        for (int j = 1; j <= numStudents; j++) {
            System.out.println("Enter marks for Student " + j);

        //Number of subject     
        System.out.println("Enter number of subjects");
        int n=scanner.nextInt();

       int[] a=new int[n];

       double totalMarks=0;

      System.out.println("Enter marks out of 100");

for( int i=0;i<n;i++)
{
  a[i]=scanner.nextInt();
}
// Calculate total marks for each student
for( int i=0;i<n;i++)
{
 totalMarks=totalMarks+a[i];
} 
// Calculate average percentage for each student
double averagePercentage = totalMarks/n;
            
            
            // Determine the grade based on average percentage
            char grade;
            if (averagePercentage >= 90) {
                grade = 'A';
            } else if (averagePercentage >= 80) {
                grade = 'B';
            } else if (averagePercentage >= 70) {
                grade = 'C';
            } else if (averagePercentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            
            // Display results for each student
            System.out.println("Student " + j + " - Total Marks: " + totalMarks);
            System.out.println("Student " + j + " - Average Percentage: " + averagePercentage + "%");
            System.out.println("Student " + j + " - Grade: " + grade);
            System.out.println(); // Separate each student's result
        }
        
        scanner.close();
    }
}