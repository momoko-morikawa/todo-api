package com.example.todoapi.repository.task;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TaskRepository {
	
	@Select("SELECT id, title FROM tasks WHERE id = #{taskId}")
	public Optional<TaskRecord> select(Long taskId);
	
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("INSERT INTO tasks (title) VALUES (#{title})")
	void insert(TaskRecord record);
	
	@Select("SELECT id, title FROM tasks LIMIT #{limit} OFFSET #{offset}")
    List<TaskRecord> selectList(int limit, long offset);
	
	@Update("UPDATE tasks SET title = #{title} WHERE id = #{id}")
	void update(TaskRecord taskRecord);
	
	@Delete("DELETE FROM tasks WHERE id = #{id}")
	void delete(Long taskId);

}
