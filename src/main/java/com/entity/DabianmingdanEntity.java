package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 答辩名单
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-04-09 10:42:17
 */
@TableName("dabianmingdan")
public class DabianmingdanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DabianmingdanEntity() {
		
	}
	
	public DabianmingdanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 课题名称
	 */
					
	private String ketimingcheng;
	
	/**
	 * 工号
	 */
					
	private String gonghao;
	
	/**
	 * 教师姓名
	 */
					
	private String jiaoshixingming;
	
	/**
	 * 所在院系
	 */
					
	private String suozaiyuanxi;
	
	/**
	 * 答辩名称
	 */
					
	private String dabianmingcheng;
	
	/**
	 * 相关图片
	 */
					
	private String xiangguantupian;
	
	/**
	 * 答辩成绩
	 */
					
	private Integer dabianchengji;
	
	/**
	 * 答辩结果
	 */
					
	private String dabianjieguo;
	
	/**
	 * 答辩时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date dabianshijian;
	
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 年级
	 */
					
	private String nianji;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：课题名称
	 */
	public void setKetimingcheng(String ketimingcheng) {
		this.ketimingcheng = ketimingcheng;
	}
	/**
	 * 获取：课题名称
	 */
	public String getKetimingcheng() {
		return ketimingcheng;
	}
	/**
	 * 设置：工号
	 */
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	/**
	 * 获取：工号
	 */
	public String getGonghao() {
		return gonghao;
	}
	/**
	 * 设置：教师姓名
	 */
	public void setJiaoshixingming(String jiaoshixingming) {
		this.jiaoshixingming = jiaoshixingming;
	}
	/**
	 * 获取：教师姓名
	 */
	public String getJiaoshixingming() {
		return jiaoshixingming;
	}
	/**
	 * 设置：所在院系
	 */
	public void setSuozaiyuanxi(String suozaiyuanxi) {
		this.suozaiyuanxi = suozaiyuanxi;
	}
	/**
	 * 获取：所在院系
	 */
	public String getSuozaiyuanxi() {
		return suozaiyuanxi;
	}
	/**
	 * 设置：答辩名称
	 */
	public void setDabianmingcheng(String dabianmingcheng) {
		this.dabianmingcheng = dabianmingcheng;
	}
	/**
	 * 获取：答辩名称
	 */
	public String getDabianmingcheng() {
		return dabianmingcheng;
	}
	/**
	 * 设置：相关图片
	 */
	public void setXiangguantupian(String xiangguantupian) {
		this.xiangguantupian = xiangguantupian;
	}
	/**
	 * 获取：相关图片
	 */
	public String getXiangguantupian() {
		return xiangguantupian;
	}
	/**
	 * 设置：答辩成绩
	 */
	public void setDabianchengji(Integer dabianchengji) {
		this.dabianchengji = dabianchengji;
	}
	/**
	 * 获取：答辩成绩
	 */
	public Integer getDabianchengji() {
		return dabianchengji;
	}
	/**
	 * 设置：答辩结果
	 */
	public void setDabianjieguo(String dabianjieguo) {
		this.dabianjieguo = dabianjieguo;
	}
	/**
	 * 获取：答辩结果
	 */
	public String getDabianjieguo() {
		return dabianjieguo;
	}
	/**
	 * 设置：答辩时间
	 */
	public void setDabianshijian(Date dabianshijian) {
		this.dabianshijian = dabianshijian;
	}
	/**
	 * 获取：答辩时间
	 */
	public Date getDabianshijian() {
		return dabianshijian;
	}
	/**
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * 设置：学生姓名
	 */
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
	/**
	 * 设置：年级
	 */
	public void setNianji(String nianji) {
		this.nianji = nianji;
	}
	/**
	 * 获取：年级
	 */
	public String getNianji() {
		return nianji;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}

}
