import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.lang.reflect.Array;
import java.util.*;

import static spark.Spark.get;

public class CohortController {

    public static void main(String[] args) {
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        Cohort cohort = new Cohort("E23");
        Student student1 = new Student("Vicky");
        Student student2 = new Student("Stoo");
        Student student3 = new Student("Pat");
        Student student4 = new Student("Kirstin");
        Student student5 = new Student("Emil");
        Student student6 = new Student("Molly");
        Student student7 = new Student("Digory");
        Student student8 = new Student("Robbie");
        Student student9 = new Student("Ricardo");
        Student student10 = new Student("Mark");
        Student student11 = new Student("Mike");
        Student student12 = new Student("Tahnee");
        Student student13 = new Student("Euan");
        Student student14 = new Student("Joanna");
        Student student15 = new Student("Raphael");
        Student student16 = new Student("Marcin");
        Student student17 = new Student("Garry");
        Student student18 = new Student("Gemma");
        Student student19 = new Student("Bea");
        cohort.addStudent(student1);
        cohort.addStudent(student2);
        cohort.addStudent(student3);
        cohort.addStudent(student4);
        cohort.addStudent(student5);
        cohort.addStudent(student6);
        cohort.addStudent(student7);
        cohort.addStudent(student8);
        cohort.addStudent(student9);
        cohort.addStudent(student10);
        cohort.addStudent(student11);
        cohort.addStudent(student12);
        cohort.addStudent(student13);
        cohort.addStudent(student14);
        cohort.addStudent(student15);
        cohort.addStudent(student16);
        cohort.addStudent(student17);
        cohort.addStudent(student18);
        cohort.addStudent(student19);


        get("/cohorts", (req, res) -> {
//            Random generator = new Random();
//            int randomIndex = generator.nextInt(cohort.getStudents().size());
//            Student chosenOne = cohort.getStudents().get(randomIndex);
//            int randomIndex2 = generator.nextInt(cohort.getStudents().size());
//            Student chosenTwo = cohort.getStudents().get(randomIndex);
              //model.put("chosenOne", chosenOne);

            HashMap<String, Object> model = new HashMap<>();
            Random random = new Random();
            List<Student> chooseFromList = cohort.getStudents();
            int randomIndex = random.nextInt(chooseFromList.size());
            Student chosenOne = chooseFromList.get(randomIndex);
            int randomIndex2 = random.nextInt(chooseFromList.size());
            Student chosenTwo = chooseFromList.get(randomIndex2);
            int randomIndex3 = random.nextInt(chooseFromList.size());

            if (chosenOne == chosenTwo) {
                chosenTwo = chooseFromList.get(randomIndex3);
                System.out.println("Avoided SELF-PAIR");
            }
            //return cohort.getStudents()[random.nextInt(cohort.getStudents().size())];
            model.put("chosenOne", chosenOne.getName());
            model.put("chosenTwo", chosenTwo.getName());
            model.put("template", "cohorts.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);



        get("/random", (req, res) -> {

            Random generator = new Random();
            int randomIndex = generator.nextInt(cohort.getStudents().size());
            Student chosenOne = cohort.getStudents().get(randomIndex);

            HashMap<String, Object> model = new HashMap<>();
            model.put("chosenOne", chosenOne);

            model.put("template", "random.vtl");
            return new ModelAndView(model, "layout.vtl");

        }, velocityTemplateEngine);





    }
}
