package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
    
	@Autowired
	private CourseDao courseDao;
	
	
/***	 the commented list code is
    for storing the data statically ***/ 
	
//	List<Course> list;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course (123, "Java", "This contain java begginers course"));
//		list.add(new Course (234, "Angular", "This contain Angular begginers course"));
//		list.add(new Course (456, "NodeJS", "This contain Node JS begginers course"));
	}
	
	@Override
	public List<Course> getCourses() {
		//return list;
		return courseDao.findAll();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse(long courseId) {
		
//		Course c = null;
//		for (Course course : list) {
//			if (course.getId() == CourseId) {
//				c = course;
//				break;
//			}
//		}
		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse( Course course) {
		
//		list.forEach(e -> {
//			if(e.getId() == course.getId()) 
//			{
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		courseDao.save(course);
		return course;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void  deleteCourse(long courseId) {
		//list = this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
		Course entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
	}

}
