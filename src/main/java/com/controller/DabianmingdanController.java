package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DabianmingdanEntity;
import com.entity.view.DabianmingdanView;

import com.service.DabianmingdanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 答辩名单
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-09 10:42:17
 */
@RestController
@RequestMapping("/dabianmingdan")
public class DabianmingdanController {
    @Autowired
    private DabianmingdanService dabianmingdanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DabianmingdanEntity dabianmingdan, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			dabianmingdan.setGonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			dabianmingdan.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DabianmingdanEntity> ew = new EntityWrapper<DabianmingdanEntity>();
		PageUtils page = dabianmingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dabianmingdan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DabianmingdanEntity dabianmingdan, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			dabianmingdan.setGonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			dabianmingdan.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DabianmingdanEntity> ew = new EntityWrapper<DabianmingdanEntity>();
		PageUtils page = dabianmingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dabianmingdan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DabianmingdanEntity dabianmingdan){
       	EntityWrapper<DabianmingdanEntity> ew = new EntityWrapper<DabianmingdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dabianmingdan, "dabianmingdan")); 
        return R.ok().put("data", dabianmingdanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DabianmingdanEntity dabianmingdan){
        EntityWrapper< DabianmingdanEntity> ew = new EntityWrapper< DabianmingdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dabianmingdan, "dabianmingdan")); 
		DabianmingdanView dabianmingdanView =  dabianmingdanService.selectView(ew);
		return R.ok("查询答辩名单成功").put("data", dabianmingdanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DabianmingdanEntity dabianmingdan = dabianmingdanService.selectById(id);
        return R.ok().put("data", dabianmingdan);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DabianmingdanEntity dabianmingdan = dabianmingdanService.selectById(id);
        return R.ok().put("data", dabianmingdan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DabianmingdanEntity dabianmingdan, HttpServletRequest request){
    	dabianmingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dabianmingdan);

        dabianmingdanService.insert(dabianmingdan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DabianmingdanEntity dabianmingdan, HttpServletRequest request){
    	dabianmingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dabianmingdan);
    	dabianmingdan.setUserid((Long)request.getSession().getAttribute("userId"));

        dabianmingdanService.insert(dabianmingdan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DabianmingdanEntity dabianmingdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dabianmingdan);
        dabianmingdanService.updateById(dabianmingdan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dabianmingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DabianmingdanEntity> wrapper = new EntityWrapper<DabianmingdanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			wrapper.eq("gonghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}

		int count = dabianmingdanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
