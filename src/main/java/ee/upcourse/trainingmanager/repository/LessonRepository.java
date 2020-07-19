package ee.upcourse.trainingmanager.repository;

import ee.upcourse.trainingmanager.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
