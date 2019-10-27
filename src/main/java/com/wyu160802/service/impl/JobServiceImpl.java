package com.wyu160802.service.impl;

import com.wyu160802.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wyu160802.entity.Job;
import com.wyu160802.dao.JobDao;
import com.wyu160802.service.JobService;
/**
@author 黄明潘
@date 2019/10/27-11:22
*/
@Service
public class JobServiceImpl extends BaseServiceImpl<Job,JobDao> implements JobService{

}
