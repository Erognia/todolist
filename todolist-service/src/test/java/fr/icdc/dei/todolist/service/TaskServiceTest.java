package fr.icdc.dei.todolist.service;

import static org.junit.Assert.*;

import java.util.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
//import java.util.Date;

import org.apache.commons.collections.CollectionUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.icdc.dei.todolist.persistence.entity.Task;
import fr.icdc.dei.todolist.persistence.entity.User;
import fr.icdc.dei.todolist.persistence.entity.UserFree;

public class TaskServiceTest extends AbstractServiceTest {
	
	private static final String TASK_LABEL = "taskLabel";
	private static final long ID_ENDED_TASK = 4L;
	private static final long ID_TASK_WITH_FORECAST_ENDING_DATE = 5L;
	private static final int INTERVAL_DATE_MONTH = 12;
	private static final int INTERVAL_DATE_YEAR = 2016;
	private static Date BEGINNING_INTERVAL_DATE;
	private static Date ENDING_INTERVAL_DATE;
	private final static Task task = new Task();
	private final static User user = new UserFree();

	@Autowired
	private TaskService taskService;
	
	@BeforeClass
	public static void setUp() {
		task.setLabel(TASK_LABEL);
		user.setId(2L);
		task.setUser(user);
		
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(INTERVAL_DATE_YEAR, INTERVAL_DATE_MONTH, 4);
		BEGINNING_INTERVAL_DATE = calendar.getTime();
		calendar.set(INTERVAL_DATE_YEAR, INTERVAL_DATE_MONTH, 18);
		ENDING_INTERVAL_DATE = calendar.getTime();
	}

	@Test
	public void testListTasks() {
		assertTrue(CollectionUtils.isNotEmpty(taskService.list()));
	}
	
	@Test
	public void testAddTaskSucceedWithLessThanTenTasksForFreeUser() {
		assertNotNull(taskService.add(task));
	}
	
	@Test
	public void testEndTask(){
		assertTrue(taskService.isEnded(taskService.find(ID_ENDED_TASK)));
	}
	/*//test pas encore valide
	@Test
	public void testForecastEndingDateIsInIntervalOfDates() {
		assertTrue(taskService.forecastEndingDateIsInIntervalOfDates(taskService.find(ID_TASK_WITH_FORECAST_ENDING_DATE), BEGINNING_INTERVAL_DATE, ENDING_INTERVAL_DATE));
	}*/

}
