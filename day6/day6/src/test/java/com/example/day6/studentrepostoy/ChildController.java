package com.example.day6.studentrepostoy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skcet.sorting.model.ChildModel;
import com.skcet.sorting.service.ChildService;

@RestController


public class ChildController {
	@Autowired
ChildService cser;
	
	@PostMapping("/savegift")
	public ChildModel saveChildDetails(@RequestBody ChildModel cm)
	{
		return cser.saveDetails(cm);
	}
	@GetMapping("/sortDesc/{babyFirstName}")
	public List<ChildModel> sortasc(@PathVariable("babyFirstName")String babyFirstName){
		return cser.sortByAsc(babyFirstName);
	}
	@GetMapping("/pagination/{num}/{size}")
	public List<ChildModel> paginationEx(@PathVariable("num") int num,@PathVariable("size") int size)
	{
		return cser.pagination(num,size);
	}
	//pagination and sorting
	@GetMapping("/paginationAndSort/{num}/{size}/{babyFirstName}")
	public List<ChildModel> paginationAndSort(@PathVariable("num") int num,@PathVariable("size") int size,@PathVariable("babyFirstName") String babyFirstName)
	{
		return cser.paginationAndSorting(num,size,babyFirstName);
	}
}