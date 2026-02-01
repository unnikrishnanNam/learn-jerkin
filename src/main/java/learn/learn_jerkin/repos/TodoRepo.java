package learn.learn_jerkin.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.learn_jerkin.models.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {
}
