package Domain.Service;

import Domain.Dto.LogDto;

public interface LogService {

	//
	boolean addLog() throws Exception;

	boolean updateLog();

	LogDto getLogToday() throws Exception;

}