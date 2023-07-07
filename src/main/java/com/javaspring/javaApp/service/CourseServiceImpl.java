package com.javaspring.javaApp.service;


import com.javaspring.javaApp.entities.Course;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    List<Course> list;

    public CourseServiceImpl(){
        list= new ArrayList<>();
        list.add(new Course(001,"java core course", "this is a java course"));
        list.add(new Course(002,"spring boot course", "this is a spring boot course"));

    }
    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        Course c=null;
        for(Course course:list){
            if(course.getId()==courseId){
                c=course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        for(Course c:list){
            if(c.getId()==course.getId()){
                c.setTitle(course.getTitle());
                c.setDescription(course.getDescription());
                break;
            }
        }
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {
        int size=list.size();
        int todel=-1;
        for(int i=0;i<size;i++){
            if(list.get(i).getId()==courseId){
                todel=i;
            }
        }
        list.remove(todel);
    }
}
