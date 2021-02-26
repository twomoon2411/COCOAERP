package kh.cocoa.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kh.cocoa.dto.ScheduleDTO;

@Mapper
public interface ScheduleDAO {
	public void insertSchedule(ScheduleDTO dto, String openTarget);
	
	public List<ScheduleDTO> selectAllSchedule();
	public List<ScheduleDTO> selectCompanySchedule();
	public List<ScheduleDTO> selectDeptSchedule(String dept);
	public List<ScheduleDTO> selectTeamSchedule(String team);
	public List<ScheduleDTO> selectPersonalSchedule(String personal);
	
	public ScheduleDTO getSchedule(String seq);
	public void update(ScheduleDTO dto);
	public int delete(String seq);
	
	public List<ScheduleDTO> selectTodaySchedule(String date1, String date2);

	// 넥사크로
	public List<ScheduleDTO> selectListNex();
	public List<ScheduleDTO> selectListByDateNex(String str_start, String str_end);
}
