package Lesson_1.Marathon;

import Lesson_1.Marathon.Competitor.*;
import Lesson_1.Marathon.Obstacle.Course;
import Lesson_1.Marathon.Obstacle.Cross;
import Lesson_1.Marathon.Obstacle.Wall;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Bob"), new Cat("Vaska"), new Dog("Bobik")};
        Team team = new Team("Rocket", competitors);
     //   team.showWinners(competitors);
        Course course = new Course(new Cross(80), new Wall(2), new Wall(1), new Cross(120));
        course.doIt(team);
        team.showWinners();
    }
}