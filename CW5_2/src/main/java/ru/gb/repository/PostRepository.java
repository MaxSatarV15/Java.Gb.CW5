package ru.gb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.model.Post;
import org.springframework.data.jpa.repository.*;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
//public interface PostRepository extends JpaRepository<Post, Integer> {

}
