package hxc.manage.service;

import hxc.manage.model.JobLevel;

import java.util.List;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
public interface JobLevelService {
    List<JobLevel> getAllJobLevels();

    int addJobLevel(JobLevel jobLevel);

    boolean deleteJobLevelById(String ids);

    int updateJobLevel(JobLevel jobLevel);
}
