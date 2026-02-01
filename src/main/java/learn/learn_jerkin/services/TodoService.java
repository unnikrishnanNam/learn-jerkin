package learn.learn_jerkin.services;

import java.util.List;

import org.springframework.stereotype.Service;

import learn.learn_jerkin.models.Todo;
import learn.learn_jerkin.repos.TodoRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepo todoRepo;

    public Todo create(Todo todo) {
        return todoRepo.save(todo);
    }

    public Todo getTodoById(Long id) {
        return todoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo Not Found"));
    }

    public List<Todo> getAllTodos(){
        return todoRepo.findAll();
    }

    public Todo update(Long id, Todo newTodo) {
        Todo oldTodo = getTodoById(id);
        oldTodo.setTitle(newTodo.getTitle());
        oldTodo.setDescription(newTodo.getDescription());
        oldTodo.setCompleted(newTodo.getCompleted());
        return todoRepo.save(oldTodo);
    }

    public void delete(Long id) {
        todoRepo.deleteById(id);
    }
}
