package com.entity.view;

import com.entity.DabianmingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 答辩名单
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-09 10:42:17
 */
@TableName("dabianmingdan")
public class DabianmingdanView  extends DabianmingdanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DabianmingdanView(){
	}
 
 	public DabianmingdanView(DabianmingdanEntity dabianmingdanEntity){
 	try {
			BeanUtils.copyProperties(this, dabianmingdanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
