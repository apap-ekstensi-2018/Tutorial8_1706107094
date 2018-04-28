package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentMapper;
import com.example.model.StudentModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceDatabase implements StudentService
{
	
	public StudentServiceDatabase() {}

	public StudentServiceDatabase(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}
	
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public StudentModel selectStudent (String npm)
    {
        log.info ("select student with npm {}", npm);
        return studentMapper.selectStudent (npm);
    }


    @Override
    public List<StudentModel> selectAllStudents ()
    {
        log.info ("select all students");
        return studentMapper.selectAllStudents ();
    }


    @Override
    public boolean addStudent (StudentModel student)
    {
        return studentMapper.addStudent (student);
    }


    @Override
    public boolean deleteStudent (String npm)
    {
    	 log.info ("sudent"+npm+"delete");
    	return studentMapper.deleteStudent(npm);
    }
    
    
    public boolean updateStudent (StudentModel student)
    {
       return studentMapper.updateStudent (student);
    }

}
	