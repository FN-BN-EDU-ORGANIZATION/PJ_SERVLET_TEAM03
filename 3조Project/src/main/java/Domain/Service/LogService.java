package Domain.Service;

import Controller.member.LogDto;

public interface LogService {
	
	boolean addLog() throws Exception;
	
	boolean updateLog();

	LogDto getLogToday();
	
	
	
	

	
}

