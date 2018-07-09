package com.luke.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luke.dao.CommentsMapper;
import com.luke.dao.MessageMapper;
import com.luke.dao.USignrecordMapper;
import com.luke.dao.UserMapper;
import com.luke.dao.UserTaskMapper;
import com.luke.model.Comments;
import com.luke.model.Message;
import com.luke.model.USignrecord;
import com.luke.model.User;
import com.luke.service.ICommentsService;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;

@Service("CommentsService")
public class CommentsServiceImpl implements ICommentsService{
	
	@Autowired
	private CommentsMapper mapper;
	@Autowired
	private MessageMapper messMapper;
	@Autowired
	private USignrecordMapper uSignrecordMapper;
	@Autowired
	private UserTaskMapper userTaskMapper;
	
	@Override
	public ResultBean insert(Comments comments) {
		ResultBean bean = null;
		try {
			comments.setCreatetime(new Timestamp(new Date().getTime()));
			int row = mapper.insertSelective(comments);	
			if (row>=1) {
				Message record = new Message();
				record.setMessid(comments.getMid());
				record.setCommenetscount(1);
				messMapper.updateCount(record);
				bean = new ResultBean(Result.SUCCESS);
			}else {
				bean = new ResultBean(Result.FAIL);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			bean = new ResultBean(Result.EXCEPTION);
		}
		return bean;
	}



	
	
	@Override
	public List<Map> selectReply(Integer mid) {
		
		List<Map<String,Object>> list = mapper.selectreply(mid);
		List<Map<String,Object>> pLlist =new LinkedList<Map<String,Object>>();
		List<Map<String,Object>> hFlist =new LinkedList<Map<String,Object>>();	
		List<Map> resList  = new LinkedList<Map>();
		for(int i = 0 ; i < list.size () ; i++){
			if((Integer)list.get(i).get("pid")==0){
				pLlist.add(list.get(i));
			}
			else{
				hFlist.add(list.get(i));
			}
		}
  		
		for(int pl =0 ; pl<pLlist.size();pl++){
			Map<String,Object>  map = new HashMap<String,Object> ();
			Integer pLId =(Integer) pLlist.get(pl).get("id");
			List<String > createtime = new LinkedList<String>();
			List<String > avatarUrl = new LinkedList<String>();
			List<String > content = new LinkedList<String>();
			List<String > nickname = new LinkedList<String>();
			List<String > name = new LinkedList<String>();
			List<String > pid = new LinkedList<String>();
			List<String > id = new LinkedList<String>();
			List<String > u1 = new LinkedList<String>();
			List<String > u2 = new LinkedList<String>();
			List<String > state = new LinkedList<String>();
			List<String > state2 = new LinkedList<String>();
			map=dg((Integer)pLlist.get(pl).get("id"), hFlist,createtime,avatarUrl,content,nickname,name,pid,id,u1,u2,state,state2);
			map.put("pl", pLlist.get(pl));
			resList.add(map);
		}
		return resList;
	}
	/**
	 * 递归添加回复的回复
	 * @param id1
	 * @param hFlist
	 * @param start
	 * @param createtime
	 * @param avatarUrl
	 * @param content2
	 * @param nickname
	 * @param name
	 * @param pid
	 * @param id
	 * @param u1
	 * @param u2
	 * @return
	 */
	private HashMap<String,Object>  dg(Integer id1,List<Map<String, Object>> hFlist,
			List<String > createtime,List<String > avatarUrl,List<String > content,List<String > nickname,List<String > name,
			List<String > pid ,List<String > id ,List<String > u1 ,List<String > u2,List<String> state,List<String> state2
			){
		HashMap<String,Object> map = new HashMap<String,Object> () ;
		for( int hf=0;hf<hFlist.size();hf++){
			if(id1==(Integer) hFlist.get(hf).get("pid")||id1.equals((Integer) hFlist.get(hf).get("pid"))){
				avatarUrl.add(hFlist.get(hf).get("avatarUrl").toString());
				content.add(hFlist.get(hf).get("content").toString());
				nickname.add(hFlist.get(hf).get("nickname").toString());
				name.add(hFlist.get(hf).get("name").toString());
				pid.add(hFlist.get(hf).get("pid").toString());
				id.add(hFlist.get(hf).get("id").toString());
				u1.add(hFlist.get(hf).get("u1").toString());
				u2.add(hFlist.get(hf).get("u2").toString());
				state.add(hFlist.get(hf).get("state").toString());
				createtime.add(hFlist.get(hf).get("createtime").toString());
				dg((Integer)hFlist.get(hf).get("id"),hFlist,createtime,avatarUrl,content,nickname,name,pid,id,u1,u2,state,state2);
			}
		}
		map.put("createtime", createtime);
		map.put("avatarUrl", avatarUrl);
		map.put("content", content);
		map.put("nickname", nickname);
		map.put("name", name);
		map.put("pid", pid);
		map.put("id", id);
		map.put("u1", u1);
		map.put("u2", u2);
		map.put("state", state);
		map.put("state2", state2);
		return map;
	}
	
	
	
	
	
	@Override
	public List selectCommid(Integer mid){
		
		List<Map> list= mapper.selectCommid(mid);
		for ( int i=0;i<list.size();i++) {
			List<Map> list2 = mapper.selectPid((Integer) list.get(i).get("commid"));
			list.get(i).put("HF", list2);
		}
		
		return list;
	}
	
	/**
	 * 
	 * @Description:签到
	 * @author: ltc
	 * @date: 2018-5-19
	 * @Company: LuKe
	 */
	@Override
	public ResultBean signin(User user) {
		ResultBean bean = null;
		
		try{
			USignrecord uSignrecord = new USignrecord();
			uSignrecord.setUnionid(user.getUnionid());
			uSignrecord.setOperationtime(new Timestamp(System.currentTimeMillis()));
			uSignrecord.setSigntime(new Timestamp(System.currentTimeMillis()));
			uSignrecordMapper.insert(uSignrecord);
			userTaskMapper.updateUserAndTask(user);//更新签到任务表和user表
			bean = new ResultBean(Result.SUCCESS);
		}
		catch (Exception e) {
			bean = new ResultBean(Result.EXCEPTION);
			e.printStackTrace();
		}
		return  bean;
	}





	@Override
	public Map userSignDay(String unionid) {
		
		
		return userTaskMapper.selectUserSignDay(unionid);
	}
	
	
	







}
