-- TaskServiceTest
-- testlistThreeLastTasks
-- ID_ACCOUNT_TYPE = 1L
INSERT INTO TA_ACCOUNT_TYPE(label) VALUES('FREE');
-- ID_USER = 1L
INSERT INTO user(name, USER_TYPE) VALUES('testNameUser', 'USER_FREE')
-- ID_CATEGORY = 1L
INSERT INTO category(name) VALUES('testNameCategory')
-- ID_TASK = 1L
INSERT INTO task(label, id_user) VALUES('testFind3lastTask1DB', 1);
-- ID_TASK = 2L
INSERT INTO task(label, id_user) VALUES('testFind3lastTask2DB', 1);
-- ID_TASK = 3L
INSERT INTO task(label, id_user) VALUES('testFind3lastTask3DB', 1);
-- testAddTaskWithLessThanTenTasksForFreeUser
-- ID_USER = 2L
INSERT INTO user(name, USER_TYPE) VALUES('AddTaskWithLessThanTenTasksForFreeUser', 'USER_FREE')
-- testEndTask
-- ID_TASK = 4L
INSERT INTO task(label, endingDate, id_user) VALUES('testEndedTask4DB', '2016-12-08 11:51:03', 1);
-- testForecastEndingDateIsInIntervalOfDates
-- ID_TASK = 5L
INSERT INTO task(label, forecastEndingDate, id_user) VALUES('testForecastEndingDateIsInIntervalOfDates5DB', '2016-12-08 11:51:03', 1);